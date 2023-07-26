# Problem Name : 2356. Number of Unique Subjects Taught by Each Teacher

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### MySQL

```sql
select
    teacher_id,
    count(distinct subject_id) as cnt
from
    teacher
group by
    teacher_id;
```

#### PostgreSQL

```sql
select
    teacher_id,
    count(distinct subject_id) as cnt
from
    teacher
group by
    teacher_id;
```