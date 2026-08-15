package galena.thigh_highs_etc.neoforge.services;

import com.ninni.etcetera.registry.EtceteraSoundEvents;
import com.tterrag.registrate.AbstractRegistrate;
import galena.thigh_highs_etc.neoforge.NeoForgeEntrypoint;
import galena.thigh_highs_etc.platform.services.IPlatformHelper;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.fml.ModList;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public AbstractRegistrate<?> getRegistrate() {
        return NeoForgeEntrypoint.REGISTRATE.get();
    }

    @Override
    public boolean isModLoaded(String id) {
        return ModList.get().isLoaded(id);
    }

    @Override
    public SoundEvent getBottomEquipSound() {
        return EtceteraSoundEvents.ITEM_ARMOR_EQUIP_COTTON;
    }
}
