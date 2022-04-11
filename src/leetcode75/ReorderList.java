import Utils.LinkedListUtils;
import models.Node;

public class ReorderList {
    public static void reorderList(Node head) {
        if (head == null) return;

        // First find the middle node and split into 2 lists
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second list
        Node prev = null;
        Node cur = slow;
        Node tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        // Weave the lists together
        Node first = head;
        Node second = prev;
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
        Node head1 = LinkedListUtils.buildGenericLinkedList();
        reorderList(head1);
        LinkedListUtils.printLinkedList(head1);
    }
}
