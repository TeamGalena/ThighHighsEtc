package galena.thigh_highs_etc.fabric.client;

import galena.thigh_highs_etc.client.ThighHighsLayer;
import galena.thigh_highs_etc.index.THEItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

public class FabricClientEntrypoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ThighHighsLayer.LAYER_LOCATION, ThighHighsLayer::createLayerDefinition);

        THEItems.THIGH_HIGHS.values().forEach(it -> {
            ArmorRenderer.register(new ThighHighsRenderer(), it.get());
        });
    }

}
