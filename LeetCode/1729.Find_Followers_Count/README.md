# Problem Name : 1729. Find Followers Count

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### MySQL

```sql
select
    user_id,
    count(follower_id) as followers_count
from
    followers
group by
    user_id
order by
    user_id asc;
```

#### PostgreSQL

```sql
select
    user_id,
    count(follower_id) as followers_count
from
    followers
group by
    user_id
order by
    user_id asc;
```