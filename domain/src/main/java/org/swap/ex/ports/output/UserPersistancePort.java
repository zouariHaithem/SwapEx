package org.swap.ex.ports.output;

import org.swap.ex.model.User;

public interface UserPersistancePort {

    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(Integer userId);

    User getUserById(Integer userId);
}
