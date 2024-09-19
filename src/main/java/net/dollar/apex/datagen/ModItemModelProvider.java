package net.dollar.apex.datagen;

import net.dollar.apex.ModMain;
import net.dollar.apex.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

/**
 * Used to auto-generate item model JSON files in 'src/generated' subdirectory. In-code definitions of recipes
 *  to be generated AND their corresponding helper methods are contained within this class.
 */
public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModMain.MODID, existingFileHelper);
    }



    /**
     * Build item models, auto-generating JSON files in 'src/generated' subdirectory. Developer defines
     *  models to generate within this method.
     */
    @Override
    protected void registerModels() {
        //GENERATED
        simpleItem(ModItems.FERTILIZER);

        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.COBALT_SHARD);
        simpleItem(ModItems.PHOSPHATE_POWDER);
        simpleItem(ModItems.RAW_TIN);
        simpleItem(ModItems.TIN_INGOT);
        simpleItem(ModItems.TIN_NUGGET);
        simpleItem(ModItems.RAW_TUNGSTEN);
        simpleItem(ModItems.TUNGSTEN_INGOT);
        simpleItem(ModItems.TUNGSTEN_NUGGET);
        simpleItem(ModItems.BRONZE_COMPOUND);
        simpleItem(ModItems.BRONZE_INGOT);
        simpleItem(ModItems.BRONZE_NUGGET);
        simpleItem(ModItems.STEEL_COMPOUND);
        simpleItem(ModItems.STEEL_INGOT);
        simpleItem(ModItems.STEEL_NUGGET);

        simpleItem(ModItems.HANDFUL_OF_STARDUST);
        simpleItem(ModItems.MOLTEN_CORE);
        simpleItem(ModItems.COBALT_STEEL_INGOT);
        simpleItem(ModItems.INFUSED_GEMSTONE);
        simpleItem(ModItems.TUNGSTEN_CARBIDE_INGOT);

        simpleItem(ModItems.BASIC_UPGRADE_TEMPLATE);
        simpleItem(ModItems.CARBIDE_UPGRADE_TEMPLATE);
        simpleItem(ModItems.COBALT_UPGRADE_TEMPLATE);
        simpleItem(ModItems.INFUSION_UPGRADE_TEMPLATE);

        simpleItem(ModItems.TROPHY_OBSIDIAN_DUST);
        simpleItem(ModItems.TROPHY_OMINOUS_LETTER);



        //HANDHELD
        handheldItem(ModItems.BRONZE_AXE);
        handheldItem(ModItems.BRONZE_HOE);
        handheldItem(ModItems.BRONZE_PICKAXE);
        handheldItem(ModItems.BRONZE_SHOVEL);
        handheldItem(ModItems.BRONZE_SWORD);

        handheldItem(ModItems.GILDED_BRONZE_AXE);
        handheldItem(ModItems.GILDED_BRONZE_HOE);
        handheldItem(ModItems.GILDED_BRONZE_PICKAXE);
        handheldItem(ModItems.GILDED_BRONZE_SHOVEL);
        handheldItem(ModItems.GILDED_BRONZE_SWORD);

        handheldItem(ModItems.DIAMOND_BATTLEAXE);
        handheldItem(ModItems.DIAMOND_PAXEL);

        handheldItem(ModItems.NETHERITE_BATTLEAXE);
        handheldItem(ModItems.NETHERITE_PAXEL);

        handheldItem(ModItems.COBALT_STEEL_AXE);
        handheldItem(ModItems.COBALT_STEEL_BATTLEAXE);
        handheldItem(ModItems.COBALT_STEEL_HOE);
        handheldItem(ModItems.COBALT_STEEL_PAXEL);
        handheldItem(ModItems.COBALT_STEEL_PICKAXE);
        handheldItem(ModItems.COBALT_STEEL_SHOVEL);
        handheldItem(ModItems.COBALT_STEEL_SWORD);

        handheldItem(ModItems.INFUSED_GEMSTONE_AXE);
        handheldItem(ModItems.INFUSED_GEMSTONE_BATTLEAXE);
        handheldItem(ModItems.INFUSED_GEMSTONE_HOE);
        handheldItem(ModItems.INFUSED_GEMSTONE_PAXEL);
        handheldItem(ModItems.INFUSED_GEMSTONE_PICKAXE);
        handheldItem(ModItems.INFUSED_GEMSTONE_SHOVEL);
        handheldItem(ModItems.INFUSED_GEMSTONE_SWORD);

        handheldItem(ModItems.TUNGSTEN_CARBIDE_AXE);
        handheldItem(ModItems.TUNGSTEN_CARBIDE_BATTLEAXE);
        handheldItem(ModItems.TUNGSTEN_CARBIDE_HOE);
        handheldItem(ModItems.TUNGSTEN_CARBIDE_PAXEL);
        handheldItem(ModItems.TUNGSTEN_CARBIDE_PICKAXE);
        handheldItem(ModItems.TUNGSTEN_CARBIDE_SHOVEL);
        handheldItem(ModItems.TUNGSTEN_CARBIDE_SWORD);
    }



    /**
     * Builds a simple item model for an Item.
     * @param item Item the model is for
     * @return Generated ItemModelBuilder (unused)
     */
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(ModMain.MODID, "item/" + item.getId().getPath()));
    }

    /**
     * Builds a handheld item model for an Item.
     * @param item Item the model is for
     * @return Generated ItemModelBuilder (unused)
     */
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/handheld"))
                .texture("layer0", new ResourceLocation(ModMain.MODID, "item/" + item.getId().getPath()));
    }
}
