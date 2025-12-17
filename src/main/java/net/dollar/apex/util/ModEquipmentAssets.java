package net.dollar.apex.util;

import net.dollar.apex.ModMain;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

import static net.minecraft.world.item.equipment.EquipmentAssets.ROOT_ID;

/**
 * Contains an Identifier for each armor equipment tier. Required in order to
 *  successfully load worn equipment textures.
 */
public interface ModEquipmentAssets {
    ResourceKey<EquipmentAsset> BRONZE = createId("bronze");
    ResourceKey<EquipmentAsset> GILDED_BRONZE = createId("gilded_bronze");
    ResourceKey<EquipmentAsset> COBALT_STEEL = createId("cobalt_steel");
    ResourceKey<EquipmentAsset> INFUSED_GEMSTONE = createId("infused_gemstone");
    ResourceKey<EquipmentAsset> TUNGSTEN_CARBIDE = createId("tungsten_carbide");

    static ResourceKey<EquipmentAsset> createId(String name) {
        return ResourceKey.create(ROOT_ID, Identifier.fromNamespaceAndPath(ModMain.MODID, name));
    }
}
