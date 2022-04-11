import Utils.LinkedListUtils;
import models.ListNode;

public class ReverseLinkedList {

    // Returns the head of the reversed linked list.
    public static ListNode reverseLinkedList(ListNode head) {
        
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }

    public static void main(String[] args) {
        ListNode n0 = LinkedListUtils.buildGenericLinkedList();

        ListNode reversedHead = reverseLinkedList(n0);

        System.out.println(reversedHead);
        LinkedListUtils.printLinkedList(reversedHead);
    }
}
