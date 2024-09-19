package net.dollar.apex.entities;

import net.dollar.apex.ModMain;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Handles registering new mob entities.
 */
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ModMain.MODID);



//    public static final RegistryObject<EntityType<ObsidianGolemEntity>> OBSIDIAN_GOLEM =
//            ENTITY_TYPES.register("obsidian_golem",
//                    () -> EntityType.Builder.of(ObsidianGolemEntity::new, MobCategory.MONSTER)
//                            .fireImmune()
//                            .sized(1.67f, 3.33f)   //roughly 1.25x Iron Golem hitbox size, but narrower
//                            .build(new ResourceLocation(SimpleGearingExpansion.MOD_ID + "obsidian_golem").toString()));
    //TODO: Mysterious Specter



    /**
     * Register new mob entities.
     * @param eventBus Main event bus
     */
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
