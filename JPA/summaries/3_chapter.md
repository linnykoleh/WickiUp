## Chapter 3, Enterprise applications

- A `component` is a self contained reusable software unit that can be integrated into an application.
- A commonly used component model is `EJB model`

### Benefits of components are:
- **Loose coupling**
- **Dependency management**
- **Lifecycle management:** Lifecycle of components is managed by the application server.
- **Declarative container services**
- **Portability**
- **Scalability and reliability**

### Session beans
- A component technology designed to encapsulate business services.
- Once the client acquires a reference to a session bean, the server starts a session with that bean and can invoke business operations on it.

#### Stateless session beans
Interaction with a stateless bean begins at the start of a business method call and ends when the method call completes. It has minimal impact to overall server resources.
 
- Zero or more business interfaces that define what methods a client can invoke on the bean. When no interface is defines then the set of public methods on the bean impl class forms a logical client interface. 
- @Stateless annotation available in either the `javax.ejb` or `javax.annotation` package 
- Stateless session bean needs a no-arg constructor
- Static fields should not be used, because of bean redeployment issues. 
- The application has no control over how many instances of a session bean are created or how long they will stay around.
- The server has to initialize services for the bean after it is constructed, but before business logic of the bean is invoked.
- @PostConstruct: After server has completed initializing all the container services for the bean. 
- @PreDestroy: Before the server releases the bean instance to be garbage collected. 
- @Local / @Remote

#### Stateful session beans
The session starts when the client obtains a reference to the bean and ends only when the client chooses to end the conversation. 
- @Stateful
- @Remove to end session.
- It is allowed to have access to a private instance of the session bean
- Passivation is the process by which the server serializes the bean instance so that it can be either be stored offline to free up resources or replication to another server in a cluster.
- Activation is the process of deserializing a passivated session bean instance and making it active in the server once again. 
- @PrePassivate / @PostActivate: **Can be used for JDBC connection*

#### Singleton session beans
- Can be created eagerly during application initialization and exists until the application shuts down. The bean will never be re-created in the event of a system exception. 
- @Singleton
- Only one client can invoke a business method on the instance at any time. 
- @Startup: **To force eager initialization when the application starts*
- @DependsOn: **When multiple singleton session beans depend on one another*
- @PostConstruct / @PreDestroy
- Default is container-managed concurrency, writes a lock on all business methods. When a business method is not changing the state of the bean @Lock(LockType.READ) can be used. @Lock(LockType.Write) is default. 
- To make a Singleton bean-managed concurrency  use annotation @ConcurrencyManagement(ConcurrencyManagementType.BEAN).

### Message-driven beans
***An EJB component for asynchronous messaging. MDB uses a messaging system such as JMS. These requests are being queued and eventually delivered to the MDB by the server.***
- For JMS message-driven beans the business interface is `javax.jms.MessageListener` which defines the method `onMessage() 
- @MessageDrivenBean
- @ActivationConfigProperty


### Servlets
***Solve the problem with sessions. HTTP session is a map of data associated with a session id.***

### Dependency management
- @Resource
- @EJB
- @PersistenceContext
- @PersistenceUnit

#### Dependency lookup 
- JNDI to look up a named reference. Typically placed at class level. <br />
*Context.class - lookup()*
- EJBContext lookup() -> EJBContext / SessionContext / MessageDrivenContext: **Only runtime exceptions and the name is exactly as it was specified in the resource reference.*

### Dependency injection
- The server does the lookup automatically on your behalf and sets the result into the instantiated class.
- A resource reference is declared just as if it had been placed on the bean class.
- `inversion of control`
- Simplifies testing

- **Field injection**
- **Setter injection** 


*@PersistenceUnit for EntityManagerFactory* 
```java
@Stateless
public class EmployeeService {
    @PersistenceContext(unitName="EmployeeService")
    EntityManager em;

    // ...
}
```
*@PersistenceContext for EntityManager*
```java
@Stateful
public class EmployeeService {
    @PersistenceUnit(unitName="EmployeeService")
    private EntityManagerFactory emf;
    private EntityManager em;

    @PostConstruct
    public void init() {
        em = emf.createEntityManager();
    }

    // ...
}
```

### Transaction review
#### Acid transformation
- **Atomicity:** Either all the operations in a transaction are successful or none of them. 
- **Consistency** The data in the entire system is legal or valid with respect to the rest of the data in the system.
- **Isolation** Changes made within a transaction are visible only to the transaction that is making the changes. Once a transaction commits the changes, they are atomically visible to other transactions.
- **Durability** The changes made within a transaction endure beyond the completion of the transaction.

#### Enterprise Transaction 
- **Resource-local transaction:** Transaction at the level of the resource. These transactions are manipulated by interacting directly with the JDBC DataSource that is obtained from the application server.
- **Container transaction:** Uses the JTA transaction and can span multiple resources. 
Are also called `JTA transactions` or `global transactions`.

#### Transaction demarcation
***The act of causing a transaction to either begin or complete.***

#### Resource-local transaction
***Interacting directly with JDBC Datasource.***
- Are always demarcated explicitly by the application.

#### Container transaction
***Also called JTA transactions or global transaction.***

- Can be demarcated automatically by the container *(= container-managed transaction)* or by using a JTA interface that supports application-controlled demarcation *(= bean managed transaction)*.
- Default for EJB component is `container-managed transaction`.
- To change this, use the annotation @TransactionManagement(TransactionManagementType.BEAN/CONTAINER)

*`Transaction demarcation` is the act of causing a transaction to either begin or complete.*

### Container-managed transactions 
***@TransactionAttribute(TransactionAttributeType.TYPE)***<br/>
***This annotation can be set on class level or method level. Method level has precedence.*****

- **MANDATORY:** Transaction is started and active, if not an exception is thrown.
- **REQUIRED:** *(= default)* If transaction is active, this transaction will be used, if transaction does not exist, a new transaction will start.
- **REQUIRES_NEW:** Creates always a transaction. Can lead to excessive overhead. 
- **SUPPORTS:** Not dependent on a transaction. Will run in the transaction if there is one.
- **NOT_SUPPORTED:** Suspends current transaction.
- **NEVER:** If transaction is active, an exception is thrown.


### Bean-managed transactions
- Bean class has the responsibility to begin and commit transaction.
- The transactions do not get propagated to methods called on another BMT bean. 
- Can be used when transactions must be initiated from the web tier.

#### UserTransaction
***The UserTransaction interface is the designated object in the JTA that applications can hold on to invoke to manage transaction boundaries.***

- Can be injected by @Resource (when using dependency lookup : `java:comp/UserTransaction`)
	- begin()
	- commit()
	- getStatus()
	- rollback()
	- setRollbackOnly()
	- setTransactionTimeOut(int seconds)

- Only CMT can suspend the current transaction.
- Only one transaction at any given time.

### Stateful session bean
- One bean instance per client.
- Stays in the server until @Remove is called.
- Reference cannot be shared between threads.
- Injecting @EJB is not a good solution, it's better to use EJBContext lookup(). JNDI will be required when the client is a servlet.