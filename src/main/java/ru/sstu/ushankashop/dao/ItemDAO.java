package ru.sstu.ushankashop.dao;

import ru.sstu.ushankashop.domain.ItemEntity;

import java.util.List;

public interface ItemDAO {
    List<ItemEntity> getAllItems();
    ItemEntity getItemById(Long id);
}
