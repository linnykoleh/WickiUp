package edu.jpa.entity.embeddables;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 15.02.15
 */
@Embeddable
public class Project implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
