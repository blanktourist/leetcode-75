import models.ListNode;
import utils.LinkedListUtils;

public class MergeTwoSortedLists {
    
    public static ListNode mergeTwoSortedLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        else if (head2 == null) {
            return head1;
        }
        else if (head1.value < head2.value) {
            head1.next = mergeTwoSortedLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoSortedLists(head1, head2.next);
            return head2;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = LinkedListUtils.buildGenericLinkedList();
        ListNode head2 = LinkedListUtils.buildGenericLinkedList();

        ListNode merged = mergeTwoSortedLists(head1, head2);
        LinkedListUtils.printLinkedList(merged);
    }
}
