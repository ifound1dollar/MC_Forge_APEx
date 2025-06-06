package net.dollar.apex.datagen;

import net.dollar.apex.ModMain;
import net.dollar.apex.item.ModItems;
import net.dollar.apex.util.ModEquipmentAssets;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceLocation;

import java.util.function.BiConsumer;

public class ModItemModelGenerators extends ItemModelGenerators {
    public ModItemModelGenerators(ItemModelOutput output, BiConsumer<ResourceLocation, ModelInstance> consumer) {
        super(output, consumer);
    }


    @Override
    public void run() {
        // GENERATED (FLAT_ITEM)
        generateFlatItem(ModItems.FERTILIZER.get(), ModelTemplates.FLAT_ITEM);

        generateFlatItem(ModItems.RUBY.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.SAPPHIRE.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.COBALT_SHARD.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.PHOSPHATE_POWDER.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.RAW_TIN.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.TIN_INGOT.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.TIN_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.RAW_TUNGSTEN.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.TUNGSTEN_INGOT.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.TUNGSTEN_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.BRONZE_COMPOUND.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.BRONZE_INGOT.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.BRONZE_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.STEEL_COMPOUND.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.STEEL_NUGGET.get(), ModelTemplates.FLAT_ITEM);

        generateFlatItem(ModItems.HANDFUL_OF_STARDUST.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.MOLTEN_CORE.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.COBALT_STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.INFUSED_GEMSTONE.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.TUNGSTEN_CARBIDE_INGOT.get(), ModelTemplates.FLAT_ITEM);

        generateFlatItem(ModItems.BASIC_UPGRADE_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.CARBIDE_UPGRADE_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.COBALT_UPGRADE_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.INFUSION_UPGRADE_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);

        generateFlatItem(ModItems.TROPHY_OBSIDIAN_DUST.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.TROPHY_OMINOUS_LETTER.get(), ModelTemplates.FLAT_ITEM);



        //HANDHELD
        generateFlatItem(ModItems.BRONZE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.BRONZE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.BRONZE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.BRONZE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.BRONZE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        generateFlatItem(ModItems.GILDED_BRONZE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.GILDED_BRONZE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.GILDED_BRONZE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.GILDED_BRONZE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.GILDED_BRONZE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        generateFlatItem(ModItems.DIAMOND_BATTLEAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.DIAMOND_PAXEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        generateFlatItem(ModItems.NETHERITE_BATTLEAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.NETHERITE_PAXEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        generateFlatItem(ModItems.COBALT_STEEL_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.COBALT_STEEL_BATTLEAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.COBALT_STEEL_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.COBALT_STEEL_PAXEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.COBALT_STEEL_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.COBALT_STEEL_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.COBALT_STEEL_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        generateFlatItem(ModItems.INFUSED_GEMSTONE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.INFUSED_GEMSTONE_BATTLEAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.INFUSED_GEMSTONE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.INFUSED_GEMSTONE_PAXEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.INFUSED_GEMSTONE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.INFUSED_GEMSTONE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.INFUSED_GEMSTONE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        generateFlatItem(ModItems.TUNGSTEN_CARBIDE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.TUNGSTEN_CARBIDE_BATTLEAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.TUNGSTEN_CARBIDE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.TUNGSTEN_CARBIDE_PAXEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.TUNGSTEN_CARBIDE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.TUNGSTEN_CARBIDE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.TUNGSTEN_CARBIDE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        // BOW/CROSSBOW
        generateBow(ModItems.COBALT_STEEL_BOW.get());
        generateBow(ModItems.INFUSED_GEMSTONE_BOW.get());
        generateBow(ModItems.TUNGSTEN_CARBIDE_BOW.get());
        generateCrossbow(ModItems.COBALT_STEEL_CROSSBOW.get());
        generateCrossbow(ModItems.INFUSED_GEMSTONE_CROSSBOW.get());
        generateCrossbow(ModItems.TUNGSTEN_CARBIDE_CROSSBOW.get());

        // ARMORS
        generateTrimmableItem(ModItems.BRONZE_HELMET.get(), ModEquipmentAssets.BRONZE,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "bronze_helmet"), false);
        generateTrimmableItem(ModItems.BRONZE_CHESTPLATE.get(), ModEquipmentAssets.BRONZE,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "bronze_chestplate"), false);
        generateTrimmableItem(ModItems.BRONZE_LEGGINGS.get(), ModEquipmentAssets.BRONZE,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "bronze_leggings"), false);
        generateTrimmableItem(ModItems.BRONZE_BOOTS.get(), ModEquipmentAssets.BRONZE,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "bronze_boots"), false);

        generateTrimmableItem(ModItems.GILDED_BRONZE_HELMET.get(), ModEquipmentAssets.GILDED_BRONZE,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "gilded_bronze_helmet"), false);
        generateTrimmableItem(ModItems.GILDED_BRONZE_CHESTPLATE.get(), ModEquipmentAssets.GILDED_BRONZE,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "gilded_bronze_chestplate"), false);
        generateTrimmableItem(ModItems.GILDED_BRONZE_LEGGINGS.get(), ModEquipmentAssets.GILDED_BRONZE,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "gilded_bronze_leggings"), false);
        generateTrimmableItem(ModItems.GILDED_BRONZE_BOOTS.get(), ModEquipmentAssets.GILDED_BRONZE,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "gilded_bronze_boots"), false);

