package com.rumaruka.lightningcraft.client.render.tesr;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.rumaruka.lightningcraft.LightningCraft;
import com.rumaruka.lightningcraft.common.tiles.TileLightningInfuser;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import ru.timeconqueror.timecore.client.render.model.TimeModel;
import ru.timeconqueror.timecore.client.render.model.TimeModelLoader;

public class TesrInfuser extends TileEntityRenderer<TileLightningInfuser> {

    private static final TimeModel model = TimeModelLoader.loadJsonModel(LightningCraft.rl("model/tile/infuser.json"), RenderType::entityCutout);

    public TesrInfuser(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(TileLightningInfuser tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        IVertexBuilder builder = bufferIn.getBuffer(model.renderType(LightningCraft.rl("textures/block/infuser.png")));


        matrixStackIn.pushPose();

        matrixStackIn.translate(0.5F, 0, 0.5F);

        matrixStackIn.scale(-1, -1, 1);




        model.renderToBuffer(matrixStackIn, builder, combinedLightIn, combinedOverlayIn, 1, 1, 1, 1);

        matrixStackIn.popPose();
    }
}
