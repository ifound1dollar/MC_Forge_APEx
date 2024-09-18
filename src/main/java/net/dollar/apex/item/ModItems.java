package net.dollar.apex.item;

import net.dollar.apex.ModMain;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    //Create a Deferred Register to hold Items which will all be registered under the "apex" namespace.
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModMain.MODID);



    public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item",
            () -> new Item(new Item.Properties()));



    /**
     * Register new Items.
     * @param bus Main event bus
     */
    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
