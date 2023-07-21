# Problem Name : 584. Find Customer Referee

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### MySQL

```sql
SELECT 
    name 
FROM 
    Customer
WHERE
    referee_id <> 2
OR
    referee_id IS NULL;
```
