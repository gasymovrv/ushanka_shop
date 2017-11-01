package ru.sstu.ushankashop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.sstu.ushankashop.dao.ItemDAO;
import ru.sstu.ushankashop.domain.ItemEntity;
import ru.sstu.ushankashop.mapper.ItemMapper;
import java.util.List;

@Service
public class ItemDAOImpl implements ItemDAO {
    private ItemMapper itemMapper;
    private JdbcTemplate jdbcTemplate;

    public ItemDAOImpl() {
    }

    public ItemMapper getItemMapper() {
        return itemMapper;
    }

    @Autowired
    @Qualifier("itemMapper")
    public void setItemMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    @Qualifier("jdbcTemplate")
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<ItemEntity> getAllItems() {
        String sql = "SELECT * FROM item";
        return jdbcTemplate.query(sql, itemMapper);
    }

    @Override
    public ItemEntity getItemById(Long id) {
        String sql = "SELECT * FROM item WHERE id=?";
        return jdbcTemplate.queryForObject(sql, itemMapper, id);
    }


//    public void insert(ItemEntity item) {
//        String sql = "INSERT INTO item (name, email, age) VALUES (?, ?, ?)";
//        jdbcTemplate.update(sql, item.getName(), item.getEmail(), item.getAge());
//
//    }
//
//    public void update(ItemEntity item) {
//        String sql = "UPDATE item SET name=?, email=?, age=? WHERE id=?";
//        jdbcTemplate.update(sql, item.getName(), item.getEmail(), item.getAge(), item.getId());
//    }
//
//    public void delete(int id) {
//        String sql = "DELETE FROM item WHERE id=?";
//        jdbcTemplate.update(sql, id);
//
//    }

}
