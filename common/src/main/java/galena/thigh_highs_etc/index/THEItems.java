package galena.thigh_highs_etc.index;

import com.google.common.collect.ImmutableMap;
import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullBiFunction;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import galena.thigh_highs_etc.THEConstants;
import galena.thigh_highs_etc.platform.Services;
import galena.thigh_highs_etc.world.item.ClothingItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

import java.util.Locale;
import java.util.Map;

public class THEItems {

    private static final ResourceKey<CreativeModeTab> TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation("etcetera", "item_group"));

    private static final AbstractRegistrate<?> REGISTRATE = Services.PLATFORM.getRegistrate();

    public static TagKey<Item> THIGH_HIGHS_TAG = TagKey.create(Registries.ITEM, new ResourceLocation(THEConstants.MOD_ID, "thigh_highs"));
    public static Map<DyeColor, ItemEntry<ClothingItem>> THIGH_HIGHS = colored("thigh_highs", (builder, color) -> builder
            .item(it -> new ClothingItem(it, EquipmentSlot.FEET))
            .tag(THIGH_HIGHS_TAG)
            .tab(TAB)
            .recipe(Services.DATAGEN.thighHighs(color))
            .register()
    );

    private static String prefixWith(String string, DyeColor color) {
        return color.name().toLowerCase(Locale.ROOT) + "_" + string;
    }

    private static <T> Map<DyeColor, T> mapColors(NonNullFunction<DyeColor, T> mapper) {
        ImmutableMap.Builder<DyeColor, T> builder = new ImmutableMap.Builder<>();
        for (var color : DyeColor.values()) {
            builder.put(color, mapper.apply(color));
        }
        return builder.build();
    }

    private static <T> Map<DyeColor, T> colored(String id, NonNullBiFunction<AbstractRegistrate<?>, DyeColor, T> factory) {
        return mapColors(color -> factory.apply(REGISTRATE.object(prefixWith(id, color)), color));
    }

    public static void register() {
        // Loads this class
    }

}
