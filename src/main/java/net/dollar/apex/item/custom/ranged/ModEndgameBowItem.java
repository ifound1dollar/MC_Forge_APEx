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
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.BiConsumer;


public class ModEndgameBowItem extends BowItem {
    private final ModItemUtils.EndgameTier endgameTier;
    private final BiConsumer<List<Component>, ModItemUtils.EquipmentType> tooltipMethod;

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
     * @param tooltip List of tooltip texts to render
     * @param flag TooltipFlag determining data like simple or advanced
     */
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltipMethod.accept(tooltip, ModItemUtils.EquipmentType.RANGED);
    }
}
