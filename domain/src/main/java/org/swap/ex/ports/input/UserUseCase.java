package org.swap.ex.ports.input;

import org.swap.ex.model.User;

import java.util.Optional;

public interface UserUseCase {

    Optional<User> saveUser(User user);

    Optional<User> updateUser(User user);

    void deleteUser(Integer userId);

    Optional<User> getUserById(Integer userId);

}
