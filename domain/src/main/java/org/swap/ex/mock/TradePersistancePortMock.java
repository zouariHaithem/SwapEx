package org.swap.ex.mock;

import org.swap.ex.model.Trade;
import org.swap.ex.ports.output.TradePersistancePort;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TradePersistancePortMock implements TradePersistancePort {


    private final Map<Integer, Trade> trades = new HashMap<>();


    @Override
    public Trade saveTrade(Trade trade) {
        trades.put(trade.getId(), trade);
        return trade;
    }

    @Override
    public Trade updateTrade(Trade trade) {
        Optional<Trade> tradeUpdated = trades.entrySet().stream().filter(tradeEntry -> tradeEntry.getValue().getId().equals(trade.getId())).map(tradeEntry -> tradeEntry.setValue(trade)).findFirst();

        return tradeUpdated.isPresent() ? tradeUpdated.get() : null;
    }

    @Override
    public void deleteTrade(Integer tradeId) {
        trades.remove(tradeId);
    }

    @Override
    public Trade getTradeById(Integer tradeId) {
        var trade = trades.get(tradeId);

        return trade;
    }

    @Override
    public Trade findByIdAndReceiverId(Integer tradeId, Integer receiverId) {
        Optional<Trade> trade = trades.entrySet().stream().filter(tradeEntry -> tradeEntry.getValue().getId() == tradeId && tradeEntry.getValue().getReceiver().getId() == receiverId).map(integerTradeEntry -> integerTradeEntry.getValue()).findFirst();
        return trade.get();
    }
}
