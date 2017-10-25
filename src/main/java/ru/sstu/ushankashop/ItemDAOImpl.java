package ru.sstu.ushankashop;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemDAOImpl implements ItemDAO {
    private static List<Item> ITEMS = Arrays.asList(
            new Item(0L,"Hat-Ushanka","Warm and Cozy", 99.99,15),
            new Item(1L,"Hat","Warm", 7.99,4),
            new Item(2L,"Ushanka"," Cozy", 9.99,5)
    );

    public List<Item> getAllItems() {
        return ITEMS;
    }
}
