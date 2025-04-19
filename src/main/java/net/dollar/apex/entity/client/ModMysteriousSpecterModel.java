package net.dollar.apex.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class ModMysteriousSpecterModel extends HumanoidModel<ModMysteriousSpecterRenderState> {
    private final List<ModelPart> bodyParts;
    public final ModelPart leftSleeve;
    public final ModelPart rightSleeve;
    public final ModelPart leftPants;
    public final ModelPart rightPants;
    public final ModelPart jacket;

    public ModMysteriousSpecterModel(ModelPart modelPart) {
        super(modelPart, RenderType::entityTranslucent);
        this.leftSleeve = this.leftArm.getChild("left_sleeve");
        this.rightSleeve = this.rightArm.getChild("right_sleeve");
        this.leftPants = this.leftLeg.getChild("left_pants");
        this.rightPants = this.rightLeg.getChild("right_pants");
        this.jacket = this.body.getChild("jacket");
        this.bodyParts = List.of(this.head, this.body, this.leftArm, this.rightArm, this.leftLeg, this.rightLeg);
    }

    public static MeshDefinition createMesh(CubeDeformation p_170826_, boolean p_170827_) {
        MeshDefinition $$2 = HumanoidModel.createMesh(p_170826_, 0.0F);
        PartDefinition $$3 = $$2.getRoot();
        if (p_170827_) {
            PartDefinition $$5 = $$3.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, p_170826_), PartPose.offset(5.0F, 2.0F, 0.0F));
            PartDefinition $$6 = $$3.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, p_170826_), PartPose.offset(-5.0F, 2.0F, 0.0F));
            $$5.addOrReplaceChild("left_sleeve", CubeListBuilder.create().texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, p_170826_.extend(0.25F)), PartPose.ZERO);
            $$6.addOrReplaceChild("right_sleeve", CubeListBuilder.create().texOffs(40, 32).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, p_170826_.extend(0.25F)), PartPose.ZERO);
        } else {
            PartDefinition $$7 = $$3.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_170826_), PartPose.offset(5.0F, 2.0F, 0.0F));
            PartDefinition $$8 = $$3.getChild("right_arm");
            $$7.addOrReplaceChild("left_sleeve", CubeListBuilder.create().texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_170826_.extend(0.25F)), PartPose.ZERO);
            $$8.addOrReplaceChild("right_sleeve", CubeListBuilder.create().texOffs(40, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_170826_.extend(0.25F)), PartPose.ZERO);
        }

        PartDefinition $$9 = $$3.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_170826_), PartPose.offset(1.9F, 12.0F, 0.0F));
        PartDefinition $$10 = $$3.getChild("right_leg");
        $$9.addOrReplaceChild("left_pants", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_170826_.extend(0.25F)), PartPose.ZERO);
        $$10.addOrReplaceChild("right_pants", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_170826_.extend(0.25F)), PartPose.ZERO);
        PartDefinition $$11 = $$3.getChild("body");
        $$11.addOrReplaceChild("jacket", CubeListBuilder.create().texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, p_170826_.extend(0.25F)), PartPose.ZERO);
        return $$2;
    }

    public void setupAnim(@NotNull ModMysteriousSpecterRenderState renderState) {
        boolean $$1 = true;
        this.body.visible = $$1;
        this.rightArm.visible = $$1;
        this.leftArm.visible = $$1;
        this.rightLeg.visible = $$1;
        this.leftLeg.visible = $$1;
        super.setupAnim(renderState);
    }

    public void setAllVisible(boolean isVisible) {
        super.setAllVisible(isVisible);
        this.leftSleeve.visible = isVisible;
        this.rightSleeve.visible = isVisible;
        this.leftPants.visible = isVisible;
        this.rightPants.visible = isVisible;
        this.jacket.visible = isVisible;
    }

    public void translateToHand(@NotNull HumanoidArm p_103392_, @NotNull PoseStack p_103393_) {
        this.root().translateAndRotate(p_103393_);
        ModelPart $$2 = this.getArm(p_103392_);
        $$2.translateAndRotate(p_103393_);
    }

    public ModelPart getRandomBodyPart(RandomSource p_370076_) {
        return Util.getRandom(this.bodyParts, p_370076_);
    }

    protected HumanoidModel.ArmPose getArmPose(PlayerRenderState p_365270_, HumanoidArm p_367362_) {
        return PlayerRenderer.getArmPose(p_365270_, p_367362_);
    }
}