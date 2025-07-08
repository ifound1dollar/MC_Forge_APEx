package net.dollar.apex.entity.goal;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.function.Predicate;

/**
 * This goal prioritizes staring at a target class when within range, else will do random strolls.
 *  Based off of LookAtPlayerGoal and WaterAvoidingRandomStrollGoal.
 */
public class ModStareOrMoveGoal extends Goal {
    private enum State { IDLE, LOOKING, MOVING }

    protected final PathfinderMob mob;
    private State state = State.IDLE;

    @Nullable
    protected LivingEntity lookAt;
    protected final float lookDistance;
    private final double lookDistSquared;
    protected final Class<? extends LivingEntity> lookAtType;
    protected final TargetingConditions lookAtContext;

    public static final int DEFAULT_INTERVAL = 120;
    protected double wantedX;
    protected double wantedY;
    protected double wantedZ;
    protected final double speedModifier;
    protected int interval;
    protected boolean forceTrigger;
    private final boolean checkNoActionTime;
    private final float probability;

    private int staringForTicks = 0;
    private static final int STARING_FOR_TICKS_ANGER_THRESHOLD = 200;

    /**
     * Constructs a new ModStareOrMoveGoal instance, which causes the mob to look at a target
     *  mob type indefinitely when valid and in range, else the mob makes random strolls.
     * @param mob PathfinderMob this Goal is attached to
     * @param lookAtType LivingEntity class to look at (mob type)
     * @param lookRange Range that the mob will start looking at the target
     * @param moveSpeedModifier Speed modifier for mob movement
     * @param moveProbability Probability each tick that movement will start (only while not looking)
     */
    public ModStareOrMoveGoal(PathfinderMob mob, Class<? extends LivingEntity> lookAtType, float lookRange,
                              double moveSpeedModifier, float moveProbability) {
        this.mob = mob;
        setFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.MOVE));

        // Looking
        this.lookAtType = lookAtType;
        this.lookDistance = lookRange;
        this.lookDistSquared = ((double)lookRange * lookRange);
        if (lookAtType == Player.class) {
            Predicate<Entity> predicate = EntitySelector.notRiding(mob);
            lookAtContext = TargetingConditions.forNonCombat().range(lookRange).selector(
                    (p_359094_, p_359095_) -> predicate.test(p_359094_));
        } else {
            lookAtContext = TargetingConditions.forNonCombat().range(lookRange);
        }

        // Moving
        this.speedModifier = moveSpeedModifier;
        this.probability = moveProbability;
        this.interval = DEFAULT_INTERVAL;
        this.checkNoActionTime = true;
    }



    /**
     * Returns whether this Goal is ready to be used. Returns true if the mob can do EITHER action,
     *  looking or moving. Prioritizes looking.
     * @return Whether the Goal can be used.
     */
    @Override
    public boolean canUse() {
        // Seek a valid look target, and return true immediately if one is found.
        if (findNewLookAtTarget()) return true;

        // Else if no valid look target, check if a random stroll can be started.
        if (!forceTrigger) {
            if (checkNoActionTime && mob.getNoActionTime() >= 100) {
                return false;
            }

            if (mob.getRandom().nextInt(reducedTickDelay(interval)) != 0) {
                return false;
            }
        }

        // Get a random position for movement, and set fields if successful.
        Vec3 vec3 = getRandomTargetPos();
        if (vec3 == null) {
            return false;
        } else {
            wantedX = vec3.x;
            wantedY = vec3.y;
            wantedZ = vec3.z;
            forceTrigger = false;
            return true;
        }
    }

    /**
     * Seeks out a new lookAt Entity, setting the field directly. Returns whether a new target
     *  was found.
     * @return True if a new lookAt Entity was found.
     */
    protected boolean findNewLookAtTarget() {
        ServerLevel serverlevel = getServerLevel(mob);

        if (lookAtType == Player.class) {
            lookAt = serverlevel.getNearestPlayer(
                    lookAtContext, mob, mob.getX(), mob.getEyeY(), mob.getZ());
        } else {
            lookAt = serverlevel.getNearestEntity(serverlevel.getEntitiesOfClass(lookAtType,
                            mob.getBoundingBox().inflate(lookDistance, 3.0, lookDistance),
                            p_148124_ -> true),
                    lookAtContext, mob, mob.getX(), mob.getEyeY(), mob.getZ());
        }

        return (lookAt != null);
    }

    /**
     * Checks whether the current lookAt Entity is valid. Checks nullity, if alive, and distance.
     * @return True if the lookAt Entity is valid.
     */
    protected boolean checkLookAtTargetIsValid() {
        return (lookAt != null && lookAt.isAlive()
                && (mob.distanceToSqr(lookAt) <= lookDistSquared));
    }

    /**
     * Gets a random 3-vector position to be used as a movement target. Prioritizes avoiding water,
     *  else chooses a default random position.
     * @return The generated 3-vector world position, or null if none is available.
     */
    @Nullable
    protected Vec3 getRandomTargetPos() {
        // If in water, try to find position on land, else find default position.
        if (mob.isInWater()) {
            Vec3 vec3 = LandRandomPos.getPos(this.mob, 15, 7);
            if (vec3 == null) {
                vec3 = DefaultRandomPos.getPos(this.mob, 10, 7);
            }

            return vec3;
        }

        // Else seek random position if passes probability check (water-avoiding only if fails, otherwise default).
        return (mob.getRandom().nextFloat() >= probability) ?
                LandRandomPos.getPos(mob, 10, 7) :
                DefaultRandomPos.getPos(this.mob, 10, 7);
    }

    /**
     * Gets whether this Goal can continue being used, returning true if EITHER looking or
     *  movement can continue. Prioritizes looking.
     * @return Whether this Goal can continue being used.
     */
    @Override
    public boolean canContinueToUse() {
        if (state == State.LOOKING) {
            // While LOOKING, return whether the lookAt target is still valid.
            return checkLookAtTargetIsValid();

        } else if (state == State.MOVING) {
            // If MOVING but a valid lookAt target was found, return false to stop MOVING and start LOOKING.
            if (findNewLookAtTarget()) {
                return false;
            } else {
                // Else MOVING but no valid look target, so return whether movement is done.
                return !mob.getNavigation().isDone();
            }
        }

        // Else state is IDLE, so always return false (this method should never be called while IDLE).
        return false;
    }

    /**
     * Starts this Goal. If there is a valid look target, begins looking. If no valid look
     *  target, begins movement navigation.
     */
    @Override
    public void start() {
        // Start looking if valid lookAt target, else start movement navigation.
        if (lookAt != null && lookAt.isAlive()) {
            state = State.LOOKING;
        } else {
            mob.getNavigation().moveTo(wantedX, wantedY, wantedZ, speedModifier);
            state = State.MOVING;
        }
    }

    /**
     * Stops this Goal. Stops both looking and movement by default.
     */
    @Override
    public void stop() {
        // Nullify lookAt to stop looking, and stop navigation (movement).
        this.lookAt = null;
        this.mob.getNavigation().stop();
        super.stop();

        // Reset staring ticks and set state to IDLE.
        staringForTicks = 0;
        state = State.IDLE;
    }

    /**
     * Runs per-tick operations for this Goal. This method is only necessary for looking, as
     *  movement uses a navigation component to move (not this Goal directly).
     */
    @Override
    public void tick() {
        // Only if state is LOOKING and lookAt Entity is valid.
        if (state == State.LOOKING && lookAt != null && lookAt.isAlive()) {
            double lookAtTargetEyeY = lookAt.getEyeY();
            mob.getLookControl().setLookAt(lookAt.getX(), lookAtTargetEyeY, lookAt.getZ());

            // Ensure that lookAt target is a Player.
            if (!(lookAt instanceof Player player)) return;

            // If lookAt target is a player in creative or spectator mode, reset staringForTicks and return.
            if (player.isCreative() || player.isSpectator()) {
                staringForTicks = 0;
                return;
            }

            // Else should tick down anger time, rolling chance if greater than threshold.
            staringForTicks++;
            if (staringForTicks > STARING_FOR_TICKS_ANGER_THRESHOLD) {
                // Roll 1% chance per tick to get angry at lookAt target.
                if (mob.getRandom().nextInt(100) == 0) {

                    // If now angry at, get angry at target and play anger sound.
                    mob.setTarget(lookAt);
                    mob.playSound(SoundEvents.RAVAGER_ROAR);    // Volume uses 0.666f by default.

                    // Add Speed effect on aggro for an exciting start, also removing Slowness if active.
                    mob.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 2,
                            false, false));     // 60% movement speed bonus, 20% per level.
                    mob.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);

                    // Stop the goal (must be called AFTER setting target because stop() nullifies lookAt target).
                    stop();
                }
            }
        }
    }
}
