# Problem Name : 1068. Product Sales Analysis I

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### MySQL

```sql
SELECT
    p.product_name, s.year, s.price
FROM
    sales s
INNER JOIN
    product p
ON
    s.product_id = p.product_id;
```
