import Utils.LinkedListUtils;
import models.Node;

public class ReverseLinkedList {
    public static Node reverseLinkedList(Node head) {
        
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }

    public static void main(String[] args) {
        Node n0 = LinkedListUtils.buildGenericLinkedList();

        Node reversedHead = reverseLinkedList(n0);

        System.out.println(reversedHead);
        LinkedListUtils.printLinkedList(reversedHead);
    }
}
