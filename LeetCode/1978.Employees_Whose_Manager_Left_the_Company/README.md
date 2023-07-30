# Problem Name : 1978. Employees Whose Manager Left the Company

[:arrow_backward: LeetCode Problems](../README.md)

### Description

Use `inner join` to filter rows to be compared within `not in` subquery. Since in large data set if you don't filter the rows for comparison then repetitive comparison with all the rows will be a resource consuming task.

### Code

#### MySQL

```sql
select
	e.employee_id
from
	employees e
where
	e.manager_id is not null
	and
	e.salary < 30000
	and
	e.manager_id not in(
	select
		e1.manager_id
	from
		employees e1
	inner join
		employees e2
	on
		e1.manager_id = e2.employee_id
		and
		e1.salary < 30000
	)
order by
	e.employee_id 
;
```

#### PostgreSQL

```sql
select
	e.employee_id
from
	employees e
where
	e.manager_id is not null
	and
	e.salary < 30000
	and
	e.manager_id not in(
	select
		e1.manager_id
	from
		employees e1
	inner join
		employees e2
	on
		e1.manager_id = e2.employee_id
		and
		e1.salary < 30000
	)
order by
	e.employee_id 
;
```