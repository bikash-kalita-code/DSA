# Problem Name : 1378. Replace Employee ID With The Unique Identifier

### Code

#### MySQL

```
SELECT
	e2.unique_id, e.name
FROM
	employees e
LEFT JOIN
	employeeuni e2
ON
	e.id = e2.id;
```
