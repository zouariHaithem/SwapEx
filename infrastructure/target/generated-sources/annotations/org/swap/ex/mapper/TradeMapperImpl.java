package org.swap.ex.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.swap.ex.entity.TradeEntity;
import org.swap.ex.model.Trade;
import org.swap.ex.model.Trade.TradeBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-30T14:05:09+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TradeMapperImpl implements TradeMapper {

    @Override
    public Trade mapToTrade(TradeEntity tradeEntity) {
        if ( tradeEntity == null ) {
            return null;
        }

        TradeBuilder trade = Trade.builder();

        return trade.build();
    }

    @Override
    public TradeEntity mapToTradeEntity(Trade trade) {
        if ( trade == null ) {
            return null;
        }

        TradeEntity tradeEntity = new TradeEntity();

        return tradeEntity;
    }

    @Override
    public List<Trade> mapToListOfTrades(List<TradeEntity> tradeEntityList) {
        if ( tradeEntityList == null ) {
            return null;
        }

        List<Trade> list = new ArrayList<Trade>( tradeEntityList.size() );
        for ( TradeEntity tradeEntity : tradeEntityList ) {
            list.add( mapToTrade( tradeEntity ) );
        }

        return list;
    }

    @Override
    public List<TradeEntity> mapToTradeEntities(List<Trade> tradeList) {
        if ( tradeList == null ) {
            return null;
        }

        List<TradeEntity> list = new ArrayList<TradeEntity>( tradeList.size() );
        for ( Trade trade : tradeList ) {
            list.add( mapToTradeEntity( trade ) );
        }

        return list;
    }
}
