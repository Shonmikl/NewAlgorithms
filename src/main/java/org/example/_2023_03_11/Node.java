package org.example._2023_03_11;

public class Node {
    public Node left;
    public Node right;
    public Integer value;

    private static boolean isNodeExist(Node node) {
        return node != null && node.value != null;
    }

    private static void createNode(Node node, Integer value) {
        node.left = new Node();
        node.right = new Node();
        node.value = value;
    }

    private static void insert(Node node, int value) {
        if (!isNodeExist(node)) {
            createNode(node, value);
        } else if (value < node.value) {
            insert(node.left, value);
        } else {
            insert(node.right, value);
        }
    }

    //todo
    private static Node search(Node node, int value) {
        return null;
    }

    private static Node getMin(Node node) {
        if (!isNodeExist(node)) {
            return null;
        }
        if (!isNodeExist(node.left)) {
            return node;
        }
        return getMin(node.left);
    }

    //todo
    private static Node getMax(Node node) {
        return null;
    }

    private static void inOrderTraversal(Node node) {
        if (!isNodeExist(node)) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println("[" + node.value + "]");
        inOrderTraversal(node.right);
    }

    //todo
    private static void directOrderTraversal(Node node) {

    }

    //todo
    private static void postOrderTraversal(Node node) {

    }

    public static void main(String[] args) {
        Integer[] digit = {9, 2, 5, 13, 6, 10, 14, 7, 33};
        Node node = new Node();
        createNode(node, 9);

        for (int i = 1; i < digit.length; i++) {
            insert(node, digit[i]);
        }
    }
}