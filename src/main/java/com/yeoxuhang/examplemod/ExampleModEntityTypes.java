package com.yeoxuhang.examplemod;

import com.yeoxuhang.examplemod.exampledeyeableentity.ExampleDyeableEntity;
import com.yeoxuhang.examplemod.examplerightclickentitychangetexture.ExampleRightClickChangeTextureEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExampleModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, ExampleMod.MOD_ID);

    public static final RegistryObject<EntityType<ExampleDyeableEntity>> EXAMPLE_DYEABLE_ENTITY = ENTITY_TYPES.register("example_dyeable_entity",
            () -> EntityType.Builder.of(ExampleDyeableEntity::new, MobCategory.MONSTER)
                    .sized(0.9f, 1f)
                    .build(new ResourceLocation(ExampleMod.MOD_ID, "example_dyeable_entity").toString()));

    public static final RegistryObject<EntityType<ExampleRightClickChangeTextureEntity>> EXAMPLE_CLICK_ENTITY = ENTITY_TYPES.register("example_click_entity",
            () -> EntityType.Builder.of(ExampleRightClickChangeTextureEntity::new, MobCategory.MONSTER)
                    .sized(0.9f, 1f)
                    .build(new ResourceLocation(ExampleMod.MOD_ID, "example_click_entity").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
