package com.linnyk.jpa.tppc.entities.association.many_to_one__one_to_many.unidirectional;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "BID_U")
public class BidU {

    @Id
    @GeneratedValue
    @Column(name = "BID_ID")
    private long id;

    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID") //FK
    private ItemU item;

    public BidU(BigDecimal price, ItemU item) {
        this.price = price;
        this.item = item;
    }

    public BidU() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ItemU getItem() {
        return item;
    }

    public void setItem(ItemU item) {
        this.item = item;
    }
}
