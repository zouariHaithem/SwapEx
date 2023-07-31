package org.swap.ex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.swap.ex.adapters.ItemAdapter;
import org.swap.ex.adapters.TradeAdapter;
import org.swap.ex.adapters.UserAdapter;
import org.swap.ex.ports.input.*;
import org.swap.ex.ports.output.ItemPersistancePort;
import org.swap.ex.ports.output.TradePersistancePort;
import org.swap.ex.ports.output.UserPersistancePort;
import org.swap.ex.service.*;

@Configuration
public class SwapExConfig {

    @Bean
    public UserPersistancePort userPersistancePort() {
        return new UserAdapter();
    }

    @Bean
    public UserUseCase userService() {
        return new UserServiceImpl(userPersistancePort());
    }

    @Bean
    public ItemPersistancePort itemPersistancePort() {
        return new ItemAdapter();
    }

    @Bean
    public ItemUseCase itemService() {
        return new ItemServiceImpl(itemPersistancePort());
    }

    @Bean
    public TradePersistancePort tradePersistancePort() {
        return new TradeAdapter();
    }

    @Bean
    public TradeUseCase tradeService() {
        return new TradeServiceImpl(tradePersistancePort());
    }

    @Bean
    public UserTradeUseCase userTradeService() {
        return new UserTradeServiceImpl(userService(), tradeService());
    }

    @Bean
    public UserItemUseCase userItemService() {
        return new UserItemServiceImpl(userService(), itemService());
    }
}
