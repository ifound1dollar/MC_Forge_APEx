package net.dollar.apex.worldgen;

import net.dollar.apex.ModMain;
import net.dollar.apex.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

/**
 * ConfiguredFeatures determine which blocks that generated ores can replace AND the size of the veins.
 *  Starting with Minecraft version 1.19, PlacedFeatures are data-driven using JSON files only, and
 *  cannot be adjusted via config files.
 */
public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COBALT_ORE_KEY = registerKey("cobalt_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PHOSPHATE_ORE_KEY = registerKey("phosphate_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registerKey("tin_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TIN_ORE_SMALL_KEY = registerKey("tin_ore_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TUNGSTEN_ORE_KEY = registerKey("tungsten_ore");



    /**
     * Registers new ConfiguredFeatures using one of two helper methods.
     * @param context BootstrapContext of type ConfiguredFeature
     */
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        //define valid ore replacements here
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> rubyOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> sapphireOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> cobaltOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.COBALT_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_COBALT_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> phosphateOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.PHOSPHATE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_PHOSPHATE_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> tinOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.TIN_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> tungstenOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.TUNGSTEN_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get().defaultBlockState())
        );

        //INT PARAM IS VEIN SIZE
        //OPTIONAL FLOAT PARAM IS CHANCE PER BLOCK TO FAIL WHEN EXPOSED TO AIR

        //Vein size 3 is Emerald equivalent.
        register(context, RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(rubyOres,
                3));
        register(context, SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(sapphireOres,
                3));

        //Vein size 12 is regular Diamond equivalent, 4 is small Diamond equivalent.
        register(context, COBALT_ORE_KEY, Feature.ORE, new OreConfiguration(cobaltOres, 4));
        register(context, TUNGSTEN_ORE_KEY, Feature.ORE, new OreConfiguration(tungstenOres, 12, 0.33f));

        //Vein size 7 is Lapis equivalent.
        register(context, PHOSPHATE_ORE_KEY, Feature.ORE, new OreConfiguration(phosphateOres, 7));

        //Vein size 9 is Iron equivalent, 10 is Copper equivalent.
        register(context, TIN_ORE_KEY, Feature.ORE, new OreConfiguration(tinOres, 8));
        register(context, TIN_ORE_SMALL_KEY, Feature.ORE, new OreConfiguration(tinOres, 4));    //Half of regular
    }



    /**
     * Generates a ConfiguredFeature ResourceKey.
     * @param name String corresponding to the ConfiguredFeature's ResourceLocation
     * @return The generated ResourceKey
     */
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, name));
    }

    /**
     * Registers a new ConfiguredFeature ResourceKey.
     * @param context The ConfiguredFeature's BoostrapContext
     * @param key ResourceKey of the ConfiguredFeature to register
     * @param feature Feature type (ex. ORE)
     * @param configuration Configuration corresponding to the specific feature to generate (ex. OreConfiguration)
     */
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key,
            F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
