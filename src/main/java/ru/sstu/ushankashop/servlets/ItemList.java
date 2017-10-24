package ru.sstu.ushankashop.servlets;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "itemList")
@XmlAccessorType(XmlAccessType.NONE)//маршаллим только то что сами аннотируем
public class ItemList {
    @XmlElement(name = "i")
    private List<Item> items;

    public ItemList() {
    }

    public ItemList(List<Item> items) {
        this.items = items;
    }
}
