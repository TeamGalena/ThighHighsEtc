package galena.thigh_highs_etc.platform.services;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

public interface IDataGenHelper {


    <T extends Item> NonNullBiConsumer<DataGenContext<Item, T>, RegistrateRecipeProvider> thighHighs(DyeColor color);

}
