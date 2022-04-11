package models;

/**
 * This class represents a node of a binary tree.
 */
public class BinaryTreeNode {

    public int value;

    public BinaryTreeNode left;

    public BinaryTreeNode right;
    
    public BinaryTreeNode() {
        this.value = 0;
    }
    
    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}