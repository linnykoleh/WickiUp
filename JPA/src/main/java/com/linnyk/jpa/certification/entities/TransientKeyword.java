package com.linnyk.jpa.certification.entities;

import javax.persistence.*;

@Entity
@Table(name = "TRANSIENT_KEYWORD")
public class TransientKeyword {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Transient
    private String valueOld;

    private transient String valueNew;


    public TransientKeyword(String name, String valueOld, String valueNew) {
        this.name = name;
        this.valueOld = valueOld;
        this.valueNew = valueNew;
    }

    public TransientKeyword() {
    }
}