        generateTrimmableItem(ModItems.COBALT_STEEL_HELMET.get(), ModEquipmentAssets.COBALT_STEEL,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "cobalt_steel_helmet"), false);
        generateTrimmableItem(ModItems.COBALT_STEEL_CHESTPLATE.get(), ModEquipmentAssets.COBALT_STEEL,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "cobalt_steel_chestplate"), false);
        generateTrimmableItem(ModItems.COBALT_STEEL_LEGGINGS.get(), ModEquipmentAssets.COBALT_STEEL,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "cobalt_steel_leggings"), false);
        generateTrimmableItem(ModItems.COBALT_STEEL_BOOTS.get(), ModEquipmentAssets.COBALT_STEEL,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "cobalt_steel_boots"), false);

        generateTrimmableItem(ModItems.INFUSED_GEMSTONE_HELMET.get(), ModEquipmentAssets.INFUSED_GEMSTONE,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "infused_gemstone_helmet"), false);
        generateTrimmableItem(ModItems.INFUSED_GEMSTONE_CHESTPLATE.get(), ModEquipmentAssets.INFUSED_GEMSTONE,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "infused_gemstone_chestplate"), false);
        generateTrimmableItem(ModItems.INFUSED_GEMSTONE_LEGGINGS.get(), ModEquipmentAssets.INFUSED_GEMSTONE,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "infused_gemstone_leggings"), false);
        generateTrimmableItem(ModItems.INFUSED_GEMSTONE_BOOTS.get(), ModEquipmentAssets.INFUSED_GEMSTONE,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "infused_gemstone_boots"), false);

        generateTrimmableItem(ModItems.TUNGSTEN_CARBIDE_HELMET.get(), ModEquipmentAssets.TUNGSTEN_CARBIDE,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "tungsten_carbide_helmet"), false);
        generateTrimmableItem(ModItems.TUNGSTEN_CARBIDE_CHESTPLATE.get(), ModEquipmentAssets.TUNGSTEN_CARBIDE,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "tungsten_carbide_chestplate"), false);
        generateTrimmableItem(ModItems.TUNGSTEN_CARBIDE_LEGGINGS.get(), ModEquipmentAssets.TUNGSTEN_CARBIDE,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "tungsten_carbide_leggings"), false);
        generateTrimmableItem(ModItems.TUNGSTEN_CARBIDE_BOOTS.get(), ModEquipmentAssets.TUNGSTEN_CARBIDE,
                ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "tungsten_carbide_boots"), false);

        // SPAWN EGGS
        generateFlatItem(ModItems.OBSIDIAN_GOLEM_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.MYSTERIOUS_SPECTER_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
    }
}
