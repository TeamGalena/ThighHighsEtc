package galena.thigh_highs_etc.client;

import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class ThighHighsModel<T extends LivingEntity> extends AgeableListModel<T> {
    private final ModelPart waist;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;
    private float swimAmount;
    private boolean crouching;

    public ThighHighsModel(ModelPart root) {
        this.waist = root.getChild("waist");
        this.leftLeg = root.getChild("left_leg");
        this.rightLeg = root.getChild("right_leg");
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return List.of();
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return List.of(waist, leftLeg, rightLeg);
    }

    @Override
    public void prepareMobModel(T livingEntity, float f, float g, float h) {
        swimAmount = livingEntity.getSwimAmount(h);
        crouching  = livingEntity.isCrouching();
        young = livingEntity.isBaby();
        super.prepareMobModel(livingEntity, f, g, h);
    }

    @Override
    public void setupAnim(T entity, float f, float g, float h, float i, float j) {
        boolean bl = entity.getFallFlyingTicks() > 4;

        float k = 1.0F;
        if (bl) {
            k = (float)entity.getDeltaMovement().lengthSqr();
            k /= 0.2F;
            k *= k * k;
        }

        if (k < 1.0F) {
            k = 1.0F;
        }

        this.rightLeg.xRot = Mth.cos(f * 0.6662F) * 1.4F * g / k;
        this.leftLeg.xRot = Mth.cos(f * 0.6662F + 3.1415927F) * 1.4F * g / k;
        this.rightLeg.yRot = 0.005F;
        this.leftLeg.yRot = -0.005F;
        this.rightLeg.zRot = 0.005F;
        this.leftLeg.zRot = -0.005F;

        if (this.riding) {
            this.rightLeg.xRot = -1.4137167F;
            this.rightLeg.yRot = 0.31415927F;
            this.rightLeg.zRot = 0.07853982F;
            this.leftLeg.xRot = -1.4137167F;
            this.leftLeg.yRot = -0.31415927F;
            this.leftLeg.zRot = -0.07853982F;
        }

        if (this.crouching) {
            this.rightLeg.z = 4.0F;
            this.leftLeg.z = 4.0F;
            this.rightLeg.y = 12.2F;
            this.leftLeg.y = 12.2F;
        } else {
            this.rightLeg.z = 0.0F;
            this.leftLeg.z = 0.0F;
            this.rightLeg.y = 12.0F;
            this.leftLeg.y = 12.0F;
        }

        if (this.swimAmount > 0.0F) {
            this.leftLeg.xRot = Mth.lerp(this.swimAmount, this.leftLeg.xRot, 0.3F * Mth.cos(f * 0.33333334F + 3.1415927F));
            this.rightLeg.xRot = Mth.lerp(this.swimAmount, this.rightLeg.xRot, 0.3F * Mth.cos(f * 0.33333334F));
        }
    }

    public void copyPropertiesFrom(HumanoidModel<T> contextModel) {
        contextModel.copyPropertiesTo(this);
        leftLeg.copyFrom(contextModel.leftLeg);
        rightLeg.copyFrom(contextModel.rightLeg);
        waist.copyFrom(contextModel.body);
    }
}
