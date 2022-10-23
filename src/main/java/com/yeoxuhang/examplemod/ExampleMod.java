package com.yeoxuhang.examplemod;

import com.yeoxuhang.examplemod.examplebiome.ExampleModBiomes;
import com.yeoxuhang.examplemod.exampledeyeableentity.ExampleDyeableEntity;
import com.yeoxuhang.examplemod.exampledeyeableentity.ExampleEntityModel;
import com.yeoxuhang.examplemod.exampledeyeableentity.ExampleDyeableEntityRenderer;
import com.yeoxuhang.examplemod.examplerightclickentitychangetexture.ExampleClickEntityModel;
import com.yeoxuhang.examplemod.examplerightclickentitychangetexture.ExampleRightClickChangeTextureEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleMod.MOD_ID)
public class ExampleMod {

    public static final String MOD_ID = "examplemod";

    public ExampleMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ExampleModEntityTypes.register(eventBus);
        ExampleModItems.register(eventBus);
        ExampleModBiomes.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::entityAttributeEvent);
        eventBus.addListener(this::registerLayers);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(ExampleModEntityTypes.EXAMPLE_DYEABLE_ENTITY.get(), ExampleDyeableEntityRenderer::new);
        EntityRenderers.register(ExampleModEntityTypes.EXAMPLE_CLICK_ENTITY.get(), ExampleRightClickChangeTextureEntityRenderer::new);
    }
    private void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ExampleEntityModel.LAYER_LOCATION, ExampleEntityModel::createBodyLayer);
        event.registerLayerDefinition(ExampleClickEntityModel.LAYER_LOCATION, ExampleClickEntityModel::createBodyLayer);
    }

    private void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ExampleModEntityTypes.EXAMPLE_DYEABLE_ENTITY.get(), ExampleDyeableEntity.setAttributes());
        event.put(ExampleModEntityTypes.EXAMPLE_CLICK_ENTITY.get(), ExampleDyeableEntity.setAttributes());
    }
}
