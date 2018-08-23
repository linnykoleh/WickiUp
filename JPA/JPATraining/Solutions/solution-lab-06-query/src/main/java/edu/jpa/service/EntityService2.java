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
        EntityManager em = getEntityManagerFactory().createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root e = cq.from(Employee.class);
        cq.where(cb.equal(e.get("department").get("name"), cb.parameter(String.class, "name")));

        em.getTransaction().begin();
        try {
            TypedQuery<Employee> query = em.createQuery(cq);
            query.setParameter("name", name);
            return query.getResultList();
        } finally {
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<DepartmentInfo> getDepartmentsInfo() {
        EntityManager em = getEntityManagerFactory().createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DepartmentInfo> cq = cb.createQuery(DepartmentInfo.class);

        Root e = cq.from(Employee.class);
        cq.select(
                cb.construct(
                        DepartmentInfo.class,
                        e.get("department").get("name"), cb.count(e.get("department"))));
        cq.groupBy(e.get("department"));

        em.getTransaction().begin();
        try {
            return em.createQuery(cq).getResultList();
        } finally {
            em.getTransaction().rollback();
        }
    }
}
