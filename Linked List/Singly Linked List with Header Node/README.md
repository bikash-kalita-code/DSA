# Singly Linked List with Header Node

## Linked List with Header Node

Header node is a dummy node that is present at the beginning of the list and its link part is used to store the address of the first actual node of the list. The info part of this node may be empty or can be used to contain useful information about the list link count of elements currently present in the list.

The header node is never deleted, it exists even if the list is empty. So it may be declared while writing the program instead of dynamically allocating memory for it.

### Code

#### C

```c
#include<stdio.h>
#include<stdlib.h>

struct node {
	int info;
	struct node *link;
};

struct node *create_list(struct node *head);
void display(struct node *head);
struct node *addatend(struct node *head, int data);
struct node *addbefore(struct node *head, int data, int item);
struct node *addatpos(struct node *head, int data, int pos);
struct node *del(struct node *head, int data);
struct node *reverse(struct node *head);

int main() {

	int choice, data, pos, item;
	struct node *head;
	head = (struct node *)malloc(sizeof(struct node));
	head->info=0;
	head->link=NULL;
	head=create_list(head);

	while(1) {
		printf("1. Display\n");
		printf("2. Add at end\n");
		printf("3. Add before node\n");
		printf("4. Add at position\n");
		printf("5. Delete\n");
		printf("6. Reverse\n");
		printf("7. Quit\n");
		printf("Enter your choice : \n");
		scanf("%d", &choice);
		switch(choice) {
			case 1:
				display(head);
				break;
			case 2:
				printf("Enter the element to be inserted : \n");
				scanf("%d", &data);
				head = addatend(head, data);
				break;
			case 3:
				printf("Enter the element to be inserted : \n");
				scanf("%d", &data);
				printf("Enter the element before which to insert : \n");
				scanf("%d", &item);
				head = addbefore(head, data, item);
				break;
			case 4:
				printf("Enter the element to be inserted : \n");
				scanf("%d", &data);
				printf("Enter the position at which to insert : ");
				scanf("%d", &pos);
				head = addatpos(head, data, pos);
				break;
			case 5:
				printf("Enter the element to be deleted : ");
				scanf("%d", &data);
				head = del(head, data);
				break;
			case 6:
				head = reverse(head);
				break;
			case 7:
				exit(1);
			default:
				printf("Wrong choice\n\n");
		}
	}
	return 0;
}

struct node *create_list(struct node *head) {
	int i, n, data;
	printf("Creating new list...\n");
	printf("Enter the number of nodes : \n");
	scanf("%d", &n);
	for(i=1; i<=n; i++) {
		printf("Enter the element to be inserted : \n");
		scanf("%d", &data);
		head=addatend(head, data);
	}
	return head;
}

void display(struct node *head) {
	if(head->link==NULL) {
		printf("List is empty\n");
		return;
	}
	struct node *p;
	p=head->link;
	printf("List is : \n");
	while(p!=NULL) {
		printf("%d\t", p->info);
		p=p->link;
	}
	printf("\n");
}

struct node *addatend(struct node *head, int data) {
	struct node *p, *tmp;
	p = head;
	tmp = (struct node *)malloc(sizeof(struct node));
	tmp->info=data;
	tmp->link=NULL;
	while(p->link!=NULL) {
		p=p->link;
	}
	p->link=tmp;
	return head;
}

struct node *addbefore(struct node *head, int data, int item) {
	struct node *p, *tmp;
	p=head;
	while(p->link != NULL) {
		if(p->link->info == item) {
			tmp=(struct node *)malloc(sizeof(struct node));
			tmp->info=data;
			tmp->link=p->link;
			p->link=tmp;
			return head;
		}
		p=p->link;
	}
	printf("%d not present in the list\n", item);
	return head;
}

struct node *addatpos(struct node *head, int data, int pos) {
	struct node *tmp, *p;
	int i=1;
	p=head;
	while(i!=pos && p->link!=NULL) {
		i++;
		p=p->link;
	}
	if(i==pos) {
		tmp=(struct node *)malloc(sizeof(struct node));
		tmp->info=data;
		tmp->link=p->link;
		p->link=tmp;
		return head;
	}
	printf("Position %d is out of bound of the list\n", pos);
	return head;
}

struct node *del(struct node *head, int data) {
	struct node *tmp, *p;
	p=head;
	while(p->link != NULL) {
		if(p->link->info == data) {
			tmp=p->link;
			p->link=p->link->link;
			free(tmp);
			return head;
		}
		p=p->link;
	}
	printf("%d not found in the list\n", data);
	return head;
}

struct node *reverse(struct node *head) {
	struct node *prev, *curr, *next;
	prev=NULL;
	curr=head->link;
	while(curr!=NULL) {
		next=curr->link;
		curr->link=prev;
		prev=curr;
		curr=next;
	}
	head->link = prev;
	return head;
}
```