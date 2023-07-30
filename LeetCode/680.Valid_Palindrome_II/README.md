# Problem Name : 680. Valid Palindrome II

[:arrow_backward: LeetCode Problems](../README.md)

## Algorithm

***Method 1 - Brute Force***

1. Iterate through the array to generate `(n - 1)` substrings (consumes **O(n)** time complexity )
2. Validate if the given substring is a palindrome or not ( consumes **O(n)** time complexity )

**Time Complexity :** O(n²)

***Method 2 - Using Two Pointers***

1. Trim the string until they have equal characters from both ends
2. Now, form two substrings from the above substring by removing the first and the last character respectively. Any if any of the two substrings is a palindrome then return true

### Code

#### Java

**Method - 2**

```java
public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
```