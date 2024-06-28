# Singly Linked List with Header Node

## Sorted Linked List

In Sorted Linked List, the elements are kept in a sorted order.
Here, during insertion 4 things are taken into consideration:
 1. Insertion in the beginning
 2. Insertion in an empty list
 3. Insertion at the end
 4. Insertion in between

### Code

#### C

```c
#include<stdio.h>
#include<stdlib.h>

struct node {
	int info;
	struct node *link;
};

struct node *insert_s(struct node *start, int data);
void display(struct node *start);
void search(struct node *start, int data);

int main() {

	int choice, data;
	struct node *start = NULL;

	while(1) {
		printf("1. Insert\n");
		printf("2. Display\n");
		printf("3. Search\n");
		printf("4. Exit\n");
		printf("Enter your choice\n");
		scanf("%d", &choice);

		switch(choice) {
			case 1:
				printf("Enter the element to be inserted : \n");
				scanf("%d", &data);
				start = insert_s(start, data);
				break;
			case 2:
				display(start);
				break;
			case 3:
				printf("Enter the element to be searched : \n");
				scanf("%d", &data);
				search(start, data);
				break;
			case 4:
				exit(1);
			default:
				printf("Wrong choice!\n");
		}
	}
	return 0;
}

struct node *insert_s(struct node *start, int data) {
	struct node *p, *tmp;
	tmp = (struct node *)malloc(sizeof(struct node));
	tmp->info=data;
	// Case: When list is empty or element is to be inserted to first index
	if(start == NULL || start->info > data) {
		tmp->link = start;
		start=tmp;
		return start;
	}
	// Case: Insertion in between or at end
	p=start;
	while(p->link!=NULL && p->link->info < data) {
		p=p->link;
	}
	tmp->link=p->link;
	p->link=tmp;
	return start;
}

void display(struct node *start) {
	if(start == NULL) {
		printf("List is empty\n");
		return;
	}
	struct node *p = start;
	printf("List elements are : \n");
	while(p!=NULL) {
		printf("%d\t", p->info);
		p=p->link;
	}
	printf("\n");
}

void search(struct node *start, int data) {
	if(start==NULL || start->info > data) {
		printf("%d not found in list\n", data);
		return;
	}
	struct node *p = start;
	int pos=1;
	while(p!=NULL && p->info <= data) {
		if(p->info == data) {
			printf("Element %d found at position %d of list\n", data, pos);
			return;
		}
		pos++;
		p=p->link;
	}
	printf("%d not found in list\n", data);

}
```