# Problem Name : 242. Valid Anagram

### Code

#### Java

**_Method 1 : Using Array_**

```java
public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int i : arr) {
            if (i != 0)
                return false;
        }

        return true;
    }
```

**_Method 2 : Using HashMap_**

```java
public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        // Count the frequency of characters in string s
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Decrement the values of characters in HashMap using characters of t
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) - 1);
        }

        // If string 's' has same number of characters as string 't', then adding all
        // characters
        // of string 's' to HashMap and subtracting all the characters from HashMap will
        // yield
        // an aggregate count of '0' for all characters or else they are not an anagram
        // of each other
        for (int val : map.values()) {
            if (val != 0)
                return false;
        }

        return true;
    }
```

**_Method 3: Using Sorting_**

```java
public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }
```
