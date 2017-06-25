
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
 There are no parameters, and if you require parameters that
 is typically a factory pattern and violates the rules of a singleton.
 
#### Pitfalls:
 - Often overused, once people discover the power and simplicity of this
   pattern, they have the tendency to make everything a singleton
   when it doesn't necessarily need to be.
 - Performance problem , if you make everything a singleton, it will slow your application down
 - Since singletons don't expose an interface and have private constructors, as well as private member
   variables, they can often be difficult to unit test.
 - If not careful, not thread-safe.
 
 
[example](_1_creational/_1_singleton)  

2. 

![alt text](images/builder.png)

[example](_1_creational/_2_builder)  

3. 

![alt text](images/prototype.png)

[example](_1_creational/_3_prototype)  

4. 

![alt text](images/factory_method.png)

[example](_1_creational/_4_factory_method)  

5.

![alt text](images/abstract_factory.png)

[example](_1_creational/_5_abstract_factory)  

