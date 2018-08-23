package edu.jpa.entity;

import javax.persistence.*;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 14.02.15
 */
@Entity
//@SequenceGenerator(
//        name = "mySequence",
//        sequenceName = "Department_1_SEQ",
//        initialValue = 100,
//        allocationSize = 5
//)
//@TableGenerator(
//        name = "myTable",
//        table = "GENERATORS",
//        pkColumnName = "GENERATE_NAME",
//        pkColumnValue = "Department",
//
//
//)
public class Department_1 {

    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "mySequence")
    private int id;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    @Column(name = "DESCRIPTION")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
