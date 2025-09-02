package net.dollar.apex.datagen;

import net.dollar.apex.ModMain;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

/**
 * Handles initializing data generators used by the mod via the GatherDataEvent.
 */
@Mod.EventBusSubscriber(modid = ModMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    /**
     * Creates a DataGenerator object and adds new providers corresponding to each data generator
     *  class. Required for data generation to run.
     * @param event Event fired on data gathering
     */
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModRecipeProvider.Runner(packOutput, lookupProvider));
        generator.addProvider(true, ModLootTableProvider.create(packOutput, lookupProvider));
        generator.addProvider(event.includeClient(), new ModModelProvider(packOutput));
        generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, lookupProvider));
    }
}
