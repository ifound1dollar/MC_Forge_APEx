package net.dollar.apex.entity.client;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import net.dollar.apex.ModMain;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Crackiness;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * CLIENT-ONLY. Handles Crackiness layer applied to ModObsidianGolemEntityRenderer.
 */
@OnlyIn(Dist.CLIENT)
public class ModObsidianGolemCrackLayer extends RenderLayer<ModObsidianGolemRenderState, ModObsidianGolemModel> {
    private static final Map<Crackiness.Level, ResourceLocation> resourceLocations = ImmutableMap.of(
            Crackiness.Level.LOW, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "textures/entities/obsidian_golem_crackiness_low.png"),
            Crackiness.Level.MEDIUM, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "textures/entities/obsidian_golem_crackiness_medium.png"),
            Crackiness.Level.HIGH, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "textures/entities/obsidian_golem_crackiness_high.png"));

    public ModObsidianGolemCrackLayer(RenderLayerParent<ModObsidianGolemRenderState,
            ModObsidianGolemModel> parent) {
        super(parent);
    }



    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource source, int p_117150_,
                       ModObsidianGolemRenderState renderState, float limbAngle, float limbDistance) {
        if (!renderState.isInvisible) {
            Crackiness.Level crackLevel = renderState.crackiness;
            if (crackLevel != Crackiness.Level.NONE) {
                ResourceLocation resourcelocation = resourceLocations.get(crackLevel);
                renderColoredCutoutModel(this.getParentModel(), resourcelocation, poseStack, source, p_117150_, renderState, -1);
            }
        }
    }
}
