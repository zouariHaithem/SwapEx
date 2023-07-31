package org.swap.ex.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.swap.ex.entity.UserEntity;
import org.swap.ex.mapper.UserMapper;
import org.swap.ex.model.User;
import org.swap.ex.ports.output.UserPersistancePort;
import org.swap.ex.repository.UserRepository;

import java.util.Optional;

@Service
public class UserAdapter implements UserPersistancePort {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {

        UserEntity userEntity = UserMapper.INSTANCE.mapToUserEntity(user);
        return UserMapper.INSTANCE.mapToUser(userRepository.save(userEntity));
    }

    @Override
    public User updateUser(User user) {

        return saveUser(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserById(Integer userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if (userEntity.isPresent()) {
            return UserMapper.INSTANCE.mapToUser(userEntity.get());
        }
        return null;
    }

}
