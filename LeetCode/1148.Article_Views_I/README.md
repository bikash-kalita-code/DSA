# Problem Name : 1148. Article Views I

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### MySQL

```
SELECT 
    DISTINCT author_id AS id
FROM 
    Views
WHERE 
    author_id = viewer_id
ORDER BY id ASC;
```
