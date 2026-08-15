package galena.thigh_highs_etc.neoforge.client;

import galena.thigh_highs_etc.client.ThighHighsLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class NeoForgeClientEntrypoint {

    public static void init(IEventBus modBus) {
        modBus.addListener(NeoForgeClientEntrypoint::addModelLayers);
        modBus.addListener(NeoForgeClientEntrypoint::registerLayersDefinitions);
    }

    private static <T extends LivingEntity, M extends EntityModel<T>> void addLayerTo(LivingEntityRenderer<T, M> renderer, ModelPart layer) {
        renderer.addLayer(new ThighHighsLayer<>(renderer, layer));
    }

    private static void addModelLayers(EntityRenderersEvent.AddLayers event) {
        var mc = Minecraft.getInstance().getEntityRenderDispatcher();
        var layer = event.getEntityModels().bakeLayer(ThighHighsLayer.LAYER_LOCATION);

        event.getSkins().forEach(skin -> {
            LivingEntityRenderer<Player, PlayerModel<Player>> renderer = event.getSkin(skin);
            if (renderer != null) addLayerTo(renderer, layer);
        });

        event.getEntityTypes().forEach(type -> {
            var renderer = event.getRenderer(type);
            if (renderer instanceof HumanoidMobRenderer<?, ?> humanoid) {
                addLayerTo(humanoid, layer);
            }
        });
    }

    private static void registerLayersDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ThighHighsLayer.LAYER_LOCATION, ThighHighsLayer::createLayerDefinition);
    }

}
