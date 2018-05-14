https://www.safaribooksonline.com/library/view/hibernate-and-java/9781771373494/
https://vladmihalcea.com/why-you-should-never-use-the-table-identifier-generator-with-jpa-and-hibernate/
https://easyjava.ru/data/jpa/pervichnye-klyuchi-v-jpa/	
			      
##### GenerationType
https://www.youtube.com/watch?v=fKO6kbTUEuo&list=PLCA5CB42F5A816A17&index=5

**GenerationType.AUTO** - Автоматическая генерация, выбор осуществляется конкректным провайдером(Hibernate), 
                          в зависимости с какой базой данных  работаем.
                          Провайдер сам будет использовать ту стратегию какую использует база
                          Hibernate сам выберает подходящюю стратегию для 
					      генерации ключа, которая базируется на разных бд,
					      например для Oracle он выберет SEQUENCE, для MYSQL он выберет IDENTITY
**GenerationType.IDENTITY** - id назначаются по возрастанию и id уникальный в пределах одной таблице
**GenerationType.SEQUENCE** - id генерятся с помошью последовательности
                              Использует встроенный в базы данных, такие как PostgreSQL или Oracle, 
						      механизм генерации последовательных значений (sequence). 
						      Использование этого генератора требует создания отдельной sequence в базе данных.
**GenerationType.TABLE** - Создается отдельная табличка где хранятся записи первичных ключей
                           Не зависит от поддержки конкретной базой данных и хранит счётчики значений в отдельной таблице. 
                           С одной стороны это более гибкое и настраиваемое решение, 
                           с другой стороны более медленное и требующее большей настройки
**Без @** - Ошибка *org.hibernate.id.IdentifierGenerationException: ids for this class must be manually assigned beforeQuery calling save()*