
***Данные паттерны помогают внести порядок и научить разные объекты более правильно взаимодействовать друг с другом.***

### 1. Adapter или wrapper (адаптер, обертка)

![alt text](images/adapter.png)

> The adapter pattern is a great pattern for connecting new code to legacy code without 
> having to change the working contract that was produced from the legacy code originally.
> Works after code is designed

#### Concept:
 - Convert interface into another interface.
 - Usually when one portion of our system is a legacy app or module that we don't want to, or can't possibly change.
 - Translating requests from the client the code we are adapting to, a client to talking to a legacy app or an adapting to 
 - Client, Adapter, Adaptee
 - Examples:
 	 - Arrays -> Lists
 	 - Streams
 	 
#### Design:
 - Client centric
 - Integrate new with old
 - Interface
 - Adaptee cen be the implementation
 
#### Pitfalls:
 - Not a lot
 - Don't complicate
 - Multiple Adapters
 - Don't add functionality, if you are adding functionality to your legacy code, 
   then you should probably be considering the `decorator` or some other type of structural pattern!
 
#### Metaphor 
Данный паттерн полностью соответствует своему названию. Чтобы заставить работать «советскую» вилку через евро-розетку требуется переходник. 
Именно это и делает «адаптер», служит промежуточным объектом между двумя другими, которые не могут работать напрямую друг с другом.
 
[example](_1_adapter/)  

### 2. Bridge (мост)

> Основное отличие от адаптера, то что, адаптер работает с legacy кодом, а мост с новым кодом.
> Designed upfront, in advance

![alt text](images/bridge.png)

#### Concept:
 - Decoupling abstraction and implementation
 - Changes in abstraction won't affect client
 
#### Design:
 - Interfaces and abstract classes
 - Composition over Inheritance
 - Expect change from both side
 - Abstraction, Implementor, Refined abstraction, Concrete implementor
 
#### Pitfalls:
 - Increases complexity
 - Conceptually difficult to plan
 - What goes where is your code
 
#### Metaphor  
 Представим ситуацию, когда вам требуется работать на разных автомобилях, однако садясь в новый автомобиль вам уже желательно знать как им управлять. 
 Таким образом вы сталкиваетесь с паттерном «мост». С одной стороны вы имеете множество различных автомобилей (разные модели и марки), 
 но среди все них есть общая абстракция (интерфейс) ввиде руля, педалей, коробки передач и так далее. 
 Таким образом мы задаем как-бы правила изготовления автомобилей по которым мы можем создавать любые их виды, 
 но за счет сохранения общих правил взаимодействия с ними, мы можем одинаково управлять каждым из них. 
 «Мостом» в данном случае является пара двух «объектов»: конкретного автомобиля и правил взаимодействия с этим (и любым другим) автомобилем.
 
### 3. Composite (компоновщик)

![alt text](images/composite.png)

> Composite != Composition.
> The composite pattern is dealing with that hierarchical structure where composition is 
> just one object containing another.

#### Concept:
 - Components represent part or whole structure
 - Compose object into tree structures
 - Same operations applied on individual and composites

#### Design:
 - Tree structured !!!
 - Root is a component
 - Leaf or Composite, same operations
 - Composite knows about child objects
 - Component, Leaf, Composite
 
#### Pitfalls:
 - Can overly simplify system
 - Difficult to restrict
 - Implementation can possible be costly

#### Metaphor 
Довольно интересный паттерн суть которого заключается в минимизации различий в управлении как группами объектов так и индивидуальными объектами. 
Для примера можно рассмотреть управление солдатами в строю. Существует строевой устав, который определяет как управлять строем и согласно этого устава 
абсолютно не важно кому отдается приказ (например «шагом марш») одному солдату или целому взводу. 
Соответственно в устав (если его в чистом виде считать паттерном «компоновщик») нельзя включить команду, которую может исполнить только один солдат, но не может исполнить группа, или наоборот.

### 4. Decorator (декоратор)

![alt text](images/decorator.png)

#### Concept:
 - Also called a wrapper
 - Add behavior without affecting others
 - More that just inheritance
 - Single responsibility principle
 - Compose behavior dynamically
 - Contains another entity
 - Modifies behaviour
 
#### Design:
 - Inheritance based
 - Utilizes composition and inheritance
 - Constructor requires instance from hierarchy
 
#### Pitfalls:
 - New class for every feature added
 - Multiple little objects
 - Often confused with simple inheritance
 
#### Metaphor 
Как понятно из названия, данный паттерн чаще всего используется для расширения исходного объекта до требуемого вида.
Например мы условно можем считать «декоратором» человека с кистью и красной краской. 
Таким образом, какой бы объект (или определенный тип объектов) мы не передали в руки «декоратору», на выходе мы будем получать красные объекты.
