package org.swap.ex.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "utilisateur")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    String email;
    String password;
    String location;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner",cascade = CascadeType.ALL)
    List<ItemEntity> items;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "offerer",cascade = CascadeType.ALL)
    List<TradeEntity> offererTrades ;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "receiver",cascade = CascadeType.ALL)
    List<TradeEntity> receiverTrades ;

}
