package net.dollar.apex.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;

public class ModLootUtils {
    //Declare ResourceLocations here, then use them below within modifyLootTables().

    public enum Loot_Rarity { COMMON, UNCOMMON, RARE, VERY_RARE }
    public enum Loot_Type { BASIC_UPGRADE, FINISHED_UPGRADE, BASIC_INGREDIENT, UPGRADE_INGREDIENT }

    //region COMMON / LOWER QUALITY STRUCTURE CHESTS (rarely includes basic templates)
    public static final ResourceLocation VILLAGE_ARMORER_ID = ResourceLocation.withDefaultNamespace("chests/village/village_armorer");
    public static final ResourceLocation VILLAGE_MASON_ID = ResourceLocation.withDefaultNamespace("chests/village/village_mason");
    public static final ResourceLocation VILLAGE_TOOLSMITH_ID = ResourceLocation.withDefaultNamespace("chests/village/village_toolsmith");
    public static final ResourceLocation VILLAGE_WEAPONSMITH_ID = ResourceLocation.withDefaultNamespace("chests/village/village_weaponsmith");
    public static final ResourceLocation IGLOO_CHEST_ID = ResourceLocation.withDefaultNamespace("chests/igloo_chest");
    public static final ResourceLocation SHIPWRECK_SUPPLY_ID = ResourceLocation.withDefaultNamespace("chests/shipwreck_supply");
    //endregion

    //region UNCOMMON / MODERATE QUALITY STRUCTURE CHESTS (includes basic templates, NO complete templates)
    public static final ResourceLocation ABANDONED_MINESHAFT_ID = ResourceLocation.withDefaultNamespace("chests/abandoned_mineshaft");
    public static final ResourceLocation BURIED_TREASURE_ID = ResourceLocation.withDefaultNamespace("chests/buried_treasure");
    public static final ResourceLocation DESERT_PYRAMID_ID = ResourceLocation.withDefaultNamespace("chests/desert_pyramid");
    public static final ResourceLocation JUNGLE_TEMPLE_ID = ResourceLocation.withDefaultNamespace("chests/jungle_temple");
    public static final ResourceLocation NETHER_BRIDGE_ID = ResourceLocation.withDefaultNamespace("chests/nether_bridge");
    public static final ResourceLocation PILLAGER_OUTPOST_ID = ResourceLocation.withDefaultNamespace("chests/pillager_outpost");
    public static final ResourceLocation RUINED_PORTAL_ID = ResourceLocation.withDefaultNamespace("chests/ruined_portal");
    public static final ResourceLocation SHIPWRECK_TREASURE_ID = ResourceLocation.withDefaultNamespace("chests/shipwreck_treasure");
    public static final ResourceLocation SIMPLE_DUNGEON_ID = ResourceLocation.withDefaultNamespace("chests/simple_dungeon");
    public static final ResourceLocation UNDERWATER_RUIN_BIG_ID = ResourceLocation.withDefaultNamespace("chests/underwater_ruin_big");
    public static final ResourceLocation UNDERWATER_RUIN_SMALL_ID = ResourceLocation.withDefaultNamespace("chests/underwater_ruin_small");
    //endregion

    //region RARE / HIGH QUALITY STRUCTURE CHESTS (can include complete templates)
    public static final ResourceLocation ANCIENT_CITY_ID = ResourceLocation.withDefaultNamespace("chests/ancient_city");
    public static final ResourceLocation ANCIENT_CITY_ICE_BOX_ID = ResourceLocation.withDefaultNamespace("chests/ancient_city_ice_box");
    public static final ResourceLocation BASTION_BRIDGE_ID = ResourceLocation.withDefaultNamespace("chests/bastion_bridge");
    public static final ResourceLocation BASTION_HOGLIN_STABLE_ID = ResourceLocation.withDefaultNamespace("chests/bastion_hoglin_stable");
    public static final ResourceLocation BASTION_OTHER_ID = ResourceLocation.withDefaultNamespace("chests/bastion_other");
    public static final ResourceLocation BASTION_TREASURE_ID = ResourceLocation.withDefaultNamespace("chests/bastion_treasure");
    public static final ResourceLocation END_CITY_TREASURE_ID = ResourceLocation.withDefaultNamespace("chests/end_city_treasure");
    public static final ResourceLocation STRONGHOLD_CORRIDOR_ID = ResourceLocation.withDefaultNamespace("chests/stronghold_corridor");
    public static final ResourceLocation STRONGHOLD_CROSSING_ID = ResourceLocation.withDefaultNamespace("chests/stronghold_crossing");
    public static final ResourceLocation STRONGHOLD_LIBRARY_ID = ResourceLocation.withDefaultNamespace("chests/stronghold_library");
    public static final ResourceLocation WOODLAND_MANSION_ID = ResourceLocation.withDefaultNamespace("chests/woodland_mansion");
    //endregion



    /**
     * Helper method to generate loot by rarity. Adds item to the passed-in 'generatedLoot' object.
     * @param generatedLoot ArrayList of items in existing loot
     * @param context Relevant LootContext
     * @param item Item being added to generatedLoot Arraylist
     * @param rolls Number of rolls to apply
     * @param rarity Enumeration determining chance per roll
     */
    public static void genLootByRarity(ObjectArrayList<ItemStack> generatedLoot, LootContext context,
                                 Item item, int rolls, Loot_Rarity rarity, Loot_Type type) {
        //TEMP
        //ModMain.LOGGER.info("genLootByRarity called with id: {}", context.getQueriedLootTableId());
        //TEMP

        //TEMPORARY SOLUTION (nothing more permanent than a temporary solution)
        //Each individual item rolls on its own, so the chance must be divided by the number of
        //  items being rolled on individually.
        float chanceRatio = 1.0f;
        switch (type) {
            case BASIC_UPGRADE -> {
            }
            case FINISHED_UPGRADE, BASIC_INGREDIENT -> chanceRatio = 0.33f;    //3 items in category
            case UPGRADE_INGREDIENT -> chanceRatio = 0.2f;     //5 items in category
        }

        switch (rarity) {
            case COMMON -> {
                //COMMON (0.4 chance each roll)
                for (int i = 0; i < rolls; i++) {
                    if (context.getRandom().nextFloat() < 0.4f * chanceRatio) {
                        generatedLoot.add(new ItemStack(item, 1));
                    }
                }
            }
            case UNCOMMON -> {
                //UNCOMMON (0.3 chance each roll)
                for (int i = 0; i < rolls; i++) {
                    if (context.getRandom().nextFloat() < 0.3f * chanceRatio) {
                        generatedLoot.add(new ItemStack(item, 1));
                    }
                }
            }
            case RARE -> {
                //RARE (0.2 chance each roll)
                for (int i = 0; i < rolls; i++) {
                    if (context.getRandom().nextFloat() < 0.2f * chanceRatio) {
                        generatedLoot.add(new ItemStack(item, 1));
                    }
                }
            }
            case VERY_RARE -> {
                //VERY RARE (0.1 chance each roll)
                for (int i = 0; i < rolls; i++) {
                    if (context.getRandom().nextFloat() < 0.1f * chanceRatio) {
                        generatedLoot.add(new ItemStack(item, 1));
                    }
                }
            }
        }
    }
}
