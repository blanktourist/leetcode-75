package utils;

import models.ListNode;

public class LinkedListUtils {

    public static ListNode buildGenericLinkedList() {
        ListNode n4 = new ListNode(5);
        ListNode n3 = new ListNode(4, n4);
        ListNode n2 = new ListNode(3, n3);
        ListNode n1 = new ListNode(2, n2);
        ListNode n0 = new ListNode(1, n1);
        
        return n0;
    }

    public static ListNode buildCycleLinkedList() {
        ListNode n4 = new ListNode(5);
        ListNode n3 = new ListNode(4, n4);
        ListNode n2 = new ListNode(3, n3);
        ListNode n1 = new ListNode(2, n2);
        ListNode n0 = new ListNode(1, n1);
        n4.next = n0;
        
        return n0;
    }

    public static void printLinkedList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
