package net.dollar.apex.item.custom.cobaltsteel;

import net.dollar.apex.util.ModItemUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModCobaltSteelPickaxeItem extends Item {
    public ModCobaltSteelPickaxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(properties
                .pickaxe(material, attackDamage, attackSpeed));
    }



    /**
     * Performs normal post-hit operations but with chance to apply additional effect(s).
     * @param stack ItemStack of this Item
     * @param target Attacked (target) living entity
     * @param attacker Attacker (user) living entity
     */
    @Override
    public void hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        ModItemUtils.applyCobaltSteelOnHit(target);
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
        ModItemUtils.appendCobaltSteelEquipmentTooltip(tooltip, ModItemUtils.EquipmentType.TOOL);
    }
}
