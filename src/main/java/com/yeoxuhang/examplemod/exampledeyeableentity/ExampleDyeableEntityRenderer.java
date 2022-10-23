package com.yeoxuhang.examplemod.exampledeyeableentity;

import com.yeoxuhang.examplemod.ExampleMod;
import com.yeoxuhang.examplemod.exampledeyeableentity.layer.ExampleEntityColorLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExampleDyeableEntityRenderer extends MobRenderer<ExampleDyeableEntity, ExampleEntityModel<ExampleDyeableEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(ExampleMod.MOD_ID,
            "textures/entity/example_entity.png");
    public ExampleDyeableEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ExampleEntityModel<>(context.bakeLayer(ExampleEntityModel.LAYER_LOCATION)), 0.7F);
        this.addLayer(new ExampleEntityColorLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ExampleDyeableEntity entity)
    {
        return TEXTURE;
    }
}