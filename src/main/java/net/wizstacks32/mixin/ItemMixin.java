package net.wizstacks32.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MusicDiscItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Item.class)
public class ItemMixin {
	@Overwrite
	public final int getMaxCount() {
		return 32;
	}
	public int getMaxCount(ItemStack stack) {
        if (stack.getItem() instanceof MusicDiscItem) {
            return 1;
        } else {
            return stack.getItem().getMaxCount();
        }
	}
}