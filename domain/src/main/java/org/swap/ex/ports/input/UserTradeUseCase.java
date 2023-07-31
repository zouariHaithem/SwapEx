package org.swap.ex.ports.input;

import org.swap.ex.model.Trade;

import java.util.Optional;

public interface UserTradeUseCase {

    Optional<Trade> makeOffer(Trade trade, Integer offererId, Integer receiverId);

    Optional<Trade> acceptTrade(Integer tradeId, Integer receiverId);

    Optional<Trade> cancelTrade(Integer tradeId, Integer receiverId);
}
