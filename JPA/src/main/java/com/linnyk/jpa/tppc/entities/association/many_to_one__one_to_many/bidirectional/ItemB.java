package com.linnyk.jpa.tppc.entities.association.many_to_one__one_to_many.bidirectional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ITEM_B")
public class ItemB {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "itemB", //используется только когда связь двунаправлена
                                   // имя поля, которое ссылается с другой стороны
            cascade = CascadeType.ALL)
    private List<BidB> bidB = new ArrayList();

    public ItemB(String name) {
        this.name = name;
    }

    public ItemB() {
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

    public List<BidB> getBidB() {
        return bidB;
    }

    public void setBidB(List<BidB> bidB) {
        this.bidB = bidB;
    }
}
