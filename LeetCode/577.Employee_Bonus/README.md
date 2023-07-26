# Problem Name : 577. Employee Bonus

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### MySQL

```sql
select
	e.name, b.bonus
from
	employee e
left join
	bonus b
on
	e.empid = b.empid
where
	bonus < 1000 or bonus is null;
```

#### PostgreSQL

```sql
select
	e.name, b.bonus
from
	employee e
left join
	bonus b
on
	e.empid = b.empid
where
	bonus < 1000 or bonus is null;
```