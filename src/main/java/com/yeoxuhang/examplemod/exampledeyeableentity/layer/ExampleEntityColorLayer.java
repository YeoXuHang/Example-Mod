package com.yeoxuhang.examplemod.exampledeyeableentity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.yeoxuhang.examplemod.ExampleMod;
import com.yeoxuhang.examplemod.exampledeyeableentity.ExampleDyeableEntity;
import com.yeoxuhang.examplemod.exampledeyeableentity.ExampleEntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class ExampleEntityColorLayer extends RenderLayer<ExampleDyeableEntity, ExampleEntityModel<ExampleDyeableEntity>> {
    private static final ResourceLocation WOLF_COLLAR_LOCATION = new ResourceLocation(ExampleMod.MOD_ID ,"textures/entity/example_entity.png");

    public ExampleEntityColorLayer(RenderLayerParent<ExampleDyeableEntity, ExampleEntityModel<ExampleDyeableEntity>> p_117707_) {
        super(p_117707_);
    }

    public void render(PoseStack p_117720_, MultiBufferSource p_117721_, int p_117722_, ExampleDyeableEntity p_117723_, float p_117724_, float p_117725_, float p_117726_, float p_117727_, float p_117728_, float p_117729_) {
            float[] afloat = p_117723_.getCollarColor().getTextureDiffuseColors();
            renderColoredCutoutModel(this.getParentModel(), WOLF_COLLAR_LOCATION, p_117720_, p_117721_, p_117722_, p_117723_, afloat[0], afloat[1], afloat[2]);
    }
}
