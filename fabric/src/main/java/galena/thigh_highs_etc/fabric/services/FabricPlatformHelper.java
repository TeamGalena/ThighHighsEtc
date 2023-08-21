package galena.thigh_highs_etc.fabric.services;

import com.ninni.etcetera.registry.EtceteraSoundEvents;
import com.tterrag.registrate.AbstractRegistrate;
import galena.thigh_highs_etc.fabric.FabricEntrypoint;
import galena.thigh_highs_etc.platform.services.IPlatformHelper;
import net.minecraft.sounds.SoundEvent;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public AbstractRegistrate<?> getRegistrate() {
        return FabricEntrypoint.REGISTRATE;
    }

    @Override
    public SoundEvent getBottomEquipSound() {
        return EtceteraSoundEvents.ITEM_ARMOR_EQUIP_COTTON;
    }
}
