import java.util.LinkedList;

import Utils.BinaryTreeUtils;
import models.BinaryTreeNode;

public class KthSmallestElementInBinaryTree {



    public static int returnKthSmallestElementInBinaryTreeWithQueue(BinaryTreeNode root, int k) {
        LinkedList<BinaryTreeNode> stack = new LinkedList<BinaryTreeNode>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                return root.value;
            }
            root = root.right;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeUtils.buildGenericBinaryTree();

        System.out.println(returnKthSmallestElementInBinaryTreeWithQueue(root, 3));


    }
}
