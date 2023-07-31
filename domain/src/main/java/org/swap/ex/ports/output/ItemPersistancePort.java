package org.swap.ex.ports.output;

import org.swap.ex.model.Item;

public interface ItemPersistancePort {

    Item saveItem(Item item);

    Item updateItem(Item item);

    void deleteItem(Integer itemId);

    Item getItemById(Integer itemId);
}
