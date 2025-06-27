package net.dollar.apex.item.custom.infusedgemstone;

import net.dollar.apex.util.ModItemUtils;
import net.dollar.apex.util.ModToolTiers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ModEndgameAxeItem extends AxeItem {
    private final Consumer<LivingEntity> onHitMethod;
    private final BiConsumer<List<Component>, ModItemUtils.EquipmentType> tooltipMethod;

    public ModEndgameAxeItem(Tier material, float attackDamage, float attackSpeed, ModItemUtils.EndgameTier tier) {
        super(material, new Item.Properties()
                .attributes(AxeItem.createAttributes(
                        ModToolTiers.INFUSED_GEMSTONE, attackDamage, attackSpeed))
                .fireResistant());

        // Set proper method references to both Consumers.
        switch (tier) {
            case COBALT_STEEL -> {
                onHitMethod = ModItemUtils::applyCobaltSteelOnHit;
                tooltipMethod = ModItemUtils::appendCobaltSteelEquipmentTooltip;
            }
            case INFUSED_GEMSTONE -> {
                onHitMethod = ModItemUtils::applyInfusedGemstoneOnHit;
                tooltipMethod = ModItemUtils::appendInfusedGemstoneEquipmentTooltip;
            }
            case TUNGSTEN_CARBIDE -> {
                onHitMethod = ModItemUtils::applyTungstenCarbideOnHit;
                tooltipMethod = ModItemUtils::appendTungstenCarbideEquipmentTooltip;
            }
            default -> throw new IllegalStateException("Unexpected value: " + tier);
        }
    }



    /**
     * Performs normal post-hit operations but with chance to apply additional effect(s).
     * @param stack ItemStack of this Item
     * @param target Attacked (target) living entity
     * @param attacker Attacker (user) living entity
     * @return Whether attack was successfully performed
     */
    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        onHitMethod.accept(target);
        return super.hurtEnemy(stack, target, attacker);
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
        tooltipMethod.accept(tooltip, ModItemUtils.EquipmentType.TOOL);
    }
}
