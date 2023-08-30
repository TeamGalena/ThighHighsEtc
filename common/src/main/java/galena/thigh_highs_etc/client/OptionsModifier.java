package galena.thigh_highs_etc.client;

import galena.thigh_highs_etc.index.THEItems;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.item.ItemStack;

public class OptionsModifier {

    public static int modifyMask(int mask, ItemStack boots) {
        var wearingThighHighs = boots.is(THEItems.THIGH_HIGHS_TAG);

        if (wearingThighHighs) {
            mask &= ~PlayerModelPart.LEFT_PANTS_LEG.getMask();
            mask &= ~PlayerModelPart.RIGHT_PANTS_LEG.getMask();
        }

        return mask;
    }

    public static void broadcastChange(ItemStack boots) {

    }

}
