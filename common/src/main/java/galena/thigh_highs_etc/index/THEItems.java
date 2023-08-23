package galena.thigh_highs_etc.index;

import com.google.common.collect.ImmutableMap;
import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullBiFunction;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import galena.thigh_highs_etc.THECommon;
import galena.thigh_highs_etc.THEConstants;
import galena.thigh_highs_etc.platform.Services;
import galena.thigh_highs_etc.world.item.ClothingItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

import java.util.Locale;
import java.util.Map;

public class THEItems {

    private static final ResourceKey<CreativeModeTab> TAB = THECommon.ETC_LOADED
            ? ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(THECommon.ETC_ID, "item_group"))
            : CreativeModeTabs.COMBAT;

    public static final TagKey<Item> THIGH_HIGHS_TAG = TagKey.create(Registries.ITEM, new ResourceLocation(THEConstants.MOD_ID, "thigh_highs"));
    public static Map<DyeColor, ItemEntry<ClothingItem>> THIGH_HIGHS = THECommon.colored("thigh_highs", (builder, color) -> builder
            .item(it -> new ClothingItem(it, EquipmentSlot.FEET))
            .tag(THIGH_HIGHS_TAG)
            .tab(TAB)
            .recipe(Services.DATAGEN.thighHighs(color))
            .register()
    );

    public static void register() {
        // Loads this class
    }

}
