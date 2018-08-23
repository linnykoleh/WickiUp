package com.linnyk.jpa.tppc.entities.association.one_to_one.bidirectional;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "STATISTIC_B")
public class Statistic_B {

    @Id
    @GeneratedValue
    @Column(name = "STAT_ID")
    private long statisticId;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToOne(mappedBy = "statisticB") // mappedBy для bidirectional связи
    private Item_B item_b;

    public Statistic_B() {
    }

    public Statistic_B(int price, Date date) {
        this.price = price;
        this.date = date;
    }

    public long getStatisticId() {
        return statisticId;
    }

    public void setStatisticId(long statisticId) {
        this.statisticId = statisticId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Item_B getItem_b() {
        return item_b;
    }

    public void setItem_b(Item_B item_b) {
        this.item_b = item_b;
    }

    @Override
    public String toString() {
        return "Statistic_B{" +
                "statisticId=" + statisticId +
                ", price=" + price +
                ", date=" + date +
                ", item_b=" + item_b.getItemId() +
                '}';
    }
}
