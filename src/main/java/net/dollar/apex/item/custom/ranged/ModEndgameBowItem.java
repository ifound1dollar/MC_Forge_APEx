package net.dollar.apex.item.custom.ranged;


import net.dollar.apex.util.ModItemUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Corresponds to an endgame-tier Bow item. Spawns a custom ArrowEntity which
 *  deals bonus damage and applies an effect on-hit.
 */
public class ModEndgameBowItem extends BowItem {
    private final ModItemUtils.EndgameTier endgameTier;
    private final BiConsumer<Consumer<Component>, ModItemUtils.EquipmentType> tooltipMethod;

    /**
     * Instantiates a new endgame-tier Bow item for the passed-in EndgameTier. Spawns
     *  a custom ArrowEntity when fired which deals bonus damage and applies an effect on-hit.
     * @param tier EndgameTier for this Bow item
     * @param properties Item.Properties for this Bow item
     */
    public ModEndgameBowItem(ModItemUtils.EndgameTier tier, Item.Properties properties) {
        super(properties);

        // Set endgameTier field and tooltip method reference based on passed-in EndgameTier.
        this.endgameTier = tier;
        switch (tier) {
            case COBALT_STEEL -> tooltipMethod = ModItemUtils::appendCobaltSteelEquipmentTooltip;
            case INFUSED_GEMSTONE -> tooltipMethod = ModItemUtils::appendInfusedGemstoneEquipmentTooltip;
            case TUNGSTEN_CARBIDE -> tooltipMethod = ModItemUtils::appendTungstenCarbideEquipmentTooltip;
            default -> throw new IllegalStateException("Unexpected value: " + tier);
        }
    }



    /**
     * Creates the projectile fired from this Bow. Is overridden here to create custom arrow.
     * @param level Active Level
     * @param shooter Shooter LivingEntity
     * @param weaponStack ItemStack corresponding to this weapon
     * @param arrowStack ItemStack corresponding to the arrow to be fired
     * @param crit Whether the arrow will critically strike
     * @return The generated Projectile entity
     */
    @Override
    protected @NotNull Projectile createProjectile(@NotNull Level level, @NotNull LivingEntity shooter,
                                                   @NotNull ItemStack weaponStack, @NotNull ItemStack arrowStack,
                                                   boolean crit) {
        //Replace vanilla functionality to get the ArrowItem from the found ItemStack with this function. Will
        //  automatically handle Spectral Arrow and Tipped Arrow functionality in-method.
        AbstractArrow abstractarrow = ModItemUtils.createCustomArrow(
                level, shooter, arrowStack, weaponStack, endgameTier);

        if (crit) {
            abstractarrow.setCritArrow(true);
        }

        return abstractarrow;
    }

    /**
     * Appends text to the Item's hover tooltip.
     * @param stack ItemStack corresponding to this item
     * @param context Relevant TooltipContext
     * @param display TooltipDisplay corresponding to this tooltip
     * @param tooltip List of tooltip text Components to render
     * @param flag TooltipFlag determining data like simple or advanced
     */
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull TooltipDisplay display,
                                @NotNull Consumer<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltipMethod.accept(tooltip, ModItemUtils.EquipmentType.RANGED);
    }
}
