package net.dollar.apex.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModGildedBronzeArmorItem extends ArmorItem {
    public ModGildedBronzeArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
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
     * @param level Relevant level
     * @param tooltip List of tooltip texts to render
     * @param flag TooltipFlag determining data like simple or advanced
     */
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, List<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.gilded_bronze_armor"));
    }
}
