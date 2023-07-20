# Problem Name : 1299. Replace Elements with Greatest Element on Right Side

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### Java

```java
public int[] replaceElements(int[] arr) {
        int temp = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int max = Math.max(arr[i], temp);
            arr[i] = temp;
            temp = max;
        }
        return arr;
    }
```