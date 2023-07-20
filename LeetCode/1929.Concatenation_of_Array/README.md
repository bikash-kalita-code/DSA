# Problem Name : 1929. Concatenation of Array

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### Java

```java
public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];

        int nums_length = nums.length;

        for (int i = 0; i < nums_length; i++) {
            result[i] = result[i + nums_length] = nums[i];
        }

        return result;
    }
```
