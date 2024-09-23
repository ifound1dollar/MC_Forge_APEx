package net.dollar.apex.entity.custom;

import net.dollar.apex.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

/**
 * Custom boss Monster entity, naturally spawning very low in the world.
 */
public class ModMysteriousSpecterEntity extends Monster implements NeutralMob {
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    private int remainingPersistentAngerTime;
    @Nullable
    private UUID persistentAngerTarget;

    private int ticksSinceLastAttack = 0;
    private int teleportDelayTicks = 0;
    private int auraCounterTicks = 60;
    private final int textureID;

    public ModMysteriousSpecterEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);

        //Set textureID to a value between 0-4, which is used to determine which texture to render.
        textureID = level.random.nextInt(5);
    }



    /**
     * Gets the textureID field (in range of 0-4), which will determine which texture to load for this
     *  Entity instance.
     * @return The textureID field value
     */
    public int getTextureID() {
        return textureID;
    }

    /**
     * Register mob goals (AI).
     */
    @Override
    protected void registerGoals() {
        //NOTE: smaller numbers (first argument) imply higher priority

        //speedModifier, followingTargetEvenIfNotSeen
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0d, true));
        //speedModifier
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0d));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    /**
     * Checks whether a spawn attempt is valid, specifically whether it is below a specific y-value.
     * @param entityType EntityType of ObsidianGolemEntity (this)
     * @param accessor Active LevelAccessor
     * @param spawnType Type of mob spawn (NATURAL)
     * @param blockPos Position of spawn attempt being queried
     * @param randomSource RandomSource instance
     * @return Whether the spawn attempt is valid
     */
    public static boolean checkMysteriousSpecterSpawnRules(EntityType<ModMysteriousSpecterEntity> entityType, LevelAccessor accessor,
                                                       MobSpawnType spawnType, BlockPos blockPos, RandomSource randomSource) {
        //Only allow spawn above a certain y-level (62 is sea level).
        if (blockPos.getY() < 62) {
            return false;
        }

        return checkMobSpawnRules(entityType, accessor, spawnType, blockPos, randomSource);
    }



    /**
     * Set mob attributes, like MAX_HEALTH, FOLLOW_RANGE, etc.
     * @return Newly created AttributeSupplier
     */
    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 120)
                .add(Attributes.ATTACK_DAMAGE, 15.0)    //Normal, Easy/Hard values are auto-scaled
                .add(Attributes.ATTACK_KNOCKBACK, 0.5)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0)
                .add(Attributes.FOLLOW_RANGE, 30)
                .build();
    }

    /**
     * Decreases air supply while the mob is underwater (infinite).
     * @param value Original air supply value
     * @return New air supply value
     */
    @Override
    protected int decreaseAirSupply(int value) {
        return value;
    }

    /**
     * Performs per-tick AI operations. Updates attackAnimationTick and persistentAnger (neutral mob).
     */
    public void aiStep() {
        super.aiStep();

        if (!this.level().isClientSide) {
            this.updatePersistentAnger((ServerLevel)this.level(), true);
        }
    }

    public void addAdditionalSaveData(CompoundTag p_28867_) {
        super.addAdditionalSaveData(p_28867_);
        this.addPersistentAngerSaveData(p_28867_);
    }

    public void readAdditionalSaveData(CompoundTag p_28857_) {
        super.readAdditionalSaveData(p_28857_);
        this.readPersistentAngerSaveData(this.level(), p_28857_);
    }


    /**
     * Begins counting persistent anger, called when a LivingEntity attacks this Monster.
     */
    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
    }

    /**
     * Sets current remaining persistent anger time.
     * @param value New persistent anger time
     */
    public void setRemainingPersistentAngerTime(int value) {
        this.remainingPersistentAngerTime = value;
    }

    /**
     * Gets current remaining persistent anger time.
     * @return Current remaining persistent anger time.
     */
    public int getRemainingPersistentAngerTime() {
        return this.remainingPersistentAngerTime;
    }

    /**
     * Sets current persistent anger target via UUID.
     * @param targetUUID UUID of new persistent anger target
     */
    public void setPersistentAngerTarget(@javax.annotation.Nullable UUID targetUUID) {
        this.persistentAngerTarget = targetUUID;
    }

    /**
     * Gets current persistent target UUID.
     * @return Current persistent target UUID
     */
    @javax.annotation.Nullable
    public UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }



    /**
     * Gets hurt sound produced by this Monster.
     * @param source DamageSource of damage being dealt
     * @return Hurt SoundEvent
     */
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLAZE_AMBIENT;
    }

    /**
     * Gets death sound produced by this Monster.
     * @return Death SoundEvent
     */
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLAZE_DEATH;
    }

    /**
     * Plays step sound of this Monster.
     * @param blockPos Position being stepped on
     * @param blockState Blockstate of block at position being stepped on
     */
    protected void playStepSound(BlockPos blockPos, BlockState blockState) {
        //PLAY NO STEP SOUND.
//        this.playSound(SoundEvents.IRON_GOLEM_STEP, 1.0F, 1.0F);
    }



    /**
     * Gets ATTACK_DAMAGE attribute assigned to this Monster.
     * @return ATTACK_DAMAGE attribute as float
     */
    private float getAttackDamage() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    /**
     * Performs attack operations like checking for attack timer, dealing damage to target, and playing sound.
     * @param targetEntity Target Entity
     * @return Whether attack was performed successfully
     */
    @Override
    public boolean doHurtTarget(Entity targetEntity) {
        //Can only attack once every second, then resets counter
        if (ticksSinceLastAttack < 20) {
            return false;
        }
        ticksSinceLastAttack = 0;

        //actual attack here
        float f = this.getAttackDamage();
        float f1 = (int)f > 0 ? f / 2.0F + (float)this.random.nextInt((int)f) : f;
        boolean flag = targetEntity.hurt(this.damageSources().mobAttack(this), f1);

        //If damaging target was successful.
        if (flag) {
            //Immediately reset movement speed buff.
            resetMovementSpeed();

            this.doEnchantDamageEffects(this, targetEntity);

            if (targetEntity instanceof LivingEntity livingEntity) {
                //CHANCE TO APPLY EFFECT TO TARGET HERE, 50% chance on-hit
                if (this.random.nextInt(100) < 67) {
                    //Increase Wither level based on missing Health (split into 3 parts, 33% HP each).
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 81,
                            calcWitherStrength()));
                }

                //ALSO CHANCE TO SET TARGET ON FIRE BASED ON % MISSING HP + 10% (LOOSELY CORRESPONDS TO CRACKINESS)
                if (this.random.nextFloat() > (this.getHealth() / this.getMaxHealth()) - 0.1f) {
                    livingEntity.setSecondsOnFire(4);
                }
            }
        }

        this.playSound(SoundEvents.PLAYER_ATTACK_STRONG, 1.0F, 1.0F);
        return flag;
    }

    /**
     * Calculates strength of Wither effect to apply to targets based on missing Health.
     * @return The calculated Wither effect strength as an integer
     */
    private int calcWitherStrength() {
        //EXAMPLE: At 25% Health: 1.0 - .25 = 0.75 | 0.75 * 3.0 = 2.25 | floor(2.25) = 2
        double strength = 1.0 - (this.getHealth() / this.getMaxHealth());   //Inverted missing Health
        strength *= 3.0;                                                    //Convert to range 0-3
        strength = Math.floor(strength);                                    //Floor, guarantees between 0-2
        return (int)strength;   //Convert to integer before returning
    }

    /**
     * Performs default hurt operations like taking damage, playing hurt sound, etc. Here, reduces
     *  Sharp damage taken and updates visual crackiness.
     * @param source DamageSource of damage being dealt
     * @param value Original amount of damage
     * @return Whether hurt operation was completed successfully
     */
    @Override
    public boolean hurt(DamageSource source, float value) {
        return super.hurt(source, value);
    }



    /**
     * Performs any per-tick operations of this Entity. Here, checks if this Monster has not been
     *  able to attack for at least 3s. If it hasn't, rolls a chance each tick to blind and slow all
     *  nearby LivingEntities then teleport toward its target.
     */
    @Override
    public void tick() {
        super.tick();

        //Decrement aura counter, then if <= 0, do aura and reset counter.
        auraCounterTicks--;
        if (auraCounterTicks <= 0) {
            applyWeaknessHungerAura();
            auraCounterTicks = 60;
        }

        //If there is no target, ensure that ticksSinceLastAttack remains at 0 and return.
        if (this.getTarget() == null) {
            ticksSinceLastAttack = 0;
            return;
        }

        ticksSinceLastAttack++;
        teleportDelayTicks--;
        //if this hasn't attacked in >3 seconds, roll 1% chance per tick to afflict nearby players and teleport to target
        if (ticksSinceLastAttack > 60 && this.random.nextInt(100) < 1) {
            weakenAndSlowNearbyEntities();

            //IF this hasn't been able to attack in 12s (240 ticks), teleport directly on top of the
            //  target, ELSE teleport to near the target
            increaseMovementSpeedTemporarily();
        }
    }

    /**
     * Applies the Weakness and Hunger effect to all nearby Entities.
     */
    private void applyWeaknessHungerAura() {
        double radius = 16.0;
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        List<Entity> entities = this.level().getEntities(this,
                new AABB(x - radius, y - radius, z - radius,
                        x + radius, y + radius, z + radius));

        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity) {
                //Do not apply effect to Mysterious Specters.
                if (livingEntity instanceof ModMysteriousSpecterEntity) {
                    continue;
                }

                //Apply lowest-level Weakness and Hunger to each entity for 10 seconds.
                livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 0));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 200, 0));
            }
        }
    }

    /**
     * Applies Blindness and Slowness effects to all nearby LivingEntities and plays aggressive sound.
     */
    private void weakenAndSlowNearbyEntities() {
        //Store xyz coordinates and get all entities within radius of this Entity.
        double radius = 24.0;
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        List<Entity> entities = this.level().getEntities(this,
                new AABB(x - radius, y - radius, z - radius,
                        x + radius, y + radius, z + radius));

        //Play aggressive sound, then apply effects to all nearby LivingEntities.
        this.playSound(SoundEvents.RAVAGER_ROAR, 1.0f, 1.0f);
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity) {
                //Slow and Weaken ALL nearby LivingEntities regardless of whether angry at.
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60));

                //Knockback the LivingEntity with half default strength.
                //KNOCKBACK NOT WORKING FOR SOME REASON
