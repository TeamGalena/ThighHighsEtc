package galena.thigh_highs_etc.mixin;

import galena.thigh_highs_etc.index.THEItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.PlayerModelPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class PlayerMixin {

    @Inject(at = @At("HEAD"), method = "isModelPartShown(Lnet/minecraft/world/entity/player/PlayerModelPart;)Z", cancellable = true)
    public void onEquip(PlayerModelPart part, CallbackInfoReturnable<Boolean> cir) {
        @SuppressWarnings("DataFlowIssue")
        var self = (Player) (Object) this;
        var boots = self.getItemBySlot(EquipmentSlot.FEET);
        if (boots.is(THEItems.THIGH_HIGHS_TAG)) {
            cir.setReturnValue(false);
        }
    }

}
