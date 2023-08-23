package galena.thigh_highs_etc.platform.services;

import com.tterrag.registrate.AbstractRegistrate;
import net.minecraft.sounds.SoundEvent;

public interface IPlatformHelper {

    AbstractRegistrate<?> getRegistrate();

    boolean isModLoaded(String id);

    SoundEvent getBottomEquipSound();

}
