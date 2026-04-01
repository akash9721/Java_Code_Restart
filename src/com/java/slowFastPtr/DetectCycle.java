
package com.java.slowFastPtr;

class ListNode{
	int data;
	ListNode next;
	
	public ListNode(int data) {
		this.data=data;
	}
}
public class DetectCycle {

    public static boolean detect(ListNode head) {
    	ListNode slowNode=head;
    	ListNode fastNode=head;
    	
    	while(fastNode!=null && fastNode.next!=null) {
    		slowNode=slowNode.next;
    		fastNode=fastNode.next.next;
    		if(slowNode==fastNode) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public static int startingNode(ListNode head) {
    	ListNode slowListNode=head;
    	ListNode fastListNode=head;
    	while(fastListNode!=null && fastListNode.next!=null) {
    		slowListNode=slowListNode.next;
    		fastListNode=fastListNode.next.next;
    		if(slowListNode==fastListNode) {
    			break;
    		}
    	}
    	slowListNode=head;
    	while(slowListNode!=fastListNode) {
    		slowListNode=slowListNode.next;
    		fastListNode=fastListNode.next;
    	}
    	return slowListNode.data;
    }
    
    public static int cycleLength(ListNode head) {
    	ListNode slowListNode=head;
    	ListNode fastListNode=head;
    	while(fastListNode!=null && fastListNode.next!=null) {
    		slowListNode=slowListNode.next;
    		fastListNode=fastListNode.next.next;
    		if(slowListNode==fastListNode) {
    			int cnt=1;
    			slowListNode=slowListNode.next;
    			while(slowListNode!=fastListNode) {
    				cnt++;
    				slowListNode=slowListNode.next;
    			}
    			return cnt;
    		}
    	}
    	return 0;
    }
    
    public static ListNode removeLoop(ListNode head) {
    	ListNode slowListNode=head;
    	ListNode fastListNode=head;
    	while(fastListNode!=null && fastListNode.next!=null) {
    		slowListNode=slowListNode.next;
    		fastListNode=fastListNode.next.next;
    		if(slowListNode==fastListNode) {
    			break;
    		}
    	}
    	slowListNode=head;
		if(slowListNode==fastListNode) {
			while(fastListNode.next!=slowListNode) {
				fastListNode=fastListNode.next;
			}
		}else {
			while(slowListNode.next!=fastListNode.next) {
				slowListNode=slowListNode.next;
				fastListNode=fastListNode.next;
			}
		}
    	fastListNode.next=null;
    	return head;
    }
    
    public static void printList(ListNode head) {
		ListNode currNode=head;
		while(currNode!=null) {
			System.out.print(currNode.data+" ");
			if(currNode.next!=null) {
				System.out.print("->");
			}
			currNode=currNode.next;
		}
	}
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // 🔥 create cycle
        head.next.next.next.next.next = head.next;
        
        System.out.println("Cycle detect");
        boolean result = detect(head);
        System.out.println("List has cycle: " + result);
        
        System.out.println("\nStarting node of cycle");
        int startingNode = startingNode(head);
        System.out.println("Starting node of cycle: "+startingNode);
        
		System.out.println("\nLength of cycle");
		int cycleLength = cycleLength(head);
		System.out.println("linked list cycle length: "+cycleLength);
		
		System.out.println("\nRemove loop in the linkedlist");
		ListNode removeLoop = removeLoop(head);
		printList(removeLoop);
		
		
	}
}
