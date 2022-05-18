package br.com.blecaute.inventory.format.updater;

import br.com.blecaute.inventory.InventoryBuilder;
import br.com.blecaute.inventory.format.updater.ObjectUpdater;
import br.com.blecaute.inventory.type.InventoryItem;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public interface PaginatedObjectUpdater<T extends InventoryItem> extends ObjectUpdater<T> {

    void update(@NotNull InventoryBuilder<T> builder, @NotNull Inventory inventory, @NotNull Collection<T> objects);

}