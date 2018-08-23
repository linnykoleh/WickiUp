package com.linnyk.jpa.certification.entities;

import javax.persistence.*;

@Entity
@Access(value = AccessType.PROPERTY)
public class FieldPropertyName {

    private long id;
    private String name;

    public FieldPropertyName() {
    }

    public FieldPropertyName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public long getId(){
        return id;
    }

    @Column(name = "NAME")
    public String getName(){
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
