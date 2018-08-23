package edu.jpa.service;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 01.03.15
 */
public class DepartmentInfo {
    private final String departmentName;
    private final long employeesCount;

    public DepartmentInfo(String departmentName, long employeesCount) {
        this.departmentName = departmentName;
        this.employeesCount = employeesCount;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public long getEmployeesCount() {
        return employeesCount;
    }
}
