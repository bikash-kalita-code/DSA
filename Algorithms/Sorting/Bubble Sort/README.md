# Bubble Sort

Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order. This algorithm is not suitable for large data sets as its average and worst-case time complexity is quite high.

### Code

#### C

```c
#include <stdio.h>

void swap(int *p, int *q)
{
	int tmp = *p;
	*p = *q;
	*q = tmp;
}

void printArray(int arr[], int n)
{
	for (int i = 0; i < n; i++)
	{
		printf("%d\t", arr[i]);
	}
	printf("\n");
}

void bubbleSort(int arr[], int n)
{
	for (int i = 0; i < n - 1; i++)
	{
		for (int j = 1; j < n - i; j++)
		{
			if (arr[j - 1] > arr[j])
				swap(&arr[j - 1], &arr[j]);
		}
	}
}

int main()
{
	int n;
	printf("Enter number of elements to be inserted : \n");
	scanf("%d", &n);
	int arr[n];
	for (int i = 0; i < n; i++)
	{
		printf("Enter element %d : ", i);
		scanf("%d", &arr[i]);
	}

	printf("Original Array : \n");
	printArray(arr, n);
	printf("\n");

	bubbleSort(arr, n);

	printf("Sorted array : \n");
	printArray(arr, n);

	return 0;
}
```