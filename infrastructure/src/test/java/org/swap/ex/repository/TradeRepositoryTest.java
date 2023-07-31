package org.swap.ex.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.swap.ex.config.TestConfig;
import org.swap.ex.entity.TradeEntity;
import org.swap.ex.entity.TradeStatutEntity;
import org.swap.ex.entity.UserEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

//@DataJpaTest
//@ContextConfiguration(classes = {PersistenceConfig.class})
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class TradeRepositoryTest extends TestConfig {

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private UserRepository userRepository;

    private TradeEntity trade;

    private UserEntity receiver;

    @BeforeEach
    public void setup() {

        receiver = UserEntity.builder()
                .id(1)
                .name("Haithem")
                .email("h.z@gmail.com")
                .password("12334")
                .location("tunis")
                .build();
        trade = TradeEntity.builder().statut(TradeStatutEntity.ACCEPTEDD).receiver(receiver)
                .build();
    }

//    @BeforeAll
//    public static void initTest() throws SQLException {
//        Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8083")
//                .start();
//    }

    @Test
    @DisplayName("JUnit test for save Trade operation")
    public void givenTradeObject_whenSave_thenReturnSavedTrade() {
        // when - action or the behaviour that we are going test
        TradeEntity savedTrade = tradeRepository.save(trade);

        // then - verify the output
        assertThat(savedTrade).isNotNull();
        assertThat(savedTrade.getId()).isGreaterThan(0);
    }

    @Test
    @DisplayName("JUnit test for get trade by Id operation")
    public void giventradeObject_whenFindTradeById_thenReturnTrade() {
        // when - action or the behaviour that we are going test
        tradeRepository.save(trade);
        TradeEntity savedTrade = tradeRepository.findById(trade.getId()).get();

        // then - verify the output
        assertThat(savedTrade).isNotNull();
    }


    @Test
    @DisplayName("JUnit test for Update Trade operation")
    public void giventradeObject_whenUpdateTrade_thenReturnUpdatedTrade() {
        // when - action or the behaviour that we are going test
        tradeRepository.save(trade);
        TradeEntity savedTrade = tradeRepository.findById(trade.getId()).get();
        savedTrade.setStatut(TradeStatutEntity.PENDING);
        TradeEntity updatedTrade = tradeRepository.save(savedTrade);

        // then - verify the output
        assertThat(updatedTrade.getId()).isEqualTo(trade.getId());
        assertThat(updatedTrade.getStatut()).isEqualTo(TradeStatutEntity.PENDING);

    }

    @Test
    @DisplayName("JUnit test for Delete Trade operation")
    public void giventradeObject_whenDeleteTrade_thenRemovedTrade() {
        // when - action or the behaviour that we are going test
        tradeRepository.save(trade);

        tradeRepository.deleteById(trade.getId());

        Optional<TradeEntity> tradeOptional = tradeRepository.findById(trade.getId());

        // then - verify the output
        assertThat(tradeOptional).isEmpty();

    }

    @Test
    @DisplayName("JUnit test for get trade by Id an receiverId")
    public void giventradeObject_whenFindTradeById_and_receiverId_thenReturnTrade() {
        // when - action or the behaviour that we are going test
        UserEntity savedUser = userRepository.save(receiver);
        tradeRepository.save(trade);
        TradeEntity savedTrade = tradeRepository.findByIdAndReceiverId(trade.getId(), savedUser.getId()).get();

        // then - verify the output
        assertThat(savedTrade).isNotNull();
    }


}