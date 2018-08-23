package edu.jpa.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 14.02.15
 */
@Entity
public class Department_2 {

    @EmbeddedId
    private DepartmentKey id;
    private String description;

    public DepartmentKey getId() {
        return id;
    }

    public void setId(DepartmentKey id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
