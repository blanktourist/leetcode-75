import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import models.ListNode;
import utils.LinkedListUtils;

public class MergeKSortedLists {
    
    public static ListNode mergeKSortedLists(List<ListNode> lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((a,b) -> a.value - b.value);
        for (ListNode n : lists) {
            queue.add(n);
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            if (cur.next.next != null) {
                queue.add(cur.next.next);
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a2 = new ListNode(5);
        ListNode a1 = new ListNode(4, a2);
        ListNode a0 = new ListNode(1, a1);

        ListNode b2 = new ListNode(4);
        ListNode b1 = new ListNode(3, b2);
        ListNode b0 = new ListNode(1, b1);


        ListNode c1 = new ListNode(6);
        ListNode c0 = new ListNode(2, c1);

        List<ListNode> lists = new ArrayList<ListNode>(Arrays.asList(a0, b0, c0));
        ListNode head = mergeKSortedLists(lists);
        LinkedListUtils.printLinkedList(head);
    }
}
