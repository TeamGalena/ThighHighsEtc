package galena.thigh_highs_etc;

import com.google.common.collect.ImmutableMap;
import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.util.nullness.NonNullBiFunction;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import galena.thigh_highs_etc.index.THEItems;
import galena.thigh_highs_etc.platform.Services;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;

import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;

public class THECommon {

    public static final String ETC_ID = "etcetera";

    public static final boolean ETC_LOADED = Services.PLATFORM.isModLoaded(ETC_ID);

    public static void init() {
        THEItems.register();
    }

    public static String prefixWith(String string, DyeColor color) {
        return color.name().toLowerCase(Locale.ROOT) + "_" + string;
    }

    public static <T> Map<DyeColor, T> mapColors(NonNullFunction<DyeColor, T> mapper) {
        ImmutableMap.Builder<DyeColor, T> builder = new ImmutableMap.Builder<>();
        for (var color : DyeColor.values()) {
            builder.put(color, mapper.apply(color));
        }
        return builder.build();
    }

    public static <T> Map<DyeColor, T> colored(AbstractRegistrate<?> registrate, String id, NonNullBiFunction<AbstractRegistrate<?>, DyeColor, T> factory) {
        return mapColors(color -> factory.apply(registrate.object(prefixWith(id, color)), color));
    }

    public static void registerWanderingTrades(Consumer<VillagerTrades.ItemListing> consumer) {
        consumer.accept((entity, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 22), ItemStack.EMPTY,
                THEItems.TRADER_THIGH_HIGHS.asStack(),
                1, 11, 0.05F
        ));
    }

}
