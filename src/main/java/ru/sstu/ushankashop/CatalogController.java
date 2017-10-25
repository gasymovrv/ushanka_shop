package ru.sstu.ushankashop;

import org.springframework.beans.factory.annotation.Autowired;
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
    private ItemDAO itemDAO;

    public ItemDAO getItemDAO() {
        return itemDAO;
    }

    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getAllItems(){
        return getItemDAO().getAllItems();
    }

    //TODO перенести логику по поиску Item в ItemDAO
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Item getItemByID(@PathVariable Long id){
        for (int i = 0; i < getItemDAO().getAllItems().size(); i++) {
            if (getItemDAO().getAllItems().get(i).getId().equals(id)) {
                return getItemDAO().getAllItems().get(i);
            }
        }
        return null;
    }
}
