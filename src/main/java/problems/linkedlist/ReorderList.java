package main.problems.linkedlist;

import main.models.ListNode;
import main.utils.LinkedListUtils;

public class ReorderList {
    public static void reorderList(ListNode head) {
        if (head == null) return;

        // First find the middle node and split into 2 lists
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second list
        ListNode prev = null;
        ListNode cur = slow;
        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        // Weave the lists together
        ListNode first = head;
        ListNode second = prev;
        while (second.next != null) {
            tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = LinkedListUtils.buildGenericLinkedList();
        reorderList(head1);
        LinkedListUtils.printLinkedList(head1);
    }
}
