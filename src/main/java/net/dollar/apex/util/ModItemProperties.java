package net.dollar.apex.util;

import net.dollar.apex.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ChargedProjectiles;

/**
 * Handles custom ItemProperties, used by Bows and Crossbows for client-side rendering.
 */
public class ModItemProperties {
    /**
     * Generates client-side Item Properties for custom items (new Bows and Crossbows).
     */
    public static void addCustomItemProperties() {
        makeBowItemProperties(ModItems.COBALT_STEEL_BOW.get());
        makeBowItemProperties(ModItems.INFUSED_GEMSTONE_BOW.get());
        makeBowItemProperties(ModItems.TUNGSTEN_CARBIDE_BOW.get());
        makeCrossbowItemProperties(ModItems.COBALT_STEEL_CROSSBOW.get());
        makeCrossbowItemProperties(ModItems.INFUSED_GEMSTONE_CROSSBOW.get());
        makeCrossbowItemProperties(ModItems.TUNGSTEN_CARBIDE_CROSSBOW.get());
    }

    /**
     * Creates ItemProperties for pull and pulling for Bow Items. Bows cannot alter draw duration easily
     *  in-class like Crossbows, and thus the pull duration must be manually implemented in this method.
     * @param item The corresponding Bow Item
     */
    private static void makeBowItemProperties(Item item) {
        ItemProperties.register(item, new ResourceLocation("pull"), (itemStack, level, userEntity, anInteger) -> {
            if (userEntity == null) {
                return 0.0f;
            } else {
                return userEntity.getUseItem() != itemStack ?
                        0.0f : (float)(itemStack.getUseDuration() - userEntity.getUseItemRemainingTicks()) / 20.0f;
            }
        });

        ItemProperties.register(item, new ResourceLocation("pulling"),
                (itemStack, level, userEntity, anInteger) ->
                        userEntity != null && userEntity.isUsingItem() && userEntity.getUseItem() == itemStack ?
                                1.0f : 0.0f);
    }

    /**
     * Creates ItemProperties for pull, pulling, charged, and firework for a Crossbow Item. Crossbows implement
     *  charge duration directly in the class, but a custom ModUtils function is required to get each individual
     *  charge duration in ticks.
     * @param item The corresponding Crossbow Item
     */
    private static void makeCrossbowItemProperties(Item item) {
        ItemProperties.register(item, new ResourceLocation("pull"), (itemStack, level, userEntity, anInteger) -> {
            if (userEntity == null) {
                return 0.0F;
            } else {
                return CrossbowItem.isCharged(itemStack) ? 0.0F :
                        (float)(itemStack.getUseDuration() - userEntity.getUseItemRemainingTicks())
                                / CrossbowItem.getChargeDuration(itemStack);
            }
        });

        ItemProperties.register(item, new ResourceLocation("pulling"),
                (itemStack, level, userEntity, anInteger) ->
                        userEntity != null && userEntity.isUsingItem() && userEntity.getUseItem() == itemStack
                                && !CrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F);

        ItemProperties.register(item, new ResourceLocation("charged"),
                (itemStack, level, userEntity, anInteger) ->
                        CrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F);

        ItemProperties.register(item, new ResourceLocation("firework"),
                (itemStack, level, userEntity, anInteger) -> {
                    ChargedProjectiles chargedprojectiles = itemStack.get(DataComponents.CHARGED_PROJECTILES);
                    return chargedprojectiles != null && chargedprojectiles.contains(Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
        });
    }
}
