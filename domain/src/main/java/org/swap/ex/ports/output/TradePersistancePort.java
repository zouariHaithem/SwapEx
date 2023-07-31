package org.swap.ex.ports.output;

import org.swap.ex.model.Trade;

public interface TradePersistancePort {

    Trade saveTrade(Trade trade);

    Trade updateTrade(Trade trade);

    void deleteTrade(Integer tradeId);

    Trade getTradeById(Integer tradeId);

    Trade findByIdAndReceiverId(Integer tradeId, Integer receiverId);

}
