package net.dollar.apex.datagen;

import net.dollar.apex.ModMain;
import net.dollar.apex.block.ModBlocks;
import net.dollar.apex.item.ModItems;
import net.dollar.apex.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

/**
 * Used to auto-generate recipe JSON files in 'src/generated' subdirectory. In-code definitions of recipes
 *  to be generated AND their corresponding helper methods are contained within this class.
 */
public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private enum ToolType { AXE, BATTLEAXE, HOE, PAXEL, PICKAXE, SHOVEL, SWORD }

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider);
    }



    /**
     * Build recipes, auto-generating JSON files in 'src/generated' subdirectory. Developer defines recipes
     *  to generate within this method.
     * @param recipeOutput RecipeOutput object
     */
    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        //region Ores, smelting AND blasting
        smeltingRecipeBuilder(recipeOutput, ModBlocks.COBALT_ORE.get(), RecipeCategory.MISC,
                ModItems.COBALT_SHARD.get(), 0.9f, 200, "cobalt_shard" );
        blastingRecipeBuilder(recipeOutput, ModBlocks.COBALT_ORE.get(), RecipeCategory.MISC,
                ModItems.COBALT_SHARD.get(), 0.9f, 100, "cobalt_shard" );
        smeltingRecipeBuilder(recipeOutput, ModBlocks.DEEPSLATE_COBALT_ORE.get(), RecipeCategory.MISC,
                ModItems.COBALT_SHARD.get(), 0.9f, 200, "cobalt_shard" );
        blastingRecipeBuilder(recipeOutput, ModBlocks.DEEPSLATE_COBALT_ORE.get(), RecipeCategory.MISC,
                ModItems.COBALT_SHARD.get(), 0.9f, 100, "cobalt_shard" );

        smeltingRecipeBuilder(recipeOutput, ModBlocks.PHOSPHATE_ORE.get(), RecipeCategory.MISC,
                ModItems.PHOSPHATE_POWDER.get(), 0.2f, 200, "phosphate_powder" );
        blastingRecipeBuilder(recipeOutput, ModBlocks.PHOSPHATE_ORE.get(), RecipeCategory.MISC,
                ModItems.PHOSPHATE_POWDER.get(), 0.2f, 100, "phosphate_powder" );
        smeltingRecipeBuilder(recipeOutput, ModBlocks.DEEPSLATE_PHOSPHATE_ORE.get(), RecipeCategory.MISC,
                ModItems.PHOSPHATE_POWDER.get(), 0.2f, 200, "phosphate_powder" );
        blastingRecipeBuilder(recipeOutput, ModBlocks.DEEPSLATE_PHOSPHATE_ORE.get(), RecipeCategory.MISC,
                ModItems.PHOSPHATE_POWDER.get(), 0.2f, 100, "phosphate_powder" );

        smeltingRecipeBuilder(recipeOutput, ModBlocks.RUBY_ORE.get(), RecipeCategory.MISC,
                ModItems.RUBY.get(), 1.2f, 200, "ruby" );
        blastingRecipeBuilder(recipeOutput, ModBlocks.RUBY_ORE.get(), RecipeCategory.MISC,
                ModItems.RUBY.get(), 1.2f, 100, "ruby" );
        smeltingRecipeBuilder(recipeOutput, ModBlocks.DEEPSLATE_RUBY_ORE.get(), RecipeCategory.MISC,
                ModItems.RUBY.get(), 1.2f, 200, "ruby" );
        blastingRecipeBuilder(recipeOutput, ModBlocks.DEEPSLATE_RUBY_ORE.get(), RecipeCategory.MISC,
                ModItems.RUBY.get(), 1.2f, 100, "ruby" );

        smeltingRecipeBuilder(recipeOutput, ModBlocks.SAPPHIRE_ORE.get(), RecipeCategory.MISC,
                ModItems.SAPPHIRE.get(), 1.2f, 200, "sapphire" );
        blastingRecipeBuilder(recipeOutput, ModBlocks.SAPPHIRE_ORE.get(), RecipeCategory.MISC,
                ModItems.SAPPHIRE.get(), 1.2f, 100, "sapphire" );
        smeltingRecipeBuilder(recipeOutput, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), RecipeCategory.MISC,
                ModItems.SAPPHIRE.get(), 1.2f, 200, "sapphire" );
        blastingRecipeBuilder(recipeOutput, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), RecipeCategory.MISC,
                ModItems.SAPPHIRE.get(), 1.2f, 100, "sapphire" );

        smeltingRecipeBuilder(recipeOutput, ModBlocks.TIN_ORE.get(), RecipeCategory.MISC,
                ModItems.TIN_INGOT.get(), 0.7f, 200, "tin_ingot");
        blastingRecipeBuilder(recipeOutput, ModBlocks.TIN_ORE.get(), RecipeCategory.MISC,
                ModItems.TIN_INGOT.get(), 0.7f, 100, "tin_ingot");
        smeltingRecipeBuilder(recipeOutput, ModBlocks.DEEPSLATE_TIN_ORE.get(), RecipeCategory.MISC,
                ModItems.TIN_INGOT.get(), 0.7f, 200, "tin_ingot");
        blastingRecipeBuilder(recipeOutput, ModBlocks.DEEPSLATE_TIN_ORE.get(), RecipeCategory.MISC,
                ModItems.TIN_INGOT.get(), 0.7f, 100, "tin_ingot");
        smeltingRecipeBuilder(recipeOutput, ModItems.RAW_TIN.get(), RecipeCategory.MISC,
                ModItems.TIN_INGOT.get(), 0.7f, 200, "tin_ingot");
        blastingRecipeBuilder(recipeOutput, ModItems.RAW_TIN.get(), RecipeCategory.MISC,
                ModItems.TIN_INGOT.get(), 0.7f, 100, "tin_ingot");

        smeltingRecipeBuilder(recipeOutput, ModItems.BRONZE_COMPOUND.get(), RecipeCategory.MISC,
                ModItems.BRONZE_INGOT.get(), 0.7f, 200, "bronze_ingot");
        blastingRecipeBuilder(recipeOutput, ModItems.BRONZE_COMPOUND.get(), RecipeCategory.MISC,
                ModItems.BRONZE_INGOT.get(), 0.7f, 100, "bronze_ingot");

        smeltingRecipeBuilder(recipeOutput, ModItems.STEEL_COMPOUND.get(), RecipeCategory.MISC,
                ModItems.STEEL_INGOT.get(), 0.9f, 200, "steel_ingot");
        blastingRecipeBuilder(recipeOutput, ModItems.STEEL_COMPOUND.get(), RecipeCategory.MISC,
                ModItems.STEEL_INGOT.get(), 0.9f, 100, "steel_ingot");

        smeltingRecipeBuilder(recipeOutput, ModBlocks.TUNGSTEN_ORE.get(), RecipeCategory.MISC,
                ModItems.TUNGSTEN_INGOT.get(), 1.0f, 200, "tungsten_ingot");
        blastingRecipeBuilder(recipeOutput, ModBlocks.TUNGSTEN_ORE.get(), RecipeCategory.MISC,
                ModItems.TUNGSTEN_INGOT.get(), 1.0f, 100, "tungsten_ingot");
        smeltingRecipeBuilder(recipeOutput, ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), RecipeCategory.MISC,
                ModItems.TUNGSTEN_INGOT.get(), 1.0f, 200, "tungsten_ingot");
        blastingRecipeBuilder(recipeOutput, ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), RecipeCategory.MISC,
                ModItems.TUNGSTEN_INGOT.get(), 1.0f, 100, "tungsten_ingot");
        smeltingRecipeBuilder(recipeOutput, ModItems.RAW_TUNGSTEN.get(), RecipeCategory.MISC,
                ModItems.TUNGSTEN_INGOT.get(), 1.0f, 200, "tungsten_ingot");
        blastingRecipeBuilder(recipeOutput, ModItems.RAW_TUNGSTEN.get(), RecipeCategory.MISC,
                ModItems.TUNGSTEN_INGOT.get(), 1.0f, 100, "tungsten_ingot");
        //endregion
        
        //region Smeltable tools
        smeltingRecipeBuilder(recipeOutput, ModItems.BRONZE_AXE.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 200, "bronze_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.BRONZE_AXE.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 100, "bronze_nugget");
        smeltingRecipeBuilder(recipeOutput, ModItems.BRONZE_HOE.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 200, "bronze_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.BRONZE_HOE.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 100, "bronze_nugget");
        smeltingRecipeBuilder(recipeOutput, ModItems.BRONZE_PICKAXE.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 200, "bronze_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.BRONZE_PICKAXE.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 100, "bronze_nugget");
        smeltingRecipeBuilder(recipeOutput, ModItems.BRONZE_SHOVEL.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 200, "bronze_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.BRONZE_SHOVEL.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 100, "bronze_nugget");
        smeltingRecipeBuilder(recipeOutput, ModItems.BRONZE_SWORD.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 200, "bronze_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.BRONZE_SWORD.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 100, "bronze_nugget");
        smeltingRecipeBuilder(recipeOutput, ModItems.BRONZE_HELMET.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 200, "bronze_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.BRONZE_HELMET.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 100, "bronze_nugget");
        smeltingRecipeBuilder(recipeOutput, ModItems.BRONZE_CHESTPLATE.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 200, "bronze_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.BRONZE_CHESTPLATE.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 100, "bronze_nugget");
        smeltingRecipeBuilder(recipeOutput, ModItems.BRONZE_LEGGINGS.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 200, "bronze_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.BRONZE_LEGGINGS.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 100, "bronze_nugget");
        smeltingRecipeBuilder(recipeOutput, ModItems.BRONZE_BOOTS.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 200, "bronze_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.BRONZE_BOOTS.get(), RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(), 0.1f, 100, "bronze_nugget");

        smeltingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_AXE.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 200, "gold_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_AXE.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 100, "gold_nugget");
        smeltingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_HOE.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 200, "gold_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_HOE.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 100, "gold_nugget");
        smeltingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_PICKAXE.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 200, "gold_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_PICKAXE.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 100, "gold_nugget");
        smeltingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_SHOVEL.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 200, "gold_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_SHOVEL.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 100, "gold_nugget");
        smeltingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_SWORD.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 200, "gold_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_SWORD.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 100, "gold_nugget");
        smeltingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_HELMET.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 200, "gold_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_HELMET.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 100, "gold_nugget");
        smeltingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_CHESTPLATE.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 200, "gold_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_CHESTPLATE.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 100, "gold_nugget");
        smeltingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_LEGGINGS.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 200, "gold_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_LEGGINGS.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 100, "gold_nugget");
        smeltingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_BOOTS.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 200, "gold_nugget");
        blastingRecipeBuilder(recipeOutput, ModItems.GILDED_BRONZE_BOOTS.get(), RecipeCategory.MISC,
                Items.GOLD_NUGGET, 0.1f, 100, "gold_nugget");
        //endregion



        //region Basic nine-block storage recipes
        //NOTE: FIRST IS FOR BLOCK->ITEM, SECOND IS FOR ITEM->BLOCK
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModItems.COBALT_SHARD.get(),
                RecipeCategory.MISC, ModBlocks.COBALT_BLOCK.get());
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY.get(),
                RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get());
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModItems.SAPPHIRE.get(),
                RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get());
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.BUILDING_BLOCKS, Items.AMETHYST_SHARD,
                RecipeCategory.MISC, ModBlocks.DECORATIVE_AMETHYST_BLOCK.get());
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModItems.TIN_INGOT.get(),
                RecipeCategory.MISC, ModBlocks.TIN_BLOCK.get());
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_TIN.get(),
                RecipeCategory.MISC, ModBlocks.RAW_TIN_BLOCK.get());
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModItems.TUNGSTEN_INGOT.get(),
                RecipeCategory.MISC, ModBlocks.TUNGSTEN_BLOCK.get());
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_TUNGSTEN.get(),
                RecipeCategory.MISC, ModBlocks.RAW_TUNGSTEN_BLOCK.get());
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModItems.BRONZE_INGOT.get(),
                RecipeCategory.MISC, ModBlocks.BRONZE_BLOCK.get());
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL_INGOT.get(),
                RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get());
        //endregion

        //region Nuggets (cannot use storage recipes helper because duplicate ingot recipe names)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TIN_NUGGET.get(), 9)
                .requires(Ingredient.of(ModTags.Items.FORGE_TIN_INGOTS), 1)
                .unlockedBy("has_tin_ingot", has(ModTags.Items.FORGE_TIN_INGOTS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "tin_nugget_from_ingot"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 1)
                .requires(Ingredient.of(ModItems.TIN_NUGGET.get()), 9)
                .unlockedBy("has_tin_nugget", has(ModItems.TIN_NUGGET.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "tin_ingot_from_nugget"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TUNGSTEN_NUGGET.get(), 9)
                .requires(Ingredient.of(ModTags.Items.FORGE_TUNGSTEN_INGOTS), 1)
                .unlockedBy("has_tungsten_ingot", has(ModTags.Items.FORGE_TUNGSTEN_INGOTS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "tungsten_nugget_from_ingot"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT.get(), 1)
                .requires(Ingredient.of(ModItems.TUNGSTEN_NUGGET.get()), 9)
                .unlockedBy("has_tungsten_nugget", has(ModItems.TUNGSTEN_NUGGET.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "tungsten_ingot_from_nugget"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BRONZE_NUGGET.get(), 9)
                .requires(Ingredient.of(ModTags.Items.FORGE_BRONZE_INGOTS), 1)
                .unlockedBy("has_bronze_ingot", has(ModTags.Items.FORGE_BRONZE_INGOTS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "bronze_nugget_from_ingot"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BRONZE_INGOT.get(), 1)
                .requires(Ingredient.of(ModItems.BRONZE_NUGGET.get()), 9)
                .unlockedBy("has_bronze_nugget", has(ModItems.BRONZE_NUGGET.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "bronze_ingot_from_nugget"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_NUGGET.get(), 9)
                .requires(Ingredient.of(ModTags.Items.FORGE_STEEL_INGOTS), 1)
                .unlockedBy("has_steel_ingot", has(ModTags.Items.FORGE_STEEL_INGOTS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "steel_nugget_from_ingot"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_INGOT.get(), 1)
                .requires(Ingredient.of(ModItems.STEEL_NUGGET.get()), 9)
                .unlockedBy("has_steel_nugget", has(ModItems.STEEL_NUGGET.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "steel_ingot_from_nugget"));
        //endregion

        //region Phosphate Powder recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GUNPOWDER, 2)
                .requires(Ingredient.of(ModItems.PHOSPHATE_POWDER.get()), 1)
                .requires(Ingredient.of(ModTags.Items.MINECRAFT_COALS), 1)
                .unlockedBy("has_phosphate_powder", has(ModItems.PHOSPHATE_POWDER.get()))
                .unlockedBy("has_coal", has(ModTags.Items.MINECRAFT_COALS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "gunpowder_from_phosphate_coal"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FERTILIZER.get(), 2)
                .requires(Ingredient.of(ModItems.PHOSPHATE_POWDER.get()), 1)
                .requires(Ingredient.of(Items.ROTTEN_FLESH), 1)
                .unlockedBy("has_phosphate_powder", has(ModItems.PHOSPHATE_POWDER.get()))
                .unlockedBy("has_rotten_flesh", has(Items.ROTTEN_FLESH))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "fertilizer_from_phosphate_flesh"));
        //endregion

        //region Iron-Replacement Tin Recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BUCKET, 1)
                .define('d', ModTags.Items.FORGE_TIN_INGOTS)
                .pattern("d d")
                .pattern(" d ")
                .unlockedBy("has_tin_ingot", has(ModTags.Items.FORGE_TIN_INGOTS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "bucket_from_tin_ingot"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SHEARS, 1)
                .define('d', ModTags.Items.FORGE_TIN_INGOTS)
                .pattern(" d")
                .pattern("d ")
                .unlockedBy("has_tin_ingot", has(ModTags.Items.FORGE_TIN_INGOTS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "shears_from_tin_ingot"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SHEARS, 1)
                .define('d', ModTags.Items.FORGE_TIN_INGOTS)
                .pattern("d ")
                .pattern(" d")
                .unlockedBy("has_tin_ingot", has(ModTags.Items.FORGE_TIN_INGOTS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "shears_from_tin_ingot_reversed"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LANTERN, 1)
                .define('d', ModTags.Items.FORGE_TIN_INGOTS)
                .define('i', Items.TORCH)
                .pattern("ddd")
                .pattern("did")
                .pattern("ddd")
                .unlockedBy("has_tin_ingot", has(ModTags.Items.FORGE_TIN_INGOTS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "lantern_from_tin_nugget"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SOUL_LANTERN, 1)
                .define('d', ModTags.Items.FORGE_TIN_INGOTS)
                .define('i', Items.SOUL_TORCH)
                .pattern("ddd")
                .pattern("did")
                .pattern("ddd")
                .unlockedBy("has_tin_ingot", has(ModTags.Items.FORGE_TIN_INGOTS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "soul_lantern_from_tin_nugget"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TRIPWIRE_HOOK, 1)
                .define('d', ModTags.Items.FORGE_TIN_INGOTS)
                .define('i', ModTags.Items.FORGE_WOODEN_RODS)
                .define('n', ItemTags.PLANKS)
                .pattern("d")
                .pattern("i")
                .pattern("n")
                .unlockedBy("has_tin_ingot", has(ModTags.Items.FORGE_TIN_INGOTS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "tripwire_hook_from_tin_ingot"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.HOPPER, 1)
                .define('d', ModTags.Items.FORGE_TIN_INGOTS)
                .define('i', ModTags.Items.FORGE_CHESTS)
                .pattern("d d")
                .pattern("did")
                .pattern(" d ")
                .unlockedBy("has_tin_ingot", has(ModTags.Items.FORGE_TIN_INGOTS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "hopper_from_tin_ingot"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COMPASS, 1)
                .define('d', ModTags.Items.FORGE_TIN_INGOTS)
                .define('i', Items.REDSTONE)
                .pattern(" d ")
                .pattern("did")
                .pattern(" d ")
                .unlockedBy("has_tin_ingot", has(ModTags.Items.FORGE_TIN_INGOTS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "compass_from_tin_ingot"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHAIN, 1)
                .define('d', ModTags.Items.FORGE_TIN_INGOTS)
                .define('i', ModItems.TIN_NUGGET.get())
                .pattern("i")
                .pattern("d")
                .pattern("i")
                .unlockedBy("has_tin_ingot", has(ModTags.Items.FORGE_TIN_INGOTS))
                .unlockedBy("has_tin_nugget", has(ModItems.TIN_NUGGET.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "chain_from_tin_ingot_and_nugget"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CAULDRON, 1)
                .define('d', ModTags.Items.FORGE_TIN_INGOTS)
                .pattern("d d")
                .pattern("d d")
                .pattern("ddd")
                .unlockedBy("has_tin_ingot", has(ModTags.Items.FORGE_TIN_INGOTS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "cauldron_from_tin_ingot"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.FLINT_AND_STEEL, 1)
                .requires(Ingredient.of(ModTags.Items.FORGE_TIN_INGOTS), 1)
                .requires(Ingredient.of(Items.FLINT), 1)
                .unlockedBy("has_tin_ingot", has(ModTags.Items.FORGE_TIN_INGOTS))
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "flint_and_steel_from_tin_ingot"));
        //endregion

        //region Compounds and Endgame Ingredient Items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BRONZE_COMPOUND.get(), 3)
                .requires(Ingredient.of(Tags.Items.INGOTS_COPPER), 3)
                .requires(Ingredient.of(ModTags.Items.FORGE_TIN_INGOTS), 1)
                .unlockedBy("has_copper_ingot", has(ModTags.Items.FORGE_COPPER_INGOTS))
                .unlockedBy("has_tin_ingot", has(ModTags.Items.FORGE_TIN_INGOTS))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_COMPOUND.get(), 1)
                .requires(Ingredient.of(ModTags.Items.FORGE_IRON_INGOTS), 1)
                .requires(Ingredient.of(ItemTags.COALS), 1)
                .unlockedBy("has_steel_ingot", has(ModTags.Items.FORGE_STEEL_INGOTS))
                .unlockedBy("has_coal", has(ItemTags.COALS))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.INFUSED_GEMSTONE.get(), 1)
                .requires(Ingredient.of(ModTags.Items.FORGE_AMETHYST), 1)
                .requires(Ingredient.of(ModTags.Items.FORGE_DIAMONDS), 1)
                .requires(Ingredient.of(ModTags.Items.FORGE_EMERALDS), 1)
                .requires(Ingredient.of(ModTags.Items.FORGE_RUBIES), 1)
                .requires(Ingredient.of(ModTags.Items.FORGE_SAPPHIRES), 1)
                .requires(Ingredient.of(ModItems.HANDFUL_OF_STARDUST.get()), 1)
                .unlockedBy("has_amethyst", has(ModTags.Items.FORGE_AMETHYST))
                .unlockedBy("has_diamond", has(ModTags.Items.FORGE_DIAMONDS))
                .unlockedBy("has_emerald", has(ModTags.Items.FORGE_EMERALDS))
                .unlockedBy("has_ruby", has(ModTags.Items.FORGE_RUBIES))
                .unlockedBy("has_sapphire", has(ModTags.Items.FORGE_SAPPHIRES))
                .unlockedBy("has_handful_of_stardust", has(ModItems.HANDFUL_OF_STARDUST.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COBALT_STEEL_INGOT.get(), 1)
                .define('d', ModTags.Items.FORGE_STEEL_INGOTS)
                .define('i', ModItems.COBALT_SHARD.get())
                .define('n', ModItems.MOLTEN_CORE.get())
                .pattern("did")
                .pattern("ini")
                .pattern("did")
                .unlockedBy("has_steel_ingot", has(ModTags.Items.FORGE_STEEL_INGOTS))
                .unlockedBy("has_cobalt_shard", has(ModItems.COBALT_SHARD.get()))
                .unlockedBy("has_molten_core", has(ModItems.MOLTEN_CORE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "cobalt_steel_ingot"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COBALT_STEEL_INGOT.get(), 1)
                .define('d', ModTags.Items.FORGE_STEEL_INGOTS)
                .define('i', ModItems.COBALT_SHARD.get())
                .define('n', ModItems.MOLTEN_CORE.get())
                .pattern("idi")
                .pattern("dnd")
                .pattern("idi")
                .unlockedBy("has_steel_ingot", has(ModTags.Items.FORGE_STEEL_INGOTS))
                .unlockedBy("has_cobalt_shard", has(ModItems.COBALT_SHARD.get()))
                .unlockedBy("has_molten_core", has(ModItems.MOLTEN_CORE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "cobalt_steel_ingot_reversed"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TUNGSTEN_CARBIDE_INGOT.get(), 1)
                .define('d', ModTags.Items.FORGE_TUNGSTEN_INGOTS)
                .define('i', ItemTags.COALS)
                .define('n', ModItems.MOLTEN_CORE.get())
                .pattern("did")
                .pattern("ini")
                .pattern("did")
                .unlockedBy("has_tungsten_ingot", has(ModTags.Items.FORGE_TUNGSTEN_INGOTS))
                .unlockedBy("has_coal", has(ItemTags.COALS))
                .unlockedBy("has_molten_core", has(ModItems.MOLTEN_CORE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "tungsten_carbide_ingot"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TUNGSTEN_CARBIDE_INGOT.get(), 1)
                .define('d', ModTags.Items.FORGE_TUNGSTEN_INGOTS)
                .define('i', ItemTags.COALS)
                .define('n', ModItems.MOLTEN_CORE.get())
                .pattern("idi")
                .pattern("dnd")
                .pattern("idi")
                .unlockedBy("has_tungsten_ingot", has(ModTags.Items.FORGE_TUNGSTEN_INGOTS))
                .unlockedBy("has_coal", has(ItemTags.COALS))
                .unlockedBy("has_molten_core", has(ModItems.MOLTEN_CORE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "tungsten_carbide_ingot_reversed"));
        //endregion

        //region Upgrade Templates
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 1)
                .define('d', ModItems.BASIC_UPGRADE_TEMPLATE.get())
                .define('i', Items.NETHERRACK)
                .define('n', Tags.Items.GEMS_DIAMOND)
                .pattern(" d ")
                .pattern("nin")
                .pattern(" n ")
                .unlockedBy("has_basic_upgrade_template", has(ModItems.BASIC_UPGRADE_TEMPLATE.get()))
                .unlockedBy("has_diamond", has(ModTags.Items.FORGE_DIAMONDS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "netherite_upgrade_template_from_basic"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COBALT_UPGRADE_TEMPLATE.get(), 1)
                .define('d', ModItems.BASIC_UPGRADE_TEMPLATE.get())
                .define('i', Items.STONE)
                .define('n', ModTags.Items.FORGE_STEEL_INGOTS)
                .pattern(" d ")
                .pattern("nin")
                .pattern(" n ")
                .unlockedBy("has_basic_upgrade_template", has(ModItems.BASIC_UPGRADE_TEMPLATE.get()))
                .unlockedBy("has_steel_ingot", has(ModTags.Items.FORGE_STEEL_INGOTS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "cobalt_upgrade_template_from_basic"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COBALT_UPGRADE_TEMPLATE.get(), 2)
                .define('d', ModItems.COBALT_UPGRADE_TEMPLATE.get())
                .define('i', Items.STONE)
                .define('n', ModTags.Items.FORGE_STEEL_INGOTS)
                .pattern("ndn")
                .pattern("nin")
                .pattern("nnn")
                .unlockedBy("has_cobalt_upgrade_template", has(ModItems.COBALT_UPGRADE_TEMPLATE.get()))
                .unlockedBy("has_steel_ingot", has(ModTags.Items.FORGE_STEEL_INGOTS))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INFUSION_UPGRADE_TEMPLATE.get(), 1)
                .define('d', ModItems.BASIC_UPGRADE_TEMPLATE.get())
                .define('i', Items.DEEPSLATE)
                .define('n', ModTags.Items.FORGE_DIAMONDS)
                .pattern(" d ")
                .pattern("nin")
                .pattern(" n ")
                .unlockedBy("has_basic_upgrade_template", has(ModItems.BASIC_UPGRADE_TEMPLATE.get()))
                .unlockedBy("has_diamond", has(ModTags.Items.FORGE_DIAMONDS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "infusion_upgrade_template_from_basic"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INFUSION_UPGRADE_TEMPLATE.get(), 2)
                .define('d', ModItems.INFUSION_UPGRADE_TEMPLATE.get())
                .define('i', Items.DEEPSLATE)
                .define('n', ModTags.Items.FORGE_DIAMONDS)
                .pattern("ndn")
                .pattern("nin")
                .pattern("nnn")
                .unlockedBy("has_infusion_upgrade_template", has(ModItems.INFUSION_UPGRADE_TEMPLATE.get()))
                .unlockedBy("has_diamond", has(ModTags.Items.FORGE_DIAMONDS))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARBIDE_UPGRADE_TEMPLATE.get(), 1)
                .define('d', ModItems.BASIC_UPGRADE_TEMPLATE.get())
                .define('i', Items.OBSIDIAN)
                .define('n', ModTags.Items.FORGE_TUNGSTEN_INGOTS)
                .pattern(" d ")
                .pattern("nin")
                .pattern(" n ")
                .unlockedBy("has_basic_upgrade_template", has(ModItems.BASIC_UPGRADE_TEMPLATE.get()))
                .unlockedBy("has_tungsten_ingot", has(ModTags.Items.FORGE_TUNGSTEN_INGOTS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "carbide_upgrade_template_from_basic"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARBIDE_UPGRADE_TEMPLATE.get(), 2)
                .define('d', ModItems.CARBIDE_UPGRADE_TEMPLATE.get())
                .define('i', Items.OBSIDIAN)
                .define('n', ModTags.Items.FORGE_TUNGSTEN_INGOTS)
                .pattern("ndn")
                .pattern("nin")
                .pattern("nnn")
                .unlockedBy("has_carbide_upgrade_template", has(ModItems.CARBIDE_UPGRADE_TEMPLATE.get()))
                .unlockedBy("has_tungsten_ingot", has(ModTags.Items.FORGE_TUNGSTEN_INGOTS))
                .save(recipeOutput);
        //endregion



        //region VANILLA TIER BATTLEAXES AND PAXELS
        toolRecipeBuilder(recipeOutput, ToolType.BATTLEAXE, ModTags.Items.FORGE_DIAMONDS, ModItems.DIAMOND_BATTLEAXE.get(),
                "has_diamond");
        toolRecipeBuilder(recipeOutput, ToolType.PAXEL, ModTags.Items.FORGE_DIAMONDS, ModItems.DIAMOND_PAXEL.get(),
                "has_diamond");
        smithingUpgradeRecipeBuilder(recipeOutput, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.DIAMOND_BATTLEAXE.get(),
                Items.NETHERITE_INGOT, RecipeCategory.COMBAT, ModItems.NETHERITE_BATTLEAXE.get(),
                "has_netherite_upgrade_smithing_template", "has_netherite_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.DIAMOND_PAXEL.get(),
                Items.NETHERITE_INGOT, RecipeCategory.TOOLS, ModItems.NETHERITE_PAXEL.get(),
                "has_netherite_upgrade_smithing_template", "has_netherite_ingot");
        //endregion
        
        //region BOWS
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.COBALT_UPGRADE_TEMPLATE.get(), Items.BOW,
                ModItems.COBALT_STEEL_INGOT.get(), RecipeCategory.COMBAT, ModItems.COBALT_STEEL_BOW.get(),
                "has_cobalt_upgrade_smithing_template", "has_cobalt_steel_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.INFUSION_UPGRADE_TEMPLATE.get(), Items.BOW,
                ModItems.INFUSED_GEMSTONE.get(), RecipeCategory.COMBAT, ModItems.INFUSED_GEMSTONE_BOW.get(),
                "has_infusion_upgrade_smithing_template", "has_infused_gemstone");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.CARBIDE_UPGRADE_TEMPLATE.get(), Items.BOW,
                ModItems.TUNGSTEN_CARBIDE_INGOT.get(), RecipeCategory.COMBAT, ModItems.TUNGSTEN_CARBIDE_BOW.get(),
                "has_carbide_upgrade_smithing_template", "has_tungsten_carbide_ingot");
        //endregion

        //region CROSSBOWS
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.COBALT_UPGRADE_TEMPLATE.get(), Items.CROSSBOW,
                ModItems.COBALT_STEEL_INGOT.get(), RecipeCategory.COMBAT, ModItems.COBALT_STEEL_CROSSBOW.get(),
                "has_cobalt_upgrade_smithing_template", "has_cobalt_steel_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.INFUSION_UPGRADE_TEMPLATE.get(), Items.CROSSBOW,
                ModItems.INFUSED_GEMSTONE.get(), RecipeCategory.COMBAT, ModItems.INFUSED_GEMSTONE_CROSSBOW.get(),
                "has_infusion_upgrade_smithing_template", "has_infused_gemstone");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.CARBIDE_UPGRADE_TEMPLATE.get(), Items.CROSSBOW,
                ModItems.TUNGSTEN_CARBIDE_INGOT.get(), RecipeCategory.COMBAT, ModItems.TUNGSTEN_CARBIDE_CROSSBOW.get(),
                "has_carbide_upgrade_smithing_template", "has_tungsten_carbide_ingot");
        //endregion

        //region BRONZE EQUIPMENT
        armorRecipeBuilder(recipeOutput, EquipmentSlot.HEAD, ModTags.Items.FORGE_BRONZE_INGOTS, ModItems.BRONZE_HELMET.get(),
                "has_bronze_ingot");
        armorRecipeBuilder(recipeOutput, EquipmentSlot.CHEST, ModTags.Items.FORGE_BRONZE_INGOTS, ModItems.BRONZE_CHESTPLATE.get(),
                "has_bronze_ingot");
        armorRecipeBuilder(recipeOutput, EquipmentSlot.LEGS, ModTags.Items.FORGE_BRONZE_INGOTS, ModItems.BRONZE_LEGGINGS.get(),
                "has_bronze_ingot");
        armorRecipeBuilder(recipeOutput, EquipmentSlot.FEET, ModTags.Items.FORGE_BRONZE_INGOTS, ModItems.BRONZE_BOOTS.get(),
                "has_bronze_ingot");

        toolRecipeBuilder(recipeOutput, ToolType.AXE, ModTags.Items.FORGE_BRONZE_INGOTS, ModItems.BRONZE_AXE.get(),
                "has_bronze_ingot");
        toolRecipeBuilder(recipeOutput, ToolType.HOE, ModTags.Items.FORGE_BRONZE_INGOTS, ModItems.BRONZE_HOE.get(),
                "has_bronze_ingot");
        toolRecipeBuilder(recipeOutput, ToolType.PICKAXE, ModTags.Items.FORGE_BRONZE_INGOTS, ModItems.BRONZE_PICKAXE.get(),
                "has_bronze_ingot");
        toolRecipeBuilder(recipeOutput, ToolType.SHOVEL, ModTags.Items.FORGE_BRONZE_INGOTS, ModItems.BRONZE_SHOVEL.get(),
                "has_bronze_ingot");
        toolRecipeBuilder(recipeOutput, ToolType.SWORD, ModTags.Items.FORGE_BRONZE_INGOTS, ModItems.BRONZE_SWORD.get(),
                "has_bronze_ingot");
        //endregion

        //region GILDED BRONZE EQUIPMENT
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GILDED_BRONZE_HELMET.get(), 1)
                .define('d', ModTags.Items.FORGE_GOLD_INGOTS)
                .define('i', ModItems.BRONZE_HELMET.get())
                .pattern("ddd")
                .pattern("did")
                .pattern("ddd")
                .unlockedBy("has_gilded_bronze_helmet", has(ModItems.GILDED_BRONZE_HELMET.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GILDED_BRONZE_CHESTPLATE.get(), 1)
                .define('d', ModTags.Items.FORGE_GOLD_INGOTS)
                .define('i', ModItems.BRONZE_CHESTPLATE.get())
                .pattern("ddd")
                .pattern("did")
                .pattern("ddd")
                .unlockedBy("has_gilded_bronze_chestplate", has(ModItems.GILDED_BRONZE_CHESTPLATE.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GILDED_BRONZE_LEGGINGS.get(), 1)
                .define('d', ModTags.Items.FORGE_GOLD_INGOTS)
                .define('i', ModItems.BRONZE_LEGGINGS.get())
                .pattern("ddd")
                .pattern("did")
                .pattern("ddd")
                .unlockedBy("has_gilded_bronze_leggings", has(ModItems.GILDED_BRONZE_LEGGINGS.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GILDED_BRONZE_BOOTS.get(), 1)
                .define('d', ModTags.Items.FORGE_GOLD_INGOTS)
                .define('i', ModItems.BRONZE_BOOTS.get())
                .pattern("ddd")
                .pattern("did")
                .pattern("ddd")
                .unlockedBy("has_gilded_bronze_boots", has(ModItems.GILDED_BRONZE_BOOTS.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GILDED_BRONZE_AXE.get(), 1)
                .define('d', ModTags.Items.FORGE_GOLD_INGOTS)
                .define('i', ModItems.BRONZE_AXE.get())
                .pattern("ddd")
                .pattern("did")
                .pattern("ddd")
                .unlockedBy("has_gilded_bronze_axe", has(ModItems.GILDED_BRONZE_AXE.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GILDED_BRONZE_HOE.get(), 1)
                .define('d', ModTags.Items.FORGE_GOLD_INGOTS)
                .define('i', ModItems.BRONZE_HOE.get())
                .pattern("ddd")
                .pattern("did")
                .pattern("ddd")
                .unlockedBy("has_gilded_bronze_hoe", has(ModItems.GILDED_BRONZE_HOE.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GILDED_BRONZE_PICKAXE.get(), 1)
                .define('d', ModTags.Items.FORGE_GOLD_INGOTS)
                .define('i', ModItems.BRONZE_PICKAXE.get())
                .pattern("ddd")
                .pattern("did")
                .pattern("ddd")
                .unlockedBy("has_gilded_bronze_pickaxe", has(ModItems.GILDED_BRONZE_PICKAXE.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GILDED_BRONZE_SHOVEL.get(), 1)
                .define('d', ModTags.Items.FORGE_GOLD_INGOTS)
                .define('i', ModItems.BRONZE_SHOVEL.get())
                .pattern("ddd")
                .pattern("did")
                .pattern("ddd")
                .unlockedBy("has_gilded_bronze_shovel", has(ModItems.GILDED_BRONZE_SHOVEL.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GILDED_BRONZE_SWORD.get(), 1)
                .define('d', ModTags.Items.FORGE_GOLD_INGOTS)
                .define('i', ModItems.BRONZE_SWORD.get())
                .pattern("ddd")
                .pattern("did")
                .pattern("ddd")
                .unlockedBy("has_gilded_bronze_sword", has(ModItems.GILDED_BRONZE_SWORD.get()))
                .save(recipeOutput);
        //endregion

        //region COBALT-STEEL EQUIPMENT
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.COBALT_UPGRADE_TEMPLATE.get(), Items.DIAMOND_HELMET,
                ModItems.COBALT_STEEL_INGOT.get(), RecipeCategory.COMBAT, ModItems.COBALT_STEEL_HELMET.get(),
                "has_cobalt_upgrade_smithing_template", "has_cobalt_steel_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.COBALT_UPGRADE_TEMPLATE.get(), Items.DIAMOND_CHESTPLATE,
                ModItems.COBALT_STEEL_INGOT.get(), RecipeCategory.COMBAT, ModItems.COBALT_STEEL_CHESTPLATE.get(),
                "has_cobalt_upgrade_smithing_template", "has_cobalt_steel_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.COBALT_UPGRADE_TEMPLATE.get(), Items.DIAMOND_LEGGINGS,
                ModItems.COBALT_STEEL_INGOT.get(), RecipeCategory.COMBAT, ModItems.COBALT_STEEL_LEGGINGS.get(),
                "has_cobalt_upgrade_smithing_template", "has_cobalt_steel_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.COBALT_UPGRADE_TEMPLATE.get(), Items.DIAMOND_BOOTS,
                ModItems.COBALT_STEEL_INGOT.get(), RecipeCategory.COMBAT, ModItems.COBALT_STEEL_BOOTS.get(),
                "has_cobalt_upgrade_smithing_template", "has_cobalt_steel_ingot");

        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.COBALT_UPGRADE_TEMPLATE.get(), Items.DIAMOND_AXE,
                ModItems.COBALT_STEEL_INGOT.get(), RecipeCategory.TOOLS, ModItems.COBALT_STEEL_AXE.get(),
                "has_cobalt_upgrade_smithing_template", "has_cobalt_steel_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.COBALT_UPGRADE_TEMPLATE.get(), ModItems.DIAMOND_BATTLEAXE.get(),
                ModItems.COBALT_STEEL_INGOT.get(), RecipeCategory.COMBAT, ModItems.COBALT_STEEL_BATTLEAXE.get(),
                "has_cobalt_upgrade_smithing_template", "has_cobalt_steel_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.COBALT_UPGRADE_TEMPLATE.get(), Items.DIAMOND_HOE,
                ModItems.COBALT_STEEL_INGOT.get(), RecipeCategory.TOOLS, ModItems.COBALT_STEEL_HOE.get(),
                "has_cobalt_upgrade_smithing_template", "has_cobalt_steel_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.COBALT_UPGRADE_TEMPLATE.get(), ModItems.DIAMOND_PAXEL.get(),
                ModItems.COBALT_STEEL_INGOT.get(), RecipeCategory.TOOLS, ModItems.COBALT_STEEL_PAXEL.get(),
                "has_cobalt_upgrade_smithing_template", "has_cobalt_steel_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.COBALT_UPGRADE_TEMPLATE.get(), Items.DIAMOND_PICKAXE,
                ModItems.COBALT_STEEL_INGOT.get(), RecipeCategory.TOOLS, ModItems.COBALT_STEEL_PICKAXE.get(),
                "has_cobalt_upgrade_smithing_template", "has_cobalt_steel_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.COBALT_UPGRADE_TEMPLATE.get(), Items.DIAMOND_SHOVEL,
                ModItems.COBALT_STEEL_INGOT.get(), RecipeCategory.TOOLS, ModItems.COBALT_STEEL_SHOVEL.get(),
                "has_cobalt_upgrade_smithing_template", "has_cobalt_steel_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.COBALT_UPGRADE_TEMPLATE.get(), Items.DIAMOND_SWORD,
                ModItems.COBALT_STEEL_INGOT.get(), RecipeCategory.COMBAT, ModItems.COBALT_STEEL_SWORD.get(),
                "has_cobalt_upgrade_smithing_template", "has_cobalt_steel_ingot");
        //endregion

        //region INFUSED GEMSTONE EQUIPMENT
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.INFUSION_UPGRADE_TEMPLATE.get(), Items.DIAMOND_HELMET,
                ModItems.INFUSED_GEMSTONE.get(), RecipeCategory.COMBAT, ModItems.INFUSED_GEMSTONE_HELMET.get(),
                "has_infusion_upgrade_smithing_template", "has_infused_gemstone");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.INFUSION_UPGRADE_TEMPLATE.get(), Items.DIAMOND_CHESTPLATE,
                ModItems.INFUSED_GEMSTONE.get(), RecipeCategory.COMBAT, ModItems.INFUSED_GEMSTONE_CHESTPLATE.get(),
                "has_infusion_upgrade_smithing_template", "has_infused_gemstone");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.INFUSION_UPGRADE_TEMPLATE.get(), Items.DIAMOND_LEGGINGS,
                ModItems.INFUSED_GEMSTONE.get(), RecipeCategory.COMBAT, ModItems.INFUSED_GEMSTONE_LEGGINGS.get(),
                "has_infusion_upgrade_smithing_template", "has_infused_gemstone");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.INFUSION_UPGRADE_TEMPLATE.get(), Items.DIAMOND_BOOTS,
                ModItems.INFUSED_GEMSTONE.get(), RecipeCategory.COMBAT, ModItems.INFUSED_GEMSTONE_BOOTS.get(),
                "has_infusion_upgrade_smithing_template", "has_infused_gemstone");

        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.INFUSION_UPGRADE_TEMPLATE.get(), Items.DIAMOND_AXE,
                ModItems.INFUSED_GEMSTONE.get(), RecipeCategory.TOOLS, ModItems.INFUSED_GEMSTONE_AXE.get(),
                "has_infusion_upgrade_smithing_template", "has_infused_gemstone");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.INFUSION_UPGRADE_TEMPLATE.get(), ModItems.DIAMOND_BATTLEAXE.get(),
                ModItems.INFUSED_GEMSTONE.get(), RecipeCategory.COMBAT, ModItems.INFUSED_GEMSTONE_BATTLEAXE.get(),
                "has_infusion_upgrade_smithing_template", "has_infused_gemstone");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.INFUSION_UPGRADE_TEMPLATE.get(), Items.DIAMOND_HOE,
                ModItems.INFUSED_GEMSTONE.get(), RecipeCategory.TOOLS, ModItems.INFUSED_GEMSTONE_HOE.get(),
                "has_infusion_upgrade_smithing_template", "has_infused_gemstone");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.INFUSION_UPGRADE_TEMPLATE.get(), ModItems.DIAMOND_PAXEL.get(),
                ModItems.INFUSED_GEMSTONE.get(), RecipeCategory.TOOLS, ModItems.INFUSED_GEMSTONE_PAXEL.get(),
                "has_infusion_upgrade_smithing_template", "has_infused_gemstone");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.INFUSION_UPGRADE_TEMPLATE.get(), Items.DIAMOND_PICKAXE,
                ModItems.INFUSED_GEMSTONE.get(), RecipeCategory.TOOLS, ModItems.INFUSED_GEMSTONE_PICKAXE.get(),
                "has_infusion_upgrade_smithing_template", "has_infused_gemstone");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.INFUSION_UPGRADE_TEMPLATE.get(), Items.DIAMOND_SHOVEL,
                ModItems.INFUSED_GEMSTONE.get(), RecipeCategory.TOOLS, ModItems.INFUSED_GEMSTONE_SHOVEL.get(),
                "has_infusion_upgrade_smithing_template", "has_infused_gemstone");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.INFUSION_UPGRADE_TEMPLATE.get(), Items.DIAMOND_SWORD,
                ModItems.INFUSED_GEMSTONE.get(), RecipeCategory.COMBAT, ModItems.INFUSED_GEMSTONE_SWORD.get(),
                "has_infusion_upgrade_smithing_template", "has_infused_gemstone");
        //endregion

        //region TUNGSTEN-CARBIDE EQUIPMENT
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.CARBIDE_UPGRADE_TEMPLATE.get(), Items.DIAMOND_HELMET,
                ModItems.TUNGSTEN_CARBIDE_INGOT.get(), RecipeCategory.COMBAT, ModItems.TUNGSTEN_CARBIDE_HELMET.get(),
                "has_carbide_upgrade_smithing_template", "has_tungsten_carbide_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.CARBIDE_UPGRADE_TEMPLATE.get(), Items.DIAMOND_CHESTPLATE,
                ModItems.TUNGSTEN_CARBIDE_INGOT.get(), RecipeCategory.COMBAT, ModItems.TUNGSTEN_CARBIDE_CHESTPLATE.get(),
                "has_carbide_upgrade_smithing_template", "has_tungsten_carbide_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.CARBIDE_UPGRADE_TEMPLATE.get(), Items.DIAMOND_LEGGINGS,
                ModItems.TUNGSTEN_CARBIDE_INGOT.get(), RecipeCategory.COMBAT, ModItems.TUNGSTEN_CARBIDE_LEGGINGS.get(),
                "has_carbide_upgrade_smithing_template", "has_tungsten_carbide_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.CARBIDE_UPGRADE_TEMPLATE.get(), Items.DIAMOND_BOOTS,
                ModItems.TUNGSTEN_CARBIDE_INGOT.get(), RecipeCategory.COMBAT, ModItems.TUNGSTEN_CARBIDE_BOOTS.get(),
                "has_carbide_upgrade_smithing_template", "has_tungsten_carbide_ingot");

        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.CARBIDE_UPGRADE_TEMPLATE.get(), Items.DIAMOND_AXE,
                ModItems.TUNGSTEN_CARBIDE_INGOT.get(), RecipeCategory.TOOLS, ModItems.TUNGSTEN_CARBIDE_AXE.get(),
                "has_carbide_upgrade_smithing_template", "has_tungsten_carbide_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.CARBIDE_UPGRADE_TEMPLATE.get(), ModItems.DIAMOND_BATTLEAXE.get(),
                ModItems.TUNGSTEN_CARBIDE_INGOT.get(), RecipeCategory.COMBAT, ModItems.TUNGSTEN_CARBIDE_BATTLEAXE.get(),
                "has_carbide_upgrade_smithing_template", "has_tungsten_carbide_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.CARBIDE_UPGRADE_TEMPLATE.get(), Items.DIAMOND_HOE,
                ModItems.TUNGSTEN_CARBIDE_INGOT.get(), RecipeCategory.TOOLS, ModItems.TUNGSTEN_CARBIDE_HOE.get(),
                "has_carbide_upgrade_smithing_template", "has_tungsten_carbide_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.CARBIDE_UPGRADE_TEMPLATE.get(), ModItems.DIAMOND_PAXEL.get(),
                ModItems.TUNGSTEN_CARBIDE_INGOT.get(), RecipeCategory.TOOLS, ModItems.TUNGSTEN_CARBIDE_PAXEL.get(),
                "has_carbide_upgrade_smithing_template", "has_tungsten_carbide_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.CARBIDE_UPGRADE_TEMPLATE.get(), Items.DIAMOND_PICKAXE,
                ModItems.TUNGSTEN_CARBIDE_INGOT.get(), RecipeCategory.TOOLS, ModItems.TUNGSTEN_CARBIDE_PICKAXE.get(),
                "has_carbide_upgrade_smithing_template", "has_tungsten_carbide_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.CARBIDE_UPGRADE_TEMPLATE.get(), Items.DIAMOND_SHOVEL,
                ModItems.TUNGSTEN_CARBIDE_INGOT.get(), RecipeCategory.TOOLS, ModItems.TUNGSTEN_CARBIDE_SHOVEL.get(),
                "has_carbide_upgrade_smithing_template", "has_tungsten_carbide_ingot");
        smithingUpgradeRecipeBuilder(recipeOutput, ModItems.CARBIDE_UPGRADE_TEMPLATE.get(), Items.DIAMOND_SWORD,
                ModItems.TUNGSTEN_CARBIDE_INGOT.get(), RecipeCategory.COMBAT, ModItems.TUNGSTEN_CARBIDE_SWORD.get(),
                "has_carbide_upgrade_smithing_template", "has_tungsten_carbide_ingot");
        //endregion
    }



    /**
     * Helper to automatically generate shaped recipes for the four armor slots.
     * @param recipeOutput RecipeOutput object
     * @param slot This armor piece's EquipmentSlot
     * @param ingredient Crafting ingredient
     * @param result Crafting result
     * @param hasString Tag used for unlocking crafting recipe
     */
    private void armorRecipeBuilder(RecipeOutput recipeOutput, EquipmentSlot slot,
                                    TagKey<Item> ingredient, Item result,
                                    String hasString) {
        switch (slot) {
            case HEAD -> ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result, 1)
                    .define('d', ingredient)
                    .pattern("ddd")
                    .pattern("d d")
                    .unlockedBy(hasString, has(ingredient))
                    .save(recipeOutput);
            case CHEST -> ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result, 1)
                    .define('d', ingredient)
                    .pattern("d d")
                    .pattern("ddd")
                    .pattern("ddd")
                    .unlockedBy(hasString, has(ingredient))
                    .save(recipeOutput);
            case LEGS -> ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result, 1)
                    .define('d', ingredient)
                    .pattern("ddd")
                    .pattern("d d")
                    .pattern("d d")
                    .unlockedBy(hasString, has(ingredient))
                    .save(recipeOutput);
            case FEET -> ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result, 1)
                    .define('d', ingredient)
                    .pattern("d d")
                    .pattern("d d")
                    .unlockedBy(hasString, has(ingredient))
                    .save(recipeOutput);
            default ->  //This should never be reached.
                    ModMain.LOGGER.debug("Invalid EquipmentSlot provided to armorRecipeBuilder.");
        }
    }

    /**
     * Helper to automatically generate shaped recipes for the five vanilla tool types AND Mace.
     * @param recipeOutput RecipeOutput object
     * @param toolType Type of tool defined in ToolType enum
     * @param ingredient Crafting ingredient
     * @param result Crafting result
     * @param hasString Tag used for unlocking crafting recipe
     */
    private void toolRecipeBuilder(RecipeOutput recipeOutput, ToolType toolType,
                                   TagKey<Item> ingredient, Item result, String hasString) {
        switch (toolType) {
            case AXE -> ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result, 1)
                    .define('d', ingredient)
                    .define('i', ModTags.Items.FORGE_WOODEN_RODS)
                    .pattern("dd")
                    .pattern("di")
                    .pattern(" i")
                    .unlockedBy(hasString, has(ingredient))
                    .save(recipeOutput);
            case BATTLEAXE -> ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result, 1)
                    .define('d', ingredient)
                    .define('i', ModTags.Items.FORGE_WOODEN_RODS)
                    .pattern("ddd")
                    .pattern("did")
                    .pattern(" i ")
                    .unlockedBy(hasString, has(ingredient))
                    .save(recipeOutput);
            case HOE -> ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result, 1)
                    .define('d', ingredient)
                    .define('i', ModTags.Items.FORGE_WOODEN_RODS)
                    .pattern("dd")
                    .pattern(" i")
                    .pattern(" i")
                    .unlockedBy(hasString, has(ingredient))
                    .save(recipeOutput);
            case PAXEL -> ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result, 1)
                    .define('d', ingredient)
                    .define('i', ModTags.Items.FORGE_WOODEN_RODS)
                    .pattern("ddd")
                    .pattern("di ")
                    .pattern(" i ")
                    .unlockedBy(hasString, has(ingredient))
                    .save(recipeOutput);
            case PICKAXE -> ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result, 1)
                    .define('d', ingredient)
                    .define('i', ModTags.Items.FORGE_WOODEN_RODS)
                    .pattern("ddd")
                    .pattern(" i ")
                    .pattern(" i ")
                    .unlockedBy(hasString, has(ingredient))
                    .save(recipeOutput);
            case SHOVEL -> ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result, 1)
                    .define('d', ingredient)
                    .define('i', ModTags.Items.FORGE_WOODEN_RODS)
                    .pattern("d")
                    .pattern("i")
                    .pattern("i")
                    .unlockedBy(hasString, has(ingredient))
                    .save(recipeOutput);
            case SWORD -> ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result, 1)
                    .define('d', ingredient)
                    .define('i', ModTags.Items.FORGE_WOODEN_RODS)
                    .pattern("d")
                    .pattern("d")
                    .pattern("i")
                    .unlockedBy(hasString, has(ingredient))
                    .save(recipeOutput);
        }
    }

    

    /**
     * Helper to automatically generate smithing recipes (1.20+). NOTE: Smithing recipes are
     *  specifically item-to-item, and should never use tags.
     * @param recipeOutput RecipeOutput object
     * @param template Required upgrade template Item
     * @param upgradeItem Item being upgraded
     * @param ingredient Upgrade ingredient Item
     * @param category Recipe category
     * @param result Smithing result Item
     * @param hasStringTemplate String in "has_[item]" format corresponding to the upgrade template
     * @param hasStringIngredient String in "has_[item]" format corresponding to the upgrade ingredient
     */
    private void smithingUpgradeRecipeBuilder(RecipeOutput recipeOutput, Item template, Item upgradeItem,
                                              Item ingredient, RecipeCategory category, Item result,
                                              String hasStringTemplate, String hasStringIngredient) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(upgradeItem),
                        Ingredient.of(ingredient), category, result)
                .unlocks(hasStringTemplate, has(template))
                .unlocks(hasStringIngredient, has(ingredient))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, getItemName(result))
                        + "_smithing");
    }

    



    /**
     * Builds a smelting recipe and writes it to a JSON file. NOTE: Smelting and Blasting recipes are
     *  specifically item-to-item, and should never use tags.
     * @param recipeOutput RecipeOutput object
     * @param ingredientItemLike ItemLike that will be blasted
     * @param category Recipe category
     * @param resultItemLike ItemLike that will be produced
     * @param xpReward XP reward per item blasted
     * @param ticks Number of ticks required to blast
     * @param resultItemName String, equal to result item name, that is used in JSON filename
     */
    protected static void smeltingRecipeBuilder(RecipeOutput recipeOutput, ItemLike ingredientItemLike,
                                                RecipeCategory category, ItemLike resultItemLike, float xpReward,
                                                int ticks, String resultItemName) {
        SimpleCookingRecipeBuilder
                .generic(Ingredient.of(ingredientItemLike), category, resultItemLike, xpReward, ticks,
                        RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new)
                .group(resultItemName)
                .unlockedBy(getHasName(ingredientItemLike), has(ingredientItemLike))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID,
                        getItemName(resultItemLike)) + "_from_smelting_" + getItemName(ingredientItemLike));
    }

    /**
     * Builds a blasting recipe and writes it to a JSON file. NOTE: Smelting and Blasting recipes are
     *  specifically item-to-item, and should never use tags.
     * @param recipeOutput RecipeOutput object
     * @param ingredientItemLike ItemLike that will be blasted
     * @param category Recipe category
     * @param resultItemLike ItemLike that will be produced
     * @param xpReward XP reward per item blasted
     * @param ticks Number of ticks required to blast
     * @param resultItemName String, equal to result item name, that is used in JSON filename
     */
    protected static void blastingRecipeBuilder(RecipeOutput recipeOutput, ItemLike ingredientItemLike,
                                                RecipeCategory category, ItemLike resultItemLike, float xpReward,
                                                int ticks, String resultItemName) {
        SimpleCookingRecipeBuilder
                .generic(Ingredient.of(ingredientItemLike), category, resultItemLike, xpReward, ticks,
                        RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new)
                .group(resultItemName)
                .unlockedBy(getHasName(ingredientItemLike), has(ingredientItemLike))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ModMain.MODID,
                        getItemName(resultItemLike)) + "_from_blasting_" + getItemName(ingredientItemLike));
    }





    //region COPIED METHODS TO FIX RECIPES GENERATING UNDER MINECRAFT INSTEAD OF MOD

    //To fix generation issue: Copy over all methods used in this class and then edit all instances
    // of 'ResourceLocation.fromNamespaceAndPath()' to first take TestMod.MOD_ID, THEN the actual value.
    //  ex. 'ResourceLocation.fromNamespaceAndPath(p_252237_)' -> 'ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, p_252237_)'

    protected static void nineBlockStorageRecipes(RecipeOutput p_249580_, RecipeCategory p_251203_,
                                                  ItemLike p_251689_, RecipeCategory p_251376_, ItemLike p_248771_) {
        nineBlockStorageRecipes(p_249580_, p_251203_, p_251689_, p_251376_, p_248771_, getSimpleRecipeName(p_248771_),
                null, getSimpleRecipeName(p_251689_), null);
    }
    protected static void nineBlockStorageRecipes(RecipeOutput p_250423_, RecipeCategory p_250083_,
                                                  ItemLike p_250042_, RecipeCategory p_248977_, ItemLike p_251911_,
                                                  String p_250475_, @Nullable String p_248641_, String p_252237_,
                                                  @Nullable String p_250414_) {
        ShapelessRecipeBuilder.shapeless(p_250083_, p_250042_, 9)
                .requires(p_251911_)
                .group(p_250414_)
                .unlockedBy(getHasName(p_251911_), has(p_251911_))
                .save(p_250423_, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, p_252237_));
        ShapedRecipeBuilder.shaped(p_248977_, p_251911_).define('#', p_250042_)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group(p_248641_)
                .unlockedBy(getHasName(p_250042_), has(p_250042_))
                .save(p_250423_, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, p_250475_));
    }
    //endregion
}
