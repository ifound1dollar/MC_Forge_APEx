package net.dollar.apex.datagen;

import net.dollar.apex.block.ModBlocks;
import net.dollar.apex.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * Used to auto-generate block loot JSON files in 'src/generated' subdirectory. In-code definitions
 *  of loot tables to be generated are contained within this class.
 */
public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }



    /**
     * Generate loot tables for each new Block.
     */
    @Override
    protected void generate() {
        dropSelf(ModBlocks.DECORATIVE_AMETHYST_BLOCK.get());
        dropSelf(ModBlocks.COBALT_BLOCK.get());
        dropSelf(ModBlocks.RUBY_BLOCK.get());
        dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        dropSelf(ModBlocks.TIN_BLOCK.get());
        dropSelf(ModBlocks.RAW_TIN_BLOCK.get());
        dropSelf(ModBlocks.TUNGSTEN_BLOCK.get());
        dropSelf(ModBlocks.RAW_TUNGSTEN_BLOCK.get());
        dropSelf(ModBlocks.BRONZE_BLOCK.get());
        dropSelf(ModBlocks.STEEL_BLOCK.get());
        
        //SINGLE ORES
        add(ModBlocks.COBALT_ORE.get(),
                (block) -> createOreDrop(ModBlocks.COBALT_ORE.get(), ModItems.COBALT_SHARD.get()));
        add(ModBlocks.DEEPSLATE_COBALT_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_COBALT_ORE.get(), ModItems.COBALT_SHARD.get()));

        add(ModBlocks.RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get()));
        add(ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModItems.RUBY.get()));

        add(ModBlocks.SAPPHIRE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));
        add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));

        add(ModBlocks.TIN_ORE.get(),
                (block) -> createOreDrop(ModBlocks.TIN_ORE.get(), ModItems.RAW_TIN.get()));
        add(ModBlocks.DEEPSLATE_TIN_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_TIN_ORE.get(), ModItems.RAW_TIN.get()));

        add(ModBlocks.TUNGSTEN_ORE.get(),
                (block) -> createOreDrop(ModBlocks.TUNGSTEN_ORE.get(), ModItems.RAW_TUNGSTEN.get()));
        add(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), ModItems.RAW_TUNGSTEN.get()));

        //MULTI-DROP ORES
        add(ModBlocks.PHOSPHATE_ORE.get(), (block) ->
                createMultiOreDrop(ModBlocks.PHOSPHATE_ORE.get(), ModItems.PHOSPHATE_POWDER.get(),
                        2.0f, 5.0f));   //Equivalent to copper
        add(ModBlocks.DEEPSLATE_PHOSPHATE_ORE.get(), (block) ->
                createMultiOreDrop(ModBlocks.DEEPSLATE_PHOSPHATE_ORE.get(), ModItems.PHOSPHATE_POWDER.get(),
                        2.0f, 5.0f));
    }



    /**
     * Generates a loot table for a Block that should drop multiple of the same item.
     * @param block The Block dropped if mined with Silk Touch
     * @param item The Item to drop normally (without Silk Touch)
     * @param min The minimum number of drops
     * @param max The maximum number of drops
     * @return The newly generated loot table builder
     */
    protected LootTable.Builder createMultiOreDrop(Block block, Item item, float min, float max) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return createSilkTouchDispatchTable(block, this.applyExplosionDecay(block,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }



    /**
     * Gets all known Blocks added by the mod as an Iterator.
     * @return Iterator of all new Blocks
     */
    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
