package net.dollar.apex.item.custom.ranged;

import net.dollar.apex.util.ModItemUtils;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpectralArrowItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModCustomArrowEntity extends Arrow {
    private boolean isSpectral;
    private final Consumer<LivingEntity> onHitMethod;

    public ModCustomArrowEntity(Level level, LivingEntity owner, ItemStack arrowStack,
                                ModItemUtils.EndgameTier tier) {
        super(level, owner, arrowStack);
        setBaseDamage(3.0f);

        // Set Consumer method reference.
        switch (tier) {
            case COBALT_STEEL -> onHitMethod = ModItemUtils::applyCobaltSteelOnHit;
            case INFUSED_GEMSTONE -> onHitMethod = ModItemUtils::applyInfusedGemstoneOnHit;
            case TUNGSTEN_CARBIDE -> onHitMethod = ModItemUtils::applyTungstenCarbideOnHit;
            default -> throw new IllegalStateException("Unexpected value: " + tier);
        }
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
     * Performs operations as the arrow hits a target LivingEntity.
     * @param hitResult EntityHitResult from collision
     */
    @Override
    protected void onHitEntity(@NotNull EntityHitResult hitResult) {
        super.onHitEntity(hitResult);

        // Only if hit Entity is a LivingEntity.
        if (hitResult.getEntity() instanceof LivingEntity target) {
            // If the arrow is spectral, make the target glowing (same functionality as actual Spectral Arrow).
            if (isSpectral) {
                MobEffectInstance statusEffectInstance = new MobEffectInstance(
                        MobEffects.GLOWING, 200, 0); //10 seconds
                target.addEffect(statusEffectInstance, this.getOwner());
            }

            // Apply special on-hit effect when this arrow entity hits a LivingEntity.
            onHitMethod.accept(target);
        }
    }
}
