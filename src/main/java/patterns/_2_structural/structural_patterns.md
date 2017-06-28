
***Данные паттерны помогают внести порядок и научить разные объекты более правильно взаимодействовать друг с другом.***

### 1. Adapter или wrapper (адаптер, обертка)

![alt text](images/adapter.png)

> The adapter pattern is a great pattern for connecting new code to legacy code without 
> having to change the working contract that was produced from the legacy code originally.

#### Concept
 - Convert interface into another interface.
 - Usually when one portion of our system is a legacy app or module that we don't want to, or can't possibly change.
 - Translating requests from the client the code we are adapting to, a client to talking to a legacy app or an adapting to 
 - Client, Adapter, Adaptee
 - Examples:
 	 - Arrays -> Lists
 	 - Streams
 	 
#### Design
 - Client centric
 - Integrate new with old
 - Interface
 - Adaptee cen be the implementation
 
#### Pitfalls 
 - Not a lot
 - Don't complicate
 - Multiple Adapters
 - Don't add functionality, if you are adding functionality to your legacy code, 
   then you should probably be considering the `decorator` or some other type of structural pattern!
 
#### Metaphor 
Данный паттерн полностью соответствует своему названию. Чтобы заставить работать «советскую» вилку через евро-розетку требуется переходник. 
Именно это и делает «адаптер», служит промежуточным объектом между двумя другими, которые не могут работать напрямую друг с другом.
 
[example](_1_adapter/)  