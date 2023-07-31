package org.swap.ex.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.swap.ex.entity.ItemEntity;
import org.swap.ex.mapper.ItemMapper;
import org.swap.ex.model.Item;
import org.swap.ex.ports.output.ItemPersistancePort;
import org.swap.ex.repository.ItemRepository;

import java.util.Optional;

@Service
public class ItemAdapter implements ItemPersistancePort {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item saveItem(Item item) {
        ItemEntity itemEntity = ItemMapper.INSTANCE.mapToItemEntity(item);
        return ItemMapper.INSTANCE.mapToItem(itemRepository.save(itemEntity));
    }

    @Override
    public Item updateItem(Item item) {
        return saveItem(item);
    }

    @Override
    public void deleteItem(Integer itemId) {
        itemRepository.deleteById(itemId);
    }

    @Override
    public Item getItemById(Integer itemId) {

        Optional<ItemEntity> itemEntity = itemRepository.findById(itemId);
        if (itemEntity.isPresent()) {
            return ItemMapper.INSTANCE.mapToItem(itemEntity.get());
        }
        return null;
    }
}
