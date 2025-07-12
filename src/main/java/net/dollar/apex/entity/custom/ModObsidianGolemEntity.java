package net.dollar.apex.entity.custom;

import net.dollar.apex.entity.ModEntities;
import net.dollar.apex.entity.ability.ModFireballEntity;
import net.dollar.apex.entity.goal.ModMeleeAttackGoal;
import net.dollar.apex.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
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
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

/**
 * Custom boss Monster entity, naturally spawning very low in the world.
 */
public class ModObsidianGolemEntity extends Monster implements NeutralMob {
    private int attackAnimationTick;
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    private int remainingPersistentAngerTime;
    @Nullable
    private UUID persistentAngerTarget;

    private int ticksSinceLastAttack = 0;
    private static final int DEFAULT_LAST_ATTACK_TICKS_THRESHOLD = 100;
    private int abilityCooldownTicks;
    private static final int DEFAULT_ABILITY_COOLDOWN_TICKS = 100;

    public ModObsidianGolemEntity(EntityType<? extends Monster> type, Level level) {
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
        //speedModifier
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 0.6d));
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
    public static boolean checkObsidianGolemSpawnRules(EntityType<ModObsidianGolemEntity> entityType, LevelAccessor accessor,
                                                       MobSpawnType spawnType, BlockPos blockPos, RandomSource randomSource) {
        // Only spawn below y=0.
        int y = blockPos.getY();
        if (y >= 0) {
            return false;
        } else if (y >= -24) {
            // Effectively reduce spawn rate by 50% above y = -24.
            return randomSource.nextBoolean()
                    && checkMobSpawnRules(entityType, accessor, spawnType, blockPos, randomSource);
        }

        // Else check regular spawn rules (normal spawn rate).
        return checkMobSpawnRules(entityType, accessor, spawnType, blockPos, randomSource);
    }



    /**
     * Set mob attributes, like MAX_HEALTH, FOLLOW_RANGE, etc.
     * @return Newly created AttributeSupplier
     */
    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 120)
                .add(Attributes.ARMOR, 20)
                .add(Attributes.ATTACK_DAMAGE, 12.0)
                .add(Attributes.ATTACK_KNOCKBACK, 1.0)
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
        return super.getAttackBoundingBox().inflate(0.2d, 0.0d, 0.2d);
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
        if (this.attackAnimationTick > 0) {
            --this.attackAnimationTick;
        }

        if (!this.level().isClientSide) {
            this.updatePersistentAnger((ServerLevel)this.level(), true);
        }
    }

    public void addAdditionalSaveData(@NotNull CompoundTag p_28867_) {
        super.addAdditionalSaveData(p_28867_);
        this.addPersistentAngerSaveData(p_28867_);
    }

    public void readAdditionalSaveData(@NotNull CompoundTag p_28857_) {
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
    protected @NotNull SoundEvent getHurtSound(@NotNull DamageSource source) {
        return SoundEvents.IRON_GOLEM_HURT;
    }

    /**
     * Gets death sound produced by this Monster.
     * @return Death SoundEvent
     */
    protected @NotNull SoundEvent getDeathSound() {
        return SoundEvents.IRON_GOLEM_DEATH;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.RAVAGER_AMBIENT;
    }

    @Override
    public int getAmbientSoundInterval() {
        return 300;     // Default is 80.
    }

    /**
     * Plays step sound of this Monster.
     * @param blockPos Position being stepped on
     * @param blockState BlockState of block at position being stepped on
     */
    protected void playStepSound(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        this.playSound(SoundEvents.IRON_GOLEM_STEP);
    }

    @Override
    protected void playAttackSound() {
        this.playSound(SoundEvents.IRON_GOLEM_ATTACK);
    }



    /**
     * Attempts to perform attack operations against the target.
     * @param targetEntity Target being attacked by this Entity
     * @return Whether the attack was successfully performed
     */
    @Override
    public boolean doHurtTarget(@NotNull Entity targetEntity) {
        ticksSinceLastAttack = 0;
        attackAnimationTick = 10;

        // If default attack operation is successful, do special attack effects.
        if (super.doHurtTarget(targetEntity)) {
            if (targetEntity instanceof LivingEntity livingEntity) {
                // Roll chance to set target on fire based on % missing HP (loosely corresponds to crack level).
                if (random.nextFloat() > (this.getHealth() / this.getMaxHealth()) - 0.25f) {
                    livingEntity.igniteForSeconds(4.0f);    // 100% chance at 25% HP because of -0.25f above
                }
            }

            // Play attack sound, then return success.
            this.playSound(SoundEvents.IRON_GOLEM_ATTACK, this.getSoundVolume(), 1.0f);
            return true;
        }

        return false;
    }

    /**
     * Performs default hurt operations like taking damage, playing hurt sound, etc. Here, reduces
     *  Sharp damage taken and updates visual crackiness.
     * @param source DamageSource of damage being dealt
     * @param value Original amount of damage
     * @return Whether hurt operation was completed successfully
     */
    @Override
    public boolean hurt(@NotNull DamageSource source, float value) {
        Crackiness.Level irongolem$crackiness = this.getCrackiness();
        boolean flag = super.hurt(source, value);
        if (flag && this.getCrackiness() != irongolem$crackiness) {
            this.playSound(SoundEvents.IRON_GOLEM_DAMAGE);
        }

        return flag;
    }

    /**
     * Gets Crackiness enum value based on percent current Health.
     * @return IronGolem.Crackiness value
     */
    public Crackiness.Level getCrackiness() {
        return Crackiness.GOLEM.byFraction(this.getHealth() / this.getMaxHealth());
    }

    /**
     * Gets current attack animation tick.
     * @return Current attack animation tick
     */
    public int getAttackAnimationTick() {
        return this.attackAnimationTick;
    }

    /**
     * This method implementation copied almost directly from IronGolem, but with EntityType overridden
     *  to use OBSIDIAN_GOLEM.
     * @param levelReader LevelReader to access the current level
     * @return Whether this Entity can spawn at a given location
     */
    @Override
    public boolean checkSpawnObstruction(LevelReader levelReader) {
        BlockPos blockpos = this.blockPosition();
        BlockPos blockpos1 = blockpos.below();
        BlockState blockstate = levelReader.getBlockState(blockpos1);
        if (!blockstate.entityCanStandOn(levelReader, blockpos1, this)) {
            return false;
        } else {
            for (int i = 1; i < 3; i++) {
                BlockPos blockpos2 = blockpos.above(i);
                BlockState blockstate1 = levelReader.getBlockState(blockpos2);
                if (!NaturalSpawner.isValidEmptySpawnBlock(levelReader, blockpos2, blockstate1, blockstate1.getFluidState(),
                        ModEntities.OBSIDIAN_GOLEM.get())) {
                    return false;
                }
            }

            return NaturalSpawner.isValidEmptySpawnBlock(levelReader, blockpos, levelReader.getBlockState(blockpos),
                    Fluids.EMPTY.defaultFluidState(), ModEntities.OBSIDIAN_GOLEM.get())
                    && levelReader.isUnobstructed(this);
        }
    }

    /**
     * Performs per-tick operations of this Entity. Here, checks if this Entity has been unable to attack for
     *  at least 3 seconds. If it hasn't, rolls a chance each tick to use special ability.
     */
    @Override
    public void tick() {
        super.tick();

        // Only run tick behavior on server.
        if (!(this.level() instanceof ServerLevel)) return;

        // If there is no target, ensure that ticksSinceLastAttack remains at 0 and return.
        if (this.getTarget() == null) {
            ticksSinceLastAttack = 0;
            return;
        }

        // If valid target, increment ticksSinceLastAttack and decrement abilityCooldownTicks.
        ticksSinceLastAttack++;
        abilityCooldownTicks--;

        // Then, if unable to attack for at least 3s and ability not on cooldown, try special ability.
        if (ticksSinceLastAttack >= DEFAULT_LAST_ATTACK_TICKS_THRESHOLD && abilityCooldownTicks <= 0) {
            if (random.nextInt(100) == 0) {
                // Roll 1% chance each tick to perform special attack.
                rangedAttackNearbyPlayers();

                abilityCooldownTicks = DEFAULT_ABILITY_COOLDOWN_TICKS;
            }
        }
    }

    /**
     * Perform special ranged attack against all nearby PlayerEntities.
     */
    private void rangedAttackNearbyPlayers() {
        double radius = 24.0;
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        List<Player> players = this.level().getEntitiesOfClass(Player.class,
                new AABB(x - radius, y - radius, z - radius,
                        x + radius, y + radius, z + radius),
                EntitySelector.NO_CREATIVE_OR_SPECTATOR);

        // Play aggressive sound at full volume, then perform special ability.
        this.playSound(SoundEvents.RAVAGER_ROAR, this.getSoundVolume(), 1.0f);
        for (Player player : players) {
            // Slow all nearby players at Level 3 intensity (45%) for 3s.
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60,
                    2, false, false, true));

            // Shoot a fireball at the player always, but if not visible, immediately damage and set on fire.
            shootFireballAtPlayer(player);
            if (!this.getSensing().hasLineOfSight(player)) {
                player.hurt(this.damageSources().mobAttack(this),
                        5.0f);                  // Same damage as fireball.
                player.igniteForSeconds(4.0f);  // Same duration as fireball.
            }
        }
    }

    /**
     * Attempts to shoot a fireball at a visible PlayerEntity. Pulled largely from blaze fireball goal.
     * @param player PlayerEntity to attempt to shoot the fireball at
     */
    private void shootFireballAtPlayer(Player player) {
        double xDist = player.getX() - this.getX();
        double yDist = player.getY(0.5) - this.getY(0.5);
        double zDist = player.getZ() - this.getZ();

        // Create fireball velocity vector, then create fireball and shoot it at the PlayerEntity.
        Vec3 vec3 = new Vec3(xDist, yDist, zDist);
        ModFireballEntity modFireballEntity = new ModFireballEntity(this.level(), this, vec3.normalize());
        modFireballEntity.setPos(
                modFireballEntity.getX(),
                this.getY(0.5) + 0.5,
                modFireballEntity.getZ());
        this.level().addFreshEntity(modFireballEntity);
    }


    /**
     * Determines whether this Monster can be affected by a specific MobEffect.
     * @param effectInstance MobEffectInstance to check validity of
     * @return Whether the MobEffect can be applied to this Monster
     */
    @Override
    public boolean canBeAffected(MobEffectInstance effectInstance) {
        Holder<MobEffect> mobEffect = effectInstance.getEffect();
        return mobEffect != MobEffects.POISON && mobEffect != MobEffects.HUNGER;
    }

    /**
     * Drops custom loot from this Monster when slain by a player. Also checks certain conditions to
     *  determine whether this should drop a custom collector item.
     * @param level Active ServerLevel
     * @param source DamageSource of killing blow
     * @param killedByPlayer Whether this was killed by a player
     */
    @Override
    protected void dropCustomDeathLoot(@NotNull ServerLevel level, @NotNull DamageSource source, boolean killedByPlayer) {
        if (!killedByPlayer) {
            //Only drop if last attacker was Player.
            return;
        }

        //Below is copied from how a Nether Star drops from WitherBoss.
        ItemEntity itementity = this.spawnAtLocation(ModItems.MOLTEN_CORE.get());
        if (itementity != null) {
            itementity.setExtendedLifetime();
        }

        //if killer player is holding Tungsten-Carbide Mace with Hardness V, drop collector item
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
        if (source.getEntity() instanceof Player player) {
            ItemStack heldItem = player.getItemBySlot(EquipmentSlot.MAINHAND);
            if (heldItem.getItem() == ModItems.TUNGSTEN_CARBIDE_BATTLEAXE.get() &&
                    EnchantmentHelper.getItemEnchantmentLevel(registryLookup.getOrThrow(Enchantments.SHARPNESS), heldItem) >= 5)
            {
                //Drop Obsidian Dust trophy item and give it a long despawn delay.
                ItemEntity trophyItem = this.spawnAtLocation(ModItems.TROPHY_OBSIDIAN_DUST.get());
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
    public int getBaseExperienceReward() {
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