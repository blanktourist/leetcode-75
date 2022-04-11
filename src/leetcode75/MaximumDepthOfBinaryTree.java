import models.BinaryTreeNode;

public class MaximumDepthOfBinaryTree {
    public static int returnMaximumDepthOfBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(returnMaximumDepthOfBinaryTree(root.left), returnMaximumDepthOfBinaryTree(root.right)) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeNode l0 = new BinaryTreeNode(9);
        BinaryTreeNode l1 = new BinaryTreeNode(15);
        BinaryTreeNode l2 = new BinaryTreeNode(7);

        BinaryTreeNode r1 = new BinaryTreeNode(20, l1, l2);
        BinaryTreeNode r0 = new BinaryTreeNode(3, l0, r1);

        System.out.println(returnMaximumDepthOfBinaryTree(r0));
    }
}
