https://www.safaribooksonline.com/library/view/hibernate-and-java/9781771373494/
https://vladmihalcea.com/why-you-should-never-use-the-table-identifier-generator-with-jpa-and-hibernate/
https://easyjava.ru/data/jpa/pervichnye-klyuchi-v-jpa/				      

##### GenerationType

**GenerationType.AUTO** - Hibernate сам выберает подходящюю стратегию для 
					      генерации ключа, которая базируется на разных провайдерах,
					      например для Oracle он выберет SEQUENCE, для MYSQL он выберет IDENTITY
**GenerationType.IDENTITY** - Работает с базами, у которых есть специальные IDENTITY поля, например с MySQL или DB2
**GenerationType.SEQUENCE** - Использует встроенный в базы данных, такие как PostgreSQL или Oracle, 
						      механизм генерации последовательных значений (sequence). 
						      Использование этого генератора требует как создания отдельной sequence в базе данных.
**GenerationType.TABLE** - Не зависит от поддержки конкретной базой данных и хранит счётчики значений в отдельной таблице. 
                           С одной стороны это более гибкое и настраиваемое решение, 
                           с другой стороны более медленное и требующее большей настройки
**Без GenerationType** - Ошибка *org.hibernate.id.IdentifierGenerationException: ids for this class must be manually assigned beforeQuery calling save()*                         