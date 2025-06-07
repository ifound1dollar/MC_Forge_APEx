package net.dollar.apex.item.custom.cobaltsteel;

import net.dollar.apex.util.ModItemUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModCobaltSteelAxeItem extends AxeItem {
    public ModCobaltSteelAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
    }



//    @Override
//    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
//        // ENTRY IS THE VALUE, KEY IS THE ENCHANTMENT
//        ItemEnchantments enchantments = EnchantmentHelper.getEnchantmentsForCrafting(book);
//        for (Object2IntMap.Entry<Holder<Enchantment>> entry : enchantments.entrySet()) {
//            Holder<Enchantment> holder = entry.getKey();
//            int i2 = enchantments.getLevel(holder);
//            int j2 = entry.getIntValue();
//            Enchantment enchantment = holder.value();
////            ModMain.LOGGER.debug("can enchant: {}", enchantment.canEnchant(stack));
////            enchantment.getSupportedItems().stream().forEach((consumer) ->
////            {
////                ModMain.LOGGER.debug(consumer.getRegisteredName());
////            });
//        }
//        ModMain.LOGGER.debug("isBookEnchantable called, size: {}", enchantments.size());
//        Random random = new Random();
//        return random.nextBoolean();
//
//
//        //return super.isBookEnchantable(stack, book);
//    }

    /**
     * Performs normal post-hit operations but with chance to apply additional effect(s).
     * @param stack ItemStack of this Item
     * @param target Attacked (target) living entity
     * @param attacker Attacker (user) living entity
     */
    @Override
    public void hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        ModItemUtils.applyCobaltSteelOnHit(target);
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
        ModItemUtils.appendCobaltSteelEquipmentTooltip(tooltip, ModItemUtils.EquipmentType.TOOL);
    }
}
