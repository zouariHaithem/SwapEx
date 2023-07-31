package org.swap.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.swap.ex.model.Item;
import org.swap.ex.ports.input.UserItemUseCase;

import java.util.List;

@RestController
@RequestMapping("/user/items")
public class UserItemController {

    @Autowired
    private UserItemUseCase userItemUseService;

    @PostMapping("/post/{userId}")
    public Item postItem(@PathVariable Integer userId, @RequestBody Item item) {
        return userItemUseService.postItem(userId, item);
    }

    @DeleteMapping("/delete/{userId}/{itemId}")
    public void deleteItem(@PathVariable Integer userId, @PathVariable Integer itemId) {
        userItemUseService.deleteItem(userId, itemId);
    }

    @GetMapping("/getAll/{userId}")
    public List<Item> getAllItems(@PathVariable Integer userId) {
        return userItemUseService.getAllItems(userId).get();
    }

}
