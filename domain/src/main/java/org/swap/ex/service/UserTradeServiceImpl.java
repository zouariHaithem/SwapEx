package org.swap.ex.service;

import org.swap.ex.model.Trade;
import org.swap.ex.model.TradeStatut;
import org.swap.ex.model.User;
import org.swap.ex.ports.input.TradeUseCase;
import org.swap.ex.ports.input.UserTradeUseCase;
import org.swap.ex.ports.input.UserUseCase;

import java.util.Optional;

public class UserTradeServiceImpl implements UserTradeUseCase {

    private UserUseCase userService;

    private TradeUseCase tradeService;

    public UserTradeServiceImpl(UserUseCase userService, TradeUseCase tradeService) {
        this.userService = userService;
        this.tradeService = tradeService;
    }

    @Override
    public Optional<Trade> makeOffer(Trade trade, Integer offererId, Integer receiverId) {
        trade.setStatut(TradeStatut.PENDING);
        Optional<User> offererUser = userService.getUserById(offererId);
        Optional<User> receiverUser = userService.getUserById(offererId);
        trade.setOfferer(offererUser.get());
        trade.setReceiver(receiverUser.get());
        return tradeService.initiateTrade(trade);
    }

    @Override
    public Optional<Trade> acceptTrade(Integer tradeId, Integer receiverId) {
        Optional<Trade> trade = tradeService.findByIdAndReceiverId(tradeId, receiverId);
        if (trade.isPresent()) {
            trade.get().setStatut(TradeStatut.ACCEPTEDD);
            return tradeService.updateTrade(trade.get());
        }

        return null;
    }

    @Override
    public Optional<Trade> cancelTrade(Integer tradeId, Integer receiverId) {
        Optional<Trade> trade = tradeService.findByIdAndReceiverId(tradeId, receiverId);
        if (trade.isPresent()) {
            trade.get().setStatut(TradeStatut.REJECTED);
            return tradeService.updateTrade(trade.get());
        }

        return null;
    }
}
