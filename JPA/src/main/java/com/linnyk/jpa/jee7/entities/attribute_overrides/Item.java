package com.linnyk.jpa.jee7.entities.attribute_overrides;

import javax.persistence.*;

@MappedSuperclass
public abstract class Item {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Float price;
    private String description;

    public Item() {
    }

    public Item(String title, Float price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
