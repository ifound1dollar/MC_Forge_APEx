package net.dollar.apex.util;

import com.mojang.serialization.MapCodec;
import net.dollar.apex.ModMain;
import net.dollar.apex.loot.chest.*;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootTableModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, ModMain.MODID);



    //Basic upgrade template
    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> BASIC_UPGRADE_TEMPLATE =
            LOOT_MODIFIER_SERIALIZERS.register("loot_basic_upgrade_template",
                    ModBasicUpgradeTemplateModifier.CODEC);

    //Finished upgrade templates
    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> COBALT_STEEL_UPGRADE_TEMPLATE =
            LOOT_MODIFIER_SERIALIZERS.register("loot_cobalt_steel_upgrade_template",
                    ModCobaltSteelUpgradeTemplateModifier.CODEC);
    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> INFUSED_GEMSTONE_UPGRADE_TEMPLATE =
            LOOT_MODIFIER_SERIALIZERS.register("loot_infused_gemstone_upgrade_template",
                    ModInfusedGemstoneUpgradeTemplateModifier.CODEC);
    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> NETHERITE_UPGRADE_TEMPLATE =
            LOOT_MODIFIER_SERIALIZERS.register("loot_netherite_upgrade_template",
                    ModNetheriteUpgradeTemplateModifier.CODEC);
    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> TUNGSTEN_CARBIDE_UPGRADE_TEMPLATE =
            LOOT_MODIFIER_SERIALIZERS.register("loot_tungsten_carbide_upgrade_template",
                    ModTungstenCarbideUpgradeTemplateModifier.CODEC);

    //Basic ingredients
    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> BRONZE_INGOT =
            LOOT_MODIFIER_SERIALIZERS.register("loot_bronze_ingot",
                    ModBronzeIngotLootModifier.CODEC);
    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> PHOSPHATE_POWDER =
            LOOT_MODIFIER_SERIALIZERS.register("loot_phosphate_powder",
                    ModPhosphatePowderLootModifier.CODEC);
    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> TIN_INGOT =
            LOOT_MODIFIER_SERIALIZERS.register("loot_tin_ingot",
                    ModTinIngotLootModifier.CODEC);

    //Upgrade ingredients
    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> COBALT_SHARD =
            LOOT_MODIFIER_SERIALIZERS.register("loot_cobalt_shard",
                    ModCobaltShardLootModifier.CODEC);
    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> RUBY =
            LOOT_MODIFIER_SERIALIZERS.register("loot_ruby",
                    ModRubyLootModifier.CODEC);
    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> SAPPHIRE =
            LOOT_MODIFIER_SERIALIZERS.register("loot_sapphire",
                    ModSapphireLootModifier.CODEC);
    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> STEEL_INGOT =
            LOOT_MODIFIER_SERIALIZERS.register("loot_steel_ingot",
                    ModSteelIngotLootModifier.CODEC);
    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> TUNGSTEN_INGOT =
            LOOT_MODIFIER_SERIALIZERS.register("loot_tungsten_ingot",
                    ModTungstenIngotLootModifier.CODEC);



    public static void register(IEventBus bus) {
        LOOT_MODIFIER_SERIALIZERS.register(bus);
    }
}
