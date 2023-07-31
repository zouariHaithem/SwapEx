package org.swap.ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.swap.ex.entity.TradeEntity;
import org.swap.ex.entity.UserEntity;

import java.util.Optional;

@Repository
public interface TradeRepository extends JpaRepository<TradeEntity, Integer> {

    Optional<TradeEntity> findByIdAndReceiverId(Integer id, Integer receiver);

}
