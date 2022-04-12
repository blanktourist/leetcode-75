package main.problems.tree;

import main.models.BinaryTreeNode;
import main.utils.BinaryTreeUtils;

public class LowestCommonAncestorOfBinarySearchTree {
    public static BinaryTreeNode returnLowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        if (p.value < root.value && q.value < root.value) {
            return returnLowestCommonAncestor(root.left, p, q);
        }

        else if (p.value > root.value && q.value > root.value) {
            return returnLowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeUtils.buildGenericBinaryTreeTwo();
        BinaryTreeNode p = root.left.left;
        BinaryTreeNode q = root.left.right.right;

        BinaryTreeNode LCA = returnLowestCommonAncestor(root, p, q);
        BinaryTreeUtils.printBinaryTree(LCA);
    }
}
