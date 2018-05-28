package com.linnyk.jpa.tppc.entities.association.many_to_many.bidirectional;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ITEM_MM_B")
public class ItemB {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private long itemId;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "items") //для двунаправленной связи
    private List<CategoryB> categories;

    public ItemB(String name) {
        this.name = name;
    }

    public ItemB() {
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryB> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryB> categories) {
        this.categories = categories;
    }

}
