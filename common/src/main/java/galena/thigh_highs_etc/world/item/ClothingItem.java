package galena.thigh_highs_etc.world.item;

import com.ninni.etcetera.item.SweaterItem;
import galena.thigh_highs_etc.platform.Services;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class ClothingItem extends Item implements Equipable {

    private final EquipmentSlot slot;

    public ClothingItem(Item.Properties settings, EquipmentSlot slot) {
        super(settings);
        this.slot = slot;
        DispenserBlock.registerBehavior(this, SweaterItem.DISPENSER_BEHAVIOR);
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        return this.swapWithEquipmentSlot(this, world, user, hand);
    }

    public EquipmentSlot getEquipmentSlot() {
        return this.slot;
    }

    public SoundEvent getEquipSound() {
        return Services.PLATFORM.getBottomEquipSound();
    }

}
