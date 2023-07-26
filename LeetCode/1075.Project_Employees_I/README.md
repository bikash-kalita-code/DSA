# Problem Name : 1075. Project Employees I

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### MySQL

```sql
select
    p.project_id,
    round(avg(e.experience_years), 2) as average_years
from
    project p
inner join
    employee e
on
    p.employee_id = e.employee_id
group by
    p.project_id
```

#### PostgreSQL

```sql
select
    p.project_id,
    round(avg(e.experience_years), 2) as average_years
from
    project p
inner join
    employee e
on
    p.employee_id = e.employee_id
group by
    p.project_id
```