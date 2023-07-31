package org.swap.ex.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.swap.ex.entity.TradeEntity;
import org.swap.ex.model.Trade;

import java.util.List;

@Mapper
public interface TradeMapper {

    TradeMapper INSTANCE = Mappers.getMapper(TradeMapper.class);

    Trade mapToTrade(TradeEntity tradeEntity);

    TradeEntity mapToTradeEntity(Trade trade);

    List<Trade> mapToListOfTrades(List<TradeEntity> tradeEntityList);

    List<TradeEntity> mapToTradeEntities(List<Trade> tradeList);
}
