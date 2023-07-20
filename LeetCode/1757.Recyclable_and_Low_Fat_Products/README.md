# Problem Name : 1757. Recyclable and Low Fat Products

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### MySQL

```
SELECT
    product_id
FROM
    Products
WHERE
    low_fats = 'Y'
AND
    recyclable = 'Y';
```
