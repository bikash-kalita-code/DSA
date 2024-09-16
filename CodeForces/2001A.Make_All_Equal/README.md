# Problem Name : [2001A Make All Equal](https://codeforces.com/problemset/problem/2001/A)

[:arrow_backward: CodeForces Problems](../README.md)

### Description

### Hint / Discussion
Minimum number of elements to be removed to make all the elements equal will be the difference between total number of elements in the array and the frequency of the most frequent element

## Algorithm

#### Time Complexity

#### Space Complexity

### Code

#### go

```go
package main

import "fmt"

func main() {
	var testCases int

	// Read number of test cases
	fmt.Scan(&testCases)

	for i:=0; i<testCases; i++ {
		var n int
		// Read number of elements in array
		fmt.Scan(&n)

		arr := make([]int, n)
		// Map to store the frequency of each element
		elementCount := make(map[int]int)

		for j:=0; j<n; j++{
			fmt.Scan(&arr[j])
			elementCount[arr[j]]++
		}

		// Find the maximum frequency of any element in the array
		maxFrequency := 0
		for _, count := range elementCount {
			if count > maxFrequency {
				maxFrequency = count
			}
		}

		// Result = (total number of elements) - (most frequent element)
		result := n - maxFrequency
		fmt.Println(result)
	}
}
```