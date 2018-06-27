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

```sql
SELECT <select_expression><br/> 
FROM <from_clause><br/>
[WHERE <conditional_expression>]<br/>
[ORDER BY <order_by_clause>]<br/>
```

- Simple query
```sql
SELECT e FROM Employee e
```
- The structure of this query is very similar to a SQL query, but with a couple of important differences. 
   - The first difference is that the domain of the query defined in the FROM clause is not a table but an entity; in this case, the Employee entity. 
     As in SQL, it has been aliased to the identifier `e`. This aliased value is known as an identification variable and is the key by which the entity will be referred to in the rest of the select statement. 
   - The second difference is that the SELECT clause in this example does not enumerate the fields of the table or use a wildcard to select all the fields. 
     Instead, only the identification variable is listed in order to indicate that the result type of the query is the Employee entity, not a tabular set of rows.

- **Identification variable:** The key by which the entity will be referred to in the rest of the select statement. (Employee e, where e is this identification variable) Every query must at least have one. 
- Query interface: getResultList() returns a collection of zero or more x objects.

#### SELECT
- Path expression - The dot operator (.) signifies path navigation in an expression. `e.department`, ` e.department.name`
   - `SELECT e.name FROM Employee e` - The result type of the path expression in the SELECT clause is String, so executing this query using **getResultList()** will produce a collection of zero or more String objects
   - `SELECT e.department FROM Employee e` - The following query demonstrates returning a different entity as a result of path navigation
   - `SELECT DISTINCT e.department FROM Employee e` - To remove the duplicates, the DISTINCT operator must be used
- State field path: navigation that results in one of the persistent state fields of the entity.
- **Single valued association path:** Navigation that leads to a single entity.
- **collection valued association path:** Navigation that leads to a collection entities.
- OBJECT(x) is used to make language backwards compatible, not recommended.
- SELECT DISTINCT is used to remove duplicate results.
- **The result type of a select query can never be a collection type.**
- **Projection:** Only reporting a subset of the state fields from an entity. (e.name, e.salary)
  `SELECT e.name, e.salary FROM Employee e` - Multiple expressions can be specified in the same SELECT clause by separating them with commas

- Constructor expression
    - Specifies that the result of the query are to be stored using a user-specified object type.<br>
        `SELECT NEW example.EmployeeDetails(e.name, e.salary, e.department.name) FROM Employee e`
- JPA supports inheritance, as a result the query language supports polymorphic results where multiple subclasses of an entity can be returned by the same query. 
    - TYPE can be used in the WHERE clause to restrict results to more than one subclass.        
- FROM is used to declare one or more identification variables.
- **Range variable declaration:** When an identification does not use a path expression.



**Joins occur whenever any of the following conditions are met in a select query.**

	- Two or more range variable declarations are listed in the FROM clause and appear in the select clause.
	- The JOIN operator is used to extend an identification variable using a path expression.
	- A path expression anywhere in the query navigates across an association field, to the same or a different entity.
	- One or more WHERE conditions compare attributes of different identification variables.

- Join conditions can be specified explicitly, such as using the JOIN operator in the FROM clause of a query, or implicitly as a result of path navigation.

```sql
SELECT p
FROM Employee e JOIN e.phones p

in sql it means

SELECT p.id, p.phone_num, p.type, p.emp_id
FROM emp e, phone p
WHERE e.id = p.emp_id
```
- Inner join: between two entities returns the objects from both entity types that satisfy all the join conditions. Path navigation from one entity to another is a form of inner join.
- Outer join: of two entities is the set of objects from both entity types that satisfy the join conditions plus the set of objects from one entity type (designated as the left entity) that have no matching join condition in the other.

- **IN VERSUS JOIN**
```sql
SELECT DISTINCT p
FROM Employee e, IN(e.phones) p

The same like

SELECT p.number
FROM Employee e JOIN e.phones p
```
- The IN operator is intended to indicate that the variable p is an enumeration of the phones collection. The JOIN operator is a more powerful and expressive way to declare relationships and is the recommended operator for queries.
- **Fetch Joins**
	- For example, if we have an Employee entity with a lazy loading relationship to its address, the following query can be used to indicate that the relationship should be resolved eagerly during query execution:
	```sql
	SELECT e
	FROM Employee e JOIN FETCH e.address
	```
- The **BETWEEN** operator can be used in conditional expressions to determine whether the result of an expression falls within an inclusive range of values
    ```sql
    SELECT e
    FROM Employee e
    WHERE e.salary BETWEEN 40000 AND 45000
    ```
    Any employee making $40,000 to $45,000 inclusively is included in the results
- The **wildcard characters** used by the pattern string are the underscore (_) for single character wildcards and the percent sign (%) for multicharacter wildcards.
    ```sql
    SELECT d
    FROM Department d
    WHERE d.name LIKE '__Eng%'
  
   - We are using a prefix of two underscore characters to wildcard the first two characters of the string candidates, so example department names to match this query would be “CAEngOtt” or “USEngCal”, but not “CADocOtt”. 
         Note that pattern matches are case-sensitive.
  ```
    
    ```sql
    SELECT d
    FROM Department d
    WHERE d.name LIKE 'QA\_%' ESCAPE '\'

    - Escaping the underscore makes it a mandatory part of the expression. For example, “QA_East” would match, but “QANorth” would not.
    ```
