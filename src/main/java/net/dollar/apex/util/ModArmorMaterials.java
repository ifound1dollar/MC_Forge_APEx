package net.dollar.apex.util;

import com.google.common.collect.Maps;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.Map;

/**
 * Defines ArmorMaterials for each of the new equipment tiers (Bronze, Gilded Bronze,
 *  Cobalt-Steel, Infused Gemstone, and Tungsten-Carbide).
 */
public interface ModArmorMaterials {
    //First integer is durability multiplier. Second integer enchantability.
    //First float is toughness. Second float is knockback resistance.
    ArmorMaterial BRONZE = new ArmorMaterial(15,
            makeDefense(2, 5, 6, 2, 5),
            9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F,
            ModTags.Items.COMMON_BRONZE_INGOTS, ModEquipmentAssets.BRONZE);

    ArmorMaterial GILDED_BRONZE = new ArmorMaterial(23,
            makeDefense(3, 5, 6, 3, 9),
            25, SoundEvents.ARMOR_EQUIP_GOLD, 1.0F, 0.0F,
            ItemTags.REPAIRS_GOLD_ARMOR, ModEquipmentAssets.GILDED_BRONZE);

    ArmorMaterial COBALT_STEEL = new ArmorMaterial(39,
            makeDefense(3, 6, 8, 3, 11),
            20, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F, 0.1F,
            ModTags.Items.MOD_REPAIRS_COBALT_STEEL_EQUIPMENT, ModEquipmentAssets.COBALT_STEEL);

    ArmorMaterial INFUSED_GEMSTONE = new ArmorMaterial(37,
            makeDefense(3, 6, 8, 3, 11),
            28, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F, 0.1F,
            ModTags.Items.MOD_REPAIRS_INFUSED_GEMSTONE_EQUIPMENT, ModEquipmentAssets.INFUSED_GEMSTONE);

    ArmorMaterial TUNGSTEN_CARBIDE = new ArmorMaterial(41,
            makeDefense(3, 6, 8, 3, 11),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
            ModTags.Items.MOD_REPAIRS_TUNGSTEN_CARBIDE_EQUIPMENT, ModEquipmentAssets.TUNGSTEN_CARBIDE);


    /**
     * Generates a map of defense values for a new ArmorMaterial.
     * @param boots Defense value of boots
     * @param leggings Defense value of leggings
     * @param chestplate Defense value of chestplate
     * @param helmet Defense value of helmet
     * @param body Defense value of body (what is this for???)
     * @return The generated map of defense values for this ArmorMaterial.
     */
    private static Map<ArmorType, Integer> makeDefense(int boots, int leggings, int chestplate, int helmet, int body) {
        return Maps.newEnumMap(
                Map.of(
                        ArmorType.BOOTS,
                        boots,
                        ArmorType.LEGGINGS,
                        leggings,
                        ArmorType.CHESTPLATE,
                        chestplate,
                        ArmorType.HELMET,
                        helmet,
                        ArmorType.BODY,
                        body
                )
        );
    }
}
