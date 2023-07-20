# Problem Name : 197. Rising Temperature

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### MySQL

```
SELECT
	w2.id
FROM
	weather w1
INNER JOIN
	weather w2
ON
	DATEDIFF( w2.recordDate, w1.recordDate ) = 1
WHERE
	w2.temperature - w1.temperature > 0;
```

#### PostgreSQL

```
SELECT
	w2.id
FROM
	weather w1
INNER JOIN
	weather w2
ON
	EXTRACT ( DAY FROM w2.recorddate::timestamp - w1.recorddate::timestamp) = 1
WHERE
	w2.temperature - w1.temperature > 0;
```
