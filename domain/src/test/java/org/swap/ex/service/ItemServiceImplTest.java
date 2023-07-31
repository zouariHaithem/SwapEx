package org.swap.ex.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.swap.ex.mock.ItemPersistancePortMock;
import org.swap.ex.model.Item;
import org.swap.ex.ports.input.ItemUseCase;
import org.swap.ex.ports.output.ItemPersistancePort;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ItemServiceImplTest {

    private ItemPersistancePort itemPersistancePort;

    private ItemUseCase itemService;

    @BeforeEach
    void setup() {
        itemPersistancePort = new ItemPersistancePortMock();
        itemService = new ItemServiceImpl(itemPersistancePort);
    }

    @Test
    public void should_save_Item() {
        Item item = createItem();
        var itemSaved = itemService.createItem(item);
        assertTrue(itemSaved.isPresent());
        assertTrue(itemSaved.get().getTitle().equals("first item"));

    }

    @Test
    public void should_get_Item_by_id() {
        Item item = createItem();
        var itemSaved = itemService.createItem(item);
        var itemFinded = itemService.getItemById(itemSaved.get().getId());
        assertTrue(itemFinded != null);
        assertTrue(itemSaved.get().getTitle().equals("first item"));

    }

    @Test
    public void should_update_Item() {
        Item item = createItem();
        var itemSaved = itemService.createItem(item);
        itemSaved.get().setTitle("second item");
        var itemUpdated = itemService.updateItem(itemSaved.get());
        var itemFinded = itemService.getItemById(itemUpdated.get().getId());
        assertTrue(itemFinded != null);
        assertTrue(itemSaved.get().getTitle().equals("second item"));

    }

    @Test
    public void should_delete_Item() {
        Item item = createItem();
        var ItemSaved = itemService.createItem(item);
        itemService.deleteItem(ItemSaved.get().getId());
        var itemFinded = itemService.getItemById(ItemSaved.get().getId());
        assertTrue(itemFinded.isEmpty());

    }

    private Item createItem() {
        return Item.builder().id(1).title("first item").description("first item to exchange").build();
    }

}