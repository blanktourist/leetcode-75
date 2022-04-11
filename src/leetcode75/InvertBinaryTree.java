import models.BinaryTreeNode;
import utils.BinaryTreeUtils;

public class InvertBinaryTree {
    
    public static void invertBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        BinaryTreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeUtils.buildGenericBinaryTree();
        BinaryTreeUtils.printBinaryTree(root);
        System.out.println("invert");
        invertBinaryTree(root);
        BinaryTreeUtils.printBinaryTree(root);
    }
}
