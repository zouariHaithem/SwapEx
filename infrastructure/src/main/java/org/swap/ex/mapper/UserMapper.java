package org.swap.ex.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.swap.ex.entity.UserEntity;
import org.swap.ex.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapToUser(UserEntity userEntity);

    UserEntity mapToUserEntity(User user);

    List<User> mapToListOfUsers(List<UserEntity> userEntityList);

    List<UserEntity> mapToUserEntities(List<User> userList);
}
