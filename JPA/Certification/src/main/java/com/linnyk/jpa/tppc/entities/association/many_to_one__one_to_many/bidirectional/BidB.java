package com.linnyk.jpa.tppc.entities.association.many_to_one__one_to_many.bidirectional;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "BID_B")
public class BidB {

    @Id
    @GeneratedValue
    @Column(name = "BID_ID")
    private long id;

    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID") //FK
    private ItemB itemB;

    public BidB(BigDecimal price, ItemB itemB) {
        this.price = price;
        this.itemB = itemB;
    }

    public BidB() {
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

    public ItemB getItemB() {
        return itemB;
    }

    public void setItemB(ItemB itemB) {
        this.itemB = itemB;
    }
}
