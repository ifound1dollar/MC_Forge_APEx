package net.dollar.apex.util;

import net.dollar.apex.ModMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
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


        
        public static final TagKey<Block> FORGE_ORES = forgeBlockTag("ores");
        
        

        /**
         * Generate a forge block tag. NOTE: BlockTags.create() method auto-inserts the 'block/' path
         *  before the JSON file name.
         * @param name Name of tag's JSON file
         * @return Generated Block TagKey
         */
        private static TagKey<Block> forgeBlockTag(String name)
        {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
        
        /**
         * Generate an apex block tag. NOTE: BlockTags.create() method auto-inserts the 'block/' path
         *  before the JSON file name.
         * @param name Name of tag's JSON file
         * @return Generated Block TagKey
         */
        private static TagKey<Block> modBlockTag(String name)
        {
            return BlockTags.create(new ResourceLocation(ModMain.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> MOD_TOOLS_COBALT_STEEL = modItemTag("tools_cobalt_steel");
        public static final TagKey<Item> MOD_TOOLS_INFUSED_DIAMOND = modItemTag("tools_infused_diamond");
        public static final TagKey<Item> MOD_TOOLS_TUNGSTEN_CARBIDE = modItemTag("tools_tungsten_carbide");



        public static final TagKey<Item> FORGE_AMETHYST = forgeItemTag("gems/amethyst");
        public static final TagKey<Item> FORGE_BATTLEAXES = forgeItemTag("tools/battleaxes");
        public static final TagKey<Item> FORGE_BOOTS = forgeItemTag("armors/boots");
        public static final TagKey<Item> FORGE_BOWS = forgeItemTag("tools/bows");
        public static final TagKey<Item> FORGE_BRONZE_INGOTS = forgeItemTag("ingots/bronze");
        public static final TagKey<Item> FORGE_CHESTPLATES = forgeItemTag("armors/chestplates");
        public static final TagKey<Item> FORGE_CHESTS = forgeItemTag("chests");
        public static final TagKey<Item> FORGE_COPPER_INGOTS = forgeItemTag("ingots/copper");
        public static final TagKey<Item> FORGE_CROSSBOWS = forgeItemTag("tools/crossbows");
        public static final TagKey<Item> FORGE_DEEPSLATES = forgeItemTag("deepslate");
        public static final TagKey<Item> FORGE_DIAMONDS = forgeItemTag("gems/diamond");
        public static final TagKey<Item> FORGE_EMERALDS = forgeItemTag("gems/emerald");
        public static final TagKey<Item> FORGE_GEMS = forgeItemTag("gems");
        public static final TagKey<Item> FORGE_GOLD_INGOTS = forgeItemTag("ingots/gold");
        public static final TagKey<Item> FORGE_HELMETS = forgeItemTag("armors/helmets");
        public static final TagKey<Item> FORGE_INGOTS = forgeItemTag("ingots");
        public static final TagKey<Item> FORGE_IRON_INGOTS = forgeItemTag("ingots/iron");
        public static final TagKey<Item> FORGE_LEGGINGS = forgeItemTag("armors/leggings");
        public static final TagKey<Item> FORGE_NETHERITE_INGOTS = forgeItemTag("ingots/netherite");
        public static final TagKey<Item> FORGE_NETHERRACKS = forgeItemTag("netherrack");
        public static final TagKey<Item> FORGE_ORES = forgeItemTag("ores");
        public static final TagKey<Item> FORGE_PAXELS = forgeItemTag("tools/paxels");
        public static final TagKey<Item> FORGE_RAW_MATERIALS = forgeItemTag("raw_materials");
        public static final TagKey<Item> FORGE_RUBIES = forgeItemTag("gems/ruby");
        public static final TagKey<Item> FORGE_SAPPHIRES = forgeItemTag("gems/sapphire");
        public static final TagKey<Item> FORGE_STEEL_INGOTS = forgeItemTag("ingots/steel");
        public static final TagKey<Item> FORGE_STONES = forgeItemTag("stone");
        public static final TagKey<Item> FORGE_TIN_INGOTS = forgeItemTag("ingots/tin");
        public static final TagKey<Item> FORGE_TUNGSTEN_INGOTS = forgeItemTag("ingots/tungsten");
        public static final TagKey<Item> FORGE_WOODEN_RODS = forgeItemTag("rods/wooden");



        /**
         * Generate a forge item tag. NOTE: ItemTags.create() method auto-inserts the 'item/' path
         *  before the JSON file name.
         * @param name Name of tag's JSON file
         * @return Generated Item TagKey
         */
        private static TagKey<Item> forgeItemTag(String name)
        {
            return ItemTags.create(new ResourceLocation("forge", name));
        }

        /**
         * Generate an apex item tag. NOTE: ItemTags.create() method auto-inserts the 'item/' path
         *  before the JSON file name.
         * @param name Name of tag's JSON file
         * @return Generated Item TagKey
         */
        private static TagKey<Item> modItemTag(String name)
        {
            return ItemTags.create(new ResourceLocation(ModMain.MODID, name));
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
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge", name));
        }
        /**
         * Generate an apex entity_type tag. NOTE: Using Registries.ENTITY_TYPE auto-inserts the
         *  'entity_type/' path before the JSON file name.
         * @param name Name of tag's JSON file
         * @return Generated EntityType TagKey
         */
        private static TagKey<EntityType<?>> modEntityTypeTag(String name)
        {
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(ModMain.MODID, name));
        }

    }
}
