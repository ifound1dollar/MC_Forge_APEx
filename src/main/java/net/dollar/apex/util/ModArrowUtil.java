package net.dollar.apex.util;

import net.dollar.apex.item.custom.arrow.ModCustomArrowEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ModArrowUtil {
    public enum ArrowType { COBALT_STEEL, INFUSED_GEMSTONE, TUNGSTEN_CARBIDE }

    /**
     * Creates a custom arrow entity specific to the Steel, Infused Gemstone, Netherite, or Tungsten-Carbide
     *  bows/crossbows. Each is of a custom ArrowEntity class with special onHit() functionality.
     * @param level Active world
     * @param shooter LivingEntity firing the weapon
     * @param arrowStack ItemStack where the arrow is pulled from (used for Spectral/Tipped behavior)
     * @param type Enum determining which of the three bow/crossbow types to spawn the ArrowEntity for
     * @return The newly created custom PersistentProjectileEntity
     */
    public static AbstractArrow createCustomArrow(Level level, LivingEntity shooter,
                                                  ItemStack arrowStack, ArrowType type) {
        ModCustomArrowEntity arrowEntity = new ModCustomArrowEntity(level, shooter, type);
        arrowEntity.checkIsSpectral(arrowStack);
        arrowEntity.setEffectsFromItem(arrowStack);
        return arrowEntity;

        //Before returning and implicitly casting the Arrow to an AbstractArrow, initialize
        //  the ArrowEntity from the ItemStack (for Tipped Arrow behaviors).
//        arrowEntity.setEffectsFromItem(arrowStack);
//        return arrowEntity;
    }
}
