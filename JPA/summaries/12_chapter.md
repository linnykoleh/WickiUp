## Chapter 12, Other Advanced Topics

#### Concurrency

- To refresh a managed entity, we simply call `refresh()` on the entity manager. 
  If the entity that we try to refresh is not managed, an `IllegalArgumentException` exception will be thrown.
- When refresh is invoked, it will overwrite the managed entity with the state in the database, causing any changes that have been made to the entity to be lost  
- Refresh operations may also be cascaded across relationships. This is done on the relationship annotation by setting the cascade element to include the `REFRESH` value. 
  If the `REFRESH` value is not present in the cascade element, the refresh will stop at the source entity
  
#### Locking  
##### Optimistic Locking
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