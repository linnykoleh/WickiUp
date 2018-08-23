package edu.jpa.blog.domain;

import javax.persistence.*;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 09.03.15
 */
@MappedSuperclass
public abstract class DomainObject {
    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || !(o == null || getClass() != o.getClass()) && id == ((DomainObject) o).id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
