package net.dollar.apex.entity.ability;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class ModFireballEntity extends SmallFireball {
    /**
     * Instantiates a ModFireballEntity object, which derives from SmallFireball and
     *  behaves almost identically. Overridden to slightly reduce burn time when a fireball
     *  hits an Entity, and not spawn fire when a fireball hits a block.
     * @param level Level this fireball is being spawned within
     * @param owner LivingEntity spawning this fireball
     * @param velocity Velocity (on construction) of this fireball entity; remains constant
     */
    public ModFireballEntity(Level level, LivingEntity owner, Vec3 velocity) {
        super(level, owner, velocity.x, velocity.y, velocity.z);
    }



    @Override
    protected void onHitEntity(@NotNull EntityHitResult entityHitResult) {
        // This method is directly copied from SmallFireball, but igniteForSeconds() duration has
        //  been set to 4s (from 5s). Also, multiple local variables have been renamed.
        super.onHitEntity(entityHitResult);

        if (!this.level().isClientSide) {
            Entity hitEntity = entityHitResult.getEntity();
            Entity ownerEntity = this.getOwner();
            int fireTicks = hitEntity.getRemainingFireTicks();
            hitEntity.setSecondsOnFire(4);      // Changed from 5 -> 4.

            DamageSource damageSource = this.damageSources().fireball(this, ownerEntity);
            if (!hitEntity.hurt(damageSource, 5.0F)) {
                hitEntity.setRemainingFireTicks(fireTicks);
            } else if (ownerEntity instanceof LivingEntity ownerLivingEntity) {
                this.doEnchantDamageEffects(ownerLivingEntity, hitEntity);
            }
        }
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult blockHitResult) {
        // Do nothing on block hit, do not want to start a fire (CAN WE MAKE NON-SPREADING FIRE???)
    }
}
