package com.linnyk.jpa.tppc.entities.association.one_to_one.unidirectional;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "STATISTIC_U")
public class Statistic_U {

    @Id
    @GeneratedValue
    @Column(name = "STAT_ID")
    private long statisticId;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Statistic_U() {
    }

    public Statistic_U(int price, Date date) {
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

    @Override
    public String toString() {
        return "Statistic_U{" +
                "statisticId=" + statisticId +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
