package net.dollar.apex.item;

import net.dollar.apex.ModMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * Handles creation of new item groups (creative mode tabs).
 */
@Mod.EventBusSubscriber(modid = ModMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItemGroups {
    //Create a Deferred Register to hold CreativeModeTabs.
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB, ModMain.MODID);

    //Creates a creative tab for all APEx items.
    public static final RegistryObject<CreativeModeTab> APEX_GROUP = CREATIVE_MODE_TABS.register("apex_group",
            () -> CreativeModeTab.builder()
                    .icon(() -> ModItems.TEST_ITEM.get().getDefaultInstance())  //TODO: Correct item
                    .title(Component.literal("APEx"))
                    .displayItems((parameters, output) -> {
                        //Add all items to tab here.
                        output.accept(ModItems.TEST_ITEM.get());    //TODO: Correct item
                    }).build());



    /**
     * Register new item groups.
     * @param bus Main event bus
     */
    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
