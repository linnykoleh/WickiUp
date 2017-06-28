
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
 