## Chapter 2, Getting started

### Entity
***An entity is a noun, or a grouping of state associated together as a single unit (an object in Java).***

- **Persistability:** The state can be represented in a data store and can be accessed at a later time. When an object is instantiated in memory, it's a `persistent object`. 
- **Identity:** An `identifier` is the key that uniquely identifies an entity instance and distinguishes it from all the other instances of the same entity type.
- **Transactionality:** Entities are `quasi-transactional` because database operations are normally done within the context of a transaction. A transaction is necessary to commit changes of the entity. 
- **Granularity:** Entities are not primitives, primitive wrappers, or built-in objects with single-dimensional state. 

### Metadata 
- Annotations
- XML
- Configuration by Exception

`@Entity` and `@Id` are needed to make an Entity of a Java class. 

### Entity Manager
***The set of managed entity instances within an entity manager at any given time is called its `persistence context`*** 

- Only one Java instance with the same persistent identity may exist in a persistence context at any time. 
- All entity managers come from factories of type `EntityManagerFactory`. A EMF is managed by a `Persistence Unit`.

`Persistence` creates `EntityManagerFactory` creates `EntityManager`.

*EntityManagerFactory emf = Persistence.createEntityManagerFactory("SomeKindOfservice");*

*TypedQuery<Employee> query = em.createQuery("SELECT e FROM something", Something.class");*
*List<Employee> emps = query.getResultList();*

**When entity is found, the entity is managed:**
*em.find(Something.class, id)* 

**Starting a transaction in Java SE:** 

*em.getTransaction().begin();<br />
createSomething(1, "Something");<br />
em.getTransaction().commit();*


### Persistence Unit
- Configuration is defined in `persistence.xml`<br />
`persistence-unit name="Something" transaction-type="RESOURCE_LOCAL"/"JTA"`<br />
`class` **Usually not necessary because the container will scan for entities automatically as part of the deployment process.*<br />
`properties` **The JDBC database login parameters must be specified when running in Java SE.*