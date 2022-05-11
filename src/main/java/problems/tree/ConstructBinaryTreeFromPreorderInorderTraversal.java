package main.problems.tree;

import java.util.HashMap;
import java.util.Map;

import main.models.BinaryTreeNode;
import main.utils.BinaryTreeUtils;

public class ConstructBinaryTreeFromPreorderInorderTraversal {

    static int preorderIndex;
    static Map<Integer, Integer> inorderIndexMap;

    public static BinaryTreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length-1);
    }

    private static BinaryTreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preOrderIndex element as the roto and increment it
        int rootValue = preorder[preorderIndex++];
        BinaryTreeNode root = new BinaryTreeNode(rootValue);

        // build lef tnad right subtree
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder1 = {3,9,20,15,7};
        int[] inorder1 = {9,3,15,20,7};

        BinaryTreeNode root1 = buildTree(preorder1, inorder1);
        BinaryTreeUtils.printBinaryTree(root1);
    }
}