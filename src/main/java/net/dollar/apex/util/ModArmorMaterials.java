package net.dollar.apex.util;

import net.dollar.apex.ModMain;
import net.dollar.apex.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    //First integer is durability multiplier. Second integer enchantability.
    //First float is toughness. Second float is knockback resistance.
    public static final Holder<ArmorMaterial> BRONZE = register("bronze", Util.make(
            new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 5);
            }), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F,
            () -> Ingredient.of(ModItems.BRONZE_INGOT.get()));
    public static final Holder<ArmorMaterial> GILDED_BRONZE = register("gilded_bronze", Util.make(
            new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 9);
            }), 25, SoundEvents.ARMOR_EQUIP_GOLD, 1.0F, 0.0F,
            () -> Ingredient.of(Items.GOLD_INGOT));
    public static final Holder<ArmorMaterial> COBALT_STEEL = register("cobalt_steel", Util.make(
            new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 11);
            }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F, 0.1F,
            () -> Ingredient.of(ModItems.COBALT_STEEL_INGOT.get()));
    public static final Holder<ArmorMaterial> INFUSED_GEMSTONE = register("infused_gemstone", Util.make(
            new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 11);
            }), 25, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F, 0.05F,
            () -> Ingredient.of(ModItems.INFUSED_GEMSTONE.get()));
    public static final Holder<ArmorMaterial> TUNGSTEN_CARBIDE = register("tungsten_carbide", Util.make(
            new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 11);
            }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
            () -> Ingredient.of(ModItems.TUNGSTEN_CARBIDE_INGOT.get()));



    private static Holder<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense,
                                                  int enchantability, Holder<SoundEvent> equipSound,
                                                  float toughness, float knockbackResistance,
                                                  Supplier<Ingredient> repairIngredient) {
        List<ArmorMaterial.Layer> $$7 = List.of(new ArmorMaterial.Layer(new ResourceLocation(ModMain.MODID, id)));
        return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, $$7);
    }

    private static Holder<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense,
                                                  int enchantability, Holder<SoundEvent> equipSound,
                                                  float toughness, float knockbackResistance,
                                                  Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers) {
        EnumMap<ArmorItem.Type, Integer> $$8 = new EnumMap<>(ArmorItem.Type.class);
        ArmorItem.Type[] var9 = ArmorItem.Type.values();

        for (ArmorItem.Type $$9 : var9) {
            $$8.put($$9, defense.get($$9));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL,
                new ResourceLocation(ModMain.MODID, id),
                new ArmorMaterial($$8, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance));
    }
}
