# Problem Name : [1768. Merge Strings Alternately](https://leetcode.com/problems/merge-strings-alternately/)

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### Go
```go
func mergeAlternately(word1 string, word2 string) string {
	len_word1, len_word2 := len(word1), len(word2)
	result := ""

	var min_length int
	if len_word1 < len_word2 {
		min_length = len_word1
	} else {
		min_length = len_word2
	}
	for i:=0; i<min_length; i++ {
		result += string(word1[i])
		result += string(word2[i])
	}

	if len_word1 < len_word2 {
		result += word2[min_length:]
	} else {
		result += word1[min_length:]
	}

	return result
}
```