package com.sparta.reshman.sorters.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private final Node root;
    private final List<Integer> list;

    public static class Node {
        private final int numericValue;
        private Node leftNode;
        private Node rightNode;
        private Node parentNode;

        public Node(int numericValue) {
            this.numericValue = numericValue;
        }

        private int getNumericValue() {
            return this.numericValue;
        }

        private Node getLeftNode() {
            return this.leftNode;
        }

        private void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        private Node getRightNode() {
            return this.rightNode;
        }

        private void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        private Node getParentNode() {
            return this.parentNode;
        }

        private void setParentNode(Node parentNode) {
            this.parentNode = parentNode;
        }
    }

    public BinaryTree(Node root) {
        this.root = root;
        this.list = new ArrayList<>();
    }

    public void addNode(int numericValue) {
        Node node = root;
        while (numericValue != node.getNumericValue()) {
            if (numericValue > node.getNumericValue()) {
                if (node.getRightNode() != null) {
                    node = node.getRightNode();
                } else {
                    Node newNode = new Node(numericValue);
                    node.setRightNode(newNode);
                    newNode.setParentNode(node);
                }
            }
            if (numericValue < node.getNumericValue()) {
                if (node.getLeftNode() != null) {
                    node = node.getLeftNode();
                } else {
                    Node newNode = new Node(numericValue);
                    node.setLeftNode(newNode);
                    newNode.setParentNode(node);
                }
            }
        }
    }

    public void addNodes(int[] elements) {
        for (int element : elements) {
            addNode(element);
        }
    }

    public List<Integer> traverseAndSort() {
        this.list.clear();
        Node node = this.root;
        node = traverseLowestNumber(node);
        printNode(node);
        while (!list.contains(largestNumber(this.root))) {

            while (hasRightChild(node) && hasUnprintedRightChild(node)) {
                printNode(node);
                node = moveIntoRightChild(node);
                node = traverseLowestNumber(node);
                printNode(node);
            }
            if (node.getParentNode() != null && isPrintedNode(node)) {
                node = node.getParentNode();
            }
            printNode(node);
        }
        return list;
    }

    private void printNode(Node node) {
        if (!list.contains(node.getNumericValue())) {
            list.add(node.getNumericValue());
        }
    }

    private int largestNumber(Node node) {
        while (hasRightChild(node)) {
            node = loadRightChild(node);
        }
        return node.getNumericValue();
    }

    private Node moveIntoRightChild(Node node) {
        node = loadRightChild(node);
        return node;
    }

    private boolean hasUnprintedRightChild(Node node) {
        return !list.contains(node.getRightNode().getNumericValue());
    }

    private boolean hasUnprintedLeftChild(Node node) {
        return node.getLeftNode() != null && !list.contains(node.getLeftNode().getNumericValue());
    }

    private boolean isPrintedNode(Node node) {
        return list.contains(node.getNumericValue());
    }

    private Node traverseLowestNumber(Node node) {
        while (hasLeftChild(node) && hasUnprintedLeftChild(node)) {
            node = loadLeftChild(node);
        }
        return node;
    }

    private boolean hasLeftChild(Node node) {
        return node.getLeftNode() != null;
    }

    private Node loadLeftChild(Node node) {
        return node.getLeftNode();
    }

    private boolean hasRightChild(Node node) {
        return node.getRightNode() != null;
    }

    private Node loadRightChild(Node node) {
        return node.getRightNode();
    }
}
