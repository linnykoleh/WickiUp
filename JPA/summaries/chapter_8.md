## Chapter 8, Query Language

### Queries:
1. Select : report query
2. Aggregate : report query, group result
3. Update
4. Delete


- **Abstract persistence schema:** The set of entities and embeddables defined by a persistence unit. The collection of which defines the overall domain from which results can be retrieved.
- **Abstract schema name:** If an entity has not been explicitly named, the unqualified class name is used by default.
- **Abstract schema type:** Refers to the class or primitive type used to implement the persistence property on an entity.
- **State fields:** Simple persistent properties with no relationship mapping comprise the persistent state of the entity.
- **Association fields:** Persistent properties that are also relationships.

SELECT <select_expression><br/> 
FROM <from_clause><br/>
[WHERE <conditional_expression>]<br/>
[ORDER BY <order_by_clause>]<br/>

- **Identification variable:** The key by which the entity will be referred to in the rest of the select statement. (Employee e, where e is this identification variable) Every query must at least have one. 
- Query interface: getResultList() returns a collection of zero or more x objects.

#### SELECT
- Path expression
- State field path: navigation that results in one of the persistent state fields of the entity.
- **Single valued association path:** Navigation that leads to a single entity.
- **collection valued association path:** Navigation that leads to a collection entities.
- The dot operator (.) signifies the path expression.
- OBJECT(x) is used to make language backwards compatible, not recommended.
- SELECT DISTINCT is used to remove duplicate results.
- The result type of a select query can never be a collection type.
- **Projection:** Only reporting a subset of the state fields from an entity. (e.name, e.salary)


- Constructor expression
    - Specifies that the result of the query are to be stored using a user-specified object type.<br>
        `SELECT NEW example.EmployeeDetails(e.name, e.salary, e.department.name) FROM Employee e`
- JPA supports inheritance, as a result the query language supports polymorphic results where multiple subclasses of an entity can be returned by the same query. 
    - TYPE can be used in the WHERE clause to restrict results to more than one subclass.        
- FROM is used to declare one or more identification variables.
- **Range variable declaration:** When an identification does not use a path expression.


### JOIN
***A query that combines results from multiple entities.***
- Two or more range variable declarations are listed in the FROM clause and appear in the select clause.
- JOIN operator is used to extend an identification variable using a path expression.
- A path expression anywhere in the query navigates across an association field.
- One or more WHERE conditions compare attributes of different identification variables.
- Inner join: Path navigation from one entity to another is a form of inner join.
- Outer join: The set of objects from both entity types that satisfy the join condition in the other.

SELECT p
FROM Employee e JOIN e.phones p

[ INNER ] JOIN <path_expression> [AS] <identifier>