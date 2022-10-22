package com.yeoxuhang.exampledyeableentity;

import com.yeoxuhang.exampledyeableentity.entity.ExampleDyeableEntity;
import com.yeoxuhang.exampledyeableentity.entity.ExampleEntityModel;
import com.yeoxuhang.exampledyeableentity.entity.ExampleEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleDyeableEntityMod.MOD_ID)
public class ExampleDyeableEntityMod {

    public static final String MOD_ID = "exampledyeableentity";

    public ExampleDyeableEntityMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ExampleDyeableEntityModEntityTypes.register(eventBus);
        ExampleDyeableEntityModItems.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::entityAttributeEvent);
        eventBus.addListener(this::registerLayers);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(ExampleDyeableEntityModEntityTypes.EXAMPLE_DYEABLE_ENTITY.get(), ExampleEntityRenderer::new);
    }
    private void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ExampleEntityModel.LAYER_LOCATION, ExampleEntityModel::createBodyLayer);
    }

    private void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ExampleDyeableEntityModEntityTypes.EXAMPLE_DYEABLE_ENTITY.get(), ExampleDyeableEntity.setAttributes());
    }
}
