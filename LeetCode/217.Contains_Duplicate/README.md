# Problem Name : 217. Contains Duplicate

[:arrow_backward: LeetCode Problems](../README.md)

### Description :

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

### Hint / Discussion

Use HashSet for solving the problem.

#### Time Complexity :

O(n)

#### Space Complexity :

O(n)

### Code

#### Java

```java
public boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length == 0)
            return false;

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (!set.add(i))
                return true;
        }

        return false;
    }
```
