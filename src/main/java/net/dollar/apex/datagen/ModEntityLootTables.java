package net.dollar.apex.datagen;

import net.dollar.apex.entity.ModEntities;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

/**
 * Used to auto-generate entity loot JSON files in 'src/generated' subdirectory. In-code definitions
 *  of loot tables to be generated are contained within this class.
 */
public class ModEntityLootTables extends EntityLootSubProvider {
    protected ModEntityLootTables(HolderLookup.Provider provider) {
        super(FeatureFlags.REGISTRY.allFlags(), provider);
    }



    /**
     * Generate loot tables for each new Entity.
     */
    @Override
    public void generate() {
        add(ModEntities.OBSIDIAN_GOLEM.get(), LootTable.lootTable());
        add(ModEntities.MYSTERIOUS_SPECTER.get(), LootTable.lootTable());
    }



    /**
     * Gets all known EntityTypes added by the mod as a Stream.
     * @return Stream of mod's EntityTypes
     */
    @Override
    protected @NotNull Stream<EntityType<?>> getKnownEntityTypes() {
        return ModEntities.ENTITY_TYPES.getEntries().stream().map(RegistryObject::get);
    }
}
