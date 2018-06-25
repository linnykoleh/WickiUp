#### Right Join

![alt text](images/right_join/Screenshot_1.png)

![alt text](images/right_join/Screenshot_4.png)
![alt text](images/right_join/Screenshot_5.png)

```sql
select *
from CUSTOMER_J c
right join ORDER_J o
on c.CUSTOMER_ID = o.CUSTOMER_ID;
```

![alt text](images/right_join/Screenshot_2.png)