# Problem Name : 596. Classes More Than 5 Students

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### MySQL

```sql
select
    class
from
    courses
group by
    class
having
    count(student) >= 5;
```

#### PostgreSQL

```sql
select
    class
from
    courses
group by
    class
having
    count(student) >= 5;
```