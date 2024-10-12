package net.dollar.apex.item.custom.crossbow;

import net.dollar.apex.util.ModArrowUtil;
import net.dollar.apex.util.ModItemUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Corresponds specifically to the Steel Crossbow item. Re-implements NUMEROUS methods from CrossbowItem
 *  which are private and must be entirely re-defined. All redundant override methods are removed.
 */
public class ModCobaltSteelCrossbowItem extends CrossbowItem {
    public ModCobaltSteelCrossbowItem(Item.Properties properties) {
        super(properties);
    }



    //ONLY OVERRIDDEN METHODS ARE createProjectile() and appendHoverText(). Minecraft 1.20.5 largely fixed Crossbow
    //  implementation so the base methods do exactly what they need to. The customArrowEntity() method below
    //  is a new method that actually spawns the Entity by calling ArrowUtil.createCustomArrow().

    /**
     * Creates the projectile fired from this Crossbow. Is overridden here to create custom arrow.
     * @param level Active Level
     * @param livingEntity Shooter LivingEntity
     * @param weaponStack ItemStack corresponding to this weapon
     * @param arrowStack ItemStack corresponding to the arrow to be fired
     * @param crit Whether the arrow will critically strike
     * @return The generated Projectile entity
     */
    protected Projectile createProjectile(Level level, LivingEntity livingEntity, ItemStack weaponStack, ItemStack arrowStack, boolean crit) {
        if (arrowStack.is(Items.FIREWORK_ROCKET)) {
            return new FireworkRocketEntity(level, arrowStack, livingEntity, livingEntity.getX(), livingEntity.getEyeY() - 0.15000000596046448, livingEntity.getZ(), true);
        } else {
            //Vanilla functionality overridden only in next line.
            Projectile projectile = customArrowEntity(level, livingEntity, arrowStack, weaponStack, crit);

            if (projectile instanceof AbstractArrow abstractarrow) {
                abstractarrow.setSoundEvent(SoundEvents.CROSSBOW_HIT);
            }

            return projectile;
        }
    }

    /**
     * Creates a custom arrow Entity using ArrowUtil that effectively replaces the method in RangedWeaponItem.
     * @param level Active world
     * @param entity LivingEntity firing the Crossbow
     * @param projectileStack ItemStack corresponding to the projectile being fired
     * @param critical Whether the arrow will be critical
     * @return The generated custom PersistentProjectileEntity
     */
    private static AbstractArrow customArrowEntity(Level level, LivingEntity entity, ItemStack projectileStack,
                                                   ItemStack weaponStack, boolean critical) {
        //Replace vanilla functionality to get the ArrowItem from the found ItemStack with this function. Will
        //  automatically handle Spectral Arrow and Tipped Arrow functionality in-method.
        AbstractArrow abstractArrow = ModArrowUtil.createCustomArrow(level, entity,
                projectileStack, weaponStack, ModArrowUtil.ARROW_TYPE.COBALT);

        //Remainder of original function (with arrow creation omitted) is below.
        if (critical) {
            abstractArrow.setCritArrow(true);
        }

        return abstractArrow;
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
        ModItemUtils.appendCobaltSteelEquipmentTooltip(tooltip, ModItemUtils.EquipmentType.RANGED);

        //Call super function AFTER because it has return statement if not charged.
        super.appendHoverText(stack, context, tooltip, flag);
    }
}
