package net.wizstacks32.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Item.class)
public class ItemMixin {
	@Overwrite
	public final int getMaxCount() {
		return 32;
	}
	@Mixin(JukeboxBlockEntity.class)
	public class JukeboxBlockEntityMixin {
		@Overwrite
		public void setRecord(ItemStack record) {
			if (record.getItem() instanceof MusicDiscItem) {
				record.decrement(1);
			}
			super.setRecord(record);
		}
	}
}