package edu.jpa.service;

import edu.jpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 01.03.15
 */
public class EntityService1 extends EntityService {

    @Override
    public List<Employee> getEmployeesByDepartmentName(String name) {
        return null;
    }

    @Override
    public List<DepartmentInfo> getDepartmentsInfo() {
        return null;
    }
}
