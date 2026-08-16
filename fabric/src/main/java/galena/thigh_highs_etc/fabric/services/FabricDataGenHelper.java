package galena.thigh_highs_etc.fabric.services;

import com.ninni.etcetera.registry.EtceteraItems;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import galena.thigh_highs_etc.index.THEItems;
import galena.thigh_highs_etc.platform.services.IDataGenHelper;
import java.util.function.UnaryOperator;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

public class FabricDataGenHelper implements IDataGenHelper {

    private static <T extends Item> NonNullBiConsumer<DataGenContext<Item, T>, RegistrateRecipeProvider> craftOrDye(DyeColor color, UnaryOperator<ShapedRecipeBuilder> crafting) {
        return (context, provider) -> {
            RecipeBuilder builder;

            if (color == DyeColor.WHITE) {
                builder = crafting.apply(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, context.get()))
                        .define('x', EtceteraItems.COTTON_FLOWER.get());
            } else {
                builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, context.get())
                        .requires(Ingredient.of(THEItems.COLORED_THIGH_HIGHS_TAG))
                        .requires(DyeItem.byColor(color));
            }

            builder
                    .unlockedBy("has_cotton", RegistrateRecipeProvider.has(EtceteraItems.COTTON_FLOWER.get()))
                    .save(provider);
        };
    }

    @Override
    public <T extends Item> NonNullBiConsumer<DataGenContext<Item, T>, RegistrateRecipeProvider> thighHighs(DyeColor color) {
        return craftOrDye(color, recipe -> recipe
                .pattern("x x")
                .pattern("x x")
                .pattern("x x")
        );
    }

}
