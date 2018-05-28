package com.linnyk.jpa.tppc.entities.association.many_to_many.unidirectional;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATEGORY_MM_U")
public class CategoryU {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private long categoryId;

    @Column(name = "CATEGORY_NAME")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = {@JoinColumn(name = "CATEGORY_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ITEM_ID")})
    private List<ItemU> items;

    public CategoryU(String name, List<ItemU> items) {
        this.name = name;
        this.items = items;
    }

    public CategoryU() {
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemU> getItems() {
        return items;
    }

    public void setItems(List<ItemU> items) {
        this.items = items;
    }
}
