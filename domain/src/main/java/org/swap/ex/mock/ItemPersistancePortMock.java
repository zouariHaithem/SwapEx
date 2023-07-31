package org.swap.ex.mock;

import org.swap.ex.model.Item;
import org.swap.ex.ports.output.ItemPersistancePort;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ItemPersistancePortMock implements ItemPersistancePort {


    private final Map<Integer, Item> items = new HashMap<>();


    @Override
    public Item saveItem(Item item) {
        items.put(item.getId(), item);
        return item;
    }

    @Override
    public Item updateItem(Item item) {
        Optional<Item> itemUpdated = items.entrySet().stream().filter(itemEntry -> itemEntry.getValue().getId().equals(item.getId())).map(itemEntry -> itemEntry.setValue(item)).findFirst();

        return itemUpdated.isPresent() ? itemUpdated.get() : null;
    }

    @Override
    public void deleteItem(Integer itemId) {
        items.remove(itemId);
    }

    @Override
    public Item getItemById(Integer itemId) {
        var item = items.get(itemId);

        return item;
    }
}
