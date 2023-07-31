package org.swap.ex.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.swap.ex.entity.UserEntity;
import org.swap.ex.model.User;
import org.swap.ex.model.User.UserBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-30T14:05:09+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User mapToUser(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        return user.build();
    }

    @Override
    public UserEntity mapToUserEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        return userEntity;
    }

    @Override
    public List<User> mapToListOfUsers(List<UserEntity> userEntityList) {
        if ( userEntityList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userEntityList.size() );
        for ( UserEntity userEntity : userEntityList ) {
            list.add( mapToUser( userEntity ) );
        }

        return list;
    }

    @Override
    public List<UserEntity> mapToUserEntities(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserEntity> list = new ArrayList<UserEntity>( userList.size() );
        for ( User user : userList ) {
            list.add( mapToUserEntity( user ) );
        }

        return list;
    }
}
