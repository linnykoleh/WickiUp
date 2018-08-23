package edu.jpa.blog.domain;

import javax.persistence.*;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 09.03.15
 */
public abstract class DomainObject {
    private int id;
    private int version;

    public int getId() {
        return id;
    }
}
