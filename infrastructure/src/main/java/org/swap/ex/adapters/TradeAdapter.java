package org.swap.ex.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.swap.ex.entity.TradeEntity;
import org.swap.ex.mapper.TradeMapper;
import org.swap.ex.model.Trade;
import org.swap.ex.ports.output.TradePersistancePort;
import org.swap.ex.repository.TradeRepository;

import java.util.Optional;

@Service
public class TradeAdapter implements TradePersistancePort {

    @Autowired
    private TradeRepository tradeRepository;

    @Override
    public Trade saveTrade(Trade trade) {

        TradeEntity tradeEntity = TradeMapper.INSTANCE.mapToTradeEntity(trade);
        return TradeMapper.INSTANCE.mapToTrade(tradeRepository.save(tradeEntity));
    }

    @Override
    public Trade updateTrade(Trade trade) {
        return saveTrade(trade);
    }

    @Override
    public void deleteTrade(Integer tradeId) {
        tradeRepository.deleteById(tradeId);
    }

    @Override
    public Trade getTradeById(Integer tradeId) {
        Optional<TradeEntity> tradeEntity = tradeRepository.findById(tradeId);
        if (tradeEntity.isPresent()) {
            return TradeMapper.INSTANCE.mapToTrade(tradeEntity.get());
        }
        return null;
    }

    @Override
    public Trade findByIdAndReceiverId(Integer tradeId, Integer receiverId) {
        Optional<TradeEntity> tradeEntity = tradeRepository.findByIdAndReceiverId(tradeId,receiverId);
        if (tradeEntity.isPresent()) {
            return TradeMapper.INSTANCE.mapToTrade(tradeEntity.get());
        }
        return null;
    }
}
