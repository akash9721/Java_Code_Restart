package com.java.linkedList;

public class RemoveNthFromEnd{

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

    public static Node remove(Node head,int n){
        Node dummy=new Node(-1);
        dummy.next=head;
        Node slow=dummy;
        Node fast=dummy;
        for(int i=0;i<=n;i++){
            fast=fast.next;
        }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
    public static void main(String[] args) {
        Node list1=new Node(1);
        list1.next=new Node(8);
        list1.next.next=new Node(11);
        list1.next.next.next=new Node(15);
        list1.next.next.next.next=new Node(20);
        printList(list1);

        int n=3;
        Node afterRemovedList = remove(list1, n);
        System.out.println("\nafter removing last "+n+" node");
        printList(afterRemovedList);
    }
}
