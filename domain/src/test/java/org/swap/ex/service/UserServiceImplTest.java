package org.swap.ex.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.swap.ex.mock.UserPersistancePortMock;
import org.swap.ex.model.User;
import org.swap.ex.ports.input.UserUseCase;
import org.swap.ex.ports.output.UserPersistancePort;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceImplTest {

    private UserPersistancePort userPersistancePort;

    private UserUseCase userService;

    @BeforeEach
    void setup() {
        userPersistancePort = new UserPersistancePortMock();
        userService = new UserServiceImpl(userPersistancePort);
    }

    @Test
    public void should_save_user() {
        User user = createUser();
        var userSaved = userService.saveUser(user);
        assertTrue(userSaved != null);
        assertEquals(userSaved.get().getEmail(), "h.z@gmail.com");

    }

    @Test
    public void should_get_user_by_id() {
        User user = createUser();
        var userSaved = userService.saveUser(user);
        var userFinded = userService.getUserById(userSaved.get().getId());
        assertTrue(userFinded != null);
        assertEquals(userSaved.get().getEmail(), "h.z@gmail.com");

    }

    @Test
    public void should_update_user() {
        User user = createUser();
        var userSaved = userService.saveUser(user);
        userSaved.get().setName("Alfonso");
        var userUpdated = userService.updateUser(userSaved.get());
        var userFinded = userService.getUserById(userUpdated.get().getId());
        assertTrue(userFinded != null);
        assertEquals(userSaved.get().getName(), "Alfonso");

    }

    @Test
    public void should_delete_user() {
        User user = createUser();
        var userSaved = userService.saveUser(user);
        userService.deleteUser(userSaved.get().getId());
        var userFinded = userService.getUserById(userSaved.get().getId());
        assertTrue(userFinded.isEmpty());

    }

    private User createUser() {
        return User.builder().id(1).name("Haithem").location("Paris").email("h.z@gmail.com").build();
    }

}