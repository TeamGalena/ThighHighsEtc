package galena.thigh_highs_etc.fabric.datagen;

import galena.thigh_highs_etc.THEConstants;
import galena.thigh_highs_etc.index.THEItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;

import java.util.function.Consumer;

public class AdvancementProvider extends FabricAdvancementProvider {

    protected AdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        var id = new ResourceLocation(THEConstants.MOD_ID, "equipped_thigh_highs");
        Advancement.Builder.advancement()
                .parent(Advancement.Builder.advancement().build(new ResourceLocation("etcetera", "husbandry/plant_cotton")))
                .addCriterion("has_thigh_highs", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item()
                                .of(THEItems.THIGH_HIGHS_TAG)
                                .build()
                ))
                .display(
                        THEItems.COLORED_THIGH_HIGHS.get(DyeColor.PINK).asStack(),
                        Component.translatable(id.toLanguageKey("advancement", "title")),
                        Component.translatable(id.toLanguageKey("advancement", "description")),
                        new ResourceLocation("textures/block/pink_wool.png"),
                        FrameType.TASK,
                        true,
                        true,
                        false
                )
                .save(consumer, id.toString());
    }

}
