import models.ListNode;
import utils.LinkedListUtils;

public class RemoveNthNodeFromEndOfList {
    
    public static void removeNthNodeFromEndOfList(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        // Find length of the LinkedList
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        // Navigate to the element to be removed and remove it
        cur = head;
        for (int i = 1; i< length - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }
    
    public static void main(String[] args) {
        ListNode head1 = LinkedListUtils.buildGenericLinkedList();
        removeNthNodeFromEndOfList(head1, 2);
        LinkedListUtils.printLinkedList(head1);
    }
}