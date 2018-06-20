## Chapter 6, Entity manager 

- An entity manager manages the persistence context. 

### Container-managed entity manager
- Container manages lifecycle of the entity manager.
- `@PersistenceContext(unitName="x")`
    - Transaction-scoped: active JTA transaction, ending when transaction is complete. The entity manager is stateless, so it can be stored in any component.
    - Extended: work with single persistence context, tied to the lifecycle of a bean. Is active until the bean removes entire conversation.
        - `@PersistenceContext(unitName="x", type=PersistenceContextType.EXTENDED/TRANSACTION)`, default is TRANSACTION.

### Application-managed entity manger
- EntityManager that is created from the createEntityManager() of an EntityManagerFactory instance.
- The application manages the lifecycle of the entity manager. 
- em.getEntityManagerFactory() can be used to find the EntityManagerFactory that created the entity manager.
- To retrieve the EntityManagerFactory in Java SE you can use <br/>
`EntityManagerFactory emf = Persistence.createEntityManagerFactory("SomeKindOfService");
EntityManager em = emf.createEntityManager();`
- To retrieve the EntityManagerFactory in Java EE you can use <br/>
`@PersistenceUnit(unitName="SomeKindOfService")`<br>
This can be used when resource-local transactions are required for an operation.
- When the EntityManager is no longer needed it should be closed explicitly.: `em.close`. In Java SE the EntityManagerFactory should also be closed explicitly.

### Transaction management
- Container-managed entity managers always use JTA transactions. Application managed entity managers can also use JDBC. 
- **Transaction synchronization:** The process by which a persistence context is registered with a transaction so that the persistence context can be notified when a transaction commits.
- **Transaction association:** The act of binding a persistence context to a transaction, active persistence within the scope of that transaction.
- **Transaction propagation:** Sharing a persistence context between multiple container-managed entity managed entity managers in a single transaction. 
- There can only be one persistence context associated with and propagated across a JTA transaction.

### Transaction-scoped persistence context
- Tied to the lifecycle of the transaction. It is created bt the container during a transaction and will be closed when the transaction completes.
- An entity manager will only create a persistence context when a method is invoked on the entity manager and when there is no persistence context available. The transaction association is LAZY.
- Two beans sharing context, and one had a REQUIRES_NEW method, the active persistence will be that method.

### Extended persistence context
- Tied to the stateful session bean to which it is bound. 
- The extended entity manager of a stateful session bean always uses the same persistence context. 
- The transaction association is EAGER. In case of a container managed transaction as soon as the method call starts on the bean, the container will automatically associates the persistence context with the transaction.
- In bean-managed transactions as soon as UserTransaction.begin() is invoked within a bean method, the container intercepts the call and performs the same association. 

#### Persistence context collision
- Only one persistence can be propagated with a JTA transaction.
- Excessive use of REQUIRES_NEW can lead to application performance problems

#### Application-managed persistence context
- Can be synchronized with JTA transactions. Flush will occur if transaction commits. 
- Persistence context will not be considered associated by any container managed entity manager.
- The EntityManagerFactory will be injected. Manually create a new application-managed entity manager. During de @Remove the `em.close` needs to be used, since the container does not manage its lifecycle. 
- Application-managed entity managers do not propagate, so to share managed entities with other components the EntityManager instance needs to be shared. 
    - Storing the entity manager in a HTTP session
    - Passing the entity manager as an argument to local methods
    - Singleton session bean
- If the persistence context becomes synchronized with a transaction, changes will still be written to the database when the transaction commits, even if the entity manager is closed.
- ***EntityManagerFactory instances are thread save, EntityManager instances are not thread safe. Application code must not call joinTransaction() on the same entity manager in multiple concurrent transactions.***
- When multiple application-managed persistence contexts become synchronized with the transaction or when application-managed persistence contexts become mixed with container-managed persistence contexts, each persistence context will receive notification from the transaction manager that changes should be written to the database, Each persistence context will be flushed.]
- It is recommended to use a single persistence context strategy. 

#### Resource-local transactions
- Explicitly controlled by the application
- Interaction with resource-local transactions can be done by acquiring an implementation of the EntityTransaction interface from the entity manager: `em.getTransaction()`.
EntityTransaction is designed to imitate the UserTransaction interface defined by JTA. Main difference is that EntityTransaction operations are implemented in terms of the transaction methods on the JDBC connection interface. 
- EntityTransaction:
    - void begin()
    - void commit()
        - When no transaction is active this will result in `IllegalStateException`.
    - void rollback()
        - When no transaction is active this will result in `IllegalStateException`.
    - void setRollbackOnly()
    - boolean getRollbackOnly()
    - boolean iActive()
        - Attempting to start a new transaction while a transaction is active will result in an `IllegalStateException`.
- Can be used for example logging.
        
