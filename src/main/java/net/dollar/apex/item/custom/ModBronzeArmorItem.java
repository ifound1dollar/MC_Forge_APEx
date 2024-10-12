package net.dollar.apex.item.custom;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class ModBronzeArmorItem extends ArmorItem {
    public ModBronzeArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
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
                    enchantment == Enchantments.ALL_DAMAGE_PROTECTION ||
                    enchantment == Enchantments.RESPIRATION ||
                    enchantment == Enchantments.UNBREAKING ||
                    enchantment == Enchantments.MENDING);
        } else if (this.type == Type.CHESTPLATE) {
            return (enchantment == Enchantments.BLAST_PROTECTION ||
                    enchantment == Enchantments.FIRE_PROTECTION ||
                    enchantment == Enchantments.PROJECTILE_PROTECTION ||
                    enchantment == Enchantments.ALL_DAMAGE_PROTECTION ||
                    enchantment == Enchantments.THORNS ||
                    enchantment == Enchantments.UNBREAKING ||
                    enchantment == Enchantments.MENDING);
        } else if (this.type == Type.LEGGINGS) {
            return (enchantment == Enchantments.BLAST_PROTECTION ||
                    enchantment == Enchantments.FIRE_PROTECTION ||
                    enchantment == Enchantments.PROJECTILE_PROTECTION ||
                    enchantment == Enchantments.ALL_DAMAGE_PROTECTION ||
                    enchantment == Enchantments.SWIFT_SNEAK ||
                    enchantment == Enchantments.UNBREAKING ||
                    enchantment == Enchantments.MENDING);
        } else if (this.type == Type.BOOTS) {
            return (enchantment == Enchantments.BLAST_PROTECTION ||
                    enchantment == Enchantments.DEPTH_STRIDER ||
                    enchantment == Enchantments.FALL_PROTECTION ||
                    enchantment == Enchantments.FROST_WALKER ||
                    enchantment == Enchantments.FIRE_PROTECTION ||
                    enchantment == Enchantments.PROJECTILE_PROTECTION ||
                    enchantment == Enchantments.ALL_DAMAGE_PROTECTION ||
                    enchantment == Enchantments.SOUL_SPEED ||
                    enchantment == Enchantments.UNBREAKING ||
                    enchantment == Enchantments.MENDING);
        }
        return false;   //Return false if none of the types above.
    }
}
