package net.dollar.apex.item.custom.equipment;

import net.dollar.apex.item.custom.ModPaxelItem;
import net.dollar.apex.util.ModItemUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModCobaltSteelPaxelItem extends ModPaxelItem {
    /**
     * Instantiates a new Cobalt-Steel Paxel item. This class must remain distinct
     *  from the other generic Endgame classes because it overrides getMiningSpeed().
     * @param material ToolMaterial for this Item
     * @param attackDamage Attack damage of this Item
     * @param attackSpeed Attack speed of this Item
     * @param properties Item.Properties for this Item
     */
    public ModCobaltSteelPaxelItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
    }



    /**
     * Gets the mining speed of this Tool, depending on the Block being mined. Overridden to
     *  double base mining speed when mining Deepslate (enables instant-mining with E5 + H2).
     * @param itemStack ItemStack corresponding to this Item
     * @param state BlockState of the Block being mined
     * @return The mining (destroy) speed of the Block being mined with this Tool.
     */
    @Override
    public float getDestroySpeed(@NotNull ItemStack itemStack, @NotNull BlockState state) {
        float baseVal = super.getDestroySpeed(itemStack, state);

        // If the block being mined is Deepslate, increase mining speed by a further 100% (allows instant
        //  mining with Cobalt Steel Paxel/Pickaxe w/Efficiency V & Haste II : results in total mining speed
        //  of 92.4, needs 90).
        // This means that mining Deepslate will always be extremely fast, but this method only allows
        //  accessing the base destroy speed (defined by the ToolMaterial). There is no way to efficiently
        //  increase mining speed only under certain conditions (cannot justify checking enchantment level
        //  of the tool each time this method is called, that is too inefficient).
        return (state.getBlock() == Blocks.DEEPSLATE) ? baseVal * 2.0f : baseVal;
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
        ModItemUtils.applyCobaltSteelOnHit(target);
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
        ModItemUtils.appendCobaltSteelEquipmentTooltip(tooltip, ModItemUtils.EquipmentType.TOOL);
    }
}
