# Problem Name : 570. Managers with at Least 5 Direct Reports

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### MySQL

```sql
select
    e2.name
from
    employee e1
inner join
    employee e2
on
    e1.managerId = e2.id
group by 
    e1.managerId
having
    count(e1.managerId) >= 5;
```