# Problem Name : 125. Valid Palindrome

[:arrow_backward: LeetCode Problems](../README.md)

### Code

***NOTE : In below code `Method 2` is faster than `Method 1`***

#### Java

**Method 1 - Using regular expression to filter non alphanumeric characters**

```java
public boolean isPalindrome(String s) {
    s = s.replaceAll("[^a-zA-Z0-9]", ""); // O(n)
    s = s.toLowerCase(); // O(n)
    for (int i = 0, j = s.length() - 1; i < j; i++, j--) { // O(n)
        if (s.charAt(i) != s.charAt(j))
            return false;
    }
    return true;
}
```

**Method 2 - Manually replacing alphanumeric characters to lowercase and filtering out rest**

```java
public boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while (i < j) { // O(n)
        Character left = s.charAt(i);
        Character right = s.charAt(j);

        if (!Character.isLetterOrDigit(left)) {
            i++;
            continue;
        }

        if (!Character.isLetterOrDigit(right)) {
            j--;
            continue;
        }

        if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
            return false;
        }

        i++;
        j--;
    }
    return true;
}
```