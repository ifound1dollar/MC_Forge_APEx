package net.dollar.apex.item.custom.cobaltsteel;

import net.dollar.apex.item.ModItems;
import net.dollar.apex.util.IFullSetEffectArmor;
import net.dollar.apex.util.ModItemUtils;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModCobaltSteelArmorItem extends ArmorItem implements IFullSetEffectArmor {
    public ModCobaltSteelArmorItem(Holder<ArmorMaterial> material, Type type, Item.Properties properties) {
        super(material, type, properties);
    }



    /**
     * IFullSetEffectArmor interface method that prevents an effect from being applied if a full set is worn.
     * @param effect Effect trying to be applied
     * @return Whether the effect can be applied to this armor's wearer
     */
    @Override
    public boolean canReceiveEffect(Holder<MobEffect> effect, LivingEntity wearer) {
        //Can receive effect UNLESS full set and effect is slowness.
        boolean isFullSet = false;

        //Check for correct equipment, then set isFullSet accordingly
        if (wearer instanceof Player player) {
            boolean hasHelm = player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.COBALT_STEEL_HELMET.get();
            boolean hasChest = player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.COBALT_STEEL_CHESTPLATE.get();
            boolean hasLegs = player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.COBALT_STEEL_LEGGINGS.get();
            boolean hasBoots = player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.COBALT_STEEL_BOOTS.get();
            isFullSet = hasHelm && hasChest && hasLegs && hasBoots;
        }

        //ModMain.LOGGER.info("Full set: " + isFullSet + " | Effect: " + effect.getName());
        return !(isFullSet && (effect == MobEffects.WEAKNESS || effect == MobEffects.DIG_SLOWDOWN));
    }

    /**
     * Appends text to the Item's hover tooltip.
     * @param stack ItemStack corresponding to this item
     * @param context Relevant TooltipContext
     * @param tooltip List of tooltip texts to render
     * @param flag TooltipFlag determining data like simple or advanced
     */
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        ModItemUtils.appendCobaltSteelEquipmentTooltip(tooltip, ModItemUtils.EquipmentType.ARMOR);
    }
}
