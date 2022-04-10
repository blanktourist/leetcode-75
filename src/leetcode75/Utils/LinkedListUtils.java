package Utils;

import models.Node;

public class LinkedListUtils {
    public static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.value);
            curr = curr.next;
        }
        System.out.println();
    }
}
