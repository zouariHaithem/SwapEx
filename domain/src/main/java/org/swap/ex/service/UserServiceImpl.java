package org.swap.ex.service;

import org.swap.ex.model.User;
import org.swap.ex.ports.input.UserUseCase;
import org.swap.ex.ports.output.UserPersistancePort;

import java.util.Optional;

public class UserServiceImpl implements UserUseCase {

    private UserPersistancePort userPersistancePort;

    public UserServiceImpl(UserPersistancePort userPersistancePort) {
        this.userPersistancePort = userPersistancePort;
    }


    @Override
    public Optional<User> saveUser(User user) {
        return Optional.of(userPersistancePort.saveUser(user));
    }

    @Override
    public Optional<User> updateUser(User user) {
        return Optional.of(userPersistancePort.updateUser(user));
    }

    @Override
    public void deleteUser(Integer userId) {
        userPersistancePort.deleteUser(userId);
    }

    @Override
    public Optional<User> getUserById(Integer userId) {
        return Optional.ofNullable(userPersistancePort.getUserById(userId));
    }
}
