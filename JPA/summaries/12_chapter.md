## Chapter 12, Other Advanced Topics

#### Concurrency

- To refresh a managed entity, we simply call `refresh()` on the entity manager. 
  If the entity that we try to refresh is not managed, an `IllegalArgumentException` exception will be thrown.