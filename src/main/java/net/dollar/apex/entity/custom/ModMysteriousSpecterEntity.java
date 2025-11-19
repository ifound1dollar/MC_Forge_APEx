package net.dollar.apex.entity.custom;

import net.dollar.apex.entity.goal.ModMeleeAttackGoal;
import net.dollar.apex.entity.goal.ModStareOrMoveGoal;
import net.dollar.apex.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
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
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
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
    private static final int DEFAULT_LAST_ATTACK_TICKS_THRESHOLD = 100;
    private int auraCounterTicks = 60;
    private int abilityCooldownTicks;
    private static final int DEFAULT_ABILITY_COOLDOWN_TICKS = 100;

    public ModMysteriousSpecterEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        abilityCooldownTicks = DEFAULT_ABILITY_COOLDOWN_TICKS;
    }



    /**
     * Register mob goals (AI).
     */
    @Override
    protected void registerGoals() {
        //NOTE: smaller numbers (first argument) imply higher priority

        this.goalSelector.addGoal(1, new ModMeleeAttackGoal(this, 1.0, false,
                40));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));

        this.goalSelector.addGoal(3, new ModStareOrMoveGoal(this, Player.class, 10.0f,
                0.666d, 0.001f));
    }

    /**
     * Checks whether a spawn attempt is valid, specifically whether it is below a specific y-value.
     * @param entityType EntityType of ObsidianGolemEntity (this)
     * @param accessor Active LevelAccessor
     * @param spawnReason Type of mob spawn (NATURAL)
     * @param blockPos Position of spawn attempt being queried
     * @param randomSource RandomSource instance
     * @return Whether the spawn attempt is valid
     */
    public static boolean checkMysteriousSpecterSpawnRules(EntityType<ModMysteriousSpecterEntity> entityType, ServerLevelAccessor accessor,
                                                       EntitySpawnReason spawnReason, BlockPos blockPos, RandomSource randomSource) {
        // Return false if biome at attempted spawn location is mushroom island.
        if (accessor.getBiome(blockPos).is(Biomes.MUSHROOM_FIELDS)) return false;

        //Only allow spawn above a certain y-level (62 is sea level).
        if (blockPos.getY() < 62) {
            return false;
        }

        return checkMonsterSpawnRules(entityType, accessor, spawnReason, blockPos, randomSource);
    }

    /**
     * Gets whether this mob should despawn in peaceful mode. Returns true here.
     * @return Returns true if it should despawn, false otherwise
     */
    @Override
    protected boolean shouldDespawnInPeaceful() {
        return true;
    }

    /**
     * Set mob attributes, like MAX_HEALTH, FOLLOW_RANGE, etc.
     * @return Newly created AttributeSupplier
     */
    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 120)
                .add(Attributes.ATTACK_DAMAGE, 12.0)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0)
                .add(Attributes.FOLLOW_RANGE, 30)
                .add(Attributes.STEP_HEIGHT, 1.0f)
                .build();
    }

    /**
     * Gets the attack Box for this mob. Overridden to expand on the X and Z axes somewhat.
     * @return The attack Box for this mob.
     */
    @Override
    protected @NotNull AABB getAttackBoundingBox() {
        return super.getAttackBoundingBox().inflate(0.1d, 0.0d, 0.1d);
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

    public void addAdditionalSaveData(@NotNull ValueOutput output) {
        super.addAdditionalSaveData(output);
        this.addPersistentAngerSaveData(output);
    }

    public void readAdditionalSaveData(@NotNull ValueInput input) {
        super.readAdditionalSaveData(input);
        this.readPersistentAngerSaveData(this.level(), input);
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
    protected @NotNull SoundEvent getHurtSound(@NotNull DamageSource source) {
        return SoundEvents.BLAZE_AMBIENT;
    }

    /**
     * Gets death sound produced by this Monster.
     * @return Death SoundEvent
     */
    protected @NotNull SoundEvent getDeathSound() {
        return SoundEvents.BLAZE_DEATH;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return switch (getRandom().nextInt(5)) {
            case 0 -> SoundEvents.BLAZE_AMBIENT;
            case 1 -> SoundEvents.HUSK_AMBIENT;
            case 2 -> SoundEvents.ZOMBIE_VILLAGER_AMBIENT;
            case 3 -> SoundEvents.GHAST_AMBIENT;
            case 4 -> SoundEvents.WARDEN_TENDRIL_CLICKS;
            default -> null;    // Should never reach default case.
        };
    }

    @Override
    public int getAmbientSoundInterval() {
        return 300;     // Default is 80.
    }

    @Override
    protected float getSoundVolume() {
        return 0.666f;  // Default is 1.0f.
    }

    @Override
    protected void playAttackSound() {
        this.playSound(SoundEvents.RAVAGER_ATTACK);
    }


    /**
     * Performs attack operations like checking for attack timer, dealing damage to target, and playing sound.
     * @param targetEntity Target Entity
     * @return Whether attack was performed successfully
     */
    @Override
    public boolean doHurtTarget(@NotNull ServerLevel serverLevel, @NotNull Entity targetEntity) {
        ticksSinceLastAttack = 0;

        // If default attack operation was successful, do special attack effects.
        if (super.doHurtTarget(serverLevel, targetEntity)) {
            // Immediately reset movement speed buff.
            resetMovementSpeed();

            // Then, do special Mysterious Specter attack behaviors.
            if (targetEntity instanceof LivingEntity livingEntity) {
                // Roll 50% chance each attack to Wither the target here.
                if (random.nextBoolean()) {
                    // Increase Wither level based on missing Health (split into 3 parts, 33% HP each).
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 81, calcWitherStrength(),
                            false, false, true));
                }
            }

            // Heal the Mysterious Specter for 1 heart (2 health) on each successful attack.
            this.setHealth(this.getHealth() + 2.0f);

            // Play attack sound, then return success.
            this.playSound(SoundEvents.RAVAGER_ATTACK, this.getSoundVolume(), 1.0f);
            return true;
        }

        return false;
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
     * Performs any per-tick operations of this Entity. Here, checks if this Monster has not been
     *  able to attack for at least 3s. If it hasn't, rolls a chance each tick to blind and slow all
     *  nearby LivingEntities then teleport toward its target.
     */
    @Override
    public void tick() {
        super.tick();

        // Only run tick behavior on server.
        if (!(this.level() instanceof ServerLevel serverLevel)) return;

        // Decrement aura counter, then if <= 0, do aura and reset counter.
        auraCounterTicks--;
        if (auraCounterTicks <= 0) {
            applyWeaknessHungerAura();
            auraCounterTicks = 60;
        }

        // If there is no target, ensure that ticksSinceLastAttack remains at 0 and return.
        if (this.getTarget() == null) {
            ticksSinceLastAttack = 0;
            return;
        }

        // Else if valid target, increment ticksSinceLastAttack and decrement abilityCooldownTicks.
        ticksSinceLastAttack++;
        abilityCooldownTicks--;

        // Then, if unable to attack for at least 3s and ability not on cooldown, try special ability.
        if (ticksSinceLastAttack > DEFAULT_LAST_ATTACK_TICKS_THRESHOLD && abilityCooldownTicks <= 0) {
            if (random.nextInt(100) == 0) {
                // Roll 1% chance each tick to perform special attack.
                blindAndSlowNearbyPlayers();
                increaseMovementSpeedTemporarily();

                // If unable to attack for at least 7.5s, also apply Wither and deal instant damage on ability use.
                if (ticksSinceLastAttack >= 150) {
                    witherAndDamageNearbyPlayers(serverLevel);
                }

                abilityCooldownTicks = DEFAULT_ABILITY_COOLDOWN_TICKS;
            }
        }
    }

    /**
     * Applies the Weakness and Hunger effect to all nearby Players.
     */
    private void applyWeaknessHungerAura() {
        double radius = 10.0;
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        List<Player> players = this.level().getEntitiesOfClass(Player.class,
                new AABB(x - radius, y - radius, z - radius,
                        x + radius, y + radius, z + radius),
                EntitySelector.NO_CREATIVE_OR_SPECTATOR);

        for (Player player : players) {
            // Apply lowest-level Weakness and Hunger to each player for 10 seconds.
            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 0,
                    false, false, true));
            player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 200, 0,
                    false, false, true));
        }
    }

    /**
     * Applies Darkness and Slowness effects to all nearby PlayerEntities and plays aggressive sound.
     */
    private void blindAndSlowNearbyPlayers() {
        //Store xyz coordinates and get all entities within radius of this Entity.
        double radius = 24.0;
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        List<Player> players = this.level().getEntitiesOfClass(Player.class,
                new AABB(x - radius, y - radius, z - radius,
                        x + radius, y + radius, z + radius),
                EntitySelector.NO_CREATIVE_OR_SPECTATOR);

        //Play aggressive sound, then apply effects to all nearby LivingEntities.
        switch (random.nextInt(3)) {
            case 0 -> this.playSound(SoundEvents.ENDERMAN_SCREAM, this.getSoundVolume(), 1.0f);
            case 1 -> this.playSound(SoundEvents.WARDEN_ANGRY, this.getSoundVolume(), 1.0f);
            default -> this.playSound(SoundEvents.RAVAGER_ROAR, this.getSoundVolume(), 1.0f);
        }
        for (Player player : players) {
            // Blind (Darkness) and Slow ALL nearby players that are not creative or spectator mode.
            player.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 60, 1,
                    false, false, true));
            player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 0,
                    false, false, true));
        }
    }

    /**
     * Applies Wither effect to each nearby PlayerEntity.
     */
    private void witherAndDamageNearbyPlayers(ServerLevel serverLevel) {
        //Store xyz coordinates and get all entities within radius of this Entity.
        double radius = 24.0;
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        List<Player> players = this.level().getEntitiesOfClass(Player.class,
                new AABB(x - radius, y - radius, z - radius,
                        x + radius, y + radius, z + radius),
                EntitySelector.NO_CREATIVE_OR_SPECTATOR);

//        // Wither effect intensity should scale up with duration.
//        // Should increase by one level per 6 seconds, -1 to apply intensity 0 at first.
//        int intensity = (ticksSinceLastAttack / 120) - 1;
//        intensity = Math.min(intensity, 2);     // Cap at intensity 2 (Level 3 Wither).

        // Apply effect to each player, strength clamped to mob health percentage.
        int intensity = calcWitherStrength();
        for (Player player : players) {
            player.addEffect(new MobEffectInstance(MobEffects.WITHER, 81, intensity,
                    false, false, true));

            // Also deal instant damage for parity with Obsidian Golem special attack.
            player.hurtServer(serverLevel, this.damageSources().mobAttack(this),
                    5.0f);                  // Same damage as fireball.
        }
    }

    /**
     * Increases Entity's movement speed for a duration using the Speed status effect.
     */
    private void increaseMovementSpeedTemporarily() {
        // Add Speed effect at Level 3 (20% * level), so 60% bonus speed, for 1200 ticks (60 seconds).
        // This will upgrade an existing lower-strength Speed effect, if active.
        if (!this.hasEffect(MobEffects.SPEED)) {
            this.addEffect(new MobEffectInstance(MobEffects.SPEED, 1200, 2,
                    false, false));
        }

        // Also remove Slowness effect if active.
        this.removeEffect(MobEffects.SLOWNESS);
    }

    /**
     * Resets Entity's movement speed back to base by removing the Speed status effect.
     */
    private void resetMovementSpeed() {
        //Remove Speed status effect, if active.
        if (this.hasEffect(MobEffects.SPEED)) {
            this.removeEffect(MobEffects.SPEED);
        }
    }


    /**
     * Determines whether this Monster can be affected by a specific MobEffect.
     * @param effectInstance MobEffectInstance to check validity of
     * @return Whether the MobEffect can be applied to this Monster
     */
    @Override
    public boolean canBeAffected(MobEffectInstance effectInstance) {
        Holder<MobEffect> mobEffect = effectInstance.getEffect();
        return mobEffect != MobEffects.POISON && mobEffect != MobEffects.WITHER && mobEffect != MobEffects.HUNGER;
    }

    /**
     * Drops custom loot from this Monster when slain by a player. Also checks certain conditions to
     *  determine whether this should drop a custom collector item.
     * @param serverLevel Active ServerLevel
     * @param source DamageSource of killing blow
     * @param killedByPlayer Whether this was killed by a player
     */
    @Override
    protected void dropCustomDeathLoot(@NotNull ServerLevel serverLevel, @NotNull DamageSource source, boolean killedByPlayer) {
        if (!killedByPlayer) {
            //Only drop if last attacker was Player.
            return;
        }

        //Below is copied from how a Nether Star drops from WitherBoss.
        ItemEntity itementity = this.spawnAtLocation(serverLevel, ModItems.HANDFUL_OF_STARDUST.get());
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
                ItemEntity trophyItem = this.spawnAtLocation(serverLevel, ModItems.TROPHY_OMINOUS_LETTER.get());
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
    public int getBaseExperienceReward(@NotNull ServerLevel serverLevel) {
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