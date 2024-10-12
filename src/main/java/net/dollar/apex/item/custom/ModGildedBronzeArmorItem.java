package net.dollar.apex.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModGildedBronzeArmorItem extends ArmorItem {
    public ModGildedBronzeArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
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
     * Allow or deny specific enchantment application to this Item. For Battleaxes, allow all
     *  vanilla weapon enchantments except Sweeping Edge.
     * @param stack The ItemStack attempting to be enchanted (this)
     * @param enchantment The Enchantment attempting to be applied
     * @return Whether the enchantment is allowed
     */
    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (this.type == Type.HELMET) {
            return (enchantment == Enchantments.AQUA_AFFINITY ||
                    enchantment == Enchantments.BLAST_PROTECTION ||
                    enchantment == Enchantments.FIRE_PROTECTION ||
                    enchantment == Enchantments.PROJECTILE_PROTECTION ||
                    enchantment == Enchantments.PROTECTION ||
                    enchantment == Enchantments.RESPIRATION ||
                    enchantment == Enchantments.UNBREAKING ||
                    enchantment == Enchantments.MENDING);
        } else if (this.type == Type.CHESTPLATE) {
            return (enchantment == Enchantments.BLAST_PROTECTION ||
                    enchantment == Enchantments.FIRE_PROTECTION ||
                    enchantment == Enchantments.PROJECTILE_PROTECTION ||
                    enchantment == Enchantments.PROTECTION ||
                    enchantment == Enchantments.THORNS ||
                    enchantment == Enchantments.UNBREAKING ||
                    enchantment == Enchantments.MENDING);
        } else if (this.type == Type.LEGGINGS) {
            return (enchantment == Enchantments.BLAST_PROTECTION ||
                    enchantment == Enchantments.FIRE_PROTECTION ||
                    enchantment == Enchantments.PROJECTILE_PROTECTION ||
                    enchantment == Enchantments.PROTECTION ||
                    enchantment == Enchantments.SWIFT_SNEAK ||
                    enchantment == Enchantments.UNBREAKING ||
                    enchantment == Enchantments.MENDING);
        } else if (this.type == Type.BOOTS) {
            return (enchantment == Enchantments.BLAST_PROTECTION ||
                    enchantment == Enchantments.DEPTH_STRIDER ||
                    enchantment == Enchantments.FEATHER_FALLING ||
                    enchantment == Enchantments.FROST_WALKER ||
                    enchantment == Enchantments.FIRE_PROTECTION ||
                    enchantment == Enchantments.PROJECTILE_PROTECTION ||
                    enchantment == Enchantments.PROTECTION ||
                    enchantment == Enchantments.SOUL_SPEED ||
                    enchantment == Enchantments.UNBREAKING ||
                    enchantment == Enchantments.MENDING);
        }
        return false;   //Return false if none of the types above.
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
        tooltip.add(Component.translatable("tooltip.gilded_bronze_armor"));
    }
}
