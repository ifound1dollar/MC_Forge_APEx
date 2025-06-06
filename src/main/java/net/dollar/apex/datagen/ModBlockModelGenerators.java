package net.dollar.apex.datagen;

import net.dollar.apex.block.ModBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ModBlockModelGenerators extends BlockModelGenerators {
    public ModBlockModelGenerators(Consumer<BlockModelDefinitionGenerator> consumer, ItemModelOutput output, BiConsumer<ResourceLocation, ModelInstance> biConsumer) {
        super(consumer, output, biConsumer);
    }



    @Override
    public void run() {
        // ALL BASIC BLOCKS
        registerSimpleBlockModel(ModBlocks.RUBY_ORE.get());
        registerSimpleBlockModel(ModBlocks.DEEPSLATE_RUBY_ORE.get());
        registerSimpleBlockModel(ModBlocks.RUBY_BLOCK.get());

        registerSimpleBlockModel(ModBlocks.SAPPHIRE_ORE.get());
        registerSimpleBlockModel(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
        registerSimpleBlockModel(ModBlocks.SAPPHIRE_BLOCK.get());

        registerSimpleBlockModel(ModBlocks.DECORATIVE_AMETHYST_BLOCK.get());

        registerSimpleBlockModel(ModBlocks.COBALT_BLOCK.get());
        registerSimpleBlockModel(ModBlocks.COBALT_ORE.get());
        registerSimpleBlockModel(ModBlocks.DEEPSLATE_COBALT_ORE.get());

        registerSimpleBlockModel(ModBlocks.PHOSPHATE_ORE.get());
        registerSimpleBlockModel(ModBlocks.DEEPSLATE_PHOSPHATE_ORE.get());

        registerSimpleBlockModel(ModBlocks.TIN_BLOCK.get());
        registerSimpleBlockModel(ModBlocks.RAW_TIN_BLOCK.get());
        registerSimpleBlockModel(ModBlocks.TIN_ORE.get());
        registerSimpleBlockModel(ModBlocks.DEEPSLATE_TIN_ORE.get());

        registerSimpleBlockModel(ModBlocks.TUNGSTEN_BLOCK.get());
        registerSimpleBlockModel(ModBlocks.RAW_TUNGSTEN_BLOCK.get());
        registerSimpleBlockModel(ModBlocks.TUNGSTEN_ORE.get());
        registerSimpleBlockModel(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get());

        registerSimpleBlockModel(ModBlocks.BRONZE_BLOCK.get());
        registerSimpleBlockModel(ModBlocks.STEEL_BLOCK.get());
    }

    /**
     * Registers a simple Block model with a corresponding Item model.
     * @param block Block to generate models for.
     */
    private void registerSimpleBlockModel(Block block)
    {
        createTrivialCube(block);
        registerSimpleItemModel(block, ModelLocationUtils.getModelLocation(block));
    }
}
