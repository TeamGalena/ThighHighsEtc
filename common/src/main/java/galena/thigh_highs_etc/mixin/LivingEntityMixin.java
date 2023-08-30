package galena.thigh_highs_etc.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(at = @At("HEAD"), method = "onEquipItem(Lnet/minecraft/world/entity/EquipmentSlot;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)V")
    public void onEquip(EquipmentSlot equipmentSlot, ItemStack from, ItemStack to, CallbackInfo ci) {
        @SuppressWarnings("DataFlowIssue")
        var self = (LivingEntity) (Object) this;

        if(self instanceof AbstractClientPlayer) {
            var mc = Minecraft.getInstance();
            mc.options.broadcastOptions();
        }
    }

}
