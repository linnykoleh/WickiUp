package edu.jpa.entity;

import javax.persistence.*;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 01.02.15
 */
@Table(name = "Company")
@Entity
public class Company {
    @Id
    @Column(name = "Company_id", table = "Company")
    private int id;

    @Column(name = "Company_name", table = "Company")
    private String name;

    @Column(name = "CompanyDetail_address", table = "CompanyDetail")
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
