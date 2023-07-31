package org.swap.ex.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.swap.ex.mock.TradePersistancePortMock;
import org.swap.ex.mock.UserPersistancePortMock;
import org.swap.ex.model.Trade;
import org.swap.ex.model.TradeStatut;
import org.swap.ex.model.User;
import org.swap.ex.ports.input.TradeUseCase;
import org.swap.ex.ports.input.UserUseCase;
import org.swap.ex.ports.output.TradePersistancePort;
import org.swap.ex.ports.output.UserPersistancePort;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TradeServiceImplTest {

    private TradePersistancePort tradePersistancePort;

    private TradeUseCase tradeService;

    private UserPersistancePort userPersistancePort;

    private UserUseCase userService;

    @BeforeEach
    void setup() {
        tradePersistancePort = new TradePersistancePortMock();
        tradeService = new TradeServiceImpl(tradePersistancePort);

        userPersistancePort = new UserPersistancePortMock();
        userService = new UserServiceImpl(userPersistancePort);
    }

    @Test
    public void should_save_Trade() {
        Trade trade = createTrade();
        var tradeSaved = tradeService.initiateTrade(trade);
        assertTrue(tradeSaved.isPresent());
        assertEquals(tradeSaved.get().getStatut(), TradeStatut.ACCEPTEDD);

    }

    @Test
    public void should_get_Trade_by_id() {
        Trade trade = createTrade();
        var tradeSaved = tradeService.initiateTrade(trade);
        var tradeFinded = tradeService.getTradeById(tradeSaved.get().getId());
        assertTrue(tradeFinded != null);
        assertEquals(tradeSaved.get().getStatut(), TradeStatut.ACCEPTEDD);

    }

    @Test
    public void should_get_Trade_by_id_and_receiver_id() {
        User user = createUser();
        Optional<User> receiver = userService.saveUser(user);
        Trade trade = createTrade();
        trade.setReceiver(receiver.get());
        var tradeSaved = tradeService.initiateTrade(trade);
        var tradeFinded = tradeService.findByIdAndReceiverId(tradeSaved.get().getId(), receiver.get().getId());
        assertTrue(tradeFinded != null);
        assertEquals(tradeSaved.get().getStatut(), TradeStatut.ACCEPTEDD);

    }

    @Test
    public void should_update_Trade() {
        Trade trade = createTrade();
        var tradeSaved = tradeService.initiateTrade(trade);
        tradeSaved.get().setStatut(TradeStatut.PENDING);
        var tradeUpdated = tradeService.updateTrade(tradeSaved.get());
        var tradeFinded = tradeService.getTradeById(tradeUpdated.get().getId());
        assertTrue(tradeFinded != null);
        assertEquals(tradeSaved.get().getStatut(), TradeStatut.PENDING);

    }

    private Trade createTrade() {
        return Trade.builder().id(1).statut(TradeStatut.ACCEPTEDD).build();
    }

    private User createUser() {
        return User.builder().id(1).name("Haithem").location("Paris").email("h.z@gmail.com").build();
    }


}