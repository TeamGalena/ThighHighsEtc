package galena.thigh_highs_etc.forge.services;

import com.ninni.etcetera.registry.EtceteraSoundEvents;
import com.tterrag.registrate.AbstractRegistrate;
import galena.thigh_highs_etc.forge.ForgeEntrypoint;
import galena.thigh_highs_etc.platform.services.IPlatformHelper;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.ModList;

public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public AbstractRegistrate<?> getRegistrate() {
        return ForgeEntrypoint.REGISTRATE.get();
    }

    @Override
    public boolean isModLoaded(String id) {
        return ModList.get().isLoaded(id);
    }

    @Override
    public SoundEvent getBottomEquipSound() {
        return EtceteraSoundEvents.ITEM_ARMOR_EQUIP_COTTON.get();
    }
}
