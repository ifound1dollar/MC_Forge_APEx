package net.dollar.apex.util;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.function.Consumer;

public class ModItemUtils {
    public enum EquipmentType { ARMOR, TOOL, RANGED }



    /**
     * Applies special effect on attack using Cobalt-Steel tools/weapons.
     * @param target Attacked (target) entity
     */
    public static void applyCobaltSteelOnHit(LivingEntity target) {
        //TODO: RE-IMPLEMENT CONFIGS
        //Apply Slowness effect to target for configurable duration in seconds.
//            target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS,
//                    ModCommonConfigs.ENDGAME_TIER_EFFECT_SECONDS.get() * 20, 1));

        // Do not apply effect to creative mode players.
        if (target instanceof Player player && player.isCreative()) return;

        //Level 2 Slowness (third argument) for 30% reduction, 15%/level.
        target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS,
                4 * 20, 1));
    }
    /**
     * Generates special tooltip for all Cobalt-Steel equipment and appends to Component list,
     *  different for armor and tools/weapons.
     * @param tooltip List of Components to be appended
     * @param equipmentType What type of equipment to generate the tooltip for (different for each)
     */
    public static void appendCobaltSteelEquipmentTooltip(Consumer<Component> tooltip, EquipmentType equipmentType) {
        //This method should only ever be called client-side, so no null risk here.

        //If the player is holding shift, show detailed info.
        if (Screen.hasShiftDown()) {
            switch (equipmentType) {
                case ARMOR -> {
                    tooltip.accept(Component.translatable("tooltip.cobalt_steel_armor_details_0"));
                    tooltip.accept(Component.translatable("tooltip.cobalt_steel_armor_details_1"));
                    tooltip.accept(Component.translatable("tooltip.cobalt_steel_armor_details_2"));
                    tooltip.accept(Component.translatable("tooltip.cobalt_steel_armor_full_set"));
                }
                case TOOL -> {
                    tooltip.accept(Component.translatable("tooltip.cobalt_steel_tool_details_0"));
                    tooltip.accept(Component.translatable("tooltip.cobalt_steel_tool_details_1"));
                    tooltip.accept(Component.translatable("tooltip.cobalt_steel_tool_details_2"));
                    tooltip.accept(Component.translatable("tooltip.cobalt_steel_tool_details_3"));
                    tooltip.accept(Component.translatable("tooltip.cobalt_steel_tool_details_4"));
                    tooltip.accept(Component.translatable("tooltip.cobalt_steel_on_hit_effect"));
                }
                case RANGED -> {
                    tooltip.accept(Component.translatable("tooltip.cobalt_steel_ranged_details_0"));
                    tooltip.accept(Component.translatable("tooltip.cobalt_steel_ranged_details_1"));
                    tooltip.accept(Component.translatable("tooltip.cobalt_steel_ranged_details_2"));
                    tooltip.accept(Component.translatable("tooltip.cobalt_steel_ranged_bonus_damage"));
                    tooltip.accept(Component.translatable("tooltip.cobalt_steel_on_hit_effect"));
                }
            }
        } else {
            tooltip.accept(Component.translatable("tooltip.cobalt_steel_hold_shift"));
        }
    }



    /**
     * Applies special effect on attack using Infused Gemstone tools/weapons.
     * @param target Attacked (target) entity
     */
    public static void applyInfusedGemstoneOnHit(LivingEntity target) {
        //TODO: RE-IMPLEMENT CONFIGS
        //Apply Wither effect to target for configurable duration in seconds.
//            target.addEffect(new MobEffectInstance(MobEffects.WITHER,
//                    (ModCommonConfigs.ENDGAME_TIER_EFFECT_SECONDS.get() * 20) + 1, 1));

        // Do not apply effect to creative mode players.
        if (target instanceof Player player && player.isCreative()) return;

        //Level 2 Wither for once-per-second damage tick (duration +1 tick so ticks 4 times).
        target.addEffect(new MobEffectInstance(MobEffects.WITHER,
                (4 * 20) + 1, 1));
    }

    /**
     * Generates special tooltip for all Infused Gemstone equipment and appends to Component list,
     *  different for armor and tools/weapons.
     * @param tooltip List of Components to be appended
     * @param equipmentType What type of equipment to generate the tooltip for (different for each)
     */
    public static void appendInfusedGemstoneEquipmentTooltip(Consumer<Component> tooltip, EquipmentType equipmentType) {
        //This method should only ever be called client-side, so no null risk here.

        //If the player is holding shift, show detailed info.
        if (Screen.hasShiftDown()) {
            switch (equipmentType) {
                case ARMOR -> {
                    tooltip.accept(Component.translatable("tooltip.infused_gemstone_armor_details_0"));
                    tooltip.accept(Component.translatable("tooltip.infused_gemstone_armor_details_1"));
                    tooltip.accept(Component.translatable("tooltip.infused_gemstone_armor_details_2"));
                    tooltip.accept(Component.translatable("tooltip.infused_gemstone_armor_full_set"));
                }
                case TOOL -> {
                    tooltip.accept(Component.translatable("tooltip.infused_gemstone_tool_details_0"));
                    tooltip.accept(Component.translatable("tooltip.infused_gemstone_tool_details_1"));
                    tooltip.accept(Component.translatable("tooltip.infused_gemstone_tool_details_2"));
                    tooltip.accept(Component.translatable("tooltip.infused_gemstone_tool_details_3"));
                    tooltip.accept(Component.translatable("tooltip.infused_gemstone_tool_details_4"));
                    tooltip.accept(Component.translatable("tooltip.infused_gemstone_on_hit_effect"));
                }
                case RANGED -> {
                    tooltip.accept(Component.translatable("tooltip.infused_gemstone_ranged_details_0"));
                    tooltip.accept(Component.translatable("tooltip.infused_gemstone_ranged_details_1"));
                    tooltip.accept(Component.translatable("tooltip.infused_gemstone_ranged_details_2"));
                    tooltip.accept(Component.translatable("tooltip.infused_gemstone_ranged_details_3"));
                    tooltip.accept(Component.translatable("tooltip.infused_gemstone_ranged_bonus_damage"));
                    tooltip.accept(Component.translatable("tooltip.infused_gemstone_on_hit_effect"));
                }
            }
        } else {
            tooltip.accept(Component.translatable("tooltip.infused_gemstone_hold_shift"));
        }
    }



    /**
     * Applies special effect on attack using Tungsten-Carbide tools/weapons.
     * @param target Attacked (target) entity
     */
    public static void applyTungstenCarbideOnHit(LivingEntity target) {
        //TODO: RE-IMPLEMENT CONFIGS
        //Apply Weakness effect to target for configurable duration in seconds.
//            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,
//                    ModCommonConfigs.ENDGAME_TIER_EFFECT_SECONDS.get() * 20, 0));

        // Do not apply effect to creative mode players.
        if (target instanceof Player player && player.isCreative()) return;

        //Level 1 Weakness (third argument) for 4 heart melee damage reduction.
        target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,
                4 * 20, 0));
    }

    /**
     * Generates special tooltip for all Tungsten-Carbide equipment and appends to Component list,
     *  different for armor and tools/weapons.
     * @param tooltip List of Components to be appended
     * @param equipmentType What type of equipment to generate the tooltip for (different for each)
     */
    public static void appendTungstenCarbideEquipmentTooltip(Consumer<Component> tooltip, EquipmentType equipmentType) {
        //This method should only ever be called client-side, so no null risk here.

        //If the player is holding shift, show detailed info.
        if (Screen.hasShiftDown()) {
            switch (equipmentType) {
                case ARMOR -> {
                    tooltip.accept(Component.translatable("tooltip.tungsten_carbide_armor_details_0"));
                    tooltip.accept(Component.translatable("tooltip.tungsten_carbide_armor_details_1"));
                    tooltip.accept(Component.translatable("tooltip.tungsten_carbide_armor_details_2"));
                    tooltip.accept(Component.translatable("tooltip.tungsten_carbide_armor_full_set"));
                }
                case TOOL -> {
                    tooltip.accept(Component.translatable("tooltip.tungsten_carbide_tool_details_0"));
                    tooltip.accept(Component.translatable("tooltip.tungsten_carbide_tool_details_1"));
                    tooltip.accept(Component.translatable("tooltip.tungsten_carbide_tool_details_2"));
                    tooltip.accept(Component.translatable("tooltip.tungsten_carbide_tool_details_3"));
                    tooltip.accept(Component.translatable("tooltip.tungsten_carbide_tool_details_4"));
                    tooltip.accept(Component.translatable("tooltip.tungsten_carbide_on_hit_effect"));
                }
                case RANGED -> {
                    tooltip.accept(Component.translatable("tooltip.tungsten_carbide_ranged_details_0"));
                    tooltip.accept(Component.translatable("tooltip.tungsten_carbide_ranged_details_1"));
                    tooltip.accept(Component.translatable("tooltip.tungsten_carbide_ranged_details_2"));
                    tooltip.accept(Component.translatable("tooltip.tungsten_carbide_ranged_details_3"));
                    tooltip.accept(Component.translatable("tooltip.tungsten_carbide_ranged_bonus_damage"));
                    tooltip.accept(Component.translatable("tooltip.tungsten_carbide_on_hit_effect"));
                }
            }
        } else {
            tooltip.accept(Component.translatable("tooltip.tungsten_carbide_hold_shift"));
        }
    }
}
