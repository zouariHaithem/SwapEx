package org.swap.ex.service;

import org.swap.ex.model.Item;
import org.swap.ex.ports.input.ItemUseCase;
import org.swap.ex.ports.output.ItemPersistancePort;

import java.util.Optional;

public class ItemServiceImpl implements ItemUseCase {

    private ItemPersistancePort itemPersistancePort;

    public ItemServiceImpl(ItemPersistancePort itemPersistancePort) {
        this.itemPersistancePort = itemPersistancePort;
    }

    @Override
    public Optional<Item> createItem(Item item) {
        return Optional.of(itemPersistancePort.saveItem(item));
    }

    @Override
    public Optional<Item> updateItem(Item item) {
        return Optional.of(itemPersistancePort.updateItem(item));
    }

    @Override
    public void deleteItem(Integer itemId) {
        itemPersistancePort.deleteItem(itemId);
    }

    @Override
    public Optional<Item> getItemById(Integer itemId) {
        return Optional.ofNullable(itemPersistancePort.getItemById(itemId));
    }
}
