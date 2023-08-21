package galena.thigh_highs_etc.fabric.services;

import com.ninni.etcetera.registry.EtceteraItems;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import galena.thigh_highs_etc.index.THEItems;
import galena.thigh_highs_etc.platform.services.IDataGenHelper;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;

public class FabricDataGenHelper implements IDataGenHelper {

    @Override
    public <T extends Item> NonNullBiConsumer<DataGenContext<Item, T>, RegistrateRecipeProvider> thighHighs(DyeColor color) {
        return (context, provider) -> {
            if (color == DyeColor.WHITE) {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, context.get())
                        .pattern("x x")
                        .pattern("x x")
                        .pattern("x x")
                        .define('x', EtceteraItems.COTTON_FLOWER)
                        .unlockedBy("has_cotton", RegistrateRecipeProvider.has(EtceteraItems.COTTON_FLOWER))
                        .save(provider);
            } else {
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, context.get())
                        .requires(DataIngredient.tag(THEItems.THIGH_HIGHS_TAG))
                        .requires(DyeItem.byColor(color))
                        .unlockedBy("has_cotton", RegistrateRecipeProvider.has(EtceteraItems.COTTON_FLOWER))
                        .save(provider);
            }
        };
    }

}
