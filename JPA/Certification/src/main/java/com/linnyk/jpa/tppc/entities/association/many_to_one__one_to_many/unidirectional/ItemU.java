package com.linnyk.jpa.tppc.entities.association.many_to_one__one_to_many.unidirectional;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_U")
public class ItemU {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    public ItemU(String name) {
        this.name = name;
    }

    public ItemU() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
