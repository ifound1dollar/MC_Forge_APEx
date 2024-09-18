package net.dollar.apex.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModCustomItem extends Item {
    private final String tooltipLang;
    private final boolean hasGlint;



    /**
     * Creates a custom Item instance with Properties (as usual), but with extra parameters for
     *  common data like custom tooltip and whether it has enchantment glint.
     * @param properties Properties for this Item
     * @param tooltipLang String pointing to the lang file entry for this Item's custom tooltip
     * @param hasGlint Whether this item has enchantment glint
     */
    public ModCustomItem(Properties properties, String tooltipLang, boolean hasGlint) {
        super(properties);
        this.tooltipLang = tooltipLang;
        this.hasGlint = hasGlint;
    }



    /**
     * Gets whether this Item should render with enchantment glint (true).
     * @param stack ItemStack of this Item
     * @return Whether this item has enchantment glint
     */
    @Override
    public boolean isFoil(ItemStack stack) {
        return hasGlint;
    }

    /**
     * Appends text to the Item's hover tooltip.
     * @param stack ItemStack corresponding to this item
     * @param level Relevant level
     * @param tooltip List of tooltip texts to render
     * @param flag TooltipFlag determining data like simple or advanced
     */
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, List<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltip.add(Component.translatable(tooltipLang));
    }
}
