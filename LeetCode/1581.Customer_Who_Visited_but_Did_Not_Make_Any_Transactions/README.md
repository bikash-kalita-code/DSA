# Problem Name : 1581. Customer Who Visited but Did Not Make Any Transactions

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### MySQL

```
SELECT
	v.customer_id, COUNT(v.customer_id) AS count_no_trans
FROM
    visits v
LEFT JOIN
    transactions t
ON
    v.visit_id = t.visit_id
WHERE
	t.transaction_id IS NULL
GROUP BY
	v.customer_id;
```
