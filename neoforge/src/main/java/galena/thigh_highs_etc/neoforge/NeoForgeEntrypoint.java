package galena.thigh_highs_etc.neoforge;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import galena.thigh_highs_etc.THECommon;
import galena.thigh_highs_etc.THEConstants;
import galena.thigh_highs_etc.neoforge.client.NeoForgeClientEntrypoint;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

@Mod(THEConstants.MOD_ID)
public class NeoForgeEntrypoint {

    public static final NonNullSupplier<Registrate> REGISTRATE = NonNullSupplier.lazy(() -> Registrate.create(THEConstants.MOD_ID));

    public NeoForgeEntrypoint(IEventBus modBus, Dist dist) {
        THECommon.init();

        if (dist.isClient()) {
            NeoForgeClientEntrypoint.init(modBus);
        }

        NeoForge.EVENT_BUS.addListener((WandererTradesEvent event) -> {
            var trades = event.getRareTrades();
            THECommon.registerWanderingTrades(trades::add);
        });
    }

}
