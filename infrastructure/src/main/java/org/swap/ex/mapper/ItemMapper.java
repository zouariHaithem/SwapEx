package org.swap.ex.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.swap.ex.entity.ItemEntity;
import org.swap.ex.entity.UserEntity;
import org.swap.ex.model.Item;
import org.swap.ex.model.User;

import java.util.List;

@Mapper
public interface ItemMapper {

    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    Item mapToItem(ItemEntity itemEntity);

    ItemEntity mapToItemEntity(Item item);

    List<Item> mapToListOfItems(List<ItemEntity> itemEntityList);

    List<ItemEntity> mapToItemEntities(List<Item> itemList);
}
