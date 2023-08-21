package galena.thigh_highs_etc.forge.client;

import galena.thigh_highs_etc.client.ThighHighsLayer;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ForgeClientEntrypoint {

    public static void init() {
        var modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(ForgeClientEntrypoint::addModelLayers);
        modBus.addListener(ForgeClientEntrypoint::registerLayersDefinitions);
    }

    private static void addModelLayers(EntityRenderersEvent.AddLayers event) {
        var layer = event.getEntityModels().bakeLayer(ThighHighsLayer.LAYER_LOCATION);

        event.getSkins().forEach(skin -> {
            LivingEntityRenderer<Player, PlayerModel<Player>> renderer = event.getSkin(skin);
            renderer.addLayer(new ThighHighsLayer<>(renderer, layer));
        });
    }

    private static void registerLayersDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ThighHighsLayer.LAYER_LOCATION, ThighHighsLayer::createLayerDefinition);
    }

}
