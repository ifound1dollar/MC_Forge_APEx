package net.dollar.apex.util;

import net.dollar.apex.item.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier BRONZE = new ForgeTier(
            250,
            6.0f,
            2.0f,
            14,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.BRONZE_INGOT.get()),
            BlockTags.INCORRECT_FOR_IRON_TOOL);
    public static final Tier GILDED_BRONZE = new ForgeTier(
            666,
            12.0f,
            2.0f,
            22,
            BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.GOLD_INGOT),
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
    public static final Tier COBALT_STEEL = new ForgeTier(
            2031,
            20.0f,
            3.0f,
            18,
            BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.COBALT_STEEL_INGOT.get()),
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
    public static final Tier INFUSED_GEMSTONE = new ForgeTier(
            2031,
            10.0f,
            4.0f,
            22,
            BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.INFUSED_GEMSTONE.get()),
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
    public static final Tier TUNGSTEN_CARBIDE = new ForgeTier(
            2501,
            7.0f,
            6.0f,
            15,
            BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.TUNGSTEN_CARBIDE_INGOT.get()),
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL);


}
