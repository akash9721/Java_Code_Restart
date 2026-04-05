package com.java.linkedList;

public class ReorderList2 {
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
    public static void reorder(Node head){
        if(head==null && head.next==null)
            return;

        Node list1=head;
        Node middle=middleNode(head);
        Node list2=reverse(middle.next);
        middle.next=null;

        while(list1!=null && list2!=null){
            Node list1Next=list1.next;
            Node list2Next=list2.next;
            list1.next=list2;
            list2.next=list1Next;
            list1=list1Next;
            list2=list2Next;
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

        reorder(head);
        System.out.println("\nAfter reorder list");
        printList(head);
    }
}
