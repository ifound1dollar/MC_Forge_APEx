package net.dollar.apex.item.custom;

import net.dollar.apex.util.ModItemUtils;
import net.dollar.apex.util.ModTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class ModPaxelItem extends DiggerItem {
    public ModPaxelItem(Tier tier, Properties properties) {
        super(tier, ModTags.Blocks.MOD_PAXEL_MINEABLE, properties);
    }



    /**
     * Allow or deny specific enchantment application to this Item. For Battleaxes, allow all
     *  vanilla weapon enchantments except Sweeping Edge.
     * @param stack The ItemStack attempting to be enchanted (this)
     * @param enchantment The Enchantment attempting to be applied
     * @return Whether the enchantment is allowed
     */
    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return (enchantment == Enchantments.EFFICIENCY ||
                enchantment == Enchantments.FORTUNE ||
                enchantment == Enchantments.SILK_TOUCH ||
                enchantment == Enchantments.UNBREAKING ||
                enchantment == Enchantments.MENDING);   //NOTE: Mending is treasure only, this just allows books.
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
