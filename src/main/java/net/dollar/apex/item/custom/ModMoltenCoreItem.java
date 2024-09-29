package net.dollar.apex.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModMoltenCoreItem extends Item {
    public ModMoltenCoreItem(Properties properties) {
        super(properties);
    }



    /**
     * Gets burn time of this Item in a furnace (halved for Blast Furnace and Smoker, auto calculated).
     * @param itemStack ItemStack of this Item
     * @param recipeType Relevant recipe type, Nullable
     * @return Burn time in ticks
     */
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 30000;   //25 minutes, longer than lava bucket
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
        tooltip.add(Component.translatable("tooltip.molten_core"));
    }
}
