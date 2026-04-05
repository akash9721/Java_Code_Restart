package com.java.linkedList;

public class IntersectionPoint {

    public static Node intersectPoint(Node head1,Node head2){
        Node a=head1;
        Node b=head2;
        while(a!=b){
            a=(a==null)?head2:a.next;
            b=(b==null)?head1:b.next;
        }
        return a;
    }
    public static void main(String[] args) {
        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(30);

        Node head2 = new Node(3);
        head2.next = new Node(6);
        head2.next.next = new Node(9);

        head2.next.next.next = head1.next;

        Node intersectPoint = intersectPoint(head1, head2);
        System.out.println("intersection point is "+intersectPoint.data);
    }
}
