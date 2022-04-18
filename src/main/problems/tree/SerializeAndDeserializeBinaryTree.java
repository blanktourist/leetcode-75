package main.problems.tree;

import main.models.BinaryTreeNode;
import main.utils.BinaryTreeUtils;

public class SerializeAndDeserializeBinaryTree {
    
    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeUtils.buildGenericBinaryTree();
        String serialize = BinaryTreeUtils.BinaryTreeCodec.serialize(root);
        System.out.println(serialize);
        BinaryTreeNode deserialize = BinaryTreeUtils.BinaryTreeCodec.deserialize(serialize);
        boolean isSameTree = SameTree.isSameTree(root, deserialize);
        System.out.println(isSameTree);
        
    }
}
