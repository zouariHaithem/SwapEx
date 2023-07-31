package org.swap.ex.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "trade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TradeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    UserEntity offerer;
    @ManyToOne(fetch = FetchType.LAZY)
    UserEntity receiver;
    @OneToMany(fetch = FetchType.LAZY)
    List<ItemEntity> offeredItems;
    @OneToMany(fetch = FetchType.LAZY)
    List<ItemEntity> desiredItem;
    TradeStatutEntity statut;

}
