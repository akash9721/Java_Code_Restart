package com.java.linkedList;

public class ReorderList {
    public static Node middleNode(Node head){
        if(head==null || head.next==null)
            return head;
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static Node reverse(Node head){
        Node prev=null;
        Node curr=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public static Node reorder(Node list1,Node list2){
        Node dummy=new Node(-1);
        Node trav=dummy;
        while(list1!=null && list2!=null){
            trav.next=list1;
            trav=list1;
            list1=list1.next;
            trav.next=list2;
            trav=list2;
            list2=list2.next;
        }
        while(list1!=null){
            trav.next=list1;
            trav=list1;
            list1=list1.next;
        }
        while(list2!=null){
            trav.next=list2;
            trav=list2;
            list2=list2.next;
        }
        return dummy.next;
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
    public static void main(String[] args) {
        Node head=new Node(2);
        head.next=new Node(3);
        head.next.next=new Node(4);
        head.next.next.next=new Node(5);
        head.next.next.next.next=new Node(6);
        System.out.println("before reorder list");
        printList(head);

        Node list1=head;
        Node middle=middleNode(head);
        Node list2=reverse(middle.next);
        middle.next=null;
        Node reordered = reorder(list1, list2);
        System.out.println("\nafter reorder list");
        printList(reordered);
    }
}
