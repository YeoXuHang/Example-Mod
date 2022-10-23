package com.yeoxuhang.examplemod.examplerightclickentitychangetexture;

import com.yeoxuhang.examplemod.ExampleMod;
import com.yeoxuhang.examplemod.exampledeyeableentity.ExampleEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExampleRightClickChangeTextureEntityRenderer extends MobRenderer<ExampleRightClickChangeTextureEntity, ExampleClickEntityModel<ExampleRightClickChangeTextureEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(ExampleMod.MOD_ID,
            "textures/entity/example_entity.png");

    protected static final ResourceLocation CLICKED = new ResourceLocation(ExampleMod.MOD_ID,
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