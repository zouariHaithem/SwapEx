package org.swap.ex.model;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {

    Integer id;
    String name;
    String email;
    String password;
    String location;
    List<Item> items;
    List<Trade> offererTrades;
    List<Trade> receiverTrades;

}
