package org.swap.ex.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.swap.ex.entity.ItemEntity;
import org.swap.ex.model.Item;
import org.swap.ex.model.Item.ItemBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-30T14:05:09+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ItemMapperImpl implements ItemMapper {

    @Override
    public Item mapToItem(ItemEntity itemEntity) {
        if ( itemEntity == null ) {
            return null;
        }

        ItemBuilder item = Item.builder();

        return item.build();
    }

    @Override
    public ItemEntity mapToItemEntity(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemEntity itemEntity = new ItemEntity();

        return itemEntity;
    }

    @Override
    public List<Item> mapToListOfItems(List<ItemEntity> itemEntityList) {
        if ( itemEntityList == null ) {
            return null;
        }

        List<Item> list = new ArrayList<Item>( itemEntityList.size() );
        for ( ItemEntity itemEntity : itemEntityList ) {
            list.add( mapToItem( itemEntity ) );
        }

        return list;
    }

    @Override
    public List<ItemEntity> mapToItemEntities(List<Item> itemList) {
        if ( itemList == null ) {
            return null;
        }

        List<ItemEntity> list = new ArrayList<ItemEntity>( itemList.size() );
        for ( Item item : itemList ) {
            list.add( mapToItemEntity( item ) );
        }

        return list;
    }
}
