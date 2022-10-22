package com.yeoxuhang.exampledyeableentity.entity;

import com.yeoxuhang.exampledyeableentity.ExampleEntityMod;
import com.yeoxuhang.exampledyeableentity.entity.layer.ExampleEntityColorLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExampleDyeableEntityRenderer extends MobRenderer<ExampleDyeableEntity, ExampleEntityModel<ExampleDyeableEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(ExampleEntityMod.MOD_ID,
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