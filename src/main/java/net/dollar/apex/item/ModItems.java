package net.dollar.apex.item;

import net.dollar.apex.ModMain;
import net.dollar.apex.entity.ModEntities;
import net.dollar.apex.item.custom.*;
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
import net.dollar.apex.util.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
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
            () -> new ForgeSpawnEggItem(ModEntities.OBSIDIAN_GOLEM, 0xFF12031E, 0xFFED4D0E,
                    new Item.Properties()));
    public static final RegistryObject<Item> MYSTERIOUS_SPECTER_SPAWN_EGG = registerItem("mysterious_specter_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MYSTERIOUS_SPECTER, 0xFFE3E3E3, 0xFFB8B8B8,
                    new Item.Properties()));
    public static final RegistryObject<Item> FERTILIZER = registerItem("fertilizer",
            () -> new BoneMealItem((new Item.Properties())));
    //endregion

    //region Trophy items
    //Set stacksTo here instead of in the item class.
    public static final RegistryObject<Item> TROPHY_OBSIDIAN_DUST = registerItem("trophy_obsidian_dust",
            () -> new ModCustomItem(new Item.Properties().stacksTo(1),
                    "tooltip.trophy_item", false));
    public static final RegistryObject<Item> TROPHY_OMINOUS_LETTER = registerItem("trophy_ominous_letter",
            () -> new ModCustomItem(new Item.Properties().stacksTo(1),
                    "tooltip.trophy_item", false));
    //endregion

    //region Raw Items, Gems, Compounds
    public static final RegistryObject<Item> RUBY = registerItem("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE = registerItem("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COBALT_SHARD = registerItem("cobalt_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PHOSPHATE_POWDER = registerItem("phosphate_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TIN = registerItem("raw_tin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIN_INGOT = registerItem("tin_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIN_NUGGET = registerItem("tin_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRONZE_COMPOUND = registerItem("bronze_compound",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRONZE_INGOT = registerItem("bronze_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRONZE_NUGGET = registerItem("bronze_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_COMPOUND = registerItem("steel_compound",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_INGOT = registerItem("steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_NUGGET = registerItem("steel_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TUNGSTEN = registerItem("raw_tungsten",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_INGOT = registerItem("tungsten_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_NUGGET = registerItem("tungsten_nugget",
            () -> new Item(new Item.Properties()));
    //endregion

    //Region End-game upgrade items
    public static final RegistryObject<Item> MOLTEN_CORE = registerItem("molten_core",
            () -> new ModMoltenCoreItem(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HANDFUL_OF_STARDUST = registerItem("handful_of_stardust",
            () -> new ModCustomItem(new Item.Properties(),
                    "tooltip.handful_of_stardust", false));
    public static final RegistryObject<Item> INFUSED_GEMSTONE = registerItem("infused_gemstone",
            () -> new ModCustomItem(new Item.Properties().fireResistant(),
                    "tooltip.infused_gemstone", true));
    public static final RegistryObject<Item> COBALT_STEEL_INGOT = registerItem("cobalt_steel_ingot",
            () -> new ModCustomItem(new Item.Properties().fireResistant(),
                    "tooltip.cobalt_steel_ingot", false));
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_INGOT = registerItem("tungsten_carbide_ingot",
            () -> new ModCustomItem(new Item.Properties().fireResistant(),
                    "tooltip.tungsten_carbide_ingot", false));
    //endregion

    //region Upgrade Templates
    public static final RegistryObject<Item> BASIC_UPGRADE_TEMPLATE = registerItem("basic_upgrade_template",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COBALT_UPGRADE_TEMPLATE = registerItem("cobalt_upgrade_smithing_template",
            ModSmithingUpgradeItemHelper::createCobaltUpgradeTemplate);
    public static final RegistryObject<Item> INFUSION_UPGRADE_TEMPLATE = registerItem("infusion_upgrade_smithing_template",
            ModSmithingUpgradeItemHelper::createInfusionUpgradeTemplate);
    public static final RegistryObject<Item> CARBIDE_UPGRADE_TEMPLATE = registerItem("carbide_upgrade_smithing_template",
            ModSmithingUpgradeItemHelper::createCarbideUpgradeTemplate);
    //endregion

    //region Bows/Crossbows 
    public static final RegistryObject<Item> COBALT_STEEL_BOW = registerItem("cobalt_steel_bow",
            () -> new ModCobaltSteelBowItem(new Item.Properties().durability(1200).fireResistant()));
    public static final RegistryObject<Item> COBALT_STEEL_CROSSBOW = registerItem("cobalt_steel_crossbow",
            () -> new ModCobaltSteelCrossbowItem(new Item.Properties().durability(1500).fireResistant()));
    public static final RegistryObject<Item> INFUSED_GEMSTONE_BOW = registerItem("infused_gemstone_bow",
            () -> new ModInfusedGemstoneBowItem(new Item.Properties().durability(1200).fireResistant()));   //Base durability (durability) is 384
    public static final RegistryObject<Item> INFUSED_GEMSTONE_CROSSBOW = registerItem("infused_gemstone_crossbow",
            () -> new ModInfusedGemstoneCrossbowItem(new Item.Properties().durability(1500).fireResistant()));  //Base durability (durability) is 465
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_BOW = registerItem("tungsten_carbide_bow",
            () -> new ModTungstenCarbideBowItem(new Item.Properties().durability(1200).fireResistant()));
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_CROSSBOW = registerItem("tungsten_carbide_crossbow",
            () -> new ModTungstenCarbideCrossbowItem(new Item.Properties().durability(1500).fireResistant()));
    //endregion

    //region Axes
    public static final RegistryObject<Item> BRONZE_AXE = registerItem("bronze_axe",
            () -> new AxeItem(ModToolTiers.BRONZE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.BRONZE, 6.0f, -3.1f))));
    public static final RegistryObject<Item> GILDED_BRONZE_AXE = registerItem("gilded_bronze_axe",
            () -> new AxeItem(ModToolTiers.GILDED_BRONZE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.GILDED_BRONZE, 6.0f, -2.9f))));
    public static final RegistryObject<Item> COBALT_STEEL_AXE = registerItem("cobalt_steel_axe",
            () -> new ModCobaltSteelAxeItem(ModToolTiers.COBALT_STEEL,
                    5.0f, -2.7f));  //Very fast, Netherite = 5.0f, -3.0f
    public static final RegistryObject<Item> INFUSED_GEMSTONE_AXE = registerItem("infused_gemstone_axe",
            () -> new ModInfusedGemstoneAxeItem(ModToolTiers.INFUSED_GEMSTONE,
                    5.0f, -2.9f));  //Faster, Netherite = 5.0f, -3.0f
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_AXE = registerItem("tungsten_carbide_axe",
            () -> new ModTungstenCarbideAxeItem(ModToolTiers.TUNGSTEN_CARBIDE,
                    6.0f, -3.2f));  //Slower, Netherite = 5.0f, -3.0f
    //endregion

    //region Battleaxes
    public static final RegistryObject<Item> DIAMOND_BATTLEAXE = registerItem("diamond_battleaxe",
            () -> new ModBattleaxeItem(Tiers.DIAMOND, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.DIAMOND, 5, -3.0f))));
    public static final RegistryObject<Item> NETHERITE_BATTLEAXE = registerItem("netherite_battleaxe",
            () -> new ModBattleaxeItem(Tiers.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.NETHERITE, 5, -3.0f))
                    .fireResistant()));     //Equivalent to Axe stats
    public static final RegistryObject<Item> COBALT_STEEL_BATTLEAXE = registerItem("cobalt_steel_battleaxe",
            () -> new ModCobaltSteelBattleaxeItem(ModToolTiers.COBALT_STEEL,
                    5, -2.7f));     //Faster, Netherite = 5.0f, -3.0f
    public static final RegistryObject<Item> INFUSED_GEMSTONE_BATTLEAXE = registerItem("infused_gemstone_battleaxe",
            () -> new ModInfusedGemstoneBattleaxeItem(ModToolTiers.INFUSED_GEMSTONE,
                    5, -2.9f));     //Very fast, Netherite = 5.0f, -3.0f
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_BATTLEAXE = registerItem("tungsten_carbide_battleaxe",
            () -> new ModTungstenCarbideBattleaxeItem(ModToolTiers.TUNGSTEN_CARBIDE,
                    6, -3.2f));     //Slower, Netherite = 5.0f, -3.0f
    //endregion

    //region Hoes
    public static final RegistryObject<Item> BRONZE_HOE = registerItem("bronze_hoe",
            () -> new HoeItem(ModToolTiers.BRONZE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.BRONZE, -2.0f, -1.0f))));
    public static final RegistryObject<Item> GILDED_BRONZE_HOE = registerItem("gilded_bronze_hoe",
            () -> new HoeItem(ModToolTiers.GILDED_BRONZE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.GILDED_BRONZE, -2.0f, -0.0f))));
    public static final RegistryObject<Item> COBALT_STEEL_HOE = registerItem("cobalt_steel_hoe",
            () -> new ModCobaltSteelHoeItem(ModToolTiers.COBALT_STEEL,
                    -2, 0.0f));     //Very fast, Netherite = -4, 0.0f
    public static final RegistryObject<Item> INFUSED_GEMSTONE_HOE = registerItem("infused_gemstone_hoe",
            () -> new ModInfusedGemstoneHoeItem(ModToolTiers.INFUSED_GEMSTONE,
                    -2, -1.0f));    //Faster, Netherite = -4, 0.0f
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_HOE = registerItem("tungsten_carbide_hoe",
            () -> new ModTungstenCarbideHoeItem(ModToolTiers.TUNGSTEN_CARBIDE,
                    -3, -2.0f));    //Slower, Netherite = -4, 0.0f
    //endregion

    //region Paxel
    public static final RegistryObject<Item> DIAMOND_PAXEL = registerItem("diamond_paxel",
            () -> new ModPaxelItem(Tiers.DIAMOND, new Item.Properties()
                    .attributes(ModPaxelItem.createAttributes(Tiers.DIAMOND, 2.0f, -2.9f))));
    public static final RegistryObject<Item> NETHERITE_PAXEL = registerItem("netherite_paxel",
            () -> new ModPaxelItem(Tiers.NETHERITE, new Item.Properties()
                    .attributes(ModPaxelItem.createAttributes(Tiers.NETHERITE, 2.0f, -2.9f))
                    .fireResistant())); //Rough average between Axe, Pickaxe, and Shovel stats
    public static final RegistryObject<Item> COBALT_STEEL_PAXEL = registerItem("cobalt_steel_paxel",
            () -> new ModCobaltSteelPaxelItem(ModToolTiers.COBALT_STEEL,
                    2.0f, -2.6f));  //Faster, Netherite = 2.0f, -2.9f
    public static final RegistryObject<Item> INFUSED_GEMSTONE_PAXEL = registerItem("infused_gemstone_paxel",
            () -> new ModInfusedGemstonePaxelItem(ModToolTiers.INFUSED_GEMSTONE,
                    2.0f, -2.8f));  //Very fast, Netherite = 2.0f, -2.9f
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_PAXEL = registerItem("tungsten_carbide_paxel",
            () -> new ModTungstenCarbidePaxelItem(ModToolTiers.TUNGSTEN_CARBIDE,
                    2.5f, -3.1f));  //Slower, Netherite = 2.0f, -2.9f
    //endregion

    //region Pickaxes
    public static final RegistryObject<Item> BRONZE_PICKAXE = registerItem("bronze_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BRONZE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.BRONZE, 1.0f, -2.8f))));
    public static final RegistryObject<Item> GILDED_BRONZE_PICKAXE = registerItem("gilded_bronze_pickaxe",
            () -> new PickaxeItem(ModToolTiers.GILDED_BRONZE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.GILDED_BRONZE, 1.0f, -2.6f))));
    public static final RegistryObject<Item> INFUSED_GEMSTONE_PICKAXE = registerItem("infused_gemstone_pickaxe",
            () -> new ModInfusedGemstonePickaxeItem(ModToolTiers.INFUSED_GEMSTONE,
                    1, -2.7f));     //Faster, Netherite = 1, -2.8f
    public static final RegistryObject<Item> COBALT_STEEL_PICKAXE = registerItem("cobalt_steel_pickaxe",
            () -> new ModCobaltSteelPickaxeItem(ModToolTiers.COBALT_STEEL,
                    1, -2.5f));     //Slower, Netherite = 1, -2.8f
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_PICKAXE = registerItem("tungsten_carbide_pickaxe",
            () -> new ModTungstenCarbidePickaxeItem(ModToolTiers.TUNGSTEN_CARBIDE,
                    1, -3.0f));     //Very fast, Netherite = 1, -2.8f
    //endregion

    //region Shovel
    public static final RegistryObject<Item> BRONZE_SHOVEL = registerItem("bronze_shovel",
            () -> new ShovelItem(ModToolTiers.BRONZE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.BRONZE, 1.5f, -3.0f))));
    public static final RegistryObject<Item> GILDED_BRONZE_SHOVEL = registerItem("gilded_bronze_shovel",
            () -> new ShovelItem(ModToolTiers.GILDED_BRONZE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.GILDED_BRONZE, 1.5f, -2.8f))));
    public static final RegistryObject<Item> INFUSED_GEMSTONE_SHOVEL = registerItem("infused_gemstone_shovel",
            () -> new ModInfusedGemstoneShovelItem(ModToolTiers.INFUSED_GEMSTONE,
                    2.0f, -2.9f));  //Faster, Netherite = 1.5f, -3.0f
    public static final RegistryObject<Item> COBALT_STEEL_SHOVEL = registerItem("cobalt_steel_shovel",
            () -> new ModCobaltSteelShovelItem(ModToolTiers.COBALT_STEEL,
                    1.5f, -2.7f));  //Very fast, Netherite = 1.5f, -3.0f
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_SHOVEL = registerItem("tungsten_carbide_shovel",
            () -> new ModTungstenCarbideShovelItem(ModToolTiers.TUNGSTEN_CARBIDE,
                    2.0f, -3.2f));  //Slower, Netherite = 1.5f, -3.0f
    //endregion

    //region Sword
    public static final RegistryObject<Item> BRONZE_SWORD = registerItem("bronze_sword",
            () -> new SwordItem(ModToolTiers.BRONZE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.BRONZE, 3, -2.4f))));
    public static final RegistryObject<Item> GILDED_BRONZE_SWORD = registerItem("gilded_bronze_sword",
            () -> new SwordItem(ModToolTiers.GILDED_BRONZE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.GILDED_BRONZE, 3, -2.2f))));
    public static final RegistryObject<Item> INFUSED_GEMSTONE_SWORD = registerItem("infused_gemstone_sword",
            () -> new ModInfusedGemstoneSwordItem(ModToolTiers.INFUSED_GEMSTONE,
                    3, -2.3f));     //Faster, Netherite = 3, -2.4f
    public static final RegistryObject<Item> COBALT_STEEL_SWORD = registerItem("cobalt_steel_sword",
            () -> new ModCobaltSteelSwordItem(ModToolTiers.COBALT_STEEL,
                    3, -2.0f));     //Very fast, Netherite = 3, -2.4f
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_SWORD = registerItem("tungsten_carbide_sword",
            () -> new ModTungstenCarbideSwordItem(ModToolTiers.TUNGSTEN_CARBIDE,
                    3, -2.6f));     //Slower, Netherite = 3, -2.4f
    //endregion

    //region Bronze armor
    public static final RegistryObject<Item> BRONZE_HELMET = registerItem("bronze_helmet",
            () -> new ModBronzeArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.HELMET, new Item.Properties()
                    .durability(ArmorItem.Type.HELMET.getDurability(15))));
    public static final RegistryObject<Item> BRONZE_CHESTPLATE = registerItem("bronze_chestplate",
            () -> new ModBronzeArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .durability(ArmorItem.Type.CHESTPLATE.getDurability(15))));
    public static final RegistryObject<Item> BRONZE_LEGGINGS = registerItem("bronze_leggings",
            () -> new ModBronzeArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .durability(ArmorItem.Type.LEGGINGS.getDurability(15))));
    public static final RegistryObject<Item> BRONZE_BOOTS = registerItem("bronze_boots",
            () -> new ModBronzeArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.BOOTS, new Item.Properties()
                    .durability(ArmorItem.Type.BOOTS.getDurability(15))));
    //endregion

    //region Gilded Bronze armor
    public static final RegistryObject<Item> GILDED_BRONZE_HELMET = registerItem("gilded_bronze_helmet",
            () -> new ModGildedBronzeArmorItem(ModArmorMaterials.GILDED_BRONZE, ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .durability(ArmorItem.Type.HELMET.getDurability(23))));
    public static final RegistryObject<Item> GILDED_BRONZE_CHESTPLATE = registerItem("gilded_bronze_chestplate",
            () -> new ModGildedBronzeArmorItem(ModArmorMaterials.GILDED_BRONZE, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .durability(ArmorItem.Type.CHESTPLATE.getDurability(23))));
    public static final RegistryObject<Item> GILDED_BRONZE_LEGGINGS = registerItem("gilded_bronze_leggings",
            () -> new ModGildedBronzeArmorItem(ModArmorMaterials.GILDED_BRONZE, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()
                            .durability(ArmorItem.Type.LEGGINGS.getDurability(23))));
    public static final RegistryObject<Item> GILDED_BRONZE_BOOTS = registerItem("gilded_bronze_boots",
            () -> new ModGildedBronzeArmorItem(ModArmorMaterials.GILDED_BRONZE, ArmorItem.Type.BOOTS,
                    new Item.Properties()
                            .durability(ArmorItem.Type.BOOTS.getDurability(23))));
    //endregion

    //region Cobalt-Steel armor
    public static final RegistryObject<Item> COBALT_STEEL_HELMET = registerItem("cobalt_steel_helmet",
            () -> new ModCobaltSteelArmorItem(ModArmorMaterials.COBALT_STEEL, ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .fireResistant()
                            .durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final RegistryObject<Item> COBALT_STEEL_CHESTPLATE = registerItem("cobalt_steel_chestplate",
            () -> new ModCobaltSteelArmorItem(ModArmorMaterials.COBALT_STEEL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .fireResistant()
                            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final RegistryObject<Item> COBALT_STEEL_LEGGINGS = registerItem("cobalt_steel_leggings",
            () -> new ModCobaltSteelArmorItem(ModArmorMaterials.COBALT_STEEL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()
                            .fireResistant()
                            .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final RegistryObject<Item> COBALT_STEEL_BOOTS = registerItem("cobalt_steel_boots",
            () -> new ModCobaltSteelArmorItem(ModArmorMaterials.COBALT_STEEL, ArmorItem.Type.BOOTS,
                    new Item.Properties()
                            .fireResistant()
                            .durability(ArmorItem.Type.BOOTS.getDurability(37))));
    //endregion

    //region Infused Gemstone armor
    public static final RegistryObject<Item> INFUSED_GEMSTONE_HELMET = registerItem("infused_gemstone_helmet",
            () -> new ModInfusedGemstoneArmorItem(ModArmorMaterials.INFUSED_GEMSTONE, ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .fireResistant()
                            .durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final RegistryObject<Item> INFUSED_GEMSTONE_CHESTPLATE = registerItem("infused_gemstone_chestplate",
            () -> new ModInfusedGemstoneArmorItem(ModArmorMaterials.INFUSED_GEMSTONE, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .fireResistant()
                            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final RegistryObject<Item> INFUSED_GEMSTONE_LEGGINGS = registerItem("infused_gemstone_leggings",
            () -> new ModInfusedGemstoneArmorItem(ModArmorMaterials.INFUSED_GEMSTONE, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()
                            .fireResistant()
                            .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final RegistryObject<Item> INFUSED_GEMSTONE_BOOTS = registerItem("infused_gemstone_boots",
            () -> new ModInfusedGemstoneArmorItem(ModArmorMaterials.INFUSED_GEMSTONE, ArmorItem.Type.BOOTS,
                    new Item.Properties()
                            .fireResistant()
                            .durability(ArmorItem.Type.BOOTS.getDurability(37))));
    //endregion

    //region Infused Gemstone armor
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_HELMET = registerItem("tungsten_carbide_helmet",
            () -> new ModTungstenCarbideArmorItem(ModArmorMaterials.TUNGSTEN_CARBIDE, ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .fireResistant()
                            .durability(ArmorItem.Type.HELMET.getDurability(41))));
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_CHESTPLATE = registerItem("tungsten_carbide_chestplate",
            () -> new ModTungstenCarbideArmorItem(ModArmorMaterials.TUNGSTEN_CARBIDE, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .fireResistant()
                            .durability(ArmorItem.Type.CHESTPLATE.getDurability(41))));
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_LEGGINGS = registerItem("tungsten_carbide_leggings",
            () -> new ModTungstenCarbideArmorItem(ModArmorMaterials.TUNGSTEN_CARBIDE, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()
                            .fireResistant()
                            .durability(ArmorItem.Type.LEGGINGS.getDurability(41))));
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_BOOTS = registerItem("tungsten_carbide_boots",
            () -> new ModTungstenCarbideArmorItem(ModArmorMaterials.TUNGSTEN_CARBIDE, ArmorItem.Type.BOOTS,
                    new Item.Properties()
                            .fireResistant()
                            .durability(ArmorItem.Type.BOOTS.getDurability(41))));
    //endregion



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
