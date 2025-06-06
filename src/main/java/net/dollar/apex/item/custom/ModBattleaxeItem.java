package net.dollar.apex.item.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class ModBattleaxeItem extends Item {
    /**
     * Constructs a new ModBattleaxeItem object.
     * @param material Equipment material
     * @param properties Item properties
     */
    public ModBattleaxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Properties properties) {
        super(properties
                .sword(material, attackDamage, attackSpeed));
    }



    /**
     * Calculate destroy speed of a specific block using this Item.
     * @param stack ItemStack corresponding to this Item
     * @param blockState BlockState of target block
     * @return Calculated destroy speed
     */
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState blockState) {
        return 1.0f;
    }

    /**
     * Performs Item-specific attack operations (ex. deal exactly 1 durability damage).
     * @param stack ItemStack corresponding to this Item
     * @param targetEntity Target LivingEntity
     * @param userEntity User LivingEntity
     */
    public void hurtEnemy(ItemStack stack, @NotNull LivingEntity targetEntity, @NotNull LivingEntity userEntity) {
        stack.hurtAndBreak(1, userEntity, EquipmentSlot.MAINHAND);
    }

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
