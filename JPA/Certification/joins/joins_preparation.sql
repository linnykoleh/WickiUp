create table CUSTOMER_J (
  customer_id int primary key,
  first_name varchar,
  last_name varchar,
  email varchar,
  address varchar,
  city varchar,
  state varchar,
  zipcode int
)

insert into CUSTOMER_J (CUSTOMER_ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, CITY, STATE, ZIPCODE)
values (1, 'George',	'Washington', 'gwashington@usa.gov',	'3200 Mt Vernon Hwy',	'Mount Vernon',	'VA',	22121);
insert into CUSTOMER_J (CUSTOMER_ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, CITY, STATE, ZIPCODE)
values (2, 'John',	'Adams',	'jadams@usa.gov',	'1250 Hancock St',	'Quincy',	'MA',	02169);
insert into CUSTOMER_J (CUSTOMER_ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, CITY, STATE, ZIPCODE)
values (3,	'Thomas',	'Jefferson',	'tjefferson@usa.gov',	'931 Thomas Jefferson Pkwy',	'Charlottesville',	'VA',	22902);
insert into CUSTOMER_J (CUSTOMER_ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, CITY, STATE, ZIPCODE)
values (4, 'James',	'Madison',	'jmadison@usa.gov',	'11350 Constitution Hwy',	'Orange',	'VA',	22960);
insert into CUSTOMER_J (CUSTOMER_ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, CITY, STATE, ZIPCODE)
values (5,	'James',	'Monroe',	'jmonroe@usa.gov',	'2050 James Monroe Parkway',	'Charlottesville', 'VA',	22902);

create table ORDER_J (
  order_id int primary key,
  order_date varchar,
  amount bigint,
  customer_id int
)

insert into ORDER_J(ORDER_ID, ORDER_DATE, AMOUNT, CUSTOMER_ID)
values (1,	'07/04/1776',	234.56,	1);
insert into ORDER_J(ORDER_ID, ORDER_DATE, AMOUNT, CUSTOMER_ID)
values (2,	'03/14/1760',	78.50,	3);
insert into ORDER_J (ORDER_ID, ORDER_DATE, AMOUNT, CUSTOMER_ID)
values (3, '05/23/1784', 124.00, 2);
insert into ORDER_J(ORDER_ID, ORDER_DATE, AMOUNT, CUSTOMER_ID)
values (4, '09/03/1790',	65.50,	3);
insert into ORDER_J (ORDER_ID, ORDER_DATE, AMOUNT, CUSTOMER_ID)
values (5, '07/21/1795', 25.50, 10);
insert into ORDER_J(ORDER_ID, ORDER_DATE, AMOUNT, CUSTOMER_ID)
values ( 6,	'11/27/1787',	14.40,	9);