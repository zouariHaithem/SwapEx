package org.swap.ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.swap.ex.entity.ItemEntity;
import org.swap.ex.entity.UserEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
}
