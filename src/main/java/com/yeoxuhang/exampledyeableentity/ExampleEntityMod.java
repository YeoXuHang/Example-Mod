package com.yeoxuhang.exampledyeableentity;

import com.yeoxuhang.exampledyeableentity.entity.ExampleDyeableEntity;
import com.yeoxuhang.exampledyeableentity.entity.ExampleEntityModel;
import com.yeoxuhang.exampledyeableentity.entity.ExampleDyeableEntityRenderer;
import com.yeoxuhang.exampledyeableentity.examplerightclickentitychangetexture.ExampleClickEntityModel;
import com.yeoxuhang.exampledyeableentity.examplerightclickentitychangetexture.ExampleRightClickChangeTextureEntity;
import com.yeoxuhang.exampledyeableentity.examplerightclickentitychangetexture.ExampleRightClickChangeTextureEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleEntityMod.MOD_ID)
public class ExampleEntityMod {

    public static final String MOD_ID = "exampleentitymod";

    public ExampleEntityMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ExampleEntityModEntityTypes.register(eventBus);
        ExampleEntityModItems.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::entityAttributeEvent);
        eventBus.addListener(this::registerLayers);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(ExampleEntityModEntityTypes.EXAMPLE_DYEABLE_ENTITY.get(), ExampleDyeableEntityRenderer::new);
        EntityRenderers.register(ExampleEntityModEntityTypes.EXAMPLE_CLICK_ENTITY.get(), ExampleRightClickChangeTextureEntityRenderer::new);
    }
    private void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ExampleEntityModel.LAYER_LOCATION, ExampleEntityModel::createBodyLayer);
        event.registerLayerDefinition(ExampleClickEntityModel.LAYER_LOCATION, ExampleClickEntityModel::createBodyLayer);
    }

    private void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ExampleEntityModEntityTypes.EXAMPLE_DYEABLE_ENTITY.get(), ExampleDyeableEntity.setAttributes());
        event.put(ExampleEntityModEntityTypes.EXAMPLE_CLICK_ENTITY.get(), ExampleDyeableEntity.setAttributes());
    }
}
