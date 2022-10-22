package com.yeoxuhang.exampledyeableentity;

import com.yeoxuhang.exampledyeableentity.entity.ExampleDyeableEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExampleDyeableEntityModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, ExampleDyeableEntityMod.MOD_ID);

    public static final RegistryObject<EntityType<ExampleDyeableEntity>> EXAMPLE_DYEABLE_ENTITY = ENTITY_TYPES.register("example_dyeable_entity",
            () -> EntityType.Builder.of(ExampleDyeableEntity::new, MobCategory.MONSTER)
                    .sized(0.9f, 1f)
                    .build(new ResourceLocation(ExampleDyeableEntityMod.MOD_ID, "example_dyeable_entity").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
