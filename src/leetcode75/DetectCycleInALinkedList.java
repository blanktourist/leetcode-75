import Utils.LinkedListUtils;
import models.Node;

public class DetectCycleInALinkedList {
    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head.next;

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
        Node n0 = LinkedListUtils.buildGenericLinkedList();
        Node m0 = LinkedListUtils.buildCycleLinkedList();

        System.out.println(hasCycle(n0));
        System.out.println(hasCycle(m0));
    }
}
