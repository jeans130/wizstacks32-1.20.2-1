package net.wizstacks32.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.item.MusicDiscItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

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