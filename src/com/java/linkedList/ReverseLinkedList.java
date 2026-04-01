package com.java.linkedList;

class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data=data;
	}
}
public class ReverseLinkedList {

	public static Node reverseList(Node head) {
		Node currNode=head;
		Node prevNode=null;
		Node nextNode;
		while(currNode!=null) {
			nextNode=currNode.next;
			currNode.next=prevNode;
			prevNode=currNode;
			currNode=nextNode;
		}
		return prevNode;
	}
	public static void printList(Node head) {
		Node currNode=head;
		while(currNode!=null) {
			System.out.print(currNode.data+" ");
			if(currNode.next!=null) {
				System.out.print("->");
			}
			currNode=currNode.next;
		}
	}
	
    public static int middleNode(Node head) {
    	Node slowNode=head;
    	Node fastNode=head;
    	
    	while(fastNode!=null && fastNode.next!=null) {
    		slowNode=slowNode.next;
    		fastNode=fastNode.next.next;
    	}
    	return slowNode.data;
    }
	public static void main(String[] args) {
		System.out.println();
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		System.out.println("before reverse");
		printList(head);
		
		System.out.println("\nafter reverse");
		Node reverse = reverseList(head);
		printList(reverse);
		
		System.out.println("\n\nMiddle of Linked list");
		int middledata = middleNode(reverse);
		System.out.println("Middle of Linked list is: "+middledata);
		
	}
}
