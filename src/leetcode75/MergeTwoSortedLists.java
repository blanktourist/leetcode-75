import Utils.LinkedListUtils;
import models.Node;

public class MergeTwoSortedLists {
    
    public static Node mergeTwoSortedLists(Node head1, Node head2) {
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
        Node head1 = LinkedListUtils.buildGenericLinkedList();
        Node head2 = LinkedListUtils.buildGenericLinkedList();

        Node merged = mergeTwoSortedLists(head1, head2);
        LinkedListUtils.printLinkedList(merged);
    }
}
