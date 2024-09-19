package net.dollar.apex.event;

import net.dollar.apex.ModMain;
import net.dollar.apex.util.IFullSetEffectArmor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModLivingEntityEvents {
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

//    @SubscribeEvent
//    public static void eventEntityEquipmentChange(LivingEquipmentChangeEvent event) {
//        //If the changed slot is armor, check if the chest item is an IFullSetEffectArmor item and
//        //  if the wearer is now wearing a full set that is immune to a specific effect. If so,
//        //  remove the now invalid effect immediately.
//        LivingEntity entity = event.getEntity();
//        EquipmentSlot slot = event.getSlot();
//        if (!(slot == EquipmentSlot.HEAD || slot == EquipmentSlot.CHEST
//                || slot == EquipmentSlot.LEGS || slot == EquipmentSlot.FEET)) {
//            return;
//        }
//
//        if (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof IFullSetEffectArmor armor) {
//
//        }
//    }
}
