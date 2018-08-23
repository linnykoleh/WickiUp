package com.linnyk.jpa.tppc.entities.association.many_to_many.unidirectional;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_MM_U")
public class ItemU {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private long itemId;

    @Column(name = "NAME")
    private String name;

    public ItemU(String name) {
        this.name = name;
    }

    public ItemU() {
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

    @Override
    public String toString() {
        return "ItemU{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                '}';
    }
}
