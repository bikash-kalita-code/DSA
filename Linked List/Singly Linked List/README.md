# Singly Linked List

### Code

#### C

```c
#include <stdio.h>
#include <stdlib.h>

struct node
{
	int info;
	struct node *link;
};

struct node *create_list(struct node *start);
void display(struct node *start);
void count(struct node *start);
void search(struct node *start, int data);
struct node *addatbeg(struct node *start, int data);
struct node *addatend(struct node *start, int data);
struct node *addafter(struct node *start, int data, int item);
struct node *addbefore(struct node *start, int data, int item);
struct node *addatpos(struct node *start, int data, int pos);
struct node *del(struct node *start, int data);
struct node *reverse(struct node *start);

int main()
{
	struct node *start = NULL;
	int choice, data, item, pos;
	while (1)
	{
		printf("1. Create List\n");
		printf("2. Display\n");
		printf("3. Count\n");
		printf("4. Search\n");
		printf("5. Add to empty list / Add at beginning\n");
		printf("6. Add at end\n");
		printf("7. Add after node\n");
		printf("8. Add before node\n");
		printf("9. Add at position\n");
		printf("10. Delete\n");
		printf("11. Reverse\n");
		printf("12. Quit\n");
		printf("Enter your choice : \n");
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
			count(start);
			break;
		case 4:
			printf("Enter the element to be searched : \n");
			scanf("%d", &data);
			search(start, data);
			break;
		case 5:
			printf("Enter the element to be inserted : \n");
			scanf("%d", &data);
			start = addatbeg(start, data);
			break;
		case 6:
			printf("Enter the element to be inserted : \n");
			scanf("%d", &data);
			start = addatend(start, data);
			break;
		case 7:
			printf("Enter the element to be inserted :\n");
			scanf("%d", &data);
			printf("Enter the element after which to insert : \n");
			scanf("%d", &item);
			start = addafter(start, data, item);
			break;
		case 8:
			printf("Enter the element to be inseretd :\n");
			scanf("%d", &data);
			printf("Enter the element before which to insert :\n");
			scanf("%d", &item);
			start = addbefore(start, data, item);
			break;
		case 9:
			printf("Enter the element to be inserted :\n");
			scanf("%d", &data);
			printf("Enter the position at which to insert : \n");
			scanf("%d", &pos);
			start = addatpos(start, data, pos);
			break;
		case 10:
			printf("Enter the element to be deleted : \n");
			scanf("%d", &data);
			start = del(start, data);
			break;
		case 11:
			start = reverse(start);
			break;
		case 12:
			exit(1);
		default:
			printf("Wrong choice\n");
		}
	}
}

struct node *clear_list(struct node *start)
{
	if (start == NULL)
	{
		printf("List is already empty.\n");
		return start;
	}
	struct node *p = start;
	while (p != NULL)
	{
		struct node *tmp = p;
		p = p->link;
		free(tmp);
	}
	start = NULL;
	return start;
}

struct node *create_list(struct node *start)
{
	char c;
	if (start != NULL)
	{
		printf("List is not empty. Would you like to clear it? (y/n) : \n");
		scanf(" %c", &c);
		if (c == 'y')
		{
			start = clear_list(start);
		}
		else if (c == 'n')
		{
			printf("Cannot create a new list since a list is already present.\n");
			return start;
		}
		else
		{
			printf("Incorrect choice!\n");
			return start;
		}
	}

	int data, n;
	printf("Enter number of elements to be inserted : \n");
	scanf("%d", &n);
	if (n == 0)
	{
		return start;
	}

	printf("Enter the element to be inserted : \n");
	scanf("%d", &data);
	start = addatbeg(start, data);

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
	printf("List elements are : \n");
	while (p != NULL)
	{
		printf("%d\t", p->info);
		p = p->link;
	}
	printf("\n");
}

void count(struct node *start)
{
	struct node *p = start;
	if (start == NULL)
	{
		printf("List is empty\n");
		return;
	}
	int count = 1;
	while (p->link != NULL)
	{
		count++;
		p = p->link;
	}
	printf("Number of elements in the list is %d\n", count);
}

void search(struct node *start, int data)
{
	if (start == NULL)
	{
		printf("List is empty\n");
		return;
	}
	int count = 0;
	struct node *p = start;
	while (p != NULL)
	{
		count++;
		if (p->info == data)
		{
			printf("Element %d found at position %d in the list.\n", data, count);
		}
		p = p->link;
	}
	printf("Element not found\n");
}

struct node *addatbeg(struct node *start, int data)
{
	struct node *tmp = (struct node *)malloc(sizeof(struct node));
	tmp->info = data;
	tmp->link = start;
	start = tmp;
	return start;
}

struct node *addatend(struct node *start, int data)
{
	struct node *tmp = (struct node *)malloc(sizeof(struct node));
	tmp->info = data;
	tmp->link = NULL;
	struct node *p = start;
	while (p->link != NULL)
	{
		p = p->link;
	}
	p->link = tmp;
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
			tmp->link = p->link;
			p->link = tmp;
			return start;
		}
		p = p->link;
	}
	printf("Item %d not found in the list\n", item);
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
	if (p->info == item)
	{
		start = addatbeg(start, data);
		return start;
	}
	while (p->link != NULL)
	{
		if (p->link->info == item)
		{
			struct node *tmp = (struct node *)malloc(sizeof(struct node));
			tmp->info = data;
			tmp->link = p->link;
			p->link = tmp;
			return start;
		}
		p = p->link;
	}
	printf("Item %d not found in the list\n", item);
	return start;
}

struct node *addatpos(struct node *start, int data, int pos)
{
	int count = 1;
	struct node *p = start;
	if (pos == 1)
	{
		start = addatbeg(start, data);
		return start;
	}
	while (p != NULL)
	{
		count++;
		if (count == pos)
		{
			struct node *tmp = (struct node *)malloc(sizeof(struct node));
			tmp->info = data;
			tmp->link = p->link;
			p->link = tmp;
			return start;
		}
		p = p->link;
	}
	printf("Position out of bound of the linked list\n");
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
	if (p->info == data)
	{
		struct node *tmp = p;
		p = p->link;
		free(tmp);
		start = p;
		return start;
	}
	while (p->link != NULL)
	{
		if (p->link->info == data)
		{
			struct node *tmp = p->link;
			p->link = p->link->link;
			free(tmp);
			return start;
		}
		p = p->link;
	}
	printf("Element %d not found in the linked list\n", data);
	return start;
}

struct node *reverse(struct node *start)
{
	struct node *prev, *ptr, *next;
	prev = NULL;
	ptr = start;
	while (ptr != NULL)
	{
		next = ptr->link;
		ptr->link = prev;
		prev = ptr;
		ptr = next;
	}
	start = prev;
	return start;
}

```