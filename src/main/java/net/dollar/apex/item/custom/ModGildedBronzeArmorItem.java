package net.dollar.apex.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModGildedBronzeArmorItem extends Item {
    public ModGildedBronzeArmorItem(ArmorMaterial material, ArmorType type, Properties properties) {
        super(properties
                .humanoidArmor(material, type));
    }



    /**
     * Determines whether an ItemStack of this Item pacifies Piglins (true).
     * @param stack ItemStack corresponding to this Item
     * @param wearer The LivingEntity wearing this ItemStack
     * @return Whether this item makes Piglins neutral
     */
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
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
        tooltip.accept(Component.translatable("tooltip.gilded_bronze_armor"));
    }
}
