package net.dollar.apex.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dollar.apex.ModMain;
import net.dollar.apex.entity.custom.ModMysteriousSpecterEntity;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/**
 * CLIENT-ONLY. Handles Old Lady Muff rendering, supporting custom texture. Also implements custom render scale.
 */
@OnlyIn(Dist.CLIENT)
public class ModMysteriousSpecterEntityRenderer extends MobRenderer<ModMysteriousSpecterEntity,
        ModMysteriousSpecterRenderState, ModMysteriousSpecterModel> {
    private static final String TEXTURE_BASE = "textures/entities/mysterious_specter";

    public ModMysteriousSpecterEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ModMysteriousSpecterModel(context.bakeLayer(ModelLayers.PLAYER)), 0.6f);  //shadow radius
    }



    /**
     * Gets texture ResourceLocation defined in top of class.
     * @param renderState RenderState for the Mysterious Specter entity being rendered
     * @return Texture ResourceLocation
     */
    @Override
    public @NotNull ResourceLocation getTextureLocation(ModMysteriousSpecterRenderState renderState) {
        //Generate and return a new identifier using the TEXTURE_BASE string appended with the texture
        //  ID from the Entity instance (plus the .png extension).
        return ResourceLocation.fromNamespaceAndPath(ModMain.MODID, TEXTURE_BASE + renderState.getTextureID() + ".png");
    }

    /**
     * Sets scale of this rendered Entity.
     * @param renderState RenderState for the Mysterious Specter being rendered
     * @param poseStack PoseStack corresponding to this renderer
     */
    @Override
    protected void scale(@NotNull ModMysteriousSpecterRenderState renderState, PoseStack poseStack) {
        //scaling this will change the size of the actual model & texture
        poseStack.scale(0.9375f, 0.9375f, 0.9375f);
    }


    @Override
    public @NotNull ModMysteriousSpecterRenderState createRenderState() {
        return new ModMysteriousSpecterRenderState();
    }
}
