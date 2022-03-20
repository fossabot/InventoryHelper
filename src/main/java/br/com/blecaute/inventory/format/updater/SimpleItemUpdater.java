package br.com.blecaute.inventory.format.updater;

import br.com.blecaute.inventory.callback.ItemCallback;
import br.com.blecaute.inventory.type.InventoryItem;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public interface SimpleItemUpdater<T extends InventoryItem> {

    void update(@Nullable ItemStack itemStack);

    void update(@Nullable ItemStack itemStack, @Nullable ItemCallback<T> callback);

    void update(int slot, @Nullable ItemStack itemStack, @Nullable ItemCallback<T> callback);

    void flush();

}
