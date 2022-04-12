package main.problems.tree;

import main.models.BinaryTreeNode;
import main.utils.BinaryTreeUtils;

public class BinaryTreeMaximumPathSum {
    
    public static int returnMaxPathSum(BinaryTreeNode root) {
        return dp(root)[0];
    }

    // This method returns: {answer for this sub-problem, answer for max single path including this node}
    private static int[] dp(BinaryTreeNode root) {
        if (root == null) {
            return new int[]{0,0};
        }

        int[] leftSubAnswer = dp(root.left);
        int[] rightSubAnswer = dp(root.right);

        int firstAnswer = Math.max(leftSubAnswer[1] + rightSubAnswer[1] + root.value, Math.max(leftSubAnswer[0], rightSubAnswer[0]));
        int secondAnswer = Math.max(root.value + leftSubAnswer[1], root.value+ rightSubAnswer[1]);

        return new int[]{firstAnswer, secondAnswer};
    }

    public static void main(String[] args) {
        BinaryTreeNode root0 = BinaryTreeUtils.buildGenericBinaryTree3();
        BinaryTreeNode root1 = BinaryTreeUtils.buildGenericBinaryTree();

        System.out.println(returnMaxPathSum(root0));
        System.out.println(returnMaxPathSum(root1));
    }
}
