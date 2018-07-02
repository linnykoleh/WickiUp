## Chapter 12, Other Advanced Topics

### Concurrency

- To refresh a managed entity, we simply call `refresh()` on the entity manager. 
  If the entity that we try to refresh is not managed, an `IllegalArgumentException` exception will be thrown.
- When refresh is invoked, it will overwrite the managed entity with the state in the database, causing any changes that have been made to the entity to be lost  
- Refresh operations may also be cascaded across relationships. This is done on the relationship annotation by setting the cascade element to include the `REFRESH` value. 
  If the `REFRESH` value is not present in the cascade element, the refresh will stop at the source entity
  
### Locking  
#### Optimistic Locking
- Provider maintains a versioning system for the entity
- Version fields are at the core of optimistic locking and provide the best and most performant protection for infrequent concurrent entity modification.
```java
@Entity
public class Employee {
    
    @Id 
    private int id;
    
    @Version 
    private int version;
    
}
```
- Version-locking fields defined on the entity can be of type `int`, `short`, `long`, the corresponding wrapper types, and `java.sql.Timestamp`. 
  The most common practice is just to use int or one of the numeric types, but some legacy databases use timestamps.
- Version fields will be automatically updated only when either the non-relationship fields or the owning foreign key relationship fields (e.g., many-to-one and one-to-one source foreign key relationships) are modified. 
  If you want a non-owned, collection-valued relationship to cause an update to the entity version, you might need to use one of the locking strategies described in the following locking sections.
- The second point worth remembering is that version fields will be automatically updated only when either the non-relationship fields or the owning foreign key relationship fields (e.g., many-to-one and one-to-one source foreign key relationships) are modified. If you want a non-owned, collection-valued relationship to cause an update to the entity version, you might need to use one of the locking strategies described in the following locking sections.  
- By default, JPA assumes what is defined in the `ANSI/ISO SQL` specification and known in transaction isolation parlance as `Read Committed isolation`. 
  This standard isolation level simply guarantees that any changes made inside a transaction will not be visible to other transactions until the changing transaction has been committed.
 
#####  Optimistic Read Locking

- An optimistic read lock in JPA provides `Repeatable Read` level of isolation.
- To optimistically read-lock an entity, a lock mode of `LockModeType.OPTIMISTIC` can be passed to one of the locking methods
- The provider will, however, most often optimistically read-lock the object, meaning that the provider will not actually go to the database for a lock when the locking method is called. 
  It will instead wait until the end of the transaction, and at commit time it will reread the entity to see if the entity has been changed since it was last read in the transaction. 
  If it has not changed, the read lock was honored, but if the entity has changed, the gamble was lost and the transaction will be rolled back.
```java
protected long totalSalaryInDepartment(int deptId) {    
    long total = 0;    
    Department dept = em.find(Department.class, deptId);    
    for (Employee emp : dept.getEmployees()) {        
        em.lock(emp, LockModeType.OPTIMISTIC);        
        total += emp.getSalary();    
    }    
    return total;
}
```  
- The `LockModeType.OPTIMISTIC` value was introduced in JPA 2.0 and is really just a rename of the `LockModeType.READ` option that existed in JPA 1.0.

##### Optimistic Write Locking

- The write lock guarantees all that the optimistic read lock does, but also pledges to increment the version field in the transaction regardless of whether a user updated the entity or not.
  This provides a promise of an optimistic lock failure if another transaction also tries to modify the same entity before this one commits
- Recall that updates to the version column do not normally occur when changes are made to a non-owned relationship. 
- The common case for using `OPTIMISTIC_FORCE_INCREMENT` is to guarantee consistency across entity relationship changes (often they are one-to-many relationships with target foreign keys) 
  when in the object model the entity relationship pointers change, but in the data model no columns in the entity table change.
```java
@Stateful
public class EmployeeManagement {
    @PersistenceContext(unitName="EmployeeService",
                        type=PersistenceContextType.EXTENDED)
    EntityManager em;

    public void addUniform(int id, Uniform uniform) {
        Employee emp = em.find(Employee.class, id);
        em.lock(emp, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        emp.addUniform(uniform);
        uniform.setEmployee(emp);
    }

    // ...
}
```
- The `LockModeType.OPTIMISTIC_FORCE_INCREMENT` value was introduced in JPA 2.0 and is really just a rename of the `LockModeType.WRITE` option that existed in JPA 1.0.  
  