package galena.thigh_highs_etc.fabric.client;

import com.google.common.base.Suppliers;
import com.mojang.blaze3d.vertex.PoseStack;
import galena.thigh_highs_etc.client.ThighHighsLayer;
import galena.thigh_highs_etc.client.ThighHighsModel;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class ThighHighsRenderer implements ArmorRenderer {

    private final Supplier<ThighHighsModel<LivingEntity>> model = Suppliers.memoize(() -> {
        var part = Minecraft.getInstance().getEntityModels().bakeLayer(ThighHighsLayer.LAYER_LOCATION);
        return new ThighHighsModel<>(part);
    });

    @Override
    public void render(PoseStack matrices, MultiBufferSource vertexConsumers, ItemStack stack, LivingEntity entity, EquipmentSlot slot, int light, HumanoidModel<LivingEntity> contextModel) {
        var model = this.model.get();
        var texture = ThighHighsLayer.getTexture(stack);

        model.copyPropertiesFrom(contextModel);
        model.prepareMobModel(entity, 1f, 1f, 1f);

        ArmorRenderer.renderPart(matrices, vertexConsumers, light, stack, model, texture);
    }

}
