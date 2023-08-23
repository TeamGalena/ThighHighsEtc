package galena.thigh_highs_etc.fabric.services;

import com.ninni.etcetera.registry.EtceteraItems;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import galena.thigh_highs_etc.index.THEItems;
import galena.thigh_highs_etc.platform.services.IDataGenHelper;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.UnaryOperator;

public class FabricDataGenHelper implements IDataGenHelper {

    private static final DataIngredient COTTON = DataIngredient.items(EtceteraItems.COTTON_FLOWER);

    private static <T extends Item> NonNullBiConsumer<DataGenContext<Item, T>, RegistrateRecipeProvider> craftOrDye(DyeColor color, UnaryOperator<ShapedRecipeBuilder> crafting) {
        return (context, provider) -> {
            RecipeBuilder builder;

            if (color == DyeColor.WHITE) {
                builder = crafting.apply(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, context.get()))
                        .define('x', COTTON);
            } else {
                builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, context.get())
                        .requires(DataIngredient.tag(THEItems.THIGH_HIGHS_TAG))
                        .requires(DyeItem.byColor(color));
            }

            builder
                    .unlockedBy("has_cotton", COTTON.getCritereon(provider))
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
