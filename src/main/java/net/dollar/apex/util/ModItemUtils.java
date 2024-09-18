package net.dollar.apex.util;

import com.google.common.collect.Sets;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraft.world.entity.LivingEntity;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModItemUtils {
    public static final Set<ToolAction> DEFAULT_PAXEL_ACTIONS = Stream.of(
            ToolActions.AXE_DIG, ToolActions.AXE_STRIP, ToolActions.AXE_SCRAPE, ToolActions.AXE_WAX_OFF,
            ToolActions.HOE_DIG, ToolActions.HOE_TILL,
            ToolActions.PICKAXE_DIG,
            ToolActions.SHOVEL_DIG, ToolActions.SHOVEL_FLATTEN)
            .collect(Collectors.toCollection(Sets::newIdentityHashSet));



    public enum EquipmentType { ARMOR, TOOL, RANGED }



    /**
     * Applies special effect on attack using Cobalt-Steel tools/weapons.
     * @param target Attacked (target) entity
     */
    public static void applyCobaltSteelOnHit(LivingEntity target) {
        //Apply Weakness effect to target for configurable duration in seconds.
        //TODO: RE-IMPLEMENT CONFIGS
        //Level 1 (third argument) for 4 heart melee damage reduction.
//            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,
//                    ModCommonConfigs.ENDGAME_TIER_EFFECT_SECONDS.get() * 20, 0));
        target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,
                4 * 20, 0));
    }
    /**
     * Generates special tooltip for all Cobalt-Steel equipment and appends to Component list,
     *  different for armor and tools/weapons.
     * @param tooltip List of Components to be appended
     * @param type What type of equipment to generate the tooltip for (different for each)
     */
    public static void appendCobaltSteelEquipmentTooltip(List<Component> tooltip, EquipmentType type) {
        //This method should only ever be called client-side, so no null risk here.
        //If the player is holding shift, show detailed info.
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.cobalt_steel_details_0"));
            tooltip.add(Component.translatable("tooltip.cobalt_steel_details_1"));
            tooltip.add(Component.translatable("tooltip.cobalt_steel_details_2"));
            tooltip.add(Component.translatable("tooltip.cobalt_steel_details_3"));
            tooltip.add(Component.translatable("tooltip.cobalt_steel_details_4"));

            //TODO: RE-IMPLEMENT CONFIGS
            switch (type) {
                case ARMOR -> {
                    tooltip.add(Component.translatable("tooltip.cobalt_steel_armor"));
                }
                case TOOL -> {
                    tooltip.add(Component.translatable("tooltip.cobalt_steel_onhit"));
                }
                case RANGED -> {
                    tooltip.add(Component.translatable("tooltip.cobalt_steel_bow_crossbow"));
                    tooltip.add(Component.translatable("tooltip.cobalt_steel_onhit"));
                }
            }
        } else {
            tooltip.add(Component.translatable("tooltip.cobalt_steel_hold_shift"));
        }
    }



    /**
     * Applies special effect on attack using Infused Gemstone tools/weapons.
     * @param target Attacked (target) entity
     */
    public static void applyInfusedGemstoneOnHit(LivingEntity target) {
        //Apply Wither effect to target for configurable duration in seconds.
        //TODO: RE-IMPLEMENT CONFIGS
        //Level 2 wither for once-per-second damage tick (duration +1 tick so ticks 4 times).
//            target.addEffect(new MobEffectInstance(MobEffects.WITHER,
//                    (ModCommonConfigs.ENDGAME_TIER_EFFECT_SECONDS.get() * 20) + 1, 1));
        target.addEffect(new MobEffectInstance(MobEffects.WITHER,
                (4 * 20) + 1, 1));
    }

    /**
     * Generates special tooltip for all Infused Gemstone equipment and appends to Component list,
     *  different for armor and tools/weapons.
     * @param tooltip List of Components to be appended
     * @param type What type of equipment to generate the tooltip for (different for each)
     */
    public static void appendInfusedGemstoneEquipmentTooltip(List<Component> tooltip, EquipmentType type) {
        //This method should only ever be called client-side, so no null risk here.
        //If the player is holding shift, show detailed info.
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.infused_gemstone_details_0"));
            tooltip.add(Component.translatable("tooltip.infused_gemstone_details_1"));
            tooltip.add(Component.translatable("tooltip.infused_gemstone_details_2"));
            tooltip.add(Component.translatable("tooltip.infused_gemstone_details_3"));
            tooltip.add(Component.translatable("tooltip.infused_gemstone_details_4"));

            //TODO: RE-IMPLEMENT CONFIGS
            switch (type) {
                case ARMOR -> {
                    tooltip.add(Component.translatable("tooltip.infused_gemstone_armor"));
                }
                case TOOL -> {
                    tooltip.add(Component.translatable("tooltip.infused_gemstone_onhit"));
                }
                case RANGED -> {
                    tooltip.add(Component.translatable("tooltip.infused_gemstone_bow_crossbow"));
                    tooltip.add(Component.translatable("tooltip.infused_gemstone_onhit"));
                }
            }
        } else {
            tooltip.add(Component.translatable("tooltip.infused_gemstone_hold_shift"));
        }
    }



    /**
     * Applies special effect on attack using Tungsten-Carbide tools/weapons.
     * @param target Attacked (target) entity
     */
    public static void applyTungstenCarbideOnHit(LivingEntity target) {
        //Apply Slowness effect to target for configurable duration in seconds.
        //TODO: RE-IMPLEMENT CONFIGS
        //Level 2 slow (third argument) for 30% reduction, 15%/level.
//            target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS,
//                    ModCommonConfigs.ENDGAME_TIER_EFFECT_SECONDS.get() * 20, 1));
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,
                4 * 20, 1));
    }

    /**
     * Generates special tooltip for all Tungsten-Carbide equipment and appends to Component list,
     *  different for armor and tools/weapons.
     * @param tooltip List of Components to be appended
     * @param type What type of equipment to generate the tooltip for (different for each)
     */
    public static void appendTungstenCarbideEquipmentTooltip(List<Component> tooltip, EquipmentType type) {
        //This method should only ever be called client-side, so no null risk here.
        //If the player is holding shift, show detailed info.
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.tungsten_carbide_details_0"));
            tooltip.add(Component.translatable("tooltip.tungsten_carbide_details_1"));
            tooltip.add(Component.translatable("tooltip.tungsten_carbide_details_2"));
            tooltip.add(Component.translatable("tooltip.tungsten_carbide_details_3"));
            tooltip.add(Component.translatable("tooltip.tungsten_carbide_details_4"));

            //TODO: RE-IMPLEMENT CONFIGS
            switch (type) {
                case ARMOR -> {
                    tooltip.add(Component.translatable("tooltip.tungsten_carbide_armor"));
                }
                case TOOL -> {
                    tooltip.add(Component.translatable("tooltip.tungsten_carbide_onhit"));
                }
                case RANGED -> {
                    tooltip.add(Component.translatable("tooltip.tungsten_carbide_bow_crossbow"));
                    tooltip.add(Component.translatable("tooltip.tungsten_carbide_onhit"));
                }
            }
        } else {
            tooltip.add(Component.translatable("tooltip.tungsten_carbide_hold_shift"));
        }
    }
}
