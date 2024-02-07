package net.wizstacks32.mixin;

import net.minecraft.item.Item;
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