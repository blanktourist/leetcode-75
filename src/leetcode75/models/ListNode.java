package models;

/**
 * This class represents a node of a singly linked list.
 */
public class ListNode {

    public int value;

    public ListNode next;
    
    public ListNode() {
        this.value = 0;
    }
    
    public ListNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}