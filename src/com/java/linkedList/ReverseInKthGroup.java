package com.java.linkedList;

public class ReverseInKthGroup {

    public static Node reverseInGroup(Node head,int k){
        //base case
        if(head==null)
            return null;

        //reverse first k node
        Node nextNode=null;
        Node prev=null;
        Node curr=head;
        int cnt=0;
        while (curr!=null && cnt<k){
            nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
            cnt++;
        }

        //further handle recurssion
        if(nextNode!=null){
            head.next=reverseInGroup(nextNode,k);
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
    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(4);
        head.next.next=new Node(9);
        head.next.next.next=new Node(3);
        head.next.next.next.next=new Node(2);
        System.out.println("Before reversal");
        printList(head);

        System.out.println("\nAfter reversal");
        Node newList = reverseInGroup(head, 2);
        printList(newList);
    }
}
