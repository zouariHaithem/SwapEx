package org.swap.ex.ports.input;

import org.swap.ex.model.Item;

import java.util.List;
import java.util.Optional;

public interface UserItemUseCase {

    Item postItem(Integer userId, Item item);

    void deleteItem(Integer userId, Integer itemId);

    Optional<List<Item>> getAllItems(Integer userId);
}
