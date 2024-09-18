package net.dollar.apex.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

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
}
