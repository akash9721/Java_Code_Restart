package com.java.linkedList;

public class MergeTwoSortedList {

    public static Node merge(Node list1,Node list2){
        Node dummy=new Node(-1);
        Node trav=dummy;

        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        while(list1!=null && list2!=null){
            if(list1.data<=list2.data){
                trav.next=list1;
                trav=list1;
                list1=list1.next;
            }
            else{
                trav.next=list2;
                trav=list2;
                list2=list2.next;
            }
        }
        while(list1!=null){
            trav.next=list1;
            trav=list1;
            list1=list1.next;
        }
        while (list2!=null){
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
        Node list1=new Node(1);
        list1.next=new Node(8);
        list1.next.next=new Node(11);
        list1.next.next.next=new Node(15);
        list1.next.next.next.next=new Node(20);

        Node list2=new Node(2);
        list2.next=new Node(5);
        list2.next.next=new Node(9);
        list2.next.next.next=new Node(27);

        Node merged = merge(list1, list2);
        printList(merged);
    }
}
