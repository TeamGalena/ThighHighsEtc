package galena.thigh_highs_etc.forge;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import galena.thigh_highs_etc.THECommon;
import galena.thigh_highs_etc.THEConstants;
import galena.thigh_highs_etc.forge.client.ForgeClientEntrypoint;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod(THEConstants.MOD_ID)
public class ForgeEntrypoint {

    public static final NonNullSupplier<Registrate> REGISTRATE = NonNullSupplier.lazy(() -> Registrate.create(THEConstants.MOD_ID));

    public ForgeEntrypoint() {
        THECommon.init();

        //noinspection Convert2MethodRef
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ForgeClientEntrypoint.init());
    }

}