//                livingEntity.takeKnockback(0.5f, MathHelper.sin(this.getYaw() * ((float)Math.PI / 180)),
//                        -MathHelper.cos(this.getYaw() * ((float)Math.PI / 180)));
            }
        }
    }

    /**
     * Increases Entity's movement speed for a duration using the Speed status effect.
     */
    private void increaseMovementSpeedTemporarily() {
        //Add Speed effect at level 5 (20% * level), so double speed, for 1200 ticks (60 seconds).
        if (!this.hasEffect(MobEffects.MOVEMENT_SPEED)) {
            this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 4));
        }
    }

    /**
     * Resets Entity's movement speed back to base by removing the Speed status effect.
     */
    private void resetMovementSpeed() {
        //Remove Speed status effect, if active.
        if (this.hasEffect(MobEffects.MOVEMENT_SPEED)) {
            this.removeEffect(MobEffects.MOVEMENT_SPEED);
        }
    }


    /**
     * Determines whether this Monster can be affected by a specific MobEffect.
     * @param effectInstance MobEffectInstance to check validity of
     * @return Whether the MobEffect can be applied to this Monster
     */
    @Override
    public boolean canBeAffected(MobEffectInstance effectInstance) {
        MobEffect mobeffect = effectInstance.getEffect();
        return mobeffect != MobEffects.POISON && mobeffect != MobEffects.WITHER && mobeffect != MobEffects.HUNGER;
    }

    /**
     * Drops custom loot from this Monster when slain by a player. Also checks certain conditions to
     *  determine whether this should drop a custom collector item.
     * @param source DamageSource of killing blow
     * @param lootingLevel Looting level of slaying weapon
     * @param killedByPlayer Whether this was killed by a player
     */
    @Override
    protected void dropCustomDeathLoot(DamageSource source, int lootingLevel, boolean killedByPlayer) {
        if (!killedByPlayer) {
            //Only drop if last attacker was Player.
            return;
        }

        //Below is copied from how a Nether Star drops from WitherBoss.
        ItemEntity itementity = this.spawnAtLocation(ModItems.HANDFUL_OF_STARDUST.get());
        if (itementity != null) {
            itementity.setExtendedLifetime();
        }

        //Will drop trophy item if slain with specific circumstances.
        if (source.getEntity() instanceof Player player) {
            Item heldItem = player.getItemBySlot(EquipmentSlot.MAINHAND).getItem();
            if (heldItem == Items.NETHERITE_HOE ||
                    heldItem == ModItems.COBALT_STEEL_HOE.get() ||
                    heldItem == ModItems.INFUSED_GEMSTONE_HOE.get() ||
                    heldItem == ModItems.TUNGSTEN_CARBIDE_HOE.get())
            {
                //Drop Ominous Letter trophy item and give it a long despawn delay.
                ItemEntity trophyItem = this.spawnAtLocation(ModItems.TROPHY_OMINOUS_LETTER.get());
                if (trophyItem != null) {
                    trophyItem.setExtendedLifetime();
                }
            }
        }
    }

    /**
     * Gets experience drop from this Monster on death.
     * @return Amount of experience reward
     */
    @Override
    public int getExperienceReward() {
        //WitherBoss drops 50xp on death
        return 50;
    }

    /**
     * Gets maximum distance that this Monster will voluntarily drop during pathfinding.
     * @return Maximum fall distance
     */
    @Override
    public int getMaxFallDistance() {
        return 10;  //can always fall 10 blocks with no concern
    }

    /**
     * Gets whether this Entity is fire immune (true).
     * @return Whether this Entity is fire immune
     */
    @Override
    public boolean fireImmune() {
        return true;
    }
}