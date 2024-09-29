package net.dollar.apex.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ModBattleaxeItem extends TieredItem {
    /**
     * Constructs a new ModBattleaxeItem object.
     * @param tier Equipment tier
     * @param properties Item properties
     */
    public ModBattleaxeItem(Tier tier, Properties properties) {
        super(tier, properties);
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
        return (enchantment == Enchantments.SHARPNESS ||
                enchantment == Enchantments.BANE_OF_ARTHROPODS ||
                enchantment == Enchantments.SMITE ||
                enchantment == Enchantments.UNBREAKING ||
                enchantment == Enchantments.FIRE_ASPECT ||
                enchantment == Enchantments.LOOTING ||
                enchantment == Enchantments.MENDING);   //NOTE: Mending is treasure only, this just allows books.
    }

    /**
     * Checks whether a player can attack a specific block with this item.
     * @return Whether the player can attack a block with this Item
     */
    public boolean canAttackBlock(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        return !player.isCreative();
    }

    /**
     * Calculate destroy speed of a specific block using this Item.
     * @param stack ItemStack corresponding to this Item
     * @param blockState BlockState of target block
     * @return Calculated destroy speed
     */
    public float getDestroySpeed(ItemStack stack, BlockState blockState) {
        return 1.0f;
    }

    /**
     * Performs Item-specific attack operations (ex. deal exactly 1 durability damage).
     * @param stack ItemStack corresponding to this Item
     * @param targetEntity Target LivingEntity
     * @param userEntity User LivingEntity
     * @return Whether the attack was successfully performed
     */
    public boolean hurtEnemy(ItemStack stack, LivingEntity targetEntity, LivingEntity userEntity) {
        stack.hurtAndBreak(1, userEntity, EquipmentSlot.MAINHAND);
        return true;
    }

//    /**
//     * Performs Item-specific mining operations (ex. deal durability damage).
//     * @param stack ItemStack corresponding to this Item
//     * @param level Active game Level
//     * @param blockState Blockstate of block being mined
//     * @param blockPos Position of block being mined
//     * @param userEntity User LivingEntity
//     * @return Whether the mining was successfully performed
//     */
//    public boolean mineBlock(ItemStack stack, Level level, BlockState blockState, BlockPos blockPos, LivingEntity userEntity) {
//        if (blockState.getDestroySpeed(level, blockPos) != 0.0F) {
//            stack.hurtAndBreak(1, userEntity, (livingEntity) -> {
//                livingEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
//            }); //Change to deal only 1 durability damage instead of 2.
//        }
//
//        return true;
//    }

//    /**
//     * Gets Map of default attribute modifiers for the corresponding EquipmentSlot.
//     * @param slot EquipmentSlot corresponding to this Item
//     * @return Multimap of Attributes, AttributeModifiers
//     */
//    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
//        return slot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
//    }

    /**
     * Checks whether this Item can perform a specific ToolAction (false).
     * @param stack ItemStack corresponding to this Item
     * @param toolAction ToolAction being queried
     * @return Whether this Item can perform the queried ToolAction
     */
    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        return false;
    }
}
