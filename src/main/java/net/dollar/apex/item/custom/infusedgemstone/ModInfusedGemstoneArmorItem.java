package net.dollar.apex.item.custom.infusedgemstone;

import net.dollar.apex.item.ModItems;
import net.dollar.apex.util.IFullSetEffectArmor;
import net.dollar.apex.util.ModItemUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModInfusedGemstoneArmorItem extends ArmorItem implements IFullSetEffectArmor {
    public ModInfusedGemstoneArmorItem(ArmorMaterial material, Type type, Item.Properties properties) {
        super(material, type, properties);
    }



    /**
     * IFullSetEffectArmor interface method that prevents an effect from being applied if a full set is worn.
     * @param effect Effect trying to be applied
     * @return Whether the effect can be applied to this armor's wearer
     */
    @Override
    public boolean canReceiveEffect(MobEffect effect, LivingEntity wearer) {
        //Can receive effect UNLESS full set and effect is wither.
        boolean isFullSet = false;

        //Check for correct equipment, then set isFullSet accordingly
        if (wearer instanceof Player player) {
            boolean hasHelm = player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.INFUSED_GEMSTONE_HELMET.get();
            boolean hasChest = player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.INFUSED_GEMSTONE_CHESTPLATE.get();
            boolean hasLegs = player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.INFUSED_GEMSTONE_LEGGINGS.get();
            boolean hasBoots = player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.INFUSED_GEMSTONE_BOOTS.get();
            isFullSet = hasHelm && hasChest && hasLegs && hasBoots;
        }

        return !(isFullSet && (effect == MobEffects.WITHER || effect == MobEffects.POISON));
    }



    /**
     * Appends text to the Item's hover tooltip.
     * @param stack ItemStack corresponding to this item
     * @param level Relevant level
     * @param tooltip List of tooltip texts to render
     * @param flag TooltipFlag determining data like simple or advanced
     */
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        ModItemUtils.appendInfusedGemstoneEquipmentTooltip(tooltip, ModItemUtils.EquipmentType.ARMOR);
    }
}
