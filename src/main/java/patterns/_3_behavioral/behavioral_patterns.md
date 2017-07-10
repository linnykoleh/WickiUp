
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
  
[example](_3_chain_of_resposibility/)  