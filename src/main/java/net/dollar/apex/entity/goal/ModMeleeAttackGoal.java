package net.dollar.apex.entity.goal;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.pathfinder.Path;

import java.util.EnumSet;

public class ModMeleeAttackGoal extends Goal {
    protected final PathfinderMob mob;
    private final double speedModifier;
    private final boolean followingTargetEvenIfNotSeen;

    private Path path;
    private double pathedTargetX;
    private double pathedTargetY;
    private double pathedTargetZ;

    private int ticksUntilNextPathRecalculation;
    private int ticksUntilNextAttack;
    private final int attackIntervalTicks;
    private long lastCanUseCheck;
    private final long COOLDOWN_BETWEEN_CAN_USE_CHECKS;

    /**
     * Instantiates a new ModMeleeAttackGoal, which is functionally similar to MeleeAttackGoal but
     *  supports explicitly setting attack speed on construction.
     * @param mob PathAwareEntity that this Goal is attached to
     * @param speed Movement speed of mob when actively attacking a target
     * @param followIfTargetNotSeen Whether to follow the target even if not seen (should be true)
     * @param attackIntervalTicks Minimum number of ticks between each attack attempt (attack speed)
     */
    public ModMeleeAttackGoal(PathfinderMob mob, double speed, boolean followIfTargetNotSeen, int attackIntervalTicks) {
        this.mob = mob;
        this.speedModifier = speed;
        this.followingTargetEvenIfNotSeen = followIfTargetNotSeen;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));

        this.attackIntervalTicks = attackIntervalTicks;
        this.COOLDOWN_BETWEEN_CAN_USE_CHECKS = attackIntervalTicks;
    }

    /**
     * Returns whether this Goal is ready to be used. Returns true if the mob has a valid target
     *  which it can attack.
     * @return Whether the Goal can be used.
     */
    @Override
    public boolean canUse() {
        long i = this.mob.level().getGameTime();

        // Verify attack cooldown, returning if still on cooldown.
        if (i - this.lastCanUseCheck < COOLDOWN_BETWEEN_CAN_USE_CHECKS) {
            return false;
        } else {
            // Get target, then start pathfinding if target valid.
            this.lastCanUseCheck = i;
            LivingEntity livingentity = this.mob.getTarget();
            if (livingentity == null) {
                return false;
            } else if (!livingentity.isAlive()) {
                return false;
            } else {
                this.path = this.mob.getNavigation().createPath(livingentity, 0);
                return this.path != null ? true : this.mob.isWithinMeleeAttackRange(livingentity);
            }
        }
    }

    /**
     * Gets whether this Goal can continue being used, returning true if the mob still
     *  has an attackable target.
     * @return Whether this Goal can continue being used.
     */
    @Override
    public boolean canContinueToUse() {
        // Get target and verify valid, then handle navigation.
        LivingEntity livingentity = this.mob.getTarget();
        if (livingentity == null) {
            return false;
        } else if (!livingentity.isAlive()) {
            return false;
        } else if (!this.followingTargetEvenIfNotSeen) {
            return !this.mob.getNavigation().isDone();
        } else {
            return !this.mob.isWithinRestriction(livingentity.blockPosition())
                    ? false
                    : !(livingentity instanceof Player player && (player.isSpectator() || player.isCreative()));
        }
    }

    /**
     * Starts executing this Goal. Begins movement toward the target and begins attacking it.
     */
    @Override
    public void start() {
        this.mob.getNavigation().moveTo(this.path, this.speedModifier);
        this.mob.setAggressive(true);
        this.ticksUntilNextPathRecalculation = 0;
        this.ticksUntilNextAttack = 0;
    }

    /**
     * Stops execution of this Goal. Nullifies target, stops attacking, and stops navigation.
     */
    @Override
    public void stop() {
        LivingEntity livingentity = this.mob.getTarget();
        if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) {
            this.mob.setTarget(null);
        }

        this.mob.setAggressive(false);
        this.mob.getNavigation().stop();
    }

    /**
     * Gets whether this Goal should run every tick. Overridden to always return true.
     * @return True if this Goal should run every tick (overridden to always return true)
     */
    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    /**
     * Runs per-tick operations for this Goal. Used to move toward and actually attack
     *  the target.
     */
    @Override
    public void tick() {
        LivingEntity livingentity = this.mob.getTarget();

        if (livingentity != null) {
            this.mob.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
            this.ticksUntilNextPathRecalculation = Math.max(this.ticksUntilNextPathRecalculation - 1, 0);

            if ((this.followingTargetEvenIfNotSeen || this.mob.getSensing().hasLineOfSight(livingentity))
                    && this.ticksUntilNextPathRecalculation <= 0
                    && (this.pathedTargetX == 0.0 && this.pathedTargetY == 0.0 && this.pathedTargetZ == 0.0
                    || livingentity.distanceToSqr(this.pathedTargetX, this.pathedTargetY, this.pathedTargetZ) >= 1.0
                    || this.mob.getRandom().nextFloat() < 0.05F
            )) {
                this.pathedTargetX = livingentity.getX();
                this.pathedTargetY = livingentity.getY();
                this.pathedTargetZ = livingentity.getZ();
                this.ticksUntilNextPathRecalculation = 4 + this.mob.getRandom().nextInt(7);
                double d0 = this.mob.distanceToSqr(livingentity);

                if (d0 > 1024.0) {
                    this.ticksUntilNextPathRecalculation += 10;
                } else if (d0 > 256.0) {
                    this.ticksUntilNextPathRecalculation += 5;
                }

                if (!this.mob.getNavigation().moveTo(livingentity, this.speedModifier)) {
                    this.ticksUntilNextPathRecalculation += 15;
                }

                this.ticksUntilNextPathRecalculation = this.adjustedTickDelay(this.ticksUntilNextPathRecalculation);
            }

            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
            this.checkAndPerformAttack(livingentity);
        }
    }

    /**
     * Actually attempts to attack the target, checking whether an attack is possible and
     *  then resetting attack cooldown and actually attacking if true.
     * @param target The LivingEntity being attacked
     */
    protected void checkAndPerformAttack(LivingEntity target) {
        if (this.canPerformAttack(target)) {
            this.resetAttackCooldown();
            this.mob.swing(InteractionHand.MAIN_HAND);
            this.mob.doHurtTarget(getServerLevel(this.mob), target);
        }
    }

    /**
     * Resets the cooldown of this Goal. The cooldown of this Goal is the attack cooldown.
     */
    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackIntervalTicks);
    }

    /**
     * Gets whether the cooldown of this Goal has completed fully. The cooldown of this Goal
     *  is the attack cooldown.
     * @return True if the cooldown has completed and an attack is ready to be used again
     */
    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    /**
     * Gets whether the mob this Goal is attached to can attack the passed-in LivingEntity.
     * @param target The LivingEntity in question
     * @return True if the LivingEntity can be attacked (Goal not on cooldown and target is visible and in range)
     */
    protected boolean canPerformAttack(LivingEntity target) {
        return this.isTimeToAttack() && this.mob.isWithinMeleeAttackRange(target)
                && this.mob.getSensing().hasLineOfSight(target);
    }
}
