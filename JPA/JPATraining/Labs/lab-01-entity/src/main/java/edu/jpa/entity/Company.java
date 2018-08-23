package edu.jpa.entity;

import javax.persistence.*;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 01.02.15
 */
@Entity
@Table(name = "Company")
@SecondaryTable(name = "CompanyDetail", pkJoinColumns = @PrimaryKeyJoinColumn(name = "Company_id", referencedColumnName = "Company_id"))
public class Company {

    @Id
    @Column(name = "Company_id", table = "Company")
    private int id;

    @Column(name = "NAME", table = "Company")
    private String name;

    @Column(name = "ADDRESS", table = "CompanyDetail")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