#### Transaction rollback and entity state
- 1. Database transaction will be rolled back. 
- 2. The persistence context is cleared detaching all the managed entity instances. 
- If persistence context was transaction-scoped, it is removed. 
- If some of the changes that failed are sitting a detached entity, consider selectively copying the changed data into new managed entities.

 
- Container-managed transaction-scoped is the best choice for Entity Manager.
    - Default for Java EE applications
- Extended transaction scope is tied to the lifecycle of a stateful bean. 
    
#### Entity manager operations
- **persist():** Creates a new entity instance and after this the entity will be managed. If the entity is already managed by the persistence context, it is ignored.
    - If persist is outside of an transaction in a transaction-scoped entity manager will throw *TransactionRequiredException*. Application-managed and extended will manage the entity.
    - If the provider immediately determines if the entity is already in the database, an *EntityExistsException* will be thrown. Otherwise an exception will be thrown when the persistence context is synchronized to the database.
- **contains():** Can be used to check whether an entity is already managed. 
- If an entity is managed, it does not mean that is in the database right away. The actual SQL to create the relational data will not be generated until the persistence context is synchronized with the database.
- **find():** Returns managed entity instance, except when invoked outside of a transaction on a transaction-scoped entity manager. In that case, the entity returns in a detached state. 
- **getReference():** When a relationship is being created between two entities in a one-to-one or many-to-one relationship in which the target entity already exists and its primary key is well-know, the getReference() can be used. Only when its primary key is required. 
 - Is a proxy is used, it might throw an *EntityNotFoundException* if it is unsable to locate the real entity instance when an attribute other than the primary key is accessed.
 - The object returned by the method might not be managed.
- **remove():**  If an entity is the target of foreign keys in other tables, those keys must be cleared for the remove to succeed.
    - The entity must be managed by the entity manager. If the remove() is called outside of a transaction in a transaction-scoped entity manager, a *TransactionRequiredException* will be thrown.
- **clear():** This method will clear the persistence context. All managed entity instances will be detached. Changes written to the database from the transaction will not rollback.    
- **detach():** An entity that no longer is associated with a persistence context. Any changes in the entity won't be persisted to the database.
- **merge():** The entity manager integrates detached entity state into a persistence context.

#### Cascade
- This can be added on @OneToOne, @OneToMany, @ManyToOne and @ManyToMany.
- @OneToMany(cascade=CascadeType.TYPEOFENUM)
- PERSIST: unidirectional, explicitly set on both sides of a relationship if the same behavior is intended for both situations. 
- REMOVE: Can be 'safely' used on one-to-one and one-to-many when there is a clear child-parent relationship. Instances will be detached. The link between the objects will remain.

#### Flush
- **flush():** To manually trigger the entity manager to internally flush the persistence context. 
- A flush happens automatically when a transaction commits.
- When the query is about to be executed and it depends on new or changed entities in de persistence context, a flush will happen.
- A flush consists of three components:
    1. New entities that need to be persisted
    2. Changed entities that need to be updated
    3. Entities that need to be removed.
    - It will look for new entities, then checks if new entities have a cascade persist enabled. After that it will check the integrity of relationships.
    - Any time a detached object that is the target of the one-to-one or many-to-one relationship is encountered where the source entity is the owner, the flush will still proceed because the act of persisting the owning entity does not depend on the target. Only the primary key value is needs to be stored.


#### Detachment
- When the transaction that a transaction-scoped persistence context is associated with commits, all the entities managed by the persistence context become detached. 
- If an application-managed persistence context is closed, all its managed entities become detached. 
- If a stateful session bean with an extended persistence context is removed, all its managed entities become detached.
- If the clear() method of an entity manager is used, it detaches all the entities in the persistence context managed by that entity manager.
- If the detach() method of an entity manager is used, it detaches a single entity instance from the persistence context managed by that entity manager.
- When transaction rollback occurs, it causes all entities in all persistence context associated with the transaction to become detached.
- When an entity is serialized, the serialized form of the entity is detached from its persistence context.


ALL or DETACH cascade option can be used.
- **detach()** does not detach either new or removed entities. It will attempt to cascade across relationships on removed entities. 
- The behaviour of accessing an unloaded attribute when the entity is detached is not defined. It will depend on the vendor implementation.


- **merge()** any changes while detached will be written to the database. Use this with a return value. If a new entity is merged, it will persist the entity. 
- It can be optionally cascades with MERGE. 
- If an entity that is removed will be merged, an *IllegalArgumentException* will be thrown.
- If a relationship that wasn't loaded before detach will not load.
- The entity that is being merged is compared to the object with the same identifier. If an entity is found with the same identifier, it will be overwritten by the entity that is being merged. 
    - MERGE cascade on tbe relationship mapping or merge() explicitly the relation object.
        - Always go parent to child.

        
#### Planning for detachment
- Triggering lazy loading by accessing the field or relationship that is being lazy loaded.
- Configure eager loading. Collection valued relationships are by default LAZY loaded.
- Avoid detachment.