package galena.thigh_highs_etc.index;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
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
import net.minecraft.world.item.Rarity;

import java.util.Map;

public class THEItems {

    private static final AbstractRegistrate<?> REGISTRATE = Services.PLATFORM.getRegistrate();

    private static final ResourceKey<CreativeModeTab> TAB = THECommon.ETC_LOADED
            ? ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(THECommon.ETC_ID, "item_group"))
            : CreativeModeTabs.COMBAT;

    public static final TagKey<Item> THIGH_HIGHS_TAG = TagKey.create(Registries.ITEM, new ResourceLocation(THEConstants.MOD_ID, "thigh_highs"));
    public static final Map<DyeColor, ItemEntry<ClothingItem>> COLORED_THIGH_HIGHS = THECommon.colored(REGISTRATE,"thigh_highs", (builder, color) -> builder
            .item(it -> new ClothingItem(it, EquipmentSlot.FEET))
            .properties(it -> it.stacksTo(1))
            .tag(THIGH_HIGHS_TAG)
            .tab(TAB)
            .tab(CreativeModeTabs.COLORED_BLOCKS)
            .recipe(Services.DATAGEN.thighHighs(color))
            .register()
    );

    public static final ItemEntry<ClothingItem> TRADER_THIGH_HIGHS = REGISTRATE.object("trader_thigh_highs")
            .item(it -> new ClothingItem(it, EquipmentSlot.FEET))
            .properties(it -> it.stacksTo(1))
            .properties(it -> it.rarity(Rarity.UNCOMMON))
            .tag(THIGH_HIGHS_TAG)
            .tab(TAB)
            .register();

    public static void register() {
        // Loads this class
    }

}
