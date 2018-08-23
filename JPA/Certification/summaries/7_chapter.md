## Chapter 7, Using Queries
              
- The **getSingleResult()** method is provided as a convenience for queries that return only a single value. 
  Instead of iterating to the first result in a collection, the object is directly returned. 
  It is important to note, however, that **getSingleResult()** behaves differently from **getResultList()** in how it handles unexpected results. 
  Whereas **getResultList()** returns an empty collection when no results are available, **getSingleResult()** throws a NoResultException exception. 
  Therefore if there is a chance that the desired result may not be found, then this exception needs to be handled.
- If multiple results are available after executing the query instead of the single expected result, **getSingleResult()** will throw a NonUniqueResultException exception. 
  Again, this can be problematic for application code if the query criteria may result in more than one row being returned in certain circumstances. 
  Although **getSingleResult()** is convenient to use, be sure that the query and its possible results are well understood; otherwise application code may have to deal with an unexpected runtime exception 

##### Queries and Uncommitted Changes  
- To offer more control over the integrity requirements of queries, the EntityManager and Query interfaces support a setFlushMode() method to set the flush mode, an indicator to the provider how it should handle pending changes and queries. 
  There are two possible flush mode settings, **AUTO** and **COMMIT**, which are defined by the FlushModeType enumerated type. 
- The default setting is **AUTO**, which means that the provider should ensure that pending transactional changes are included in query results. 
  If a query might overlap with changed data in the persistence context, this setting will ensure that the results are correct.
- The **COMMIT** flush mode tells the provider that queries don’t overlap with changed data in the persistence context, so it does not need to do anything in order to get correct results  
- If the entity manager setting is **AUTO** and one query has the **COMMIT** setting, the provider will guarantee query integrity for all the queries other than the one with the **COMMIT** setting.
  Likewise, if the entity manager setting is **COMMIT** and one query has an **AUTO** setting, only the query with the **AUTO** setting is guaranteed to incorporate pending changes from the persistence context.

```
  Before a query is executed, uncommitted database changes (if any) have to be flushed to the database in order to be visible to the query.
  Flush policy in JPA is represented by the FlushModeType enum, which has two values:
  
  - AUTO - changes are flushed before query execution and on commit/flush.
  - COMMIT - changes are flushed only on explicit commit/flush.  
```  

```
When using the default AUTO flush mode, the Persistence Context should be flushed as follows:

- before the transaction is committed,
- before running a JPQL or HQL query
- before executing a native SQL query
```