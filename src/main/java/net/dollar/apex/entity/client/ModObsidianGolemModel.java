package net.dollar.apex.entity.client;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * CLIENT-ONLY. Defines Obsidian Golem model, copied largely from IronGolemModel but without flower layer.
 */
@OnlyIn(Dist.CLIENT)
public class ModObsidianGolemModel extends EntityModel<ModObsidianGolemRenderState> {
    private final ModelPart head;
    private final ModelPart rightArm;
    private final ModelPart leftArm;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;

    public ModObsidianGolemModel(ModelPart modelPart) {
        super(modelPart);
        this.head = modelPart.getChild("head");
        this.rightArm = modelPart.getChild("right_arm");
        this.leftArm = modelPart.getChild("left_arm");
        this.rightLeg = modelPart.getChild("right_leg");
        this.leftLeg = modelPart.getChild("left_leg");
    }



    public void setupAnim(ModObsidianGolemRenderState renderState) {
        super.setupAnim(renderState);
        float $$1 = renderState.attackTicksRemaining;
        float $$2 = renderState.walkAnimationSpeed;
        float $$3 = renderState.walkAnimationPos;
        if ($$1 > 0.0F) {
            this.rightArm.xRot = -2.0F + 1.5F * Mth.triangleWave($$1, 10.0F);
            this.leftArm.xRot = -2.0F + 1.5F * Mth.triangleWave($$1, 10.0F);
        }

        this.head.yRot = renderState.yRot * ((float)Math.PI / 180F);
        this.head.xRot = renderState.xRot * ((float)Math.PI / 180F);
        this.rightLeg.xRot = -1.5F * Mth.triangleWave($$3, 13.0F) * $$2;
        this.leftLeg.xRot = 1.5F * Mth.triangleWave($$3, 13.0F) * $$2;
        this.rightLeg.yRot = 0.0F;
        this.leftLeg.yRot = 0.0F;
    }
}
