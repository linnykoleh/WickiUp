package com.linnyk.jpa.tppc.entities.association.one_to_one.bidirectional;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_OO_B")
public class Item_B {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private long itemId;

    @Column(name = "NAME")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STAT_ID")
    private Statistic_B statisticB;

    public Item_B() {
    }

    public Item_B(String name, Statistic_B statisticB) {
        this.name = name;
        this.statisticB = statisticB;
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

    public Statistic_B getStatisticB() {
        return statisticB;
    }

    public void setStatisticB(Statistic_B statisticU) {
        this.statisticB = statisticU;
    }

    @Override
    public String toString() {
        return "Item_B{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", statisticU=" + statisticB.getStatisticId() +
                '}';
    }
}
