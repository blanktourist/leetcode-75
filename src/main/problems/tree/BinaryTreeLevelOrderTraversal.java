package main.problems.tree;

import java.util.ArrayList;
import java.util.List;

import main.models.BinaryTreeNode;
import main.utils.BinaryTreeUtils;

public class BinaryTreeLevelOrderTraversal {
    
    public static List<List<Integer>> returnLevelOrderTraversalOfBinaryTree(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        add(result, root, 0);
        return result;
    }

    public static void add(List<List<Integer>> result, BinaryTreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level >= result.size()) {
            List<Integer> levelList = new ArrayList<>();
            levelList.add(root.value);
            result.add(levelList);
        } else {
            List<Integer> levelList = result.get(level);
            levelList.add(root.value);
        }

        add(result, root.left, level + 1);
        add(result, root.right, level + 1);
    }
    
    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeUtils.buildGenericBinaryTree();
        List<List<Integer>> result = returnLevelOrderTraversalOfBinaryTree(root);
        System.out.println(result);
    }
}
