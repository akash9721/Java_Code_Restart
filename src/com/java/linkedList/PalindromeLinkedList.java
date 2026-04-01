package com.java.linkedList;

public class PalindromeLinkedList {
    public static Node middleNode(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static Node reverseList(Node head){
        Node curr=head;
        Node prev=null;
        Node nextNode;
        while(curr!=null){
            nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }

    public static boolean isPalindrone(Node node1,Node node2){
        while (node1!=null && node2!=null){
            if(node1.data!=node2.data){
                return false;
            }
            node1=node1.next;
            node2=node2.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Node head=new Node(2);
        head.next=new Node(3);
        head.next.next=new Node(4);
        head.next.next.next=new Node(3);
        head.next.next.next.next=new Node(2);

        Node node1=head;
        Node mid = middleNode(head);
        Node node2 = reverseList(mid.next);
        mid.next=null;

        System.out.println(isPalindrone(node1, node2)?"LIST IS PALINDRON":"LIST IS NOT PALINDRON");

        node2 = reverseList(node2);
        mid.next=node2;

    }
}
