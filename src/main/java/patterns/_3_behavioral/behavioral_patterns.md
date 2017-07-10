
**Эта группа паттернов позволяет структурировать подходы к обработке поведения и взаимодействия объектов. 
  Проще говоря, как должны проходить процессы в которых существует несколько вариантов протекания событий.**
  
### 1. Chain of Responsibility  (цепочка обязанностей)  

![alt text](images/chain_of_responsibility.png)

#### Concept:
 - Decoupling of sender and receiver
 - Receiver contains reference to next receiver
 - Promotes loose coupling
 - No handler - OK
 - Examples:
 	- java.util.logging.Logger#log()
 	- javax.servlet.Filter#doFilter()
 	- Spring security filter chain
 	
#### Design:
 - Chain of receiver objects
 - Handler is interface based
 - ConcreteHandler for each implementation
 - Each handler has a reference to the next
 - Handler, ConcreteHandler

#### Pitfalls:
 - Handling.Handler guarantee
 - Runtime configuration risk
 - Chain length/performance issue

#### Metaphor 
 Самым простым примером цепочки обязанностей можно считать получение какого-либо официального документа. Например вам требуется получить справку со счета из банка. 
 Так или иначе, вы должны эту справку получить, однако кто именно ее должен вам дать — пока не ясно. 
 Вы приходите в местное отделение банка, вам говорят что «мы сейчас заняты, идите в другое отделение», дальше вы идете в другое, там вам отвечают «мы этим не занимаемся», 
 вы идете в региональное отделение и там получаете нужную справку. 
 Таким образом паттерн реализует «цепочку обязанностей» отдельные объекты которой (отделения банка) должны обработать ваш запрос. 
 Соответственно ваш запрос может быть обработан в первом же отделении, или же в нескольких, в зависимости от самого запроса и обрабатывающих объектов.
  
[example](_1_chain_of_resposibility/)  

### 2. Command (команда)  

![alt text](images/command.png)

#### Concept:
 - Encapsulate request as an Object
 - Object-oriented callback
 - Decouple sender from processor
 - Often used to "undo" functionality
 - Examples:
 	- java.lang.Runnable

#### Design:
 - Object per command
 - Command interface
 - Execute method
 - 'Unexecute' method
 - Reflection
 - Command, Invoker, ConcreteCommand
 
#### Pitfalls:
 - Dependence of other patterns
 - Multiple Commands
 - Make use Memento
 - Prototype of copies
 
#### Metaphor 
Паттерн «команда» очень похож в реальной жизни на кнопки выключателей света в наших квартирах и домах. 
Каждый выключатель по своей сути делает одно простое действие — разъединяет или соединяет два провода, однако что стоит за этими проводами выключателю не известно. 
Что подключат, то и произойдет. Точно также действует и паттерн «команда». Он лишь определяет общие правила для объектов (устройств), 
в виде соединения двух проводов для выполнения команды, а что именно будет выполнено уже определяет само устройство (объект).
Таким образом мы можем включать одним типом выключателей как свет в комнате, так и пылесос.

### 3. Interpreter (переводчик) 

![alt text](images/interpreter.png)

#### Concept:
 - Represent grammar
 - Interpret a sentence
 - Map a domain
 - Examples:
    - java.util.Pattern
    - java.text.Format
   
#### Design:
 - AbstractExpression
 - Interpret
 - TerminalExpression
 - NonterminalExression 
   
#### Metaphor 
Сравнить данный паттерн можно с тем, как вы закладываете часто используемые действия в сокращенный набор слов, чтобы сам «интерпретатор» потом превратил этот набор в более комплексные осмысленные действия. 
По сути каждый человек постоянно является «интерпретатором». Хотите провести жизненный эксперимент? Если из дома выходит кто-то из вашей семьи (муж, жена, ребенок), скажите ему простой набор слов 
«Литр молока, половинку белого, 200 грамм творога». По сути вы ничего особенного не сказали, лишь перечислили набор продуктов, однако велик шанс того, что «интерпретатор» транслирует это в команду 
«зайди по дороге в продуктовый магазин и купи следующее … и принеси это домой». Паттерн «интерпретатор» призван сократить часто исполняемые действия в более короткое их описание.    
