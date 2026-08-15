package galena.thigh_highs_etc.fabric.datagen;

import galena.thigh_highs_etc.THECommon;
import galena.thigh_highs_etc.THEConstants;
import galena.thigh_highs_etc.index.THEItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;

public class AdvancementProvider extends FabricAdvancementProvider {

    protected AdvancementProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        var id = ResourceLocation.fromNamespaceAndPath(THEConstants.MOD_ID, "equipped_thigh_highs");
        Advancement.Builder.advancement()
                .parent(Advancement.Builder.advancement().build(ResourceLocation.fromNamespaceAndPath(THECommon.ETC_ID, "husbandry/plant_cotton")))
                .addCriterion("has_thigh_highs", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item()
                                .of(THEItems.THIGH_HIGHS_TAG)
                                .build()
                ))
                .display(
                        THEItems.COLORED_THIGH_HIGHS.get(DyeColor.PINK).asStack(),
                        Component.translatable(id.toLanguageKey("advancement", "title")),
                        Component.translatable(id.toLanguageKey("advancement", "description")),
                        ResourceLocation.withDefaultNamespace("textures/block/pink_wool.png"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .save(consumer, id.toString());
    }

}
