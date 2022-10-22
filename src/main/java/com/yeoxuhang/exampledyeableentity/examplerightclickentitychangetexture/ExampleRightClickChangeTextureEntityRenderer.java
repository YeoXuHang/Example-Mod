package com.yeoxuhang.exampledyeableentity.examplerightclickentitychangetexture;

import com.yeoxuhang.exampledyeableentity.ExampleEntityMod;
import com.yeoxuhang.exampledyeableentity.entity.ExampleDyeableEntity;
import com.yeoxuhang.exampledyeableentity.entity.ExampleEntityModel;
import com.yeoxuhang.exampledyeableentity.entity.layer.ExampleEntityColorLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExampleRightClickChangeTextureEntityRenderer extends MobRenderer<ExampleRightClickChangeTextureEntity, ExampleClickEntityModel<ExampleRightClickChangeTextureEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(ExampleEntityMod.MOD_ID,
            "textures/entity/example_entity.png");

    protected static final ResourceLocation CLICKED = new ResourceLocation(ExampleEntityMod.MOD_ID,
            "textures/entity/example_entity_clicked.png");
    public ExampleRightClickChangeTextureEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ExampleClickEntityModel<>(context.bakeLayer(ExampleEntityModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(ExampleRightClickChangeTextureEntity entity)
    {
        if (entity.isClicked()) {
            return CLICKED;
        }
        return TEXTURE;
    }
}