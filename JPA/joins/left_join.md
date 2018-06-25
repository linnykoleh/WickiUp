#### Left Join

![alt text](images/left_join/Screenshot_1.png)

![alt text](images/left_join/Screenshot_4.png)
![alt text](images/left_join/Screenshot_5.png)

```sql
select *
from CUSTOMER_J c
left join ORDER_J o
on c.CUSTOMER_ID = o.CUSTOMER_ID;
```

![alt text](images/left_join/Screenshot_2.png)