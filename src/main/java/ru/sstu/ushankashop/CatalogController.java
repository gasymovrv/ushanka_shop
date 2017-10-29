package ru.sstu.ushankashop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("catalog")
public class CatalogController {

    @Autowired
    @Qualifier("idao1")//здесь указываем то, что будем искать; по умолчанию ищет по типу
    private ItemDAO itemDAO;

    public ItemDAO getItemDAO() {
        return itemDAO;
    }

    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    /**
     *
     * @return то что будем возвращать клиенту, в виде MediaType.APPLICATION_JSON_VALUE
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getAllItems() {
        return getItemDAO().getAllItems();
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Item getItemById(@PathVariable Long id) {
        return getItemDAO().getItemById(id);
    }
}
