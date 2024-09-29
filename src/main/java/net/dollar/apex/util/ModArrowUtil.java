package net.dollar.apex.util;

import net.dollar.apex.item.custom.arrow.CobaltSteelArrowEntity;
import net.dollar.apex.item.custom.arrow.InfusedGemstoneArrowEntity;
import net.dollar.apex.item.custom.arrow.TungstenCarbideArrowEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ModArrowUtil {
    public enum ARROW_TYPE { INFUSED, COBALT, CARBIDE }

    /**
     * Creates a custom arrow entity specific to the Steel, Infused Gemstone, Netherite, or Tungsten-Carbide
     *  bows/crossbows. Each is of a custom ArrowEntity class with special onHit() functionality.
     * @param level Active world
     * @param shooter LivingEntity firing the weapon
     * @param arrowStack ItemStack where the arrow is pulled from (used for Spectral/Tipped behavior)
     * @param type Enum determining which of the four bow/crossbow types to spawn the ArrowEntity for
     * @return The newly created custom PersistentProjectileEntity
     */
    public static AbstractArrow createCustomArrow(Level level, LivingEntity shooter,
                                                  ItemStack arrowStack, ARROW_TYPE type) {
        Arrow arrowEntity;

        //For each case, first generate the correct type of ArrowEntity. Then, check whether it is
        //  spectral. Finally, implicitly cast it to the ArrowEntity class by assigning it to arrowEntity.
        switch (type) {
            case INFUSED -> {
                InfusedGemstoneArrowEntity temp = new InfusedGemstoneArrowEntity(level, shooter, arrowStack);
                temp.checkIsSpectral(arrowStack);
                arrowEntity = temp;
            }
            case CARBIDE -> {
                TungstenCarbideArrowEntity temp = new TungstenCarbideArrowEntity(level, shooter, arrowStack);
                temp.checkIsSpectral(arrowStack);
                arrowEntity = temp;
            }
            default -> {    //Guaranteed to be COBALT
                CobaltSteelArrowEntity temp = new CobaltSteelArrowEntity(level, shooter, arrowStack);
                temp.checkIsSpectral(arrowStack);
                arrowEntity = temp;
            }
        }

        //Before returning and implicitly casting the Arrow to an AbstractArrow, initialize
        //  the ArrowEntity from the ItemStack (for Tipped Arrow behaviors).
//        arrowEntity.setEffectsFromItem(arrowStack);
        return arrowEntity;
    }
}
