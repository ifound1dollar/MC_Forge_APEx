package net.dollar.apex.item.custom.equipment;

import net.dollar.apex.item.ModItems;
import net.dollar.apex.util.IFullSetEffectArmor;
import net.dollar.apex.util.ModItemUtils;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class ModEndgameArmorItem extends Item implements IFullSetEffectArmor {
    private final BiPredicate<Holder<MobEffect>, LivingEntity> canReceiveEffectMethod;
    private final BiConsumer<Consumer<Component>, ModItemUtils.EquipmentType> tooltipMethod;

    public ModEndgameArmorItem(ModItemUtils.EndgameTier tier, Properties properties) {
        super(properties);

        // Set proper method references in BiConsumers.
        switch (tier) {
            case COBALT_STEEL -> {
                canReceiveEffectMethod = (effect, wearer) -> {
                    // Check for correct equipment, then set isFullSet accordingly.
                    boolean isFullSet;
                    boolean hasHelm = wearer.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.COBALT_STEEL_HELMET.get();
                    boolean hasChest = wearer.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.COBALT_STEEL_CHESTPLATE.get();
                    boolean hasLegs = wearer.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.COBALT_STEEL_LEGGINGS.get();
                    boolean hasBoots = wearer.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.COBALT_STEEL_BOOTS.get();
                    isFullSet = hasHelm && hasChest && hasLegs && hasBoots;

                    // Return true or false depending on whether full set, and whether effect should be prevented.
                    return !(isFullSet && (effect == MobEffects.SLOWNESS || effect == MobEffects.MINING_FATIGUE));
                };
                tooltipMethod = ModItemUtils::appendCobaltSteelEquipmentTooltip;
            }
            case INFUSED_GEMSTONE -> {
                canReceiveEffectMethod = (effect, wearer) -> {
                    boolean isFullSet;
                    boolean hasHelm = wearer.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.INFUSED_GEMSTONE_HELMET.get();
                    boolean hasChest = wearer.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.INFUSED_GEMSTONE_CHESTPLATE.get();
                    boolean hasLegs = wearer.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.INFUSED_GEMSTONE_LEGGINGS.get();
                    boolean hasBoots = wearer.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.INFUSED_GEMSTONE_BOOTS.get();
                    isFullSet = hasHelm && hasChest && hasLegs && hasBoots;
                    return !(isFullSet && (effect == MobEffects.POISON || effect == MobEffects.WITHER));
                };
                tooltipMethod = ModItemUtils::appendInfusedGemstoneEquipmentTooltip;
            }
            case TUNGSTEN_CARBIDE -> {
                canReceiveEffectMethod = (effect, wearer) -> {
                    boolean isFullSet;
                    boolean hasHelm = wearer.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.TUNGSTEN_CARBIDE_HELMET.get();
                    boolean hasChest = wearer.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.TUNGSTEN_CARBIDE_CHESTPLATE.get();
                    boolean hasLegs = wearer.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.TUNGSTEN_CARBIDE_LEGGINGS.get();
                    boolean hasBoots = wearer.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.TUNGSTEN_CARBIDE_BOOTS.get();
                    isFullSet = hasHelm && hasChest && hasLegs && hasBoots;
                    return !(isFullSet && (effect == MobEffects.WEAKNESS || effect == MobEffects.LEVITATION));
                };
                tooltipMethod = ModItemUtils::appendTungstenCarbideEquipmentTooltip;
            }
            default -> throw new IllegalStateException("Unexpected value: " + tier);
        }
    }



    /**
     * IFullSetEffectArmor interface method that prevents an effect from being applied if a full set is worn.
     * @param effect Effect trying to be applied
     * @return Whether the effect can be applied to this armor's wearer
     */
    @Override
    public boolean canReceiveEffect(Holder<MobEffect> effect, LivingEntity wearer) {
        return canReceiveEffectMethod.test(effect, wearer);
    }

    /**
     * Appends text to the Item's hover tooltip.
     * @param stack ItemStack corresponding to this item
     * @param context Relevant TooltipContext
     * @param display TooltipDisplay corresponding to this tooltip
     * @param tooltip List of tooltip text Components to render
     * @param flag TooltipFlag determining data like simple or advanced
     */
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull TooltipDisplay display,
                                @NotNull Consumer<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltipMethod.accept(tooltip, ModItemUtils.EquipmentType.ARMOR);
    }
}
