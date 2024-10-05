package org.dsa.binary.tree.serialization;

public class Main {
    public static void main(String[] args) {
        // Creating a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Serializing the tree
        String serializedTree = TreeNode.serialize(root);
        System.out.println("Serialized Tree: " + serializedTree);

        // Deserializing the tree

        TreeNode deserializedTree = TreeNode.deserialize(serializedTree);
        // Print the deserialized tree to verify
        System.out.print("Deserialized Tree (Pre-Order): ");
        TreeNode.printPreOrder(deserializedTree);

    }
}