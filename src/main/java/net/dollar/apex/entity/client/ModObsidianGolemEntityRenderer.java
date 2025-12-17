package net.dollar.apex.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.dollar.apex.ModMain;
import net.dollar.apex.entity.custom.ModObsidianGolemEntity;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/**
 * CLIENT-ONLY. Handles Old Lady Muff rendering, supporting custom texture. Also implements custom render scale.
 */
@OnlyIn(Dist.CLIENT)
public class ModObsidianGolemEntityRenderer extends MobRenderer<@NotNull ModObsidianGolemEntity,
        @NotNull ModObsidianGolemRenderState, @NotNull ModObsidianGolemModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(
            ModMain.MODID, "textures/entity/obsidian_golem.png");

    public ModObsidianGolemEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ModObsidianGolemModel(context.bakeLayer(ModelLayers.IRON_GOLEM)), 0.7f);  //shadow radius
        this.addLayer(new ModObsidianGolemCrackLayer(this));    //add custom crackiness layer
    }



    /**
     * Gets texture Identifier defined in top of class.
     * @param renderState RenderState for the Obsidian Golem being rendered
     * @return Texture Identifier
     */
    @Override
    public @NotNull Identifier getTextureLocation(@NotNull ModObsidianGolemRenderState renderState) {
        return TEXTURE;
    }

    /**
     * Sets scale of this rendered Entity.
     * @param renderState RenderState for the Obsidian Golem being rendered
     * @param poseStack PoseStack corresponding to this renderer
     */
    @Override
    protected void scale(@NotNull ModObsidianGolemRenderState renderState, PoseStack poseStack) {
        poseStack.scale(1.25f, 1.25f, 1.25f);
    }



    public @NotNull ModObsidianGolemRenderState createRenderState() {
        return new ModObsidianGolemRenderState();
    }

    public void extractRenderState(@NotNull ModObsidianGolemEntity entity, @NotNull ModObsidianGolemRenderState renderState, float p_363302_) {
        super.extractRenderState(entity, renderState, p_363302_);
        renderState.attackTicksRemaining = (float) entity.getAttackAnimationTick() > 0.0F ? (float) entity.getAttackAnimationTick() - p_363302_ : 0.0F;
        renderState.crackiness = entity.getCrackiness();
    }

    protected void setupRotations(@NotNull ModObsidianGolemRenderState renderState, @NotNull PoseStack poseStack, float p_115016_, float p_115017_) {
        super.setupRotations(renderState, poseStack, p_115016_, p_115017_);
        if (!((double) renderState.walkAnimationSpeed < 0.01)) {
            float $$4 = 13.0F;
            float $$5 = renderState.walkAnimationPos + 6.0F;
            float $$6 = (Math.abs($$5 % 13.0F - 6.5F) - 3.25F) / 3.25F;
            poseStack.mulPose(Axis.ZP.rotationDegrees(6.5F * $$6));
        }
    }
}