- **Subqueries**    
    - Subqueries can be used in the WHERE and HAVING clauses of a query.
    ```sql
      SELECT e
      FROM Employee e
      WHERE e.salary = (SELECT MAX(emp.salary) FROM Employee emp)
    ```
    - Another good example
    ```sql
    SELECT e
    FROM Employee e
    WHERE EXISTS (SELECT 1
                  FROM e.phones p
                  WHERE p.type = 'Cell')
            
    in sql it means 
        
    SELECT e.id, e.name, e.salary, e.manager_id, e.dept_id, e.address_id
    FROM emp e
    WHERE EXISTS (SELECT 1
                  FROM phone p
                  WHERE p.emp_id = e.id AND
                        p.type = 'Cell')
                        
    ```
- **Collection Expressions**
    - The IS EMPTY operator or its negated form IS NOT EMPTY is the logical equivalent of IS NULL, but for collections
    ```sql
    SELECT e
    FROM Employee e
    WHERE e.directs IS NOT EMPTY
    ```   
    - The MEMBER OF operator and its negated form NOT MEMBER OF are a shorthand way of checking whether an entity is a member of a collection association path
    ```sql
    SELECT e
    FROM Employee e
    WHERE :project MEMBER OF e.projects
    ```
- **ANY, ALL, and SOME Expressions**
    - The ANY, ALL, and SOME operators can be used to compare an expression to the results of a subquery
    ```sql
    SELECT e
    FROM Employee e
    WHERE e.directs IS NOT EMPTY AND
          e.salary < ALL (SELECT d.salary
                          FROM e.directs d)
    ```    
    - **ALL operator** is used, the comparison between the left side of the equation and all subquery results must be true 
    - **ANY operator** behaves similarly, but the overall condition is true as long as at least one of the comparisons between the expression and the subquery result is true
    - **SOME operator** is an alias for the ANY operator.
- **Native Database Functions**
    - The following query invokes a database function named `shouldGetBonus` The id of the employee’s department and the projects he works on are passed as parameters and the function return type is a boolean. 
    The result creates a condition that makes the query return the set of all employees who get a bonus.
    ```sql
    SELECT DISTINCT e
    FROM Employee e JOIN e.projects p
    WHERE FUNCTION('shouldGetBonus', e.department.id, p.id)
    ```
- **CASE Expressions**
    -  The heart of the case expression is the WHEN clause, of which there must be at least one
    ```sql
    SELECT p.name,
           CASE WHEN TYPE(p) = DesignProject THEN 'Development'
                WHEN TYPE(p) = QualityProject THEN 'QA'
                ELSE 'Non-Development'
           END
    FROM Project p
    WHERE p.employees IS NOT EMPTY
    ```   
    - The scalar expressions in the **COALESCE** expression are resolved in order. 
      The first one to return a non-null value becomes the result of the expression.
      ```sql
        SELECT COALESCE(d.name, d.id)
        FROM Department d
      ```
- **ORDER BY**      
	- The optional keywords ASC or DESC after the expression can be used to indicate ascending or descending sorts, respectively. The default sort order is ascending.
	```sql
	SELECT e, d	
	FROM Employee e JOIN e.department d
	ORDER BY d.name, e.name DESC
	```
	- ORDER BY clause is limited to the same path expressions used in the SELECT clause. For example, the following query is not legal
	```sql
	SELECT e.name
    FROM Employee e
    ORDER BY e.salary DESC
	```
- **Aggregate Queries**
	-  An aggregate query groups results and applies aggregate functions to obtain summary information about query results. 
	   A query is considered an aggregate query if it uses an aggregate function or possesses a **GROUP BY** clause and/or a **HAVING**clause.	
	```sql
	SELECT <select_expression>
	FROM <from_clause>
	[WHERE <conditional_expression>]
	[GROUP BY <group_by_clause>]
	[HAVING <conditional_expression>]
	[ORDER BY <order_by_clause>]
    ```
- **Aggregate Functions**   
	- Five aggregate functions can be placed in the select clause of a query: AVG, COUNT, MAX, MIN, and SUM.
- **GROUP BY Clause**
	- GROUP BY clause defines the grouping expressions over which the results will be aggregated.
	- Note that the same field expression used in the `SELECT` clause is repeated in the `GROUP BY` clause. 
	  All non-aggregate expressions must be listed this way.
    ```sql
	SELECT d.name, e.salary, COUNT(p)
	FROM Department d JOIN d.employees e JOIN e.projects p
	GROUP BY d.name, e.salary
	``` 
- **HAVING Clause**	
	- The `HAVING` clause defines a filter to be applied after the query results have been grouped
	- It is effectively a secondary WHERE clause, and its definition is the same: the keyword HAVING followed by a conditional expression.
	- The primary use of the HAVING clause is to restrict the results based on the aggregate result values
	```sql
	SELECT e, COUNT(p)
	FROM Employee e JOIN e.projects p
	GROUP BY e
	HAVING COUNT(p) >= 2
	```
- **Update Queries**
```sql
	UPDATE Employee e
	SET e.salary = 60000
	WHERE e.salary = 55000

	UPDATE Employee e
	SET e.salary = e.salary + 5000
	WHERE EXISTS (SELECT p
				  FROM e.projects p
				  WHERE p.name = 'Release2')
```
- **Delete Queries**
	- If the WHERE clause is not provided, all entities of the given type are removed.
```sql
DELETE FROM Employee e
WHERE e.department IS NULL
```