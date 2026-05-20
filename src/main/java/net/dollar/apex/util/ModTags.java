package net.dollar.apex.util;

import net.dollar.apex.ModMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * Handles creating new tags specific to the mod, like Blocks, Items, and EntityTypes.
 */
public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> MOD_PAXEL_MINEABLE = modBlockTag("paxel_mineable");


        
        public static final TagKey<Block> COMMON_ORES = commonBlockTag("ores");



        /**
         * Generate a common (#c) block tag. NOTE: BlockTags.create() method auto-inserts the 'block/' path
         *  before the JSON file name.
         * @param name Name of tag's JSON file
         * @return Generated Block TagKey
         */
        private static TagKey<Block> commonBlockTag(String name)
        {
            return BlockTags.create(Identifier.fromNamespaceAndPath("c", name));
        }

        /**
         * Generate an apex block tag. NOTE: BlockTags.create() method auto-inserts the 'block/' path
         *  before the JSON file name.
         * @param name Name of tag's JSON file
         * @return Generated Block TagKey
         */
        private static TagKey<Block> modBlockTag(String name)
        {
            return BlockTags.create(Identifier.fromNamespaceAndPath(ModMain.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> MOD_TOOLS_COBALT_STEEL = modItemTag("tools_cobalt_steel");
        public static final TagKey<Item> MOD_TOOLS_infused_gemstone = modItemTag("tools_infused_gemstone");
        public static final TagKey<Item> MOD_TOOLS_TUNGSTEN_CARBIDE = modItemTag("tools_tungsten_carbide");

        public static final TagKey<Item> MOD_REPAIRS_COBALT_STEEL_EQUIPMENT = modItemTag(
                "repairs_cobalt_steel_equipment");
        public static final TagKey<Item> MOD_REPAIRS_INFUSED_GEMSTONE_EQUIPMENT = modItemTag(
                "repairs_infused_gemstone_equipment");
        public static final TagKey<Item> MOD_REPAIRS_TUNGSTEN_CARBIDE_EQUIPMENT = modItemTag(
                "repairs_tungsten_carbide_equipment");



        public static final TagKey<Item> COMMON_AMETHYST = commonItemTag("gems/amethyst");
        public static final TagKey<Item> COMMON_BATTLEAXES = commonItemTag("tools/battleaxes");
        public static final TagKey<Item> COMMON_BOOTS = commonItemTag("armors/boots");
        public static final TagKey<Item> COMMON_BOWS = commonItemTag("tools/bows");
        public static final TagKey<Item> COMMON_BRONZE_INGOTS = commonItemTag("ingots/bronze");
        public static final TagKey<Item> COMMON_CHESTPLATES = commonItemTag("armors/chestplates");
        public static final TagKey<Item> COMMON_CHESTS = commonItemTag("chests");
        public static final TagKey<Item> COMMON_COPPER_INGOTS = commonItemTag("ingots/copper");
        public static final TagKey<Item> COMMON_CROSSBOWS = commonItemTag("tools/crossbows");
        public static final TagKey<Item> COMMON_DEEPSLATES = commonItemTag("deepslate");
        public static final TagKey<Item> COMMON_DIAMONDS = commonItemTag("gems/diamond");
        public static final TagKey<Item> COMMON_EMERALDS = commonItemTag("gems/emerald");
        public static final TagKey<Item> COMMON_GEMS = commonItemTag("gems");
        public static final TagKey<Item> COMMON_GOLD_INGOTS = commonItemTag("ingots/gold");
        public static final TagKey<Item> COMMON_HELMETS = commonItemTag("armors/helmets");
        public static final TagKey<Item> COMMON_INGOTS = commonItemTag("ingots");
        public static final TagKey<Item> COMMON_IRON_INGOTS = commonItemTag("ingots/iron");
        public static final TagKey<Item> COMMON_LEGGINGS = commonItemTag("armors/leggings");
        public static final TagKey<Item> COMMON_NETHERITE_INGOTS = commonItemTag("ingots/netherite");
        public static final TagKey<Item> COMMON_NETHERRACKS = commonItemTag("netherrack");
        public static final TagKey<Item> COMMON_ORES = commonItemTag("ores");
        public static final TagKey<Item> COMMON_PAXELS = commonItemTag("tools/paxels");
        public static final TagKey<Item> COMMON_RAW_MATERIALS = commonItemTag("raw_materials");
        public static final TagKey<Item> COMMON_RUBIES = commonItemTag("gems/ruby");
        public static final TagKey<Item> COMMON_SAPPHIRES = commonItemTag("gems/sapphire");
        public static final TagKey<Item> COMMON_STEEL_INGOTS = commonItemTag("ingots/steel");
        public static final TagKey<Item> COMMON_STONES = commonItemTag("stone");
        public static final TagKey<Item> COMMON_TIN_INGOTS = commonItemTag("ingots/tin");
        public static final TagKey<Item> COMMON_TUNGSTEN_INGOTS = commonItemTag("ingots/tungsten");
        public static final TagKey<Item> COMMON_WOODEN_RODS = commonItemTag("rods/wooden");



        public static final TagKey<Item> MINECRAFT_COALS = minecraftItemTag("coals");



        /**
         * Generate a common (#c) item tag. NOTE: ItemTags.create() method auto-inserts the 'item/' path
         *  before the JSON file name.
         * @param name Name of tag's JSON file
         * @return Generated Item TagKey
         */
        private static TagKey<Item> commonItemTag(String name)
        {
            return ItemTags.create(Identifier.fromNamespaceAndPath("c", name));
        }

        /**
         * Generate an apex item tag. NOTE: ItemTags.create() method auto-inserts the 'item/' path
         *  before the JSON file name.
         * @param name Name of tag's JSON file
         * @return Generated Item TagKey
         */
        private static TagKey<Item> modItemTag(String name)
        {
            return ItemTags.create(Identifier.fromNamespaceAndPath(ModMain.MODID, name));
        }

        private static TagKey<Item> minecraftItemTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath("minecraft", name));
        }
    }

    public static class Entities {
        public static final TagKey<EntityType<?>> ARROWS_HEAVY = modEntityTypeTag("arrows_heavy");



        /**
         * Generate a forge entity_type tag. Using Registries.ENTITY_TYPE auto-inserts the
         *  'entity_type/' path before the JSON file name.
         * @param name Name of tag's JSON file
         * @return Generated EntityType TagKey
         */
        private static TagKey<EntityType<?>> forgeEntityTypeTag(String name)
        {
            return TagKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("forge", name));
        }
        /**
         * Generate an apex entity_type tag. NOTE: Using Registries.ENTITY_TYPE auto-inserts the
         *  'entity_type/' path before the JSON file name.
         * @param name Name of tag's JSON file
         * @return Generated EntityType TagKey
         */
        private static TagKey<EntityType<?>> modEntityTypeTag(String name)
        {
            return TagKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(ModMain.MODID, name));
        }

    }
}
