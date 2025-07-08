package net.dollar.apex.entity;

import net.dollar.apex.ModMain;
import net.dollar.apex.entity.custom.ModMysteriousSpecterEntity;
import net.dollar.apex.entity.custom.ModObsidianGolemEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Class responsible for defining and registering mob entities for this mod.
 */
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ModMain.MODID);



    public static final RegistryObject<EntityType<ModObsidianGolemEntity>> OBSIDIAN_GOLEM =
            ENTITY_TYPES.register("obsidian_golem",
                    () -> EntityType.Builder.of(ModObsidianGolemEntity::new, MobCategory.MONSTER)
                            .sized(1.4f, 2.7f)
                            .build(ResourceKey.create(Registries.ENTITY_TYPE,
                                    ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "obsidian_golem"))));
    public static final RegistryObject<EntityType<ModMysteriousSpecterEntity>> MYSTERIOUS_SPECTER =
            ENTITY_TYPES.register("mysterious_specter",
                    () -> EntityType.Builder.of(ModMysteriousSpecterEntity::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.8f)
                            .build(ResourceKey.create(Registries.ENTITY_TYPE,
                                    ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "mysterious_specter"))));



    /**
     * Register new mob entities.
     * @param eventBus Main event bus
     */
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
