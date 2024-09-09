# Problem Name : 345. Reverse Vowels of a String

[:arrow_backward: LeetCode Problems](../README.md)

### Code

#### Go
```go
func reverseVowels(s string) string {
	if len(s) == 1 {
		return s
	}

	start := 0
	end := len(s) - 1
	vowels := map[string]bool{
		"a": true,
		"e": true,
		"i": true,
		"o": true,
		"u": true,
	}
	for start < end {
		for start < end && !vowels[strings.ToLower(string(s[start]))] {
			start++
		}
		for start < end && !vowels[strings.ToLower(string(s[end]))] {
			end--
		}
		if start < end {
			s = s[0:start] + string(s[end]) + s[start+1:end] + string(s[start]) + s[end+1:]
			start++
			end--
		}
	}

	return s
}
```

#### JavaScript
```js
/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function (s) {
    if (s.length === 1) return s;

    let start = 0;
    let end = s.length - 1;
    const set = new Set(['a', 'e', 'i', 'o', 'u']);
    while (start < end) {
        while (start < end && !set.has(s[start].toLowerCase())) {
            start++;
        }
        while (start < end && !set.has(s[end].toLowerCase())) {
            end--;
        }
        if (start < end) {
            s = s.substring(0, start) + s[end] + s.substring(start + 1, end) + s[start] + s.substring(end + 1);
            start++;
            end--;
        }
    }
    return s;
};
```

#### TypeScript
```ts
function reverseVowels(s: string): string {
  if (s.length === 1) return s;

  let start: number = 0;
  let end: number = s.length - 1;
  const set: Set<string> = new Set(["a", "e", "i", "o", "u"]);
  while (start < end) {
    while (start < end && !set.has(s[start].toLowerCase())) {
      start++;
    }
    while (start < end && !set.has(s[end].toLowerCase())) {
      end--;
    }
    if (start < end) {
      s =
        s.substring(0, start) +
        s[end] +
        s.substring(start + 1, end) +
        s[start] +
        s.substring(end + 1);
      start++;
      end--;
    }
  }
  return s;
}
```