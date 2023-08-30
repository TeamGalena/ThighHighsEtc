package galena.thigh_highs_etc.mixin;

import galena.thigh_highs_etc.client.OptionsModifier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.world.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Options.class)
public abstract class OptionsMixin {

    @ModifyArg(
            method = "broadcastOptions()V",
            index = 4,
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/network/protocol/game/ServerboundClientInformationPacket;<init>(Ljava/lang/String;ILnet/minecraft/world/entity/player/ChatVisiblity;ZILnet/minecraft/world/entity/HumanoidArm;ZZ)V"
            )
    )
    public int modifySkinMask(int mask) {
        var mc = Minecraft.getInstance();
        assert mc.player != null;
        var boots = mc.player.getItemBySlot(EquipmentSlot.FEET);
        return OptionsModifier.modifyMask(mask, boots);
    }

}
