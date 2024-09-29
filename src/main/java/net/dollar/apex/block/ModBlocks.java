package net.dollar.apex.block;

import net.dollar.apex.ModMain;
import net.dollar.apex.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ModMain.MODID);



    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.REDSTONE_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops().mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.LAPIS_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops().mapColor(MapColor.LAPIS)));
    public static final RegistryObject<Block> DECORATIVE_AMETHYST_BLOCK = registerBlock("decorative_amethyst_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops().mapColor(MapColor.COLOR_PURPLE)));


    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops().mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)
                    .strength(5f, 6f).requiresCorrectToolForDrops().mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops().mapColor(MapColor.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4.5f).requiresCorrectToolForDrops().mapColor(MapColor.DEEPSLATE)));


    public static final RegistryObject<Block> BRONZE_BLOCK = registerBlock("bronze_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops().mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops().mapColor(MapColor.STONE)));
    public static final RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops().mapColor(MapColor.LAPIS)));


    public static final RegistryObject<Block> TUNGSTEN_BLOCK = registerBlock("tungsten_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops().mapColor(MapColor.DEEPSLATE)));
    public static final RegistryObject<Block> RAW_TUNGSTEN_BLOCK = registerBlock("raw_tungsten_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)
                    .strength(5f, 6f).requiresCorrectToolForDrops().mapColor(MapColor.DEEPSLATE)));
    public static final RegistryObject<Block> TUNGSTEN_ORE = registerBlock("tungsten_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops().mapColor(MapColor.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_TUNGSTEN_ORE = registerBlock("deepslate_tungsten_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4.5f).requiresCorrectToolForDrops().mapColor(MapColor.DEEPSLATE)));


    //gem ore blocks drop experience and loot; DropExperienceBlock constructor is overridden to accept
    //  a UniformInt as a second parameter which determines the amount of XP to drop
    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops().mapColor(MapColor.STONE),
                    UniformInt.of(4, 8)));  //Diamond is 3, 7
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4.5f).requiresCorrectToolForDrops().mapColor(MapColor.DEEPSLATE),
                    UniformInt.of(4, 8)));


    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops().mapColor(MapColor.STONE),
                    UniformInt.of(4, 8)));
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4.5f).requiresCorrectToolForDrops().mapColor(MapColor.DEEPSLATE),
                    UniformInt.of(4, 8)));


    public static final RegistryObject<Block> COBALT_ORE = registerBlock("cobalt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops().mapColor(MapColor.STONE),
                    UniformInt.of(3, 6)));  //Diamond is 3, 7
    public static final RegistryObject<Block> DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4.5f).requiresCorrectToolForDrops().mapColor(MapColor.DEEPSLATE),
                    UniformInt.of(3, 6)));


    public static final RegistryObject<Block> PHOSPHATE_ORE = registerBlock("phosphate_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops().mapColor(MapColor.STONE),
                    UniformInt.of(1, 3)));
    public static final RegistryObject<Block> DEEPSLATE_PHOSPHATE_ORE = registerBlock("deepslate_phosphate_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4.5f).requiresCorrectToolForDrops().mapColor(MapColor.DEEPSLATE),
                    UniformInt.of(1, 3)));



    /**
     * Registers new Block and calls helper method to generate corresponding Item.
     * @param name Name of new block
     * @param block Actual Block (via supplier)
     * @return Generated Block RegistryObject
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    /**
     * Registers new Item corresponding to a newly registered Block.
     * @param name Name of new Block
     * @param block Block RegistryObject (just generated)
     * @return Generated Item RegistryObject
     */
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }



    /**
     * Register new Blocks.
     * @param eventBus Main event bus
     */
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
