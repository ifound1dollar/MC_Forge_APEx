package net.dollar.apex;

import com.mojang.logging.LogUtils;
import net.dollar.apex.block.ModBlocks;
import net.dollar.apex.config.Config;
import net.dollar.apex.entity.ModEntities;
import net.dollar.apex.item.ModItemGroups;
import net.dollar.apex.item.ModItems;
import net.dollar.apex.util.ModLootTableModifiers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ModMain.MODID)
public class ModMain
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "apex";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();



    public ModMain(FMLJavaModLoadingContext context)
    {
        BusGroup modBusGroup = context.getModBusGroup();

        // Register the commonSetup method for modloading
        FMLCommonSetupEvent.getBus(modBusGroup).addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        //MinecraftForge.EVENT_BUS.register(this);

        //Register the Deferred Register to the mod event bus for all new items, blocks, entities, etc.
        ModEntities.register(modBusGroup);  //Register entities first to ensure spawn eggs load correctly
        ModItemGroups.register(modBusGroup);
        ModBlocks.register(modBusGroup);
        ModItems.register(modBusGroup);
        ModLootTableModifiers.register(modBusGroup);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC, "apex_common.toml");

        //TEMP
        //LOGGER.info(ModItems.MYSTERIOUS_SPECTER_SPAWN_EGG.getId().toString());
        //TEMP
    }



//    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public void onServerStarting(ServerStartingEvent event)
//    {
//        // Do something when the server starts
//        LOGGER.info("HELLO from server starting");
//    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
//        // Some common setup code
//        LOGGER.info("HELLO FROM COMMON SETUP");
//
//        if (Config.logDirtBlock)
//            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
//
//        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);
//
//        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
//            LOGGER.info("HELLO FROM CLIENT SETUP");
//            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
