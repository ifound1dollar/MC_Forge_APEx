package net.dollar.apex.item;

import net.dollar.apex.ModMain;
import net.dollar.apex.block.ModBlocks;
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
                    .icon(() -> ModItems.INFUSED_GEMSTONE.get().getDefaultInstance())
                    .title(Component.literal("APEx"))
                    .displayItems((parameters, output) -> {
                        //Add all items to tab here.

                        //Ores and Raw Blocks
                        output.accept(ModBlocks.COBALT_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_COBALT_ORE.get());
                        output.accept(ModBlocks.COBALT_BLOCK.get());
                        output.accept(ModBlocks.PHOSPHATE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_PHOSPHATE_ORE.get());
                        output.accept(ModBlocks.RUBY_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_RUBY_ORE.get());
                        output.accept(ModBlocks.RUBY_BLOCK.get());
                        output.accept(ModBlocks.SAPPHIRE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        output.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        output.accept(ModBlocks.TIN_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_TIN_ORE.get());
                        output.accept(ModBlocks.RAW_TIN_BLOCK.get());
                        output.accept(ModBlocks.TIN_BLOCK.get());
                        output.accept(ModBlocks.TUNGSTEN_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get());
                        output.accept(ModBlocks.RAW_TUNGSTEN_BLOCK.get());
                        output.accept(ModBlocks.TUNGSTEN_BLOCK.get());


                        //Crafted Blocks
                        output.accept(ModBlocks.DECORATIVE_AMETHYST_BLOCK.get());
                        output.accept(ModBlocks.BRONZE_BLOCK.get());
                        output.accept(ModBlocks.STEEL_BLOCK.get());

                        //Misc. Blocks
                        //SOMETHING HERE



                        //Misc. Items
                        output.accept(ModItems.OBSIDIAN_GOLEM_SPAWN_EGG.get());
                        output.accept(ModItems.MYSTERIOUS_SPECTER_SPAWN_EGG.get());
                        output.accept(ModItems.FERTILIZER.get());

                        //Raw Items, Gems, Compounds
                        output.accept(ModItems.COBALT_SHARD.get());
                        output.accept(ModItems.PHOSPHATE_POWDER.get());
                        output.accept(ModItems.RUBY.get());
                        output.accept(ModItems.SAPPHIRE.get());
                        output.accept(ModItems.RAW_TIN.get());
                        output.accept(ModItems.TIN_INGOT.get());
                        output.accept(ModItems.TIN_NUGGET.get());
                        output.accept(ModItems.RAW_TUNGSTEN.get());
                        output.accept(ModItems.TUNGSTEN_INGOT.get());
                        output.accept(ModItems.TUNGSTEN_NUGGET.get());
                        output.accept(ModItems.BRONZE_COMPOUND.get());
                        output.accept(ModItems.BRONZE_INGOT.get());
                        output.accept(ModItems.BRONZE_NUGGET.get());
                        output.accept(ModItems.STEEL_COMPOUND.get());
                        output.accept(ModItems.STEEL_INGOT.get());
                        output.accept(ModItems.STEEL_NUGGET.get());

                        //Endgame upgrade items
                        output.accept(ModItems.HANDFUL_OF_STARDUST.get());
                        output.accept(ModItems.MOLTEN_CORE.get());
                        output.accept(ModItems.COBALT_STEEL_INGOT.get());
                        output.accept(ModItems.INFUSED_GEMSTONE.get());
                        output.accept(ModItems.TUNGSTEN_CARBIDE_INGOT.get());

                        //Upgrade templates
                        output.accept(ModItems.BASIC_UPGRADE_TEMPLATE.get());
                        output.accept(ModItems.COBALT_UPGRADE_TEMPLATE.get());
                        output.accept(ModItems.INFUSION_UPGRADE_TEMPLATE.get());
                        output.accept(ModItems.CARBIDE_UPGRADE_TEMPLATE.get());

                        //Bronze equipment
                        output.accept(ModItems.BRONZE_AXE.get());
                        output.accept(ModItems.BRONZE_HOE.get());
                        output.accept(ModItems.BRONZE_PICKAXE.get());
                        output.accept(ModItems.BRONZE_SHOVEL.get());
                        output.accept(ModItems.BRONZE_SWORD.get());
                        output.accept(ModItems.BRONZE_HELMET.get());
                        output.accept(ModItems.BRONZE_CHESTPLATE.get());
                        output.accept(ModItems.BRONZE_LEGGINGS.get());
                        output.accept(ModItems.BRONZE_BOOTS.get());

                        //Gilded Bronze equipment
                        output.accept(ModItems.GILDED_BRONZE_AXE.get());
                        output.accept(ModItems.GILDED_BRONZE_HOE.get());
                        output.accept(ModItems.GILDED_BRONZE_PICKAXE.get());
                        output.accept(ModItems.GILDED_BRONZE_SHOVEL.get());
                        output.accept(ModItems.GILDED_BRONZE_SWORD.get());
                        output.accept(ModItems.GILDED_BRONZE_HELMET.get());
                        output.accept(ModItems.GILDED_BRONZE_CHESTPLATE.get());
                        output.accept(ModItems.GILDED_BRONZE_LEGGINGS.get());
                        output.accept(ModItems.GILDED_BRONZE_BOOTS.get());

                        //Diamond equipment
                        output.accept(ModItems.DIAMOND_BATTLEAXE.get());
                        output.accept(ModItems.DIAMOND_PAXEL.get());

                        //Netherite equipment
                        output.accept(ModItems.NETHERITE_BATTLEAXE.get());
                        output.accept(ModItems.NETHERITE_PAXEL.get());

                        //Cobalt-Steel equipment
                        output.accept(ModItems.COBALT_STEEL_BOW.get());
                        output.accept(ModItems.COBALT_STEEL_CROSSBOW.get());
                        output.accept(ModItems.COBALT_STEEL_AXE.get());
                        output.accept(ModItems.COBALT_STEEL_BATTLEAXE.get());
                        output.accept(ModItems.COBALT_STEEL_HOE.get());
                        output.accept(ModItems.COBALT_STEEL_PAXEL.get());
                        output.accept(ModItems.COBALT_STEEL_PICKAXE.get());
                        output.accept(ModItems.COBALT_STEEL_SHOVEL.get());
                        output.accept(ModItems.COBALT_STEEL_SWORD.get());
                        output.accept(ModItems.COBALT_STEEL_HELMET.get());
                        output.accept(ModItems.COBALT_STEEL_CHESTPLATE.get());
                        output.accept(ModItems.COBALT_STEEL_LEGGINGS.get());
                        output.accept(ModItems.COBALT_STEEL_BOOTS.get());

                        //Infused Gemstone equipment
                        output.accept(ModItems.INFUSED_GEMSTONE_BOW.get());
                        output.accept(ModItems.INFUSED_GEMSTONE_CROSSBOW.get());
                        output.accept(ModItems.INFUSED_GEMSTONE_AXE.get());
                        output.accept(ModItems.INFUSED_GEMSTONE_BATTLEAXE.get());
                        output.accept(ModItems.INFUSED_GEMSTONE_HOE.get());
                        output.accept(ModItems.INFUSED_GEMSTONE_PAXEL.get());
                        output.accept(ModItems.INFUSED_GEMSTONE_PICKAXE.get());
                        output.accept(ModItems.INFUSED_GEMSTONE_SHOVEL.get());
                        output.accept(ModItems.INFUSED_GEMSTONE_SWORD.get());
                        output.accept(ModItems.INFUSED_GEMSTONE_HELMET.get());
                        output.accept(ModItems.INFUSED_GEMSTONE_CHESTPLATE.get());
                        output.accept(ModItems.INFUSED_GEMSTONE_LEGGINGS.get());
                        output.accept(ModItems.INFUSED_GEMSTONE_BOOTS.get());

                        //Tungsten-Carbide equipment
                        output.accept(ModItems.TUNGSTEN_CARBIDE_BOW.get());
                        output.accept(ModItems.TUNGSTEN_CARBIDE_CROSSBOW.get());
                        output.accept(ModItems.TUNGSTEN_CARBIDE_AXE.get());
                        output.accept(ModItems.TUNGSTEN_CARBIDE_BATTLEAXE.get());
                        output.accept(ModItems.TUNGSTEN_CARBIDE_HOE.get());
                        output.accept(ModItems.TUNGSTEN_CARBIDE_PAXEL.get());
                        output.accept(ModItems.TUNGSTEN_CARBIDE_PICKAXE.get());
                        output.accept(ModItems.TUNGSTEN_CARBIDE_SHOVEL.get());
                        output.accept(ModItems.TUNGSTEN_CARBIDE_SWORD.get());
                        output.accept(ModItems.TUNGSTEN_CARBIDE_HELMET.get());
                        output.accept(ModItems.TUNGSTEN_CARBIDE_CHESTPLATE.get());
                        output.accept(ModItems.TUNGSTEN_CARBIDE_LEGGINGS.get());
                        output.accept(ModItems.TUNGSTEN_CARBIDE_BOOTS.get());

                        //Trophy items
                        output.accept(ModItems.TROPHY_OBSIDIAN_DUST.get());
                        output.accept(ModItems.TROPHY_OMINOUS_LETTER.get());
                    }).build());



    /**
     * Register new item groups.
     * @param bus Main event bus
     */
    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
