package org.swap.ex.repository;

import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.swap.ex.config.PersistenceConfig;
import org.swap.ex.config.TestConfig;
import org.swap.ex.entity.UserEntity;

import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

//@DataJpaTest
//@ContextConfiguration(classes = {PersistenceConfig.class})
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class UserRepositoryTest extends TestConfig {

    @Autowired
    private UserRepository userRepository;

    private UserEntity user;

    @BeforeEach
    public void setup() {
        user = UserEntity.builder()
                .name("Haithem")
                .email("h.z@gmail.com")
                .password("12334")
                .location("tunis")
                .build();
    }



    @Test
    @DisplayName("JUnit test for save User operation")
    public void givenUserObject_whenSave_thenReturnSavedUser() {
        // when - action or the behaviour that we are going test
        UserEntity savedUser = userRepository.save(user);

        // then - verify the output
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    @DisplayName("JUnit test for get User by Id operation")
    public void givenUserObject_whenFindUserById_thenReturnUser() {
        // when - action or the behaviour that we are going test
        userRepository.save(user);
        UserEntity savedUser = userRepository.findById(user.getId()).get();

        // then - verify the output
        assertThat(savedUser).isNotNull();
    }


    @Test
    @DisplayName("JUnit test for Update User operation")
    public void givenUserObject_whenUpdateUser_thenReturnUpdatedUser() {
        // when - action or the behaviour that we are going test
        userRepository.save(user);
        UserEntity savedUser = userRepository.findById(user.getId()).get();
        savedUser.setName("Lucas");
        UserEntity updatedUser = userRepository.save(savedUser);

        // then - verify the output
        assertThat(updatedUser.getId()).isEqualTo(user.getId());
        assertThat(updatedUser.getName()).isEqualTo("Lucas");

    }

    @Test
    @DisplayName("JUnit test for Delete User operation")
    public void givenUserObject_whenDeleteUser_thenRemovedUser() {
        // when - action or the behaviour that we are going test
        userRepository.save(user);

        userRepository.deleteById(user.getId());

        Optional<UserEntity> userOptional = userRepository.findById(user.getId());

        // then - verify the output
        assertThat(userOptional).isEmpty();

    }


}