package com.linnyk.jpa.certification.entities.lazy_initialization_exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "COMMENT_LIE")
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "COMMENT_ID")
    private long commentId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "VALUE")
    private String value;

    @ManyToOne
    @JoinColumn(name = "USER_ID") //FK
    private User user;

    public Comment(String title, String value) {
        this.title = title;
        this.value = value;
    }
}
