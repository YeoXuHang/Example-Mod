package com.yeoxuhang.exampledyeableentity.entity;

import com.yeoxuhang.exampledyeableentity.ExampleDyeableEntityMod;
import com.yeoxuhang.exampledyeableentity.entity.layer.ExampleEntityColorLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExampleEntityRenderer extends MobRenderer<ExampleDyeableEntity, ExampleEntityModel<ExampleDyeableEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(ExampleDyeableEntityMod.MOD_ID,
            "textures/entity/example_entity.png");
    public ExampleEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ExampleEntityModel<>(context.bakeLayer(ExampleEntityModel.LAYER_LOCATION)), 0.7F);
        this.addLayer(new ExampleEntityColorLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ExampleDyeableEntity entity)
    {
        return TEXTURE;
    }
}