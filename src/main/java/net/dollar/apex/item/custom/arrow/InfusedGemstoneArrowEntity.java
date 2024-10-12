package net.dollar.apex.item.custom.arrow;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpectralArrowItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;

public class InfusedGemstoneArrowEntity extends Arrow {
    private boolean isSpectral;

    public InfusedGemstoneArrowEntity(Level level, LivingEntity owner, ItemStack arrowStack, ItemStack weaponStack) {
        super(level, owner, arrowStack, weaponStack);
    }



    /**
     * Checks whether the passed-in ItemStack's corresponding Item is a SpectralArrowItem, setting
     *  the local isSpectral variable if so (affects onHit() behavior).
     * @param arrow ItemStack of the ArrowItem used to spawn this ArrowEntity
     */
    public void checkIsSpectral(ItemStack arrow) {
        if (arrow.getItem() instanceof SpectralArrowItem) { isSpectral = true; }
    }

    /**
     * Sets the base damage value of this ArrowEntity (set to 3.0 from 2.0).
     * @param damage New base damage (default 2.0)
     */
    @Override
    public void setBaseDamage(double damage) {
        super.setBaseDamage(3.0);
    }

    /**
     * Performs operations as the arrow hits a target LivingEntity.
     * @param hitResult EntityHitResult from collision
     */
    @Override
    protected void onHitEntity(@NotNull EntityHitResult hitResult) {
        super.onHitEntity(hitResult);

        //Only if hit Entity is a LivingEntity.
        if (hitResult.getEntity() instanceof LivingEntity livingEntity) {
            //If the arrow is spectral, make the target glowing (same functionality as actual Spectral Arrow).
            if (isSpectral) {
                MobEffectInstance statusEffectInstance = new MobEffectInstance(
                        MobEffects.GLOWING, 200, 0); //10 seconds
                livingEntity.addEffect(statusEffectInstance, this.getOwner());
            }

            //Apply Wither effect to target for configurable duration in seconds.
            //TODO: RE-IMPLEMENT CONFIGS
            //Level 2 wither for once-per-second damage tick (duration +1 tick so ticks 4 times).
//            target.addEffect(new MobEffectInstance(MobEffects.WITHER,
//                    (ModCommonConfigs.ENDGAME_TIER_EFFECT_SECONDS.get() * 20) + 1, 1));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER,
                    (4 * 20) + 1, 1));
        }
    }
}
