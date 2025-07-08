package net.dollar.apex.util;

import net.dollar.apex.ModMain;
import net.minecraft.resources.ResourceLocation;

/**
 * Contains an Identifier for each armor equipment tier. Required in order to
 *  successfully load worn equipment textures.
 */
public interface ModEquipmentModels {
    ResourceLocation BRONZE = ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "bronze");
    ResourceLocation GILDED_BRONZE = ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "gilded_bronze");
    ResourceLocation COBALT_STEEL = ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "cobalt_steel");
    ResourceLocation INFUSED_GEMSTONE = ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "infused_gemstone");
    ResourceLocation TUNGSTEN_CARBIDE = ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "tungsten_carbide");
}
