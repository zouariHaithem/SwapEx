package org.swap.ex.service;

import org.swap.ex.model.Trade;
import org.swap.ex.ports.input.TradeUseCase;
import org.swap.ex.ports.output.TradePersistancePort;

import java.util.Optional;

public class TradeServiceImpl implements TradeUseCase {


    private TradePersistancePort tradePersistancePort;

    public TradeServiceImpl(TradePersistancePort tradePersistancePort) {
        this.tradePersistancePort = tradePersistancePort;
    }

    @Override
    public Optional<Trade> initiateTrade(Trade trade) {
        return Optional.of(tradePersistancePort.saveTrade(trade));
    }

    @Override
    public Optional<Trade> getTradeById(Integer tradeId) {
        return Optional.of(tradePersistancePort.getTradeById(tradeId));
    }

    @Override
    public Optional<Trade> findByIdAndReceiverId(Integer tradeId, Integer receiverId) {
        return Optional.of(tradePersistancePort.findByIdAndReceiverId(tradeId, receiverId));
    }

    @Override
    public Optional<Trade> updateTrade(Trade trade) {
        return Optional.of(tradePersistancePort.updateTrade(trade));
    }

    @Override
    public void deleteTrade(Integer tradeId) {
        tradePersistancePort.deleteTrade(tradeId);
    }
}
