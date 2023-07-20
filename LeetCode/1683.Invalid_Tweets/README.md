# Problem Name : 1683. Invalid Tweets

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### MySQL

```
SELECT 
    tweet_id 
FROM 
    Tweets
WHERE 
    CHAR_LENGTH(content) > 15;
```
