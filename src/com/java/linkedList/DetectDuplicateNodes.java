package com.java.linkedList;

public class DetectDuplicateNodes {

    public static void printList(Node head){
        while(head!=null){
            System.out.print(head.data);
            if(head.next!=null)
                System.out.print("->");
            head=head.next;
        }
    }

    public static Node removeDuplicate(Node head){
        Node curr=head;
        while (curr!=null && curr.next!=null){
            if(curr.data==curr.next.data){
                curr.next=curr.next.next;
            }
            else{
                curr=curr.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Node head=new Node(2);
        head.next=new Node(3);
        head.next.next=new Node(3);
        head.next.next.next=new Node(3);
        head.next.next.next.next=new Node(4);
        System.out.println("before removing list");
        printList(head);

        System.out.println("\nAfter removing duplicate");
        Node removedDuplicate = removeDuplicate(head);
        printList(removedDuplicate);

    }
}
