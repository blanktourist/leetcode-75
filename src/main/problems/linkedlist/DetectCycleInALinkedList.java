package main.problems.linkedlist;

import main.models.ListNode;
import main.utils.LinkedListUtils;

public class DetectCycleInALinkedList {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }

    public static void main(String[] args) {
        ListNode n0 = LinkedListUtils.buildGenericLinkedList();
        ListNode m0 = LinkedListUtils.buildCycleLinkedList();

        System.out.println(hasCycle(n0));
        System.out.println(hasCycle(m0));
    }
}
