package net.dollar.apex.entity;

import net.dollar.apex.ModMain;
import net.dollar.apex.entity.custom.ModMysteriousSpecterEntity;
import net.dollar.apex.entity.custom.ModObsidianGolemEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Handles registering new mob entities.
 */
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ModMain.MODID);



    public static final RegistryObject<EntityType<ModObsidianGolemEntity>> OBSIDIAN_GOLEM =
            ENTITY_TYPES.register("obsidian_golem",
                    () -> EntityType.Builder.of(ModObsidianGolemEntity::new, MobCategory.MONSTER)
                            .sized(1.67f, 3.33f)   //roughly 1.25x Iron Golem hitbox size, but narrower
                            .build(ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "obsidian_golem").toString()));
    public static final RegistryObject<EntityType<ModMysteriousSpecterEntity>> MYSTERIOUS_SPECTER =
            ENTITY_TYPES.register("mysterious_specter",
                    () -> EntityType.Builder.of(ModMysteriousSpecterEntity::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.8f)
                            .build(ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "mysterious_specter").toString()));



    /**
     * Register new mob entities.
     * @param eventBus Main event bus
     */
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
