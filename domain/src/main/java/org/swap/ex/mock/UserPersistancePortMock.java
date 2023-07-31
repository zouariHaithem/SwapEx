package org.swap.ex.mock;

import org.swap.ex.model.User;
import org.swap.ex.ports.output.UserPersistancePort;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserPersistancePortMock implements UserPersistancePort {


    private final Map<Integer, User> users = new HashMap<>();


    @Override
    public User saveUser(User user) {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userUpdated = users.entrySet().stream().filter(userEntry -> userEntry.getValue().getId().equals(user.getId())).map(userEntry -> userEntry.setValue(user)).findFirst();

        return userUpdated.isPresent() ? userUpdated.get() : null;
    }

    @Override
    public void deleteUser(Integer userId) {
        users.remove(userId);
    }

    @Override
    public User getUserById(Integer userId) {
        var user = users.get(userId);

        return user;
    }
}
