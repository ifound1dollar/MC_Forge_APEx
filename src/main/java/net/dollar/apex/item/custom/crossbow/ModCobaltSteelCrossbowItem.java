package net.dollar.apex.item.custom.crossbow;

import net.dollar.apex.util.ModArrowUtil;
import net.dollar.apex.util.ModItemUtils;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Corresponds specifically to the Steel Crossbow item. Re-implements NUMEROUS methods from CrossbowItem
 *  which are private and must be entirely re-defined. All redundant override methods are removed.
 */
public class ModCobaltSteelCrossbowItem extends CrossbowItem {
    public ModCobaltSteelCrossbowItem(Item.Properties properties) {
        super(properties);
    }



    //EVERYTHING BELOW IS EXACTLY COPY-PASTED EXCEPT FOR THE getArrow() and appendHoverText() METHODS. THE
    //  ONLY ALTERED CODE IS DIRECTLY COMMENTED. ANY UNUSED FIELDS WERE REMOVED, AS WERE UNCHANGED OVERRIDES.
    private boolean startSoundPlayed = false;
    private boolean midLoadSoundPlayed = false;



    public InteractionResultHolder<ItemStack> use(Level p_40920_, Player p_40921_, InteractionHand p_40922_) {
        ItemStack itemstack = p_40921_.getItemInHand(p_40922_);
        ChargedProjectiles chargedprojectiles = itemstack.get(DataComponents.CHARGED_PROJECTILES);
        if (chargedprojectiles != null && !chargedprojectiles.isEmpty()) {
            this.performShooting(p_40920_, p_40921_, p_40922_, itemstack, getShootingPower(chargedprojectiles), 1.0F, null);
            return InteractionResultHolder.consume(itemstack);
        } else if (!p_40921_.getProjectile(itemstack).isEmpty()) {
            this.startSoundPlayed = false;
            this.midLoadSoundPlayed = false;
            p_40921_.startUsingItem(p_40922_);
            return InteractionResultHolder.consume(itemstack);
        } else {
            return InteractionResultHolder.fail(itemstack);
        }
    }

    private static float getShootingPower(ChargedProjectiles p_331334_) {
        return p_331334_.contains(Items.FIREWORK_ROCKET) ? 1.6F : 3.15F;
    }

    public void releaseUsing(ItemStack p_40875_, Level p_40876_, LivingEntity p_40877_, int p_40878_) {
        int i = this.getUseDuration(p_40875_) - p_40878_;
        float f = getPowerForTime(i, p_40875_);
        if (f >= 1.0F && !isCharged(p_40875_) && tryLoadProjectiles(p_40877_, p_40875_)) {
            p_40876_.playSound(null, p_40877_.getX(), p_40877_.getY(), p_40877_.getZ(), SoundEvents.CROSSBOW_LOADING_END, p_40877_.getSoundSource(), 1.0F, 1.0F / (p_40876_.getRandom().nextFloat() * 0.5F + 1.0F) + 0.2F);
        }

    }

    private static boolean tryLoadProjectiles(LivingEntity p_40860_, ItemStack p_40861_) {
        List<ItemStack> list = draw(p_40861_, p_40860_.getProjectile(p_40861_), p_40860_);
        if (!list.isEmpty()) {
            p_40861_.set(DataComponents.CHARGED_PROJECTILES, ChargedProjectiles.of(list));
            return true;
        } else {
            return false;
        }
    }

    public static boolean isCharged(ItemStack p_40933_) {
        ChargedProjectiles chargedprojectiles = p_40933_.getOrDefault(DataComponents.CHARGED_PROJECTILES, ChargedProjectiles.EMPTY);
        return !chargedprojectiles.isEmpty();
    }

    protected void shootProjectile(LivingEntity p_40896_, Projectile p_335393_, int p_333089_, float p_40900_, float p_40902_, float p_40903_, @javax.annotation.Nullable LivingEntity p_328705_) {
        Vector3f vector3f;
        if (p_328705_ != null) {
            double d0 = p_328705_.getX() - p_40896_.getX();
            double d1 = p_328705_.getZ() - p_40896_.getZ();
            double d2 = Math.sqrt(d0 * d0 + d1 * d1);
            double d3 = p_328705_.getY(0.3333333333333333) - p_335393_.getY() + d2 * 0.20000000298023224;
            vector3f = getProjectileShotVector(p_40896_, new Vec3(d0, d3, d1), p_40903_);
        } else {
            Vec3 vec3 = p_40896_.getUpVector(1.0F);
            Quaternionf quaternionf = (new Quaternionf()).setAngleAxis(p_40903_ * 0.017453292F, vec3.x, vec3.y, vec3.z);
            Vec3 vec31 = p_40896_.getViewVector(1.0F);
            vector3f = vec31.toVector3f().rotate(quaternionf);
        }

        p_335393_.shoot(vector3f.x(), vector3f.y(), vector3f.z(), p_40900_, p_40902_);
        float f = getShotPitch(p_40896_.getRandom(), p_333089_);
        p_40896_.level().playSound(null, p_40896_.getX(), p_40896_.getY(), p_40896_.getZ(), SoundEvents.CROSSBOW_SHOOT, p_40896_.getSoundSource(), 1.0F, f);
    }

