package org.swap.ex.model;


import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class Trade {

    Integer id;
    User offerer;
    User receiver;
    List<Item> offeredItems;
    List<Item> desiredItem;
    TradeStatut statut;

}
