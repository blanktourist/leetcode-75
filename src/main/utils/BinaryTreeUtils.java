package utils;

import models.BinaryTreeNode;

public class BinaryTreeUtils {
    public static BinaryTreeNode buildGenericBinaryTree() {
        BinaryTreeNode l0 = new BinaryTreeNode(1);
        BinaryTreeNode l1 = new BinaryTreeNode(3);
        BinaryTreeNode l2 = new BinaryTreeNode(6);
        BinaryTreeNode l3 = new BinaryTreeNode(9);

        BinaryTreeNode m1 = new BinaryTreeNode(2, l0, l1);
        BinaryTreeNode m2 = new BinaryTreeNode(7, l2, l3);

        BinaryTreeNode root = new BinaryTreeNode(4, m1, m2);
        
        return root;
    }

    public static BinaryTreeNode buildGenericBinaryTreeTwo() {
        BinaryTreeNode l0 = new BinaryTreeNode(3);
        BinaryTreeNode l1 = new BinaryTreeNode(5);

        BinaryTreeNode m1 = new BinaryTreeNode(0);
        BinaryTreeNode m2 = new BinaryTreeNode(4, l0, l1);
        BinaryTreeNode m3 = new BinaryTreeNode(7);
        BinaryTreeNode m4 = new BinaryTreeNode(9);


        BinaryTreeNode n1 = new BinaryTreeNode(2, m1, m2);
        BinaryTreeNode n2 = new BinaryTreeNode(8, m3, m4);

        BinaryTreeNode root = new BinaryTreeNode(6, n1, n2);
        
        return root;
    }

    public static void printBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.value);
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }
}
