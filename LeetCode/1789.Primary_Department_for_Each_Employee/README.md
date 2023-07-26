# Problem Name : 1789. Primary Department for Each Employee

[:arrow_backward: LeetCode Problems](../README.md)

## Approach

The solution of this problem have been split into two parts where first part is responsible for extraction of `(employee_id, department_id)` in which the employee is assigned to only one department and the second part is responsible for extraction of `(employee_id, department_id)` where the employee is assigned to more than one department. After getting data from both parts we will apply `union` operation to get all the employees with their respective required departments.

### Part 1 : Get `(employee_id, department_id)` from the employee table where the employee is assigned to only one department

**Step 1 : Get the `employee_id` where the employee is assigned to only one department**
```sql
select 
    employee_id
from
    employee
group by
    employee_id
having
    count(department_id) = 1
```
**Step 2 : Join the subquery in `Step 1` with the parent table `employee` to extract the `department_id`**
```sql
select 
    e1.employee_id,
    e1.department_id
from
    employee e1
inner join
    (
        select 
            employee_id
        from
            employee
        group by
            employee_id
        having
            count(department_id) = 1
    ) e2
on
    e1.employee_id = e2.employee_id
```

### Part 2 :  Get (employee_id, department_id) from the employee table where the employee is assigned to more than one department

```sql
select
    e3.employee_id, e3.department_id
from
    employee e3
where
    e3.primary_flag = 'Y'
```

Now, the final solution will be the `UNION` of both **`Part 1`** and **`Part 2`**

### Code

#### MySQL

```sql
select 
    e1.employee_id,
    e1.department_id
from
    employee e1
inner join
    (
        select 
            employee_id
        from
            employee
        group by
            employee_id
        having
            count(employee_id) = 1
    ) e2
on
    e1.employee_id = e2.employee_id
union
select
    e3.employee_id, e3.department_id
from
    employee e3
where
    e3.primary_flag = 'Y'
```

#### PostgreSQL

```sql
select 
    e1.employee_id,
    e1.department_id
from
    employee e1
inner join
    (
        select 
            employee_id
        from
            employee
        group by
            employee_id
        having
            count(employee_id) = 1
    ) e2
on
    e1.employee_id = e2.employee_id
union
select
    e3.employee_id, e3.department_id
from
    employee e3
where
    e3.primary_flag = 'Y'
    ```