# Problem Name : 1683. Invalid Tweets

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
