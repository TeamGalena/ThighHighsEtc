package galena.thigh_highs_etc.fabric;

import com.tterrag.registrate.Registrate;
import galena.thigh_highs_etc.THECommon;
import galena.thigh_highs_etc.THEConstants;
import net.fabricmc.api.ModInitializer;

public class FabricEntrypoint implements ModInitializer {

    public static final Registrate REGISTRATE = Registrate.create(THEConstants.MOD_ID);

    @Override
    public void onInitialize() {
        THECommon.init();
        REGISTRATE.register();
    }

}
