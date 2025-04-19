package net.dollar.apex.item.custom;

import net.dollar.apex.util.ModItemUtils;
import net.dollar.apex.util.ModTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;

public class ModPaxelItem extends DiggerItem {
    public ModPaxelItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(material, ModTags.Blocks.MOD_PAXEL_MINEABLE, attackDamage, attackSpeed, properties);
    }



    /**
     * Checks whether this Item can perform a specific ToolAction. Allows all Axe, Hoe, Pickaxe,
     *  and Shovel tool actions.
     * @param stack ItemStack corresponding to this Item
     * @param toolAction ToolAction being queried
     * @return Whether this Item can perform the queried ToolAction
     */
    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        return ModItemUtils.DEFAULT_PAXEL_ACTIONS.contains(toolAction);
    }
}