    private static Vector3f getProjectileShotVector(LivingEntity p_333832_, Vec3 p_332433_, float p_331595_) {
        Vector3f vector3f = p_332433_.toVector3f().normalize();
        Vector3f vector3f1 = (new Vector3f(vector3f)).cross(new Vector3f(0.0F, 1.0F, 0.0F));
        if ((double)vector3f1.lengthSquared() <= 1.0E-7) {
            Vec3 vec3 = p_333832_.getUpVector(1.0F);
            vector3f1 = (new Vector3f(vector3f)).cross(vec3.toVector3f());
        }

        Vector3f vector3f2 = (new Vector3f(vector3f)).rotateAxis(1.5707964F, vector3f1.x, vector3f1.y, vector3f1.z);
        return (new Vector3f(vector3f)).rotateAxis(p_331595_ * 0.017453292F, vector3f2.x, vector3f2.y, vector3f2.z);
    }

    protected Projectile createProjectile(Level level, LivingEntity livingEntity, ItemStack weaponStack, ItemStack arrowStack, boolean crit) {
        if (arrowStack.is(Items.FIREWORK_ROCKET)) {
            return new FireworkRocketEntity(level, arrowStack, livingEntity, livingEntity.getX(), livingEntity.getEyeY() - 0.15000000596046448, livingEntity.getZ(), true);
        } else {
            //OVERRIDE HERE. Uses custom ModArrowUtil class function to generate a custom arrow entity.
            AbstractArrow abstractarrow = ModArrowUtil.createCustomArrow(level, livingEntity, arrowStack,
                    ModArrowUtil.ARROW_TYPE.COBALT);

            abstractarrow.setShotFromCrossbow(true);    //AFAIK this guarantees crit
            abstractarrow.setSoundEvent(SoundEvents.CROSSBOW_HIT);

            return abstractarrow;
        }
    }

    protected int getDurabilityUse(ItemStack p_335533_) {
        return p_335533_.is(Items.FIREWORK_ROCKET) ? 3 : 1;
    }

    public void performShooting(Level p_40888_, LivingEntity p_40889_, InteractionHand p_40890_, ItemStack p_40891_, float p_40892_, float p_40893_, @Nullable LivingEntity p_329478_) {
        if (!p_40888_.isClientSide()) {
            if (p_40889_ instanceof Player player) {
                if (ForgeEventFactory.onArrowLoose(p_40891_, p_40889_.level(), player, 1, true) < 0) {
                    return;
                }
            }

            ChargedProjectiles chargedprojectiles = p_40891_.set(DataComponents.CHARGED_PROJECTILES, ChargedProjectiles.EMPTY);
            if (chargedprojectiles != null && !chargedprojectiles.isEmpty()) {
                this.shoot(p_40888_, p_40889_, p_40890_, p_40891_, chargedprojectiles.getItems(), p_40892_, p_40893_, p_40889_ instanceof Player, p_329478_);
                if (p_40889_ instanceof ServerPlayer serverplayer) {
                    CriteriaTriggers.SHOT_CROSSBOW.trigger(serverplayer, p_40891_);
                    serverplayer.awardStat(Stats.ITEM_USED.get(p_40891_.getItem()));
                }
            }
        }

    }

    private static float getShotPitch(RandomSource p_335611_, int p_331713_) {
        return p_331713_ == 0 ? 1.0F : getRandomShotPitch((p_331713_ & 1) == 1, p_335611_);
    }

    private static float getRandomShotPitch(boolean p_220026_, RandomSource p_220027_) {
        float f = p_220026_ ? 0.63F : 0.43F;
        return 1.0F / (p_220027_.nextFloat() * 0.5F + 1.8F) + f;
    }

    public void onUseTick(Level p_40910_, LivingEntity p_40911_, ItemStack p_40912_, int p_40913_) {
        if (!p_40910_.isClientSide) {
            int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, p_40912_);
            SoundEvent soundevent = this.getStartSound(i);
            SoundEvent soundevent1 = i == 0 ? SoundEvents.CROSSBOW_LOADING_MIDDLE : null;
            float f = (float)(p_40912_.getUseDuration() - p_40913_) / (float)getChargeDuration(p_40912_);
            if (f < 0.2F) {
                this.startSoundPlayed = false;
                this.midLoadSoundPlayed = false;
            }

            if (f >= 0.2F && !this.startSoundPlayed) {
                this.startSoundPlayed = true;
                p_40910_.playSound(null, p_40911_.getX(), p_40911_.getY(), p_40911_.getZ(), soundevent, SoundSource.PLAYERS, 0.5F, 1.0F);
            }

            if (f >= 0.5F && soundevent1 != null && !this.midLoadSoundPlayed) {
                this.midLoadSoundPlayed = true;
                p_40910_.playSound(null, p_40911_.getX(), p_40911_.getY(), p_40911_.getZ(), soundevent1, SoundSource.PLAYERS, 0.5F, 1.0F);
            }
        }

    }

    public int getUseDuration(ItemStack p_40938_) {
        return getChargeDuration(p_40938_) + 3;
    }

    public static int getChargeDuration(ItemStack p_40940_) {
        int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, p_40940_);
        return i == 0 ? 25 : 25 - 5 * i;
    }

    private SoundEvent getStartSound(int p_40852_) {
        switch (p_40852_) {
            case 1 -> {
                return SoundEvents.CROSSBOW_QUICK_CHARGE_1;
            }
            case 2 -> {
                return SoundEvents.CROSSBOW_QUICK_CHARGE_2;
            }
            case 3 -> {
                return SoundEvents.CROSSBOW_QUICK_CHARGE_3;
            }
            default -> {
                return SoundEvents.CROSSBOW_LOADING_START;
            }
        }
    }

    private static float getPowerForTime(int p_40854_, ItemStack p_40855_) {
        float f = (float)p_40854_ / (float)getChargeDuration(p_40855_);
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    public boolean useOnRelease(ItemStack p_150801_) {
        return p_150801_.is(this);
    }

    public int getDefaultProjectileRange() {
        return 8;
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
