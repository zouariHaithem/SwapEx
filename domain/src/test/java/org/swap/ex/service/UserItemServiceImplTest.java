package org.swap.ex.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.swap.ex.mock.ItemPersistancePortMock;
import org.swap.ex.mock.UserPersistancePortMock;
import org.swap.ex.model.Item;
import org.swap.ex.model.User;
import org.swap.ex.ports.input.ItemUseCase;
import org.swap.ex.ports.input.UserItemUseCase;
import org.swap.ex.ports.input.UserUseCase;
import org.swap.ex.ports.output.ItemPersistancePort;
import org.swap.ex.ports.output.UserPersistancePort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserItemServiceImplTest {

    private UserPersistancePort userPersistancePort;

    private ItemPersistancePort itemPersistancePort;

    private UserUseCase userService;

    private ItemUseCase itemService;

    private UserItemUseCase userItemService;

    @BeforeEach
    void setup() {
        userPersistancePort = new UserPersistancePortMock();
        userService = new UserServiceImpl(userPersistancePort);
        itemPersistancePort = new ItemPersistancePortMock();
        itemService = new ItemServiceImpl(itemPersistancePort);
        userItemService = new UserItemServiceImpl(userService, itemService);
    }

    @Test
    public void should_post_item() {
        User user = createUser();
        var userSaved = userService.saveUser(user);
        Item item = userItemService.postItem(userSaved.get().getId(), createItem());
        assertNotNull(item);
    }

    @Test
    public void should_get_user_items() {
        User user = createUser();
        Item item1 = createItem();
        Item item2 = createItem();
        Item item3 = createItem();
        user.setItems(List.of(item1, item2, item3));
        var userSaved = userService.saveUser(user);
        Optional<List<Item>> items = userItemService.getAllItems(user.getId());
        assertEquals(items.get().size(), 3);
    }

    @Test
    public void should_delete_user_items() {
        User user = createUser();
        Item item1 = createItem();
        user.setItems(List.of(item1));
        var userSaved = userService.saveUser(user);
        itemService.createItem(item1);
        userItemService.deleteItem(user.getId(), item1.getId());
        var itemFinded = itemService.getItemById(item1.getId());
        assertTrue(itemFinded.isEmpty());
    }

    private User createUser() {
        return User.builder().id(1).name("Haithem").location("Paris").email("h.z@gmail.com").build();
    }

    private Item createItem() {
        return Item.builder().id(1).title("first item").description("first item to exchange").build();
    }


}