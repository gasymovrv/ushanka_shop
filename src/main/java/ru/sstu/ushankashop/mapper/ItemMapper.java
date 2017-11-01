package ru.sstu.ushankashop.mapper;


import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.sstu.ushankashop.domain.ItemEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component("itemMapper")
@Scope("prototype")
public class ItemMapper implements RowMapper<ItemEntity> {

    public ItemEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        return new ItemEntity(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getDouble("price"),
                resultSet.getInt("stock"),
                resultSet.getString("manufacturer")
        );
    }
}
