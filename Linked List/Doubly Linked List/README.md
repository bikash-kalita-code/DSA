# Doubly Linked List

### Code

#### C

```c
#include <stdio.h>
#include <stdlib.h>

struct node
{
	struct node *prev;
	int info;
	struct node *next;
};

struct node *create_list(struct node *start);
void display(struct node *start);
struct node *addtoempty(struct node *start, int data);
struct node *addatbeg(struct node *start, int data);
struct node *addatend(struct node *start, int data);
struct node *addafter(struct node *start, int data, int item);
struct node *addbefore(struct node *start, int data, int item);
struct node *del(struct node *start, int data);
struct node *reverse(struct node *start);

int main()
{
	int choice, data, item;
	struct node *start = NULL;
	while (1)
	{
		printf("1. Create List\n");
		printf("2. Display\n");
		printf("3. Add to empty list\n");
		printf("4. Add at beginning\n");
		printf("5. Add at end\n");
		printf("6. Add after\n");
		printf("7. Add before\n");
		printf("8. Delete\n");
		printf("9. Reverse\n");
		printf("10. Quit\n");
		printf("Enter your choice\n");
		scanf("%d", &choice);
		switch (choice)
		{
		case 1:
			start = create_list(start);
			break;
		case 2:
			display(start);
			break;
		case 3:
			printf("Enter the element to be inserted : \n");
			scanf("%d", &data);
			start = addtoempty(start, data);
			break;
		case 4:
			printf("Enter the element to be inserted : \n");
			scanf("%d", &data);
			start = addatbeg(start, data);
			break;
		case 5:
			printf("Enter the element to be inserted : \n");
			scanf("%d", &data);
			start = addatend(start, data);
			break;
		case 6:
			printf("Enter the element to be inserted : \n");
			scanf("%d", &data);
			printf("Enter the element after which to insert : \n");
			scanf("%d", &item);
			start = addafter(start, data, item);
			break;
		case 7:
			printf("Enter the element to be inserted : \n");
			scanf("%d", &data);
			printf("Enter the element before which to insert : \n");
			scanf("%d", &item);
			start = addbefore(start, data, item);
			break;
		case 8:
			printf("Enter the element to be deleted : \n");
			scanf("%d", &data);
			start = del(start, data);
			break;
		case 9:
			start = reverse(start);
			break;
		case 10:
			exit(1);
		default:
			printf("Wrong choice\n");
		}
	}
	return 0;
}

struct node *create_list(struct node *start)
{
	if (start != NULL)
	{
		printf("List is not empty\n");
		return start;
	}
	int n;
	printf("Enter the number of elements to be inserted : \n");
	scanf("%d", &n);
	int data;
	if (n == 0)
		return start;
	printf("Enter the element to be inserted : \n");
	scanf("%d", &data);
	start = addtoempty(start, data);
	for (int i = 2; i <= n; i++)
	{
		printf("Enter the element to be inserted : \n");
		scanf("%d", &data);
		start = addatend(start, data);
	}
	return start;
}

void display(struct node *start)
{
	if (start == NULL)
	{
		printf("List is empty\n");
		return;
	}
	struct node *p = start;
	printf("List elements are :\n");
	while (p != NULL)
	{
		printf("%d\t", p->info);
		p = p->next;
	}
	printf("\n");
}

struct node *addtoempty(struct node *start, int data)
{
	if (start != NULL)
	{
		printf("List is not empty\n");
		return start;
	}
	struct node *tmp = (struct node *)malloc(sizeof(struct node));
	tmp->info = data;
	tmp->prev = NULL;
	tmp->next = NULL;
	start = tmp;
	return start;
}

struct node *addatbeg(struct node *start, int data)
{
	if (start == NULL)
	{
		printf("List is empty\n");
		return start;
	}
	struct node *tmp = (struct node *)malloc(sizeof(struct node));
	tmp->info = data;
	tmp->next = start;
	tmp->prev = NULL;
	start->prev = tmp;
	start = tmp;
	return start;
}

struct node *addatend(struct node *start, int data)
{
	if (start == NULL)
	{
		printf("List is empty\n");
		return start;
	}
	struct node *tmp = (struct node *)malloc(sizeof(struct node));
	tmp->info = data;
	struct node *p = start;
	while (p->next != NULL)
	{
		p = p->next;
	}
	tmp->next = NULL;
	tmp->prev = p;
	p->next = tmp;
	return start;
}

struct node *addafter(struct node *start, int data, int item)
{
	if (start == NULL)
	{
		printf("List is empty\n");
		return start;
	}
	struct node *p = start;
	while (p != NULL)
	{
		if (p->info == item)
		{
			struct node *tmp = (struct node *)malloc(sizeof(struct node));
			tmp->info = data;
			tmp->next = p->next;
			tmp->prev = p;
			p->next = tmp;
			if (tmp->next != NULL)
				tmp->next->prev = tmp;
			return start;
		}
		p = p->next;
	}
	printf("Element %d not found in the list\n", item);
	return start;
}

struct node *addbefore(struct node *start, int data, int item)
{
	if (start == NULL)
	{
		printf("List is empty\n");
		return start;
	}
	struct node *p = start;
	while (p != NULL)
	{
		if (p->info == item)
		{
			struct node *tmp = (struct node *)malloc(sizeof(struct node));
			tmp->info = data;
			tmp->next = p;
			tmp->prev = p->prev;
			if (p != start)
				tmp->prev->next = tmp;
			p->prev = tmp;
			if (tmp->prev == NULL)
				start = tmp;
			return start;
		}
		p = p->next;
	}
	printf("Element %d not found in the list\n", item);
	return start;
}

struct node *del(struct node *start, int data)
{
	if (start == NULL)
	{
		printf("List is empty\n");
		return start;
	}
	struct node *p = start;
	while (p != NULL)
	{
		if (p->info == data)
		{
			if (p == start && p->next == NULL)
			{
				start = NULL;
				free(p);
				return start;
			}
			else if (p == start && p->next != NULL)
			{
				p->next->prev == NULL;
				start = p->next;
				free(p);
				return start;
			}
			else if (p->next == NULL)
			{
				p->prev->next = p->next;
				free(p);
				return start;
			}
			else
			{
				p->next->prev = p->prev;
				p->prev->next = p->next;
				free(p);
				return start;
			}
		}
		p = p->next;
	}
	printf("Element %d not found in the list\n", data);
	return start;
}

struct node *reverse(struct node *start)
{
	if (start == NULL)
	{
		printf("List is empty\n");
		return start;
	}
	struct node *p = start;
	while (p != NULL)
	{
		struct node *tmp = p->next;
		p->next = p->prev;
		p->prev = tmp;
		if (p->prev != NULL)
		{
			p = p->prev;
		}
		else
		{
			start = p;
			return start;
		}
	}
}
```