package galena.thigh_highs_etc.forge.client;

import galena.thigh_highs_etc.client.ThighHighsLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.nio.charset.MalformedInputException;

public class ForgeClientEntrypoint {

    public static void init() {
        var modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(ForgeClientEntrypoint::addModelLayers);
        modBus.addListener(ForgeClientEntrypoint::registerLayersDefinitions);
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

        mc.renderers.values().forEach(it -> {
            if (it instanceof LivingEntityRenderer<?, ?> renderer) {
                addLayerTo(renderer, layer);
            }
        });
    }

    private static void registerLayersDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ThighHighsLayer.LAYER_LOCATION, ThighHighsLayer::createLayerDefinition);
    }

}
