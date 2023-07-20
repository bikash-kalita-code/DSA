# Problem Name : 1. Two Sum

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### Java

**_Method 1: Brute Force approach_**

```java
public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[] { i, j };
            }
        }
        return null;
    }
```

**_Method 2: Using HashMap_**

```java
public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] {};
    }
```
