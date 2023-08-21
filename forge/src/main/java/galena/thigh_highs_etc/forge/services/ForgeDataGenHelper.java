package galena.thigh_highs_etc.forge.services;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import galena.thigh_highs_etc.platform.services.IDataGenHelper;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

public class ForgeDataGenHelper implements IDataGenHelper {

    private void NOOP() {
        throw new IllegalStateException("DataGen should only happen in fabric");
    }

    @Override
    public <T extends Item> NonNullBiConsumer<DataGenContext<Item, T>, RegistrateRecipeProvider> thighHighs(DyeColor color) {
        return (c, p) -> NOOP();
    }

}
