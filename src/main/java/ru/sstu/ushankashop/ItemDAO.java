package ru.sstu.ushankashop;

import java.util.List;

public interface ItemDAO {
    List<Item> getAllItems();
    Item getItemById(Long id);
}
