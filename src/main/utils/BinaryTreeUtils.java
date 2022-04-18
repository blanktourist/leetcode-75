package main.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.models.BinaryTreeNode;

public class BinaryTreeUtils {
    public static BinaryTreeNode buildGenericBinaryTree() {
        BinaryTreeNode l0 = new BinaryTreeNode(1);
        BinaryTreeNode l1 = new BinaryTreeNode(3);
        BinaryTreeNode l2 = new BinaryTreeNode(6);
        BinaryTreeNode l3 = new BinaryTreeNode(9);

        BinaryTreeNode m1 = new BinaryTreeNode(2, l0, l1);
        BinaryTreeNode m2 = new BinaryTreeNode(7, l2, l3);

        BinaryTreeNode root = new BinaryTreeNode(4, m1, m2);
        
        return root;
    }

    public static BinaryTreeNode buildGenericBinaryTreeTwo() {
        BinaryTreeNode l0 = new BinaryTreeNode(3);
        BinaryTreeNode l1 = new BinaryTreeNode(5);

        BinaryTreeNode m1 = new BinaryTreeNode(0);
        BinaryTreeNode m2 = new BinaryTreeNode(4, l0, l1);
        BinaryTreeNode m3 = new BinaryTreeNode(7);
        BinaryTreeNode m4 = new BinaryTreeNode(9);


        BinaryTreeNode n1 = new BinaryTreeNode(2, m1, m2);
        BinaryTreeNode n2 = new BinaryTreeNode(8, m3, m4);

        BinaryTreeNode root = new BinaryTreeNode(6, n1, n2);
        
        return root;
    }

    public static BinaryTreeNode buildGenericBinaryTree3() {
        BinaryTreeNode l0 = new BinaryTreeNode(15);
        BinaryTreeNode l1 = new BinaryTreeNode(7);

        BinaryTreeNode m1 = new BinaryTreeNode(9);
        BinaryTreeNode m2 = new BinaryTreeNode(20, l0, l1);

        BinaryTreeNode root = new BinaryTreeNode(-10, m1, m2);
        
        return root;
    }

    public static void printBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.value);
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }

    public class BinaryTreeCodec {

        // Encode a tree to a string string.
        public static String serialize(BinaryTreeNode root) {
            return rSerialize(root, "");
        }

        private static String rSerialize(BinaryTreeNode root, String str) {
            if (root == null) {
                str += "null,";
            } else {
                str += (String.valueOf(root.value) + ",");
                str = rSerialize(root.left, str);
                str = rSerialize(root.right, str);
            }
            return str;
        }

        // Decode your encoded data to tree
        public static BinaryTreeNode deserialize(String data) {
            String[] dataArray = data.split(",");
            List<String> dataList = new ArrayList<String>(Arrays.asList(dataArray));
            return rDeserialize(dataList);
        }

        private static BinaryTreeNode rDeserialize(List<String> l) {
            if (l.get(0).equals("null")) {
                l.remove(0);
                return null;
            }

            BinaryTreeNode root = new BinaryTreeNode(Integer.valueOf(l.get(0)));
            l.remove(0);
            root.left = rDeserialize(l);
            root.right = rDeserialize(l);

            return root;
        }
    }
}
