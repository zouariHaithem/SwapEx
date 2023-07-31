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
import org.swap.ex.entity.ItemEntity;

import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

//@DataJpaTest
//@ContextConfiguration(classes = {PersistenceConfig.class})
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ItemRepositoryTest extends TestConfig {

    @Autowired
    private ItemRepository itemRepository;

    private ItemEntity item;

    @BeforeEach
    public void setup() {


        item = ItemEntity.builder()
                .description("this is tshirt for exchange ")
                .image("link of picture")
                .title("first item to exchange")
                .build();
    }

//    @BeforeAll
//    public static void initTest() throws SQLException {
//        Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8084")
//                .start();
//    }

    @Test
    @DisplayName("JUnit test for save Item operation")
    public void givenItemObject_whenSave_thenReturnSavedItem() {
        // when - action or the behaviour that we are going test
        ItemEntity savedItem = itemRepository.save(item);

        // then - verify the output
        assertThat(savedItem).isNotNull();
        assertThat(savedItem.getId()).isGreaterThan(0);
    }

    @Test
    @DisplayName("JUnit test for get Item by Id operation")
    public void givenItemObject_whenFindItemById_thenReturnItem() {
        // when - action or the behaviour that we are going test
        itemRepository.save(item);
        ItemEntity savedItem = itemRepository.findById(item.getId()).get();

        // then - verify the output
        assertThat(savedItem).isNotNull();
    }


    @Test
    @DisplayName("JUnit test for Update Item operation")
    public void givenItemObject_whenUpdateItem_thenReturnUpdatedItem() {
        // when - action or the behaviour that we are going test
        itemRepository.save(item);
        ItemEntity savedItem = itemRepository.findById(item.getId()).get();
        savedItem.setTitle("second item to exchange");
        ItemEntity updatedItem = itemRepository.save(savedItem);

        // then - verify the output
        assertThat(updatedItem.getId()).isEqualTo(item.getId());
        assertThat(updatedItem.getTitle()).isEqualTo("second item to exchange");

    }

    @Test
    @DisplayName("JUnit test for Delete Item operation")
    public void givenItemObject_whenDeleteItem_thenRemovedItem() {
        // when - action or the behaviour that we are going test
        itemRepository.save(item);

        itemRepository.deleteById(item.getId());

        Optional<ItemEntity> itemOptional = itemRepository.findById(item.getId());

        // then - verify the output
        assertThat(itemOptional).isEmpty();

    }


}