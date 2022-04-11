import models.BinaryTreeNode;
import utils.BinaryTreeUtils;

public class ValidateBinarySearchTree {
    public static boolean isValidBinarySearchTree(BinaryTreeNode root) {
        return validate(root, null, null);
    }

    public static boolean validate(BinaryTreeNode root, Integer lowerBound, Integer upperBound) {
        if (root == null) {
            return true;
        }

        if ((lowerBound == null || root.value > lowerBound) && (upperBound == null || root.value < upperBound)) {
            return validate(root.left, lowerBound, upperBound == null ? root.value : Math.min(upperBound, root.value)) && 
                validate(root.right, lowerBound == null ? root.value : Math.max(lowerBound, root.value), upperBound);
        }

        return false;
    }

    public static void main(String[] args) {
        BinaryTreeNode root0 = BinaryTreeUtils.buildGenericBinaryTree();
        BinaryTreeNode root1 = BinaryTreeUtils.buildGenericBinaryTreeTwo();

        System.out.println(isValidBinarySearchTree(root0));
        System.out.println(isValidBinarySearchTree(root1));
    }
}
