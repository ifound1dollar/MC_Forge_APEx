package net.dollar.apex.util;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ToolMaterial;

public interface ModToolMaterials {
    ToolMaterial BRONZE = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            250,
            6.0f,
            2.0f,
            14,
            ModTags.Items.FORGE_BRONZE_INGOTS);
    ToolMaterial GILDED_BRONZE = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            666,
            12.0f,
            2.0f,
            22,
            ItemTags.GOLD_TOOL_MATERIALS);
    ToolMaterial COBALT_STEEL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2031,
            20.0f,
            3.0f,
            18,
            ModTags.Items.MOD_REPAIRS_COBALT_STEEL_EQUIPMENT);
    ToolMaterial INFUSED_GEMSTONE = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2031,
            10.0f,
            4.0f,
            22,
            ModTags.Items.MOD_REPAIRS_INFUSED_GEMSTONE_EQUIPMENT);
    ToolMaterial TUNGSTEN_CARBIDE = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2501,
            7.0f,
            6.0f,
            15,
            ModTags.Items.MOD_REPAIRS_TUNGSTEN_CARBIDE_EQUIPMENT);


}
