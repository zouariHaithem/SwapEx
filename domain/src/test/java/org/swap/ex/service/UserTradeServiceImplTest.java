package org.swap.ex.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.swap.ex.mock.TradePersistancePortMock;
import org.swap.ex.mock.UserPersistancePortMock;
import org.swap.ex.model.Trade;
import org.swap.ex.model.TradeStatut;
import org.swap.ex.model.User;
import org.swap.ex.ports.input.TradeUseCase;
import org.swap.ex.ports.input.UserTradeUseCase;
import org.swap.ex.ports.input.UserUseCase;
import org.swap.ex.ports.output.TradePersistancePort;
import org.swap.ex.ports.output.UserPersistancePort;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTradeServiceImplTest {

    private UserPersistancePort userPersistancePort;

    private TradePersistancePort tradePersistancePort;

    private UserUseCase userService;

    private TradeUseCase tradeService;

    private UserTradeUseCase userTradeService;

    @BeforeEach
    void setup() {
        userPersistancePort = new UserPersistancePortMock();
        userService = new UserServiceImpl(userPersistancePort);
        tradePersistancePort = new TradePersistancePortMock();
        tradeService = new TradeServiceImpl(tradePersistancePort);
        userTradeService = new UserTradeServiceImpl(userService, tradeService);
    }

    @Test
    public void should_make_offer() {
        User offerer = createOfferer();
        User receiver = createReceiver();
        userService.saveUser(offerer);
        userService.saveUser(receiver);
        Optional<Trade> trade = userTradeService.makeOffer(createTrade(), offerer.getId(), receiver.getId());
        assertTrue(trade.isPresent());
        assertEquals(trade.get().getStatut(), TradeStatut.PENDING);
    }

    @Test
    public void acceptTrade() {
        Trade trade = createTrade();
        User receiver = createReceiver();
        trade.setReceiver(receiver);
        tradeService.initiateTrade(trade);
        Optional<Trade> tradeAccepted = userTradeService.acceptTrade(trade.getId(), receiver.getId());
        assertTrue(tradeAccepted.isPresent());
        assertEquals(tradeAccepted.get().getStatut(), TradeStatut.ACCEPTEDD);
    }

    @Test
    public void cancelTrade() {
        Trade trade = createTrade();
        User offerer = createOfferer();
        trade.setReceiver(offerer);
        tradeService.initiateTrade(trade);
        Optional<Trade> tradeAccepted = userTradeService.cancelTrade(trade.getId(), offerer.getId());
        assertTrue(tradeAccepted.isPresent());
        assertEquals(tradeAccepted.get().getStatut(), TradeStatut.REJECTED);
    }


    private User createOfferer() {
        return User.builder().id(1).name("Haithem").location("Paris").email("h.z@gmail.com").build();
    }

    private User createReceiver() {
        return User.builder().id(2).name("Iheb").location("Paris").email("Iheb.z@gmail.com").build();
    }

    private Trade createTrade() {
        return Trade.builder().id(1).statut(TradeStatut.PENDING).build();
    }
}