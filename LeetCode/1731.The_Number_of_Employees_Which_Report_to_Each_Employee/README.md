# Problem Name : 1731. The Number of Employees Which Report to Each Employee

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### MySQL

```sql
select
	e1.reports_to as employee_id,
	e2.name,
	count(e1.name) as reports_count,
	round(avg(e1.age)) as average_age
from
	employees e1
inner join
	employees e2
on
	e1.reports_to = e2.employee_id
group by
	e1.reports_to,
	e2.name
order by
    e1.reports_to;
```

#### PostgreSQL

```sql
select
	e1.reports_to as employee_id,
	e2.name,
	count(e1.name) as reports_count,
	round(avg(e1.age)) as average_age
from
	employees e1
inner join
	employees e2
on
	e1.reports_to = e2.employee_id
group by
	e1.reports_to,
	e2.name
order by
    e1.reports_to;
```