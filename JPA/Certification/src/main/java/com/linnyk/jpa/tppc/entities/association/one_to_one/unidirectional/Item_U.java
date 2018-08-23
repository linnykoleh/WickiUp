package com.linnyk.jpa.tppc.entities.association.one_to_one.unidirectional;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_OO_U")
public class Item_U {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private long itemId;

    @Column(name = "NAME")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STAT_ID")
    private Statistic_U statisticU;

    public Item_U() {
    }

    public Item_U(String name, Statistic_U statisticU) {
        this.name = name;
        this.statisticU = statisticU;
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

    public Statistic_U getStatisticU() {
        return statisticU;
    }

    public void setStatisticU(Statistic_U statisticU) {
        this.statisticU = statisticU;
    }

    @Override
    public String toString() {
        return "Item_U{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", statisticU=" + statisticU +
                '}';
    }
}
