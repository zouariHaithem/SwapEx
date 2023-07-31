package org.swap.ex.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.swap.ex.model.User;
import org.swap.ex.ports.input.UserUseCase;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserUseCase userService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user).get();
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User User) {
        return userService.updateUser(User).get();
    }

    @GetMapping("/get/{id}")
    public User getUserByID(@PathVariable Integer id) {
        return userService.getUserById(id).get();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserByID(@PathVariable Integer id) {
        userService.deleteUser(id);
    }


}
