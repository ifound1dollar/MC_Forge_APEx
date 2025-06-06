package net.dollar.apex.item.custom.tungstencarbide;

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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModTungstenCarbideArmorItem extends Item implements IFullSetEffectArmor {
    public ModTungstenCarbideArmorItem(ArmorMaterial material, ArmorType type, Properties properties) {
        super(properties
                .humanoidArmor(material, type));
    }



    /**
     * IFullSetEffectArmor interface method that prevents an effect from being applied if a full set is worn.
     * @param effect Effect trying to be applied
     * @return Whether the effect can be applied to this armor's wearer
     */
    @Override
    public boolean canReceiveEffect(Holder<MobEffect> effect, LivingEntity wearer) {
        //Can receive effect UNLESS full set and effect is weakness.
        boolean isFullSet = false;

        //Check for correct equipment, then set isFullSet accordingly
        if (wearer instanceof Player player) {
            boolean hasHelm = player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.TUNGSTEN_CARBIDE_HELMET.get();
            boolean hasChest = player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.TUNGSTEN_CARBIDE_CHESTPLATE.get();
            boolean hasLegs = player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.TUNGSTEN_CARBIDE_LEGGINGS.get();
            boolean hasBoots = player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.TUNGSTEN_CARBIDE_BOOTS.get();
            isFullSet = hasHelm && hasChest && hasLegs && hasBoots;
        }

        return !(isFullSet && (effect == MobEffects.SLOWNESS || effect == MobEffects.LEVITATION));
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
        ModItemUtils.appendTungstenCarbideEquipmentTooltip(tooltip, ModItemUtils.EquipmentType.ARMOR);
    }
}
