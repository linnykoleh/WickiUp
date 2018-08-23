
INSERT INTO `bank`(`BANK_ID`, `NAME`, `ADDRESS_LINE_1`, `ADDRESS_LINE_2`, `CITY`, `STATE`, `ZIP_CODE`, `IS_INTERNATIONAL`, `LAST_UPDATED_BY`,`LAST_UPDATED_DATE`,`CREATED_BY`,`CREATED_DATE`,`ADDRESS_TYPE`)
VALUES (1, 'Second National Trust', '301 Snowy Lane', 'Suite 2', 'Adams', 'PA', '10003', 0, 'system', '2014-11-1', 'system', '2014-11-1', 'PRIMARY');

INSERT INTO `bank`(`BANK_ID`, `NAME`, `ADDRESS_LINE_1`, `ADDRESS_LINE_2`, `CITY`, `STATE`, `ZIP_CODE`, `IS_INTERNATIONAL`, `LAST_UPDATED_BY`,`LAST_UPDATED_DATE`,`CREATED_BY`,`CREATED_DATE`,`ADDRESS_TYPE`)
VALUES (2, 'Third National Trust', 'Sunrise Drive', 'Suite 22', 'Jonestown', 'MI', '12303', 0, 'system', '2014-11-1', 'system', '2014-11-1','PRIMARY');

INSERT INTO `bank`(`BANK_ID`, `NAME`, `ADDRESS_LINE_1`, `ADDRESS_LINE_2`, `CITY`, `STATE`, `ZIP_CODE`, `IS_INTERNATIONAL`, `LAST_UPDATED_BY`,`LAST_UPDATED_DATE`,`CREATED_BY`,`CREATED_DATE`,`ADDRESS_TYPE`)
VALUES (3, 'Third National Trust', 'Bellvue', 'Suite 2', 'Newport', 'RI', '18943', 0, 'system', '2014-11-1'  'system', '2014-11-1','PRIMARY');

INSERT INTO `bank`(`BANK_ID`, `NAME`, `ADDRESS_LINE_1`, `ADDRESS_LINE_2`, `CITY`, `STATE`, `ZIP_CODE`, `IS_INTERNATIONAL`, `LAST_UPDATED_BY`,`LAST_UPDATED_DATE`,`CREATED_BY`,`CREATED_DATE`,`ADDRESS_TYPE`)
VALUES (4, 'Forth National Trust', '403 Park Ave', 'Suite 221', 'Madison', 'WI', '10003', 0, 'system', '2014-11-1', 'system', '2014-11-1','PRIMARY');

INSERT INTO `account` VALUES (1,1,'CHECKING','Checking Account',1000.00,1000.00,'2014-12-04','2014-12-04','Kevin Bowersox','2014-12-04 17:30:30','Kevin Bowersox','2014-12-04 17:30:30');
INSERT INTO `account` VALUES (2,2,'CHECKING','Interest Checking Account',1000.00,1000.00,'2014-12-04','2014-12-04','Kevin Bowersox','2014-12-04 17:30:30','Kevin Bowersox','2014-12-04 17:30:30');

INSERT INTO `transaction`
VALUES (1,1,'Withdrawl','Dress Belt',50.00,1000.00,950.00,'New Dress Belt','Kevin Bowersox','2014-12-06 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (2,1,'Withdrawl','Work Shoes',100.00,950.00,850.00,'Nice Pair of Shoes','Kevin Bowersox','2014-12-07 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (3,1,'Withdrawl','Shirt',100.00,850.00,750.00,'Nice Shirt','Kevin Bowersox','2014-12-08 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (4,1,'Withdrawl','Socks',10.00,750.00,740.00,'Nice Socks','Kevin Bowersox','2014-12-09 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (5,1,'Withdrawl','Tie',40.00,740.00,700.00,'Nice Tie','Kevin Bowersox','2014-12-09 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (6,1,'Withdrawl','Pants',100.00,700.00,600.00,'Nice Pants','Kevin Bowersox','2014-12-10 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (7,1,'Withdrawl','Lunch',20.00,600.00,580.00,'Nice Lunch','Kevin Bowersox','2014-12-11 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (8,1,'Withdrawl','Dinner',30.00,580.00,550.00,'Great Dinner','Kevin Bowersox','2014-12-11 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (9,1,'Withdrawl','Breakfast',10.00,550.00,540.00,'Breakfast at Tiffanys','Kevin Bowersox','2014-12-12 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (10,1,'Withdrawl','Groceries',100.00,540.00,440.00,'Healthy Food','Kevin Bowersox','2014-12-13 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (11,1,'Deposit','Pay Check',1000.00,440.00,1440.00,'Pay Day','Kevin Bowersox','2014-12-14 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (12,1,'Deposit','Bonus',500.00,1440.00,1940.00,'Annual Bonus','Kevin Bowersox','2014-12-19 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (13,2,'Withdrawl','Work Shoes',100.00,950.00,850.00,'Nice Pair of Shoes','Kevin Bowersox','2014-12-07 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (14,2,'Withdrawl','Shirt',100.00,850.00,750.00,'Nice Shirt','Kevin Bowersox','2014-12-08 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (15,2,'Withdrawl','Socks',10.00,750.00,740.00,'Nice Socks','Kevin Bowersox','2014-12-09 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (16,2,'Withdrawl','Tie',40.00,740.00,700.00,'Nice Tie','Kevin Bowersox','2014-12-09 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (17,2,'Withdrawl','Pants',100.00,700.00,600.00,'Nice Pants','Kevin Bowersox','2014-12-10 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (18,2,'Withdrawl','Lunch',20.00,600.00,580.00,'Nice Lunch','Kevin Bowersox','2014-12-11 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (19,2,'Withdrawl','Dinner',30.00,580.00,550.00,'Great Dinner','Kevin Bowersox','2014-12-11 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (20,2,'Withdrawl','Breakfast',10.00,550.00,540.00,'Breakfast at Tiffanys','Kevin Bowersox','2014-12-12 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (21,2,'Withdrawl','Groceries',100.00,540.00,440.00,'Healthy Food','Kevin Bowersox','2014-12-13 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (22,2,'Deposit','Royalties',1000.00,440.00,1440.00,'Pay Day','Kevin Bowersox','2014-12-14 10:53:30','Kevin Bowersox','2014-12-06 10:53:30'),
       (23,2,'Deposit','Bonus',20000.00,1440.00,21440.00,'Annual Bonus','Kevin Bowersox','2014-12-19 10:53:30','Kevin Bowersox','2014-12-06 10:53:30');


