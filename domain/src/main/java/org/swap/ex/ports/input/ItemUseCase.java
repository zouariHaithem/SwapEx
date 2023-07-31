package org.swap.ex.ports.input;

import org.swap.ex.model.Item;

import java.util.Optional;

public interface ItemUseCase {

    Optional<Item> createItem(Item item);

    Optional<Item> updateItem(Item item);

    void deleteItem(Integer itemId);

    Optional<Item> getItemById(Integer itemId);
}
