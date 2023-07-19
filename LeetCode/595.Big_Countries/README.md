# Problem Name : 595. Big Countries

### Code

#### MySQL

```
SELECT
    name, population, area
FROM 
    World
WHERE
    area >= 3000000
OR
    population >= 25000000;
```
