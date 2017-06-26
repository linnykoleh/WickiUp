
1. 

![alt text](images/singleton.png)

#### Concept:
 - Guarantees only one instance is going to be created. 
 - Guarantees the control of a resource. Since this is a creational pattern,
 the instantiation of it all controlled through the implementation of the pattern.
 - Lazily loaded.
 
#### Design: 
 - Class is responsible for lifecycle.
 - Static in nature.
 - Need to be thread safe.
 - Private instance.
 - Private constructor.
 - No parameters required for construction.
   There are no parameters, and if you require parameters that is typically a factory pattern and violates the rules of a singleton.
 
#### Pitfalls:
 - Often overused, once people discover the power and simplicity of this
   pattern, they have the tendency to make everything a singleton
   when it doesn't necessarily need to be.
 - Performance problem , if you make everything a singleton, it will slow your application down.
 - Since singletons don't expose an interface and have private constructors, as well as private member.
   variables, they can often be difficult to unit test.
 - If not careful, not thread-safe.
 
 
[example](_1_creational/_1_singleton)  

2. 

![alt text](images/builder.png)

#### Concept:
  - A lots of of arguments.
  - Large number of parameters.
  - Immutability.
  
#### Design: 
  - Flexibility over telescoping constructors.
  - Static inner class.
  - Calls appropriate constructors.
  - Negate the need for exposed setters.
  - Since java 1.5 can take advantage pf generics.
  
#### Pitfalls:
  - Immutable.
  - Inner static class.
  - Designed first.
  - Complexity.

[example](_1_creational/_2_builder)  

3. 

![alt text](images/prototype.png)

#### Concept:
  - Avoid costly creation.
  - Avoid subclassing.
  - Typically doesn't use 'new'.
  - Often utilizes an Interface.
  - Usually implemented with a Registry. The original object is created and then kept in out registry
    When another object is needed, we create clone from the registry
  
#### Design: 
  - Implements the clone/cloneable interface.
  - Avoids keyword 'new'.
  - Although a copy, each instance is unique.
  - Costly construction not handled by clients.
  - Shallow VS Deep Copy. A shallow copy just copies the immediate properties, whereas a deep copy will copy any of its object references as well.

#### Pitfalls:
  - Sometimes not clear when to use.
  - Used with another patterns.
  - Shallow VS Deep Copy.
  
[example](_1_creational/_3_prototype)  

4. 

![alt text](images/factory_method.png)

#### Concept:
  - Doesn't expose instantiation logic.
  - It is able to do this by deferring the instantiation or creation logic to the subclass.
  - Common interface that is known by all clients.

#### Design: 
  - Factory is responsible for lifecycle, at least the creation part of lifecycle.
  - Common interface.
  - Parameterized create method.
  
#### Pitfalls:  
  - Complexity.
  - Creation in subclass.
  - Refactoring.
	
[example](_1_creational/_4_factory_method)  

5.

![alt text](images/abstract_factory.png)

#### Concept:
  - Factory of Factories.
  - Factory of related objects.
  - Common interface.
  - Defer to subclasses.
  
#### Design: 
  - Groups Factories together.
  - Factory is responsible for lifecycle.
  - Common interface.
  - Concrete Classes.
  - Parameterized create method.
  - Composition !
  
#### Pitfalls:  
  - Complexity.
  - Runtime switch
  - Pattern within a pattern.
  - Starts as a Factory.
  

[example](_1_creational/_5_abstract_factory)  

