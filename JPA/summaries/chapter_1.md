## Chapter 1, Object-relational mapping

- Domain model has a class, a database has a table
- The technique of bridging the gap between the object model and the relational model is known as `object-relational mapping`.
- The building block for relationships is the foreign key. In order to do so the target table must have a primary key (id). 

### JPA
- **POJO persistence:** ORM is entirely metadata-driven. It can be done by adding annotations to the code or using externally defined XML.
- **Nonintrusive:** The persistence API exists as a separate layer from the persistent objects. The persistent objects don't need to be aware of the persistence API. The persistence API is called by the application business logic.
- **Object queries:** Queries can be expressed in JPQL. Knowledge of the database-mapping is not required, because Java entities and their attributes are used as the query schema. 
- **Mobile entities:** Objects must be able to be moved from one virtual machine to another and then back again. Objects that leave the persistence layer are called `detached`.
- **Simple configuration:** JPA makes heavy use of standards.
- **Integration and Testability:** The API is able to work outside as well as inside the application server.