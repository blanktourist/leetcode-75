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
        Node n0 = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node reversedHead = reverseLinkedList(n0);

        System.out.println(reversedHead);
        LinkedListUtils.printLinkedList(reversedHead);
    }
}
