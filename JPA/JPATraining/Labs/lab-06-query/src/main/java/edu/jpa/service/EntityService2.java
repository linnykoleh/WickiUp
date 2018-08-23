package edu.jpa.service;

import edu.jpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 01.03.15
 */
public class EntityService2 extends EntityService {
    @Override
    public List<Employee> getEmployeesByDepartmentName(String name) {
        return null;
    }

    @Override
    public List<DepartmentInfo> getDepartmentsInfo() {
        return null;
    }
}
