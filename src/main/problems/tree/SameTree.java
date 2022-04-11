import models.BinaryTreeNode;

public class SameTree {
    public static boolean isSameTree(BinaryTreeNode head1, BinaryTreeNode head2) {
        if (head1 == null && head2 == null) {
            return true;
        }
        if ((head1 != null && head2 == null) || (head1 == null && head2 != null)) {
            return false;
        }

        return head1.value == head2.value && isSameTree(head1.left, head2.left) && isSameTree(head1.right, head2.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode l0 = new BinaryTreeNode(1);
        BinaryTreeNode l1 = new BinaryTreeNode(2);
        BinaryTreeNode r0 = new BinaryTreeNode(0, l0, l1);

        BinaryTreeNode l2 = new BinaryTreeNode(1);
        BinaryTreeNode l3 = new BinaryTreeNode(2);
        BinaryTreeNode r1 = new BinaryTreeNode(0, l2, l3);

        System.out.println(isSameTree(r0, r1));

        BinaryTreeNode l4 = new BinaryTreeNode(1);
        BinaryTreeNode r2 = new BinaryTreeNode(0, l4, null);

        BinaryTreeNode l5 = new BinaryTreeNode(1);
        BinaryTreeNode r3 = new BinaryTreeNode(0, null, l5);
    
        System.out.println(isSameTree(r2, r3));

        BinaryTreeNode l6 = new BinaryTreeNode(1);
        BinaryTreeNode l7 = new BinaryTreeNode(2);
        BinaryTreeNode r4 = new BinaryTreeNode(0, l6, l7);

        BinaryTreeNode l8 = new BinaryTreeNode(2);
        BinaryTreeNode l9 = new BinaryTreeNode(1);
        BinaryTreeNode r5 = new BinaryTreeNode(0, l8, l9);

        System.out.println(isSameTree(r4, r5));
    }
}
