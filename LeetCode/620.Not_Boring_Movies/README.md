# Problem Name : 620. Not Boring Movies

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### MySQL

```sql
select
    *
from
    cinema
where
    id%2 = 1
and
    description <> "boring"
order by
    rating desc;
```

#### PostgreSQL

```sql
select
    *
from
    cinema
where
    id%2 = 1
and
    description <> "boring"
order by
    rating desc;
```