package net.dollar.apex.entity.client;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import net.dollar.apex.ModMain;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Crackiness;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * CLIENT-ONLY. Handles Crackiness layer applied to ModObsidianGolemEntityRenderer.
 */
@OnlyIn(Dist.CLIENT)
public class ModObsidianGolemCrackLayer extends RenderLayer<@NotNull ModObsidianGolemRenderState, @NotNull ModObsidianGolemModel> {
    private static final Map<Crackiness.Level, Identifier> resourceLocations = ImmutableMap.of(
            Crackiness.Level.LOW, Identifier.fromNamespaceAndPath(ModMain.MODID, "textures/entity/obsidian_golem_crackiness_low.png"),
            Crackiness.Level.MEDIUM, Identifier.fromNamespaceAndPath(ModMain.MODID, "textures/entity/obsidian_golem_crackiness_medium.png"),
            Crackiness.Level.HIGH, Identifier.fromNamespaceAndPath(ModMain.MODID, "textures/entity/obsidian_golem_crackiness_high.png"));

    public ModObsidianGolemCrackLayer(RenderLayerParent<@NotNull ModObsidianGolemRenderState,
            @NotNull ModObsidianGolemModel> parent) {
        super(parent);
    }


    @Override
    public void submit(@NotNull PoseStack poseStack, @NotNull SubmitNodeCollector collector, int light,
                       ModObsidianGolemRenderState renderState, float limbAngle, float limbDistance) {
        if (!renderState.isInvisible) {
            Crackiness.Level crackLevel = renderState.crackiness;
            if (crackLevel != Crackiness.Level.NONE) {
                Identifier resourceLocation = resourceLocations.get(crackLevel);
                renderColoredCutoutModel(this.getParentModel(), resourceLocation, poseStack, collector, light,
                        renderState, -1, 1);    // Last argument is for render order, leave at 1.
            }
        }
    }
}
