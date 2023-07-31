package org.swap.ex.ports.input;

import org.swap.ex.model.Trade;

import java.util.Optional;

public interface TradeUseCase {

    Optional<Trade> initiateTrade(Trade trade);

    Optional<Trade> getTradeById(Integer tradeId);

    Optional<Trade> findByIdAndReceiverId(Integer tradeId, Integer receiverId);

    Optional<Trade> updateTrade(Trade trade);

    void deleteTrade(Integer tradeId);
}
