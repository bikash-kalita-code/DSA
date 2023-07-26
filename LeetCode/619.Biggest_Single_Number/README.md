# Problem Name : 619. Biggest Single Number

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### MySQL

```sql
select
	max(num) as num
from
	(
	select
		num
	from
		mynumbers
	group by
		num
	having
		count(num)= 1) as mn;
```

#### PostgreSQL

```sql
select
	max(num) as num
from
	(
	select
		num
	from
		mynumbers
	group by
		num
	having
		count(num)= 1) as mn;
```