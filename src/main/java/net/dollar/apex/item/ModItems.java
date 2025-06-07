package net.dollar.apex.item;

import net.dollar.apex.ModMain;
import net.dollar.apex.entity.ModEntities;
import net.dollar.apex.item.custom.ModCustomItem;
import net.dollar.apex.item.custom.ModGildedBronzeArmorItem;
import net.dollar.apex.item.custom.ModMoltenCoreItem;
import net.dollar.apex.item.custom.bow.ModCobaltSteelBowItem;
import net.dollar.apex.item.custom.bow.ModInfusedGemstoneBowItem;
import net.dollar.apex.item.custom.bow.ModTungstenCarbideBowItem;
import net.dollar.apex.item.custom.cobaltsteel.*;
import net.dollar.apex.item.custom.crossbow.ModCobaltSteelCrossbowItem;
import net.dollar.apex.item.custom.crossbow.ModInfusedGemstoneCrossbowItem;
import net.dollar.apex.item.custom.crossbow.ModTungstenCarbideCrossbowItem;
import net.dollar.apex.item.custom.infusedgemstone.*;
import net.dollar.apex.item.custom.tungstencarbide.*;
import net.dollar.apex.util.ModArmorMaterials;
import net.dollar.apex.util.ModSmithingUpgradeItemHelper;
import net.dollar.apex.util.ModTags;
import net.dollar.apex.util.ModToolMaterials;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    //Create a Deferred Register to hold Items which will all be registered under the "apex" namespace.
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModMain.MODID);



    //region Misc.
    public static final RegistryObject<Item> OBSIDIAN_GOLEM_SPAWN_EGG = registerItem("obsidian_golem_spawn_egg",
            () -> new SpawnEggItem(ModEntities.OBSIDIAN_GOLEM.get(),
                    new Item.Properties()
                            .setId(generateItemKey("obsidian_golem_spawn_egg"))));
    public static final RegistryObject<Item> MYSTERIOUS_SPECTER_SPAWN_EGG = registerItem("mysterious_specter_spawn_egg",
            () -> new SpawnEggItem(ModEntities.MYSTERIOUS_SPECTER.get(),
                    new Item.Properties()
                            .setId(generateItemKey("mysterious_specter_spawn_egg"))));
    public static final RegistryObject<Item> FERTILIZER = registerItem("fertilizer",
            () -> new BoneMealItem(new Item.Properties()
                    .setId(generateItemKey("fertilizer"))));
    //endregion

    //region Trophy items
    //Set stacksTo here instead of in the item class.
    public static final RegistryObject<Item> TROPHY_OBSIDIAN_DUST = registerItem("trophy_obsidian_dust",
            () -> new ModCustomItem(new Item.Properties()
                    .stacksTo(1)
                    .setId(generateItemKey("trophy_obsidian_dust")),
                    "tooltip.trophy_item", false));
    public static final RegistryObject<Item> TROPHY_OMINOUS_LETTER = registerItem("trophy_ominous_letter",
            () -> new ModCustomItem(new Item.Properties()
                    .stacksTo(1)
                    .setId(generateItemKey("trophy_ominous_letter")),
                    "tooltip.trophy_item", false));
    //endregion

    //region Raw Items, Gems, Compounds
    public static final RegistryObject<Item> RUBY = registerItem("ruby",
            () -> new Item(new Item.Properties()
                    .setId(generateItemKey("ruby"))));
    public static final RegistryObject<Item> SAPPHIRE = registerItem("sapphire",
            () -> new Item(new Item.Properties()
                    .setId(generateItemKey("sapphire"))));
    public static final RegistryObject<Item> COBALT_SHARD = registerItem("cobalt_shard",
            () -> new Item(new Item.Properties()
                    .setId(generateItemKey("cobalt_shard"))));
    public static final RegistryObject<Item> PHOSPHATE_POWDER = registerItem("phosphate_powder",
            () -> new Item(new Item.Properties()
                    .setId(generateItemKey("phosphate_powder"))));
    public static final RegistryObject<Item> RAW_TIN = registerItem("raw_tin",
            () -> new Item(new Item.Properties()
                    .setId(generateItemKey("raw_tin"))));
    public static final RegistryObject<Item> TIN_INGOT = registerItem("tin_ingot",
            () -> new Item(new Item.Properties()
                    .setId(generateItemKey("tin_ingot"))));
    public static final RegistryObject<Item> TIN_NUGGET = registerItem("tin_nugget",
            () -> new Item(new Item.Properties()
                    .setId(generateItemKey("tin_nugget"))));
    public static final RegistryObject<Item> BRONZE_COMPOUND = registerItem("bronze_compound",
            () -> new Item(new Item.Properties()
                    .setId(generateItemKey("bronze_compound"))));
    public static final RegistryObject<Item> BRONZE_INGOT = registerItem("bronze_ingot",
            () -> new Item(new Item.Properties()
                    .setId(generateItemKey("bronze_ingot"))));
    public static final RegistryObject<Item> BRONZE_NUGGET = registerItem("bronze_nugget",
            () -> new Item(new Item.Properties()
                    .setId(generateItemKey("bronze_nugget"))));
    public static final RegistryObject<Item> STEEL_COMPOUND = registerItem("steel_compound",
            () -> new Item(new Item.Properties()
                    .setId(generateItemKey("steel_compound"))));
    public static final RegistryObject<Item> STEEL_INGOT = registerItem("steel_ingot",
            () -> new Item(new Item.Properties()
                    .setId(generateItemKey("steel_ingot"))));
    public static final RegistryObject<Item> STEEL_NUGGET = registerItem("steel_nugget",
            () -> new Item(new Item.Properties()
                    .setId(generateItemKey("steel_nugget"))));
    public static final RegistryObject<Item> RAW_TUNGSTEN = registerItem("raw_tungsten",
            () -> new Item(new Item.Properties()
                    .setId(generateItemKey("raw_tungsten"))));
    public static final RegistryObject<Item> TUNGSTEN_INGOT = registerItem("tungsten_ingot",
            () -> new Item(new Item.Properties()
                    .setId(generateItemKey("tungsten_ingot"))));
    public static final RegistryObject<Item> TUNGSTEN_NUGGET = registerItem("tungsten_nugget",
            () -> new Item(new Item.Properties()
                    .setId(generateItemKey("tungsten_nugget"))));
    //endregion

    //Region End-game upgrade items
    public static final RegistryObject<Item> MOLTEN_CORE = registerItem("molten_core",
            () -> new ModMoltenCoreItem(new Item.Properties()
                    .fireResistant()
                    .setId(generateItemKey("molten_core"))));
    public static final RegistryObject<Item> HANDFUL_OF_STARDUST = registerItem("handful_of_stardust",
            () -> new ModCustomItem(new Item.Properties()
                    .fireResistant()
                    .setId(generateItemKey("handful_of_stardust")),
                    "tooltip.handful_of_stardust", false));
    public static final RegistryObject<Item> INFUSED_GEMSTONE = registerItem("infused_gemstone",
            () -> new ModCustomItem(new Item.Properties()
                    .fireResistant()
                    .setId(generateItemKey("infused_gemstone")),
                    "tooltip.infused_gemstone", true));
    public static final RegistryObject<Item> COBALT_STEEL_INGOT = registerItem("cobalt_steel_ingot",
            () -> new ModCustomItem(new Item.Properties()
                    .fireResistant()
                    .setId(generateItemKey("cobalt_steel_ingot")),
                    "tooltip.cobalt_steel_ingot", false));
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_INGOT = registerItem("tungsten_carbide_ingot",
            () -> new ModCustomItem(new Item.Properties()
                    .fireResistant()
                    .setId(generateItemKey("tungsten_carbide_ingot")),
                    "tooltip.tungsten_carbide_ingot", false));
    //endregion

    //region Upgrade Templates
    public static final RegistryObject<Item> BASIC_UPGRADE_TEMPLATE = registerItem("basic_upgrade_template",
            () -> new Item(new Item.Properties()
                    .setId(generateItemKey("basic_upgrade_template"))));
    public static final RegistryObject<Item> COBALT_UPGRADE_TEMPLATE = registerItem("cobalt_upgrade_smithing_template",
            ModSmithingUpgradeItemHelper::createCobaltUpgradeTemplate);
    public static final RegistryObject<Item> INFUSION_UPGRADE_TEMPLATE = registerItem("infusion_upgrade_smithing_template",
            ModSmithingUpgradeItemHelper::createInfusionUpgradeTemplate);
    public static final RegistryObject<Item> CARBIDE_UPGRADE_TEMPLATE = registerItem("carbide_upgrade_smithing_template",
            ModSmithingUpgradeItemHelper::createCarbideUpgradeTemplate);
    //endregion

    //region Bows/Crossbows 
    public static final RegistryObject<Item> COBALT_STEEL_BOW = registerItem("cobalt_steel_bow",
            () -> new ModCobaltSteelBowItem(
                    new Item.Properties()
                            .durability(1350)   // Base bow durability is 384
                            .enchantable(18)    // Matches Cobalt-Steel tool tier value
                            .fireResistant()
                            .setId(generateItemKey("cobalt_steel_bow"))));
    public static final RegistryObject<Item> COBALT_STEEL_CROSSBOW = registerItem("cobalt_steel_crossbow",
            () -> new ModCobaltSteelCrossbowItem(
                    new Item.Properties()
                            .durability(1650)   // Base crossbow durability is 465
                            .enchantable(18)
                            .fireResistant()
                            .setId(generateItemKey("cobalt_steel_crossbow"))));
    public static final RegistryObject<Item> INFUSED_GEMSTONE_BOW = registerItem("infused_gemstone_bow",
            () -> new ModInfusedGemstoneBowItem(
                    new Item.Properties()
                            .durability(1200)
                            .enchantable(25)    // Matches Infused Gemstone tool tier value
                            .fireResistant()
                            .setId(generateItemKey("infused_gemstone_bow"))));
    public static final RegistryObject<Item> INFUSED_GEMSTONE_CROSSBOW = registerItem("infused_gemstone_crossbow",
            () -> new ModInfusedGemstoneCrossbowItem(
                    new Item.Properties()
                            .durability(1500)
                            .enchantable(25)
                            .fireResistant()
                            .setId(generateItemKey("infused_gemstone_crossbow"))));
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_BOW = registerItem("tungsten_carbide_bow",
            () -> new ModTungstenCarbideBowItem(
                    new Item.Properties()
                            .durability(1500)
                            .enchantable(15)    // Matches Tungsten-Carbide tool tier value
                            .fireResistant()
                            .setId(generateItemKey("tungsten_carbide_bow"))));
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_CROSSBOW = registerItem("tungsten_carbide_crossbow",
            () -> new ModTungstenCarbideCrossbowItem(
                    new Item.Properties()
                            .durability(1800)
                            .enchantable(15)
                            .fireResistant()
                            .setId(generateItemKey("tungsten_carbide_crossbow"))));
    //endregion

    //region Axes
    public static final RegistryObject<Item> BRONZE_AXE = registerItem("bronze_axe",
            () -> new AxeItem(ModToolMaterials.BRONZE, 6.0f, -3.1f,
                    new Item.Properties()
                            .setId(generateItemKey("bronze_axe"))));
    public static final RegistryObject<Item> GILDED_BRONZE_AXE = registerItem("gilded_bronze_axe",
            () -> new AxeItem(ModToolMaterials.GILDED_BRONZE, 6.0f, -2.9f,
                    new Item.Properties()
                            .setId(generateItemKey("gilded_bronze_axe"))));
    public static final RegistryObject<Item> COBALT_STEEL_AXE = registerItem("cobalt_steel_axe",
            () -> new ModCobaltSteelAxeItem(ModToolMaterials.COBALT_STEEL, 5.0f, -2.7f,
                    new Item.Properties()
                            .fireResistant()
                            .setId(generateItemKey("cobalt_steel_axe"))));      //Very fast, Netherite = 5.0f, -3.0f
    public static final RegistryObject<Item> INFUSED_GEMSTONE_AXE = registerItem("infused_gemstone_axe",
            () -> new ModInfusedGemstoneAxeItem(ModToolMaterials.INFUSED_GEMSTONE, 5.0f, -2.9f,
                    new Item.Properties()
                            .fireResistant()
                            .setId(generateItemKey("infused_gemstone_axe"))));  //Faster, Netherite = 5.0f, -3.0f
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_AXE = registerItem("tungsten_carbide_axe",
            () -> new ModTungstenCarbideAxeItem(ModToolMaterials.TUNGSTEN_CARBIDE, 6.0f, -3.2f,
                    new Item.Properties()
                            .fireResistant()
                            .setId(generateItemKey("tungsten_carbide_axe"))));  //Slower, Netherite = 5.0f, -3.0f
    //endregion

    //region Battleaxes
    public static final RegistryObject<Item> DIAMOND_BATTLEAXE = registerItem("diamond_battleaxe",
            () -> new Item(new Item.Properties()
                    .sword(ToolMaterial.DIAMOND, 5.0f, -3.0f)
                    .setId(generateItemKey("diamond_battleaxe"))));
    public static final RegistryObject<Item> NETHERITE_BATTLEAXE = registerItem("netherite_battleaxe",
            () -> new Item(new Item.Properties()
                    .sword(ToolMaterial.NETHERITE, 5.0f, -3.0f)
                    .fireResistant()
                    .setId(generateItemKey("netherite_battleaxe"))));       //Equivalent to Axe stats
    public static final RegistryObject<Item> COBALT_STEEL_BATTLEAXE = registerItem("cobalt_steel_battleaxe",
            () -> new ModCobaltSteelToolItem(new Item.Properties()
                    .sword(ModToolMaterials.COBALT_STEEL, 5.0f, -2.7f)
                    .fireResistant()
                    .setId(generateItemKey("cobalt_steel_battleaxe"))));        //Faster, Netherite = 5.0f, -3.0f
    public static final RegistryObject<Item> INFUSED_GEMSTONE_BATTLEAXE = registerItem("infused_gemstone_battleaxe",
            () -> new ModInfusedGemstoneToolItem(new Item.Properties()
                    .sword(ModToolMaterials.INFUSED_GEMSTONE, 5.0f, -2.9f)
                    .fireResistant()
                    .setId(generateItemKey("infused_gemstone_battleaxe"))));    //Very fast, Netherite = 5.0f, -3.0f
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_BATTLEAXE = registerItem("tungsten_carbide_battleaxe",
            () -> new ModTungstenCarbideToolItem(new Item.Properties()
                    .sword(ModToolMaterials.TUNGSTEN_CARBIDE, 6.0f, -3.2f)
                    .fireResistant()
                    .setId(generateItemKey("tungsten_carbide_battleaxe"))));    //Slower, Netherite = 5.0f, -3.0f
    //endregion

    //region Hoes
    public static final RegistryObject<Item> BRONZE_HOE = registerItem("bronze_hoe",
            () -> new HoeItem(ModToolMaterials.BRONZE, -2.0f, -1.0f,
                    new Item.Properties()
                            .setId(generateItemKey("bronze_hoe"))));
    public static final RegistryObject<Item> GILDED_BRONZE_HOE = registerItem("gilded_bronze_hoe",
            () -> new HoeItem(ModToolMaterials.GILDED_BRONZE, -2.0f, -0.0f,
                    new Item.Properties()
                            .setId(generateItemKey("gilded_bronze_hoe"))));
    public static final RegistryObject<Item> COBALT_STEEL_HOE = registerItem("cobalt_steel_hoe",
            () -> new ModCobaltSteelHoeItem(ModToolMaterials.COBALT_STEEL, -2, 0.0f,
                    new Item.Properties()
                            .fireResistant()
                            .setId(generateItemKey("cobalt_steel_hoe"))));      //Very fast, Netherite = -4, 0.0f
    public static final RegistryObject<Item> INFUSED_GEMSTONE_HOE = registerItem("infused_gemstone_hoe",
            () -> new ModInfusedGemstoneHoeItem(ModToolMaterials.INFUSED_GEMSTONE, -2, -1.0f,
                    new Item.Properties()
                            .fireResistant()
                            .setId(generateItemKey("infused_gemstone_hoe"))));  //Faster, Netherite = -4, 0.0f
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_HOE = registerItem("tungsten_carbide_hoe",
            () -> new ModTungstenCarbideHoeItem(ModToolMaterials.TUNGSTEN_CARBIDE, -3, -2.0f,
                    new Item.Properties()
                            .fireResistant()
                            .setId(generateItemKey("tungsten_carbide_hoe"))));  //Slower, Netherite = -4, 0.0f
    //endregion

    //region Paxel
    public static final RegistryObject<Item> DIAMOND_PAXEL = registerItem("diamond_paxel",
            () -> new Item(new Item.Properties()
                    .tool(ToolMaterial.DIAMOND, ModTags.Blocks.MOD_PAXEL_MINEABLE,
                            2.0f, -2.9f, 0.0f)
                    .setId(generateItemKey("diamond_paxel"))));
    public static final RegistryObject<Item> NETHERITE_PAXEL = registerItem("netherite_paxel",
            () -> new Item(new Item.Properties()
                    .tool(ToolMaterial.NETHERITE, ModTags.Blocks.MOD_PAXEL_MINEABLE,
                            2.0f, -2.9f, 0.0f)
                    .fireResistant()
                    .setId(generateItemKey("netherite_paxel"))));           //Rough average between Axe, Pickaxe, and Shovel stats
    public static final RegistryObject<Item> COBALT_STEEL_PAXEL = registerItem("cobalt_steel_paxel",
            () -> new ModCobaltSteelToolItem(new Item.Properties()
                    .tool(ModToolMaterials.COBALT_STEEL, ModTags.Blocks.MOD_PAXEL_MINEABLE,
                            2.0f, -2.6f, 0.0f)
                    .fireResistant()
                    .setId(generateItemKey("cobalt_steel_paxel"))));        //Faster, Netherite = 2.0f, -2.9f
    public static final RegistryObject<Item> INFUSED_GEMSTONE_PAXEL = registerItem("infused_gemstone_paxel",
            () -> new ModInfusedGemstoneToolItem(new Item.Properties()
                    .tool(ModToolMaterials.INFUSED_GEMSTONE, ModTags.Blocks.MOD_PAXEL_MINEABLE,
                            2.0f, -2.8f, 0.0f)
                    .fireResistant()
                    .setId(generateItemKey("infused_gemstone_paxel"))));    //Very fast, Netherite = 2.0f, -2.9f
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_PAXEL = registerItem("tungsten_carbide_paxel",
            () -> new ModTungstenCarbideToolItem(new Item.Properties()
                    .tool(ModToolMaterials.TUNGSTEN_CARBIDE, ModTags.Blocks.MOD_PAXEL_MINEABLE,
                            2.5f, -3.1f, 0.0f)
                    .fireResistant()
                    .setId(generateItemKey("tungsten_carbide_paxel"))));    //Slower, Netherite = 2.0f, -2.9f
    //endregion

    //region Pickaxes
    public static final RegistryObject<Item> BRONZE_PICKAXE = registerItem("bronze_pickaxe",
            () -> new Item(new Item.Properties()
                    .pickaxe(ModToolMaterials.BRONZE, 1.0f, -2.8f)
                    .setId(generateItemKey("bronze_pickaxe"))));
    public static final RegistryObject<Item> GILDED_BRONZE_PICKAXE = registerItem("gilded_bronze_pickaxe",
            () -> new Item(new Item.Properties()
                    .pickaxe(ModToolMaterials.GILDED_BRONZE, 1.0f, -2.6f)
                    .setId(generateItemKey("gilded_bronze_pickaxe"))));
    public static final RegistryObject<Item> COBALT_STEEL_PICKAXE = registerItem("cobalt_steel_pickaxe",
            () -> new ModCobaltSteelToolItem(new Item.Properties()
                    .pickaxe(ModToolMaterials.COBALT_STEEL, 1.0f, -2.5f)
                    .fireResistant()
                    .setId(generateItemKey("cobalt_steel_pickaxe"))));      //Slower, Netherite = 1, -2.8f
    public static final RegistryObject<Item> INFUSED_GEMSTONE_PICKAXE = registerItem("infused_gemstone_pickaxe",
            () -> new ModInfusedGemstoneToolItem(new Item.Properties()
                    .pickaxe(ModToolMaterials.INFUSED_GEMSTONE, 1.0f, -2.7f)
                    .fireResistant()
                    .setId(generateItemKey("infused_gemstone_pickaxe"))));  //Faster, Netherite = 1, -2.8f
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_PICKAXE = registerItem("tungsten_carbide_pickaxe",
            () -> new ModTungstenCarbideToolItem(new Item.Properties()
                    .pickaxe(ModToolMaterials.TUNGSTEN_CARBIDE, 1.0f, -3.0f)
                    .fireResistant()
                    .setId(generateItemKey("tungsten_carbide_pickaxe"))));  //Very fast, Netherite = 1, -2.8f
    //endregion

    //region Shovel
    public static final RegistryObject<Item> BRONZE_SHOVEL = registerItem("bronze_shovel",
            () -> new ShovelItem(ModToolMaterials.BRONZE, 1.5f, -3.0f,
                    new Item.Properties()
                            .setId(generateItemKey("bronze_shovel"))));
    public static final RegistryObject<Item> GILDED_BRONZE_SHOVEL = registerItem("gilded_bronze_shovel",
            () -> new ShovelItem(ModToolMaterials.GILDED_BRONZE, 1.5f, -2.8f,
                    new Item.Properties()
                            .setId(generateItemKey("gilded_bronze_shovel"))));
    public static final RegistryObject<Item> COBALT_STEEL_SHOVEL = registerItem("cobalt_steel_shovel",
            () -> new ModCobaltSteelShovelItem(ModToolMaterials.COBALT_STEEL, 1.5f, -2.7f,
                    new Item.Properties()
                            .fireResistant()
                            .setId(generateItemKey("cobalt_steel_shovel"))));       //Very fast, Netherite = 1.5f, -3.0f
    public static final RegistryObject<Item> INFUSED_GEMSTONE_SHOVEL = registerItem("infused_gemstone_shovel",
            () -> new ModInfusedGemstoneShovelItem(ModToolMaterials.INFUSED_GEMSTONE, 2.0f, -2.9f,
                    new Item.Properties()
                            .fireResistant()
                            .setId(generateItemKey("infused_gemstone_shovel"))));   //Faster, Netherite = 1.5f, -3.0f
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_SHOVEL = registerItem("tungsten_carbide_shovel",
            () -> new ModTungstenCarbideShovelItem(ModToolMaterials.TUNGSTEN_CARBIDE, 2.0f, -3.2f,
                    new Item.Properties()
                            .fireResistant()
                            .setId(generateItemKey("tungsten_carbide_shovel"))));   //Slower, Netherite = 1.5f, -3.0f
    //endregion

    //region Sword
    public static final RegistryObject<Item> BRONZE_SWORD = registerItem("bronze_sword",
            () -> new Item(new Item.Properties()
                    .sword(ModToolMaterials.BRONZE, 3.0f, -2.4f)
                    .setId(generateItemKey("bronze_sword"))));
    public static final RegistryObject<Item> GILDED_BRONZE_SWORD = registerItem("gilded_bronze_sword",
            () -> new Item(new Item.Properties()
                    .sword(ModToolMaterials.GILDED_BRONZE, 3.0f, -2.2f)
                    .setId(generateItemKey("gilded_bronze_sword"))));
    public static final RegistryObject<Item> COBALT_STEEL_SWORD = registerItem("cobalt_steel_sword",
            () -> new ModCobaltSteelToolItem(new Item.Properties()
                    .sword(ModToolMaterials.COBALT_STEEL, 3.0f, -2.0f)
                    .fireResistant()
                    .setId(generateItemKey("cobalt_steel_sword"))));        //Very fast, Netherite = 3, -2.4f
    public static final RegistryObject<Item> INFUSED_GEMSTONE_SWORD = registerItem("infused_gemstone_sword",
            () -> new ModInfusedGemstoneToolItem(new Item.Properties()
                    .sword(ModToolMaterials.INFUSED_GEMSTONE, 3.0f, -2.3f)
                    .fireResistant()
                    .setId(generateItemKey("infused_gemstone_sword"))));    //Faster, Netherite = 3, -2.4f
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_SWORD = registerItem("tungsten_carbide_sword",
            () -> new ModTungstenCarbideToolItem(new Item.Properties()
                    .sword(ModToolMaterials.TUNGSTEN_CARBIDE, 3.0f, -2.6f)
                    .fireResistant()
                    .setId(generateItemKey("tungsten_carbide_sword"))));    //Slower, Netherite = 3, -2.4f
    //endregion

    //region Bronze armor
    public static final RegistryObject<Item> BRONZE_HELMET = registerItem("bronze_helmet",
            () -> new Item(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.BRONZE, ArmorType.HELMET)
                    .setId(generateItemKey("bronze_helmet"))));     // Durability now contained directly in ArmorMaterial.
    public static final RegistryObject<Item> BRONZE_CHESTPLATE = registerItem("bronze_chestplate",
            () -> new Item(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.BRONZE, ArmorType.CHESTPLATE)
                    .setId(generateItemKey("bronze_chestplate"))));
    public static final RegistryObject<Item> BRONZE_LEGGINGS = registerItem("bronze_leggings",
            () -> new Item(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.BRONZE, ArmorType.LEGGINGS)
                    .setId(generateItemKey("bronze_leggings"))));
    public static final RegistryObject<Item> BRONZE_BOOTS = registerItem("bronze_boots",
            () -> new Item(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.BRONZE, ArmorType.BOOTS)
                    .setId(generateItemKey("bronze_boots"))));
    //endregion

    //region Gilded Bronze armor
    public static final RegistryObject<Item> GILDED_BRONZE_HELMET = registerItem("gilded_bronze_helmet",
            () -> new ModGildedBronzeArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.GILDED_BRONZE, ArmorType.HELMET)
                    .setId(generateItemKey("gilded_bronze_helmet"))));  // Durability now contained directly in ArmorMaterial.
    public static final RegistryObject<Item> GILDED_BRONZE_CHESTPLATE = registerItem("gilded_bronze_chestplate",
            () -> new ModGildedBronzeArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.GILDED_BRONZE, ArmorType.CHESTPLATE)
                    .setId(generateItemKey("gilded_bronze_chestplate"))));
    public static final RegistryObject<Item> GILDED_BRONZE_LEGGINGS = registerItem("gilded_bronze_leggings",
            () -> new ModGildedBronzeArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.GILDED_BRONZE, ArmorType.LEGGINGS)
                    .setId(generateItemKey("gilded_bronze_leggings"))));
    public static final RegistryObject<Item> GILDED_BRONZE_BOOTS = registerItem("gilded_bronze_boots",
            () -> new ModGildedBronzeArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.GILDED_BRONZE, ArmorType.BOOTS)
                    .setId(generateItemKey("gilded_bronze_boots"))));
    //endregion

    //region Cobalt-Steel armor
    public static final RegistryObject<Item> COBALT_STEEL_HELMET = registerItem("cobalt_steel_helmet",
            () -> new ModCobaltSteelArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.COBALT_STEEL, ArmorType.HELMET)
                    .fireResistant()
                    .setId(generateItemKey("cobalt_steel_helmet"))));
    public static final RegistryObject<Item> COBALT_STEEL_CHESTPLATE = registerItem("cobalt_steel_chestplate",
            () -> new ModCobaltSteelArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.COBALT_STEEL, ArmorType.CHESTPLATE)
                    .fireResistant()
                    .setId(generateItemKey("cobalt_steel_chestplate"))));
    public static final RegistryObject<Item> COBALT_STEEL_LEGGINGS = registerItem("cobalt_steel_leggings",
            () -> new ModCobaltSteelArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.COBALT_STEEL, ArmorType.LEGGINGS)
                    .fireResistant()
                    .setId(generateItemKey("cobalt_steel_leggings"))));
    public static final RegistryObject<Item> COBALT_STEEL_BOOTS = registerItem("cobalt_steel_boots",
            () -> new ModCobaltSteelArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.COBALT_STEEL, ArmorType.BOOTS)
                    .fireResistant()
                    .setId(generateItemKey("cobalt_steel_boots"))));
    //endregion

    //region Infused Gemstone armor
    public static final RegistryObject<Item> INFUSED_GEMSTONE_HELMET = registerItem("infused_gemstone_helmet",
            () -> new ModInfusedGemstoneArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.INFUSED_GEMSTONE, ArmorType.HELMET)
                    .fireResistant()
                    .setId(generateItemKey("infused_gemstone_helmet"))));
    public static final RegistryObject<Item> INFUSED_GEMSTONE_CHESTPLATE = registerItem("infused_gemstone_chestplate",
            () -> new ModInfusedGemstoneArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.INFUSED_GEMSTONE, ArmorType.CHESTPLATE)
                    .fireResistant()
                    .setId(generateItemKey("infused_gemstone_chestplate"))));
    public static final RegistryObject<Item> INFUSED_GEMSTONE_LEGGINGS = registerItem("infused_gemstone_leggings",
            () -> new ModInfusedGemstoneArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.INFUSED_GEMSTONE, ArmorType.LEGGINGS)
                    .fireResistant()
                    .setId(generateItemKey("infused_gemstone_leggings"))));
    public static final RegistryObject<Item> INFUSED_GEMSTONE_BOOTS = registerItem("infused_gemstone_boots",
            () -> new ModInfusedGemstoneArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.INFUSED_GEMSTONE, ArmorType.BOOTS)
                    .fireResistant()
                    .setId(generateItemKey("infused_gemstone_boots"))));
    //endregion

    //region Infused Gemstone armor
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_HELMET = registerItem("tungsten_carbide_helmet",
            () -> new ModTungstenCarbideArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.TUNGSTEN_CARBIDE, ArmorType.HELMET)
                    .fireResistant()
                    .setId(generateItemKey("tungsten_carbide_helmet"))));
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_CHESTPLATE = registerItem("tungsten_carbide_chestplate",
            () -> new ModTungstenCarbideArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.TUNGSTEN_CARBIDE, ArmorType.CHESTPLATE)
                    .fireResistant()
                    .setId(generateItemKey("tungsten_carbide_chestplate"))));
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_LEGGINGS = registerItem("tungsten_carbide_leggings",
            () -> new ModTungstenCarbideArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.TUNGSTEN_CARBIDE, ArmorType.LEGGINGS)
                    .fireResistant()
                    .setId(generateItemKey("tungsten_carbide_leggings"))));
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_BOOTS = registerItem("tungsten_carbide_boots",
            () -> new ModTungstenCarbideArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.TUNGSTEN_CARBIDE, ArmorType.BOOTS)
                    .fireResistant()
                    .setId(generateItemKey("tungsten_carbide_boots"))));
    //endregion



    /**
     * Generates a ResourceKey for the passed-in item, used for setting item ID on registry.
     * @param name Name of Item to be registered
     * @return The newly generated ResourceKey<Item>.
     */
    private static ResourceKey<Item> generateItemKey(String name) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, name));
    }

    /**
     * Registers a single item
     * @param name String identifier for the name
     * @param item Actual Item object to register
     * @return The registered Minecraft Item
     */
    private static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> item) {
        return ITEMS.register(name, item);
    }
    
    /**
     * Register () -> new Items.
     * @param bus Main event bus
     */
    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
