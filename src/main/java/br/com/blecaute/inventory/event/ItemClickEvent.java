package br.com.blecaute.inventory.event;

import br.com.blecaute.inventory.InventoryBuilder;
import br.com.blecaute.inventory.callback.ItemCallback;
import br.com.blecaute.inventory.format.InventoryFormat;
import br.com.blecaute.inventory.format.updater.ItemUpdater;
import br.com.blecaute.inventory.type.InventoryItem;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The event called when the player clicks on an item.
 *
 * @param <T> The type of @{@link InventoryItem}
 */
public class ItemClickEvent<T extends InventoryItem> extends InventoryEvent<T> implements UpdatableItem<T> {

    private final InventoryFormat<T> format;

    public ItemClickEvent(@NotNull InventoryFormat<T> format,
                          @NotNull InventoryBuilder<T> builder,
                          @NotNull InventoryClickEvent event) {

        super(builder, event);
        this.format = format;
    }

    @Override
    public void update(int slot, @Nullable ItemStack itemStack) {
        update(slot, itemStack, null);
    }

    @Override
    public void update(@Nullable ItemStack itemStack) {
        update(itemStack, null);
    }

    @Override
    public void update(@Nullable ItemStack itemStack, @Nullable ItemCallback<T> callback) {
        update(getEvent().getRawSlot(), itemStack, callback);
    }

    @Override @SuppressWarnings("unchecked")
    public void update(int slot, @Nullable ItemStack itemStack, @Nullable ItemCallback<T> callback) {
        if (!(format instanceof ItemUpdater)) {
            throw new UnsupportedOperationException("The format is not an instance of ItemUpdater");
        }

        ((ItemUpdater<T>) format).update(getBuilder(), getInventory(), slot, itemStack, callback);
    }
}
