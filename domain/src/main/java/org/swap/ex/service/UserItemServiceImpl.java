package org.swap.ex.service;

import org.swap.ex.model.Item;
import org.swap.ex.model.User;
import org.swap.ex.ports.input.ItemUseCase;
import org.swap.ex.ports.input.UserItemUseCase;
import org.swap.ex.ports.input.UserUseCase;

import java.util.List;
import java.util.Optional;

public class UserItemServiceImpl implements UserItemUseCase {

    private UserUseCase userUseCase;

    private ItemUseCase itemService;


    public UserItemServiceImpl(UserUseCase userUseCase, ItemUseCase itemService) {
        this.userUseCase = userUseCase;
        this.itemService = itemService;
    }

    @Override
    public Item postItem(Integer userId, Item item) {
        Optional<User> user = userUseCase.getUserById(userId);
        if (user.isPresent()) {

            item.setOwner(user.get());
            var itemSaved = itemService.createItem(item);
            return itemSaved.isPresent() ? itemSaved.get() : null;
        }

        return null;
    }

    @Override
    public void deleteItem(Integer userId, Integer itemId) {
        Optional<User> user = userUseCase.getUserById(userId);
        if (user.isPresent() && user.get().getItems() != null) {
            Optional<Item> itemTodelete = user.get().getItems().stream().filter(item1 -> item1.getId() == itemId).findFirst();
            if (itemTodelete.isPresent()) {
                itemService.deleteItem(itemTodelete.get().getId());
            }
        }
    }

    @Override
    public Optional<List<Item>> getAllItems(Integer userId) {
        List<Item> items = null;
        Optional<User> user = userUseCase.getUserById(userId);
        if (user.isPresent()) {
            items = user.get().getItems();
        }
        return Optional.ofNullable(items);
    }
}
