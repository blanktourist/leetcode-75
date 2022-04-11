import models.BinaryTreeNode;
import utils.BinaryTreeUtils;

public class SubtreeOfAnotherTree {
    public static boolean isSubtreeOfAnotherTree(BinaryTreeNode tree, BinaryTreeNode subtree) {
        if (tree == null && subtree == null) return true;

        if (tree != null && subtree == null) return true;

        if (tree == null && subtree != null) return false;

        if (SameTree.isSameTree(tree, subtree)) return true;

        return isSubtreeOfAnotherTree(tree.left, subtree) || isSubtreeOfAnotherTree(tree.right, subtree);
    }

    public static void main(String[] args) {
        BinaryTreeNode tree = BinaryTreeUtils.buildGenericBinaryTree();
        BinaryTreeNode subtree = tree.left;

        System.out.println(isSubtreeOfAnotherTree(tree, subtree));
    }
}
