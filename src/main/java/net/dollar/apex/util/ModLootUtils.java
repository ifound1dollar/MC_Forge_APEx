package net.dollar.apex.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;

public class ModLootUtils {
    //Declare Identifiers here, then use them below within modifyLootTables().

    public enum Loot_Rarity { COMMON, UNCOMMON, RARE, VERY_RARE }
    public enum Loot_Type { BASIC_UPGRADE, FINISHED_UPGRADE, BASIC_INGREDIENT, UPGRADE_INGREDIENT }

    //region COMMON / LOWER QUALITY STRUCTURE CHESTS (rarely includes basic templates)
    public static final Identifier VILLAGE_ARMORER_ID = Identifier.withDefaultNamespace("chests/village/village_armorer");
    public static final Identifier VILLAGE_MASON_ID = Identifier.withDefaultNamespace("chests/village/village_mason");
    public static final Identifier VILLAGE_TOOLSMITH_ID = Identifier.withDefaultNamespace("chests/village/village_toolsmith");
    public static final Identifier VILLAGE_WEAPONSMITH_ID = Identifier.withDefaultNamespace("chests/village/village_weaponsmith");
    public static final Identifier IGLOO_CHEST_ID = Identifier.withDefaultNamespace("chests/igloo_chest");
    public static final Identifier SHIPWRECK_SUPPLY_ID = Identifier.withDefaultNamespace("chests/shipwreck_supply");
    //endregion

    //region UNCOMMON / MODERATE QUALITY STRUCTURE CHESTS (includes basic templates, NO complete templates)
    public static final Identifier ABANDONED_MINESHAFT_ID = Identifier.withDefaultNamespace("chests/abandoned_mineshaft");
    public static final Identifier BURIED_TREASURE_ID = Identifier.withDefaultNamespace("chests/buried_treasure");
    public static final Identifier DESERT_PYRAMID_ID = Identifier.withDefaultNamespace("chests/desert_pyramid");
    public static final Identifier JUNGLE_TEMPLE_ID = Identifier.withDefaultNamespace("chests/jungle_temple");
    public static final Identifier NETHER_BRIDGE_ID = Identifier.withDefaultNamespace("chests/nether_bridge");
    public static final Identifier PILLAGER_OUTPOST_ID = Identifier.withDefaultNamespace("chests/pillager_outpost");
    public static final Identifier RUINED_PORTAL_ID = Identifier.withDefaultNamespace("chests/ruined_portal");
    public static final Identifier SHIPWRECK_TREASURE_ID = Identifier.withDefaultNamespace("chests/shipwreck_treasure");
    public static final Identifier SIMPLE_DUNGEON_ID = Identifier.withDefaultNamespace("chests/simple_dungeon");
    public static final Identifier UNDERWATER_RUIN_BIG_ID = Identifier.withDefaultNamespace("chests/underwater_ruin_big");
    public static final Identifier UNDERWATER_RUIN_SMALL_ID = Identifier.withDefaultNamespace("chests/underwater_ruin_small");
    //endregion

    //region RARE / HIGH QUALITY STRUCTURE CHESTS (can include complete templates)
    public static final Identifier ANCIENT_CITY_ID = Identifier.withDefaultNamespace("chests/ancient_city");
    public static final Identifier ANCIENT_CITY_ICE_BOX_ID = Identifier.withDefaultNamespace("chests/ancient_city_ice_box");
    public static final Identifier BASTION_BRIDGE_ID = Identifier.withDefaultNamespace("chests/bastion_bridge");
    public static final Identifier BASTION_HOGLIN_STABLE_ID = Identifier.withDefaultNamespace("chests/bastion_hoglin_stable");
    public static final Identifier BASTION_OTHER_ID = Identifier.withDefaultNamespace("chests/bastion_other");
    public static final Identifier BASTION_TREASURE_ID = Identifier.withDefaultNamespace("chests/bastion_treasure");
    public static final Identifier END_CITY_TREASURE_ID = Identifier.withDefaultNamespace("chests/end_city_treasure");
    public static final Identifier STRONGHOLD_CORRIDOR_ID = Identifier.withDefaultNamespace("chests/stronghold_corridor");
    public static final Identifier STRONGHOLD_CROSSING_ID = Identifier.withDefaultNamespace("chests/stronghold_crossing");
    public static final Identifier STRONGHOLD_LIBRARY_ID = Identifier.withDefaultNamespace("chests/stronghold_library");
    public static final Identifier WOODLAND_MANSION_ID = Identifier.withDefaultNamespace("chests/woodland_mansion");
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
