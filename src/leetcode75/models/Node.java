package models;

import java.util.ArrayList;
import java.util.List;

// TODO: should Node be given more structure? (eg, TreeNode, BinaryTreeNode, GraphNode, etc)
/**
 * This is a general purpose Node model.
 */
public class Node {

    public int value;
    

    public Node left;

    public Node right;

    public Node parent;


    public Node next;

    public List<Node> neighbors;

    public List<Node> children;
    
    public Node() {
        this.value = 0;
        this.neighbors = new ArrayList<Node>();
    }
    
    public Node(int value) {
        this.value = value;
        this.neighbors = new ArrayList<Node>();
    }
    
    public Node(int value, ArrayList<Node> neighbors) {
        this.value = value;
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}