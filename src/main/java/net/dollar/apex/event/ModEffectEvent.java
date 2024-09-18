package net.dollar.apex.event;

import net.dollar.apex.ModMain;
import net.dollar.apex.util.IFullSetEffectArmor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEffectEvent {
    /**
     * Intercepts the MobEffectEvent.Applicable event to allow or deny MobEffect application.
     * @param event The fired MobEffectEvent.Applicable event
     */
    @SubscribeEvent
    public static void eventEntityCanBeAffected(MobEffectEvent.Applicable event) {
        //If the LivingEntity's worn chestplate is an IFullSetEffectArmor item, call its canReceiveEffect
        //  method to check whether this effect can be applied. Returns false if the LivingEntity is
        //  wearing a full set and the effect is one of the effects that the full set is immune to.
        if (event.getEntity().getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof IFullSetEffectArmor armor) {
            boolean result = armor.canReceiveEffect(event.getEffectInstance().getEffect(), event.getEntity());

            //TEMP
            ModMain.LOGGER.info("Can receive effect status: {}", result);
            //TEMP

            //If the LivingEntity cannot receive effect, DENY event. Otherwise, leave default.
            if (!result) {
                event.setResult(Event.Result.DENY);
            }
        }
    }
}
