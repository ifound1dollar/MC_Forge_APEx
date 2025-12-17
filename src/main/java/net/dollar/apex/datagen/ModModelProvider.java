package net.dollar.apex.datagen;

import net.dollar.apex.ModMain;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

/**
 * Used to auto-generate item model JSON files in 'src/generated' subdirectory. In-code definitions of recipes
 *  to be generated AND their corresponding helper methods are contained within this class.
 */
public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output);
    }



    @Override
    protected @NotNull Stream<Item> getKnownItems() {
        return BuiltInRegistries.ITEM.stream().filter(item -> ModMain.MODID.equals(item.builtInRegistryHolder().key().identifier().getNamespace()));
    }

    @Override
    protected @NotNull Stream<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream().filter(block -> ModMain.MODID.equals(block.builtInRegistryHolder().key().identifier().getNamespace()));
    }

    @Override
    protected @NotNull ItemModelGenerators getItemModelGenerators(@NotNull ItemInfoCollector items, @NotNull SimpleModelCollector models) {
        return new ModItemModelGenerators(items, models);
    }

    @Override
    protected @NotNull BlockModelGenerators getBlockModelGenerators(@NotNull BlockStateGeneratorCollector blocks, @NotNull ItemInfoCollector items, @NotNull SimpleModelCollector models) {
        return new ModBlockModelGenerators(blocks, items, models);
    }
}
