package com.linnyk.jpa.tppc.entities.association.many_to_many.bidirectional;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATEGORY_MM_B")
public class CategoryB {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private long categoryId;

    @Column(name = "CATEGORY_NAME")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CATEGORY_ITEM_B",
            joinColumns = {@JoinColumn(name = "CATEGORY_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ITEM_ID")})
    private List<ItemB> items;

    public CategoryB(String name, List<ItemB> items) {
        this.name = name;
        this.items = items;
    }

    public CategoryB() {
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

    public List<ItemB> getItems() {
        return items;
    }

    public void setItems(List<ItemB> items) {
        this.items = items;
    }
}
