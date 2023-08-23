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
        Advancement.Builder.advancement()
                .addCriterion("critierion", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item()
                                .of(THEItems.THIGH_HIGHS_TAG)
                                .build()
                ))
                .display(
                        THEItems.COLORED_THIGH_HIGHS.get(DyeColor.PINK).asStack(),
                        Component.translatable("advancements." + THEConstants.MOD_ID + ".equipped_thigh_highs.title"),
                        Component.translatable("advancements." + THEConstants.MOD_ID + ".equipped_thigh_highs.description"),
                        new ResourceLocation("wool"),
                        FrameType.GOAL,
                        true,
                        false,
                        false
                )
                .save(consumer, "equipped_thigh_highs");
    }

}
