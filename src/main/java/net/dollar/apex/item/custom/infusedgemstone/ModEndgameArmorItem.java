package net.dollar.apex.item.custom.infusedgemstone;

import net.dollar.apex.item.ModItems;
import net.dollar.apex.util.IFullSetEffectArmor;
import net.dollar.apex.util.ModItemUtils;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class ModEndgameArmorItem extends ArmorItem implements IFullSetEffectArmor {
    private final BiPredicate<Holder<MobEffect>, LivingEntity> canReceiveEffectMethod;
    private final BiConsumer<List<Component>, ModItemUtils.EquipmentType> tooltipMethod;

    public ModEndgameArmorItem(Holder<ArmorMaterial> material, Type armorType,
                               ModItemUtils.EndgameTier tier, Properties properties) {
        super(material, armorType, properties);

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
                    return !(isFullSet && (effect == MobEffects.MOVEMENT_SLOWDOWN || effect == MobEffects.DIG_SLOWDOWN));
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
     * Allow or deny specific enchantment application to this Item. For Battleaxes, allow all
     *  vanilla weapon enchantments except Sweeping Edge.
     * @param stack The ItemStack attempting to be enchanted (this)
     * @param enchantment The Enchantment attempting to be applied
     * @return Whether the enchantment is allowed
     */
    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (this.type == Type.HELMET) {
            return (enchantment == Enchantments.AQUA_AFFINITY ||
                    enchantment == Enchantments.BLAST_PROTECTION ||
                    enchantment == Enchantments.FIRE_PROTECTION ||
                    enchantment == Enchantments.PROJECTILE_PROTECTION ||
                    enchantment == Enchantments.PROTECTION ||
                    enchantment == Enchantments.RESPIRATION ||
                    enchantment == Enchantments.UNBREAKING ||
                    enchantment == Enchantments.MENDING);
        } else if (this.type == Type.CHESTPLATE) {
            return (enchantment == Enchantments.BLAST_PROTECTION ||
                    enchantment == Enchantments.FIRE_PROTECTION ||
                    enchantment == Enchantments.PROJECTILE_PROTECTION ||
                    enchantment == Enchantments.PROTECTION ||
                    enchantment == Enchantments.THORNS ||
                    enchantment == Enchantments.UNBREAKING ||
                    enchantment == Enchantments.MENDING);
        } else if (this.type == Type.LEGGINGS) {
            return (enchantment == Enchantments.BLAST_PROTECTION ||
                    enchantment == Enchantments.FIRE_PROTECTION ||
                    enchantment == Enchantments.PROJECTILE_PROTECTION ||
                    enchantment == Enchantments.PROTECTION ||
                    enchantment == Enchantments.SWIFT_SNEAK ||
                    enchantment == Enchantments.UNBREAKING ||
                    enchantment == Enchantments.MENDING);
        } else if (this.type == Type.BOOTS) {
            return (enchantment == Enchantments.BLAST_PROTECTION ||
                    enchantment == Enchantments.DEPTH_STRIDER ||
                    enchantment == Enchantments.FEATHER_FALLING ||
                    enchantment == Enchantments.FROST_WALKER ||
                    enchantment == Enchantments.FIRE_PROTECTION ||
                    enchantment == Enchantments.PROJECTILE_PROTECTION ||
                    enchantment == Enchantments.PROTECTION ||
                    enchantment == Enchantments.SOUL_SPEED ||
                    enchantment == Enchantments.UNBREAKING ||
                    enchantment == Enchantments.MENDING);
        }
        return false;   //Return false if none of the types above.
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
        tooltipMethod.accept(tooltip, ModItemUtils.EquipmentType.ARMOR);
    }
}
