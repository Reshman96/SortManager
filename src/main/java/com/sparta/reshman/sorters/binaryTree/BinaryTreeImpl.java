package com.sparta.reshman.sorters.binaryTree;

import com.sparta.reshman.exceptions.ChildNotFoundException;

import java.util.*;

public class BinaryTreeImpl implements BinaryTree {
    private final Node root;
    private Node currentElement;

    public static class Node {
        private final int numericValue;
        private Node leftNode;
        private Node rightNode;

        public Node(int numericValue) {
            this.numericValue = numericValue;
        }

        public int getNumericValue() {
            return numericValue;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
    }

    public BinaryTreeImpl(Node root) {
        this.root = root;
        this.currentElement = root;
    }

    @Override
    public int getRootElement() {
        return this.root.getNumericValue();
    }

    @Override
    public int getNumberOfElements() {
        return getNumberOfElementBranches(root) + 1;
    }

    private int getNumberOfElementBranches(Node element) {
        int count = 0;
        if (element.getLeftNode() != null) {
            count += getNumberOfElementBranches(element.getLeftNode()) + 1;
        }
        if (element.getRightNode() != null) {
            count += getNumberOfElementBranches(element.getRightNode()) + 1;
        }
        return count;
    }

    @Override
    public void addElement(int element) {
        currentElement = root;
        while (element != currentElement.getNumericValue()) {
            if (element > currentElement.getNumericValue()) {
                if (currentElement.getRightNode() != null) {
                    currentElement = currentElement.getRightNode();
                } else {
                    currentElement.setRightNode(new Node(element));
                }
            }
            if (element < currentElement.getNumericValue()) {
                if (currentElement.getLeftNode() != null) {
                    currentElement = currentElement.getLeftNode();
                } else {
                    currentElement.setLeftNode(new Node(element));
                }
            }
        }
    }

    @Override
    public void addElements(int[] elements) {
        for (int element : elements) {
            addElement(element);
        }
    }

    @Override
    public boolean findElement(int value) {
        currentElement = root;
        while (currentElement.getLeftNode() != null || currentElement.getRightNode() != null) {
            if (currentElement.getNumericValue() == value) {
                return true;
            } else {
                if (value > currentElement.getNumericValue()) {
                    if (currentElement.getRightNode() == null) {
                        return false;
                    } else {
                        currentElement = currentElement.getRightNode();
                    }
                } else {
                    if (currentElement.getLeftNode() == null) {
                        return false;
                    } else {
                        currentElement = currentElement.getLeftNode();
                    }
                }
            }
        }
        return currentElement.getNumericValue() == value;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        if (findElement(element)) {
            try {
                return currentElement.getLeftNode().getNumericValue();
            } catch (Exception e) {
                throw new ChildNotFoundException();
            }
        }
        return -1;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        if (findElement(element)) {
            try {
                return currentElement.getRightNode().getNumericValue();
            } catch (Exception e) {
                throw new ChildNotFoundException();
            }
        }
        return -1;
    }

    @Override
    public int[] getSortedTreeAsc() {
        List<Integer> list = new ArrayList<>();
        list.add(root.getNumericValue());
        Node currentNode = root;
        traverseLeftChild(list, currentNode);
        traverseRightChild(list, currentNode);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        Arrays.sort(result);
        return result;
    }

    // Used to traverse down the left side of the tree to group all values into a list
    private List<Integer> traverseLeftChild(List<Integer> list, Node node) {
        if (node.getLeftNode() != null) {
            list.add(node.getLeftNode().getNumericValue());
            traverseLeftChild(list, node.getLeftNode());
            traverseRightChild(list, node.getLeftNode());
        }
        return list;
    }

    // Used to traverse down the right side of the tree to group all values into a list
    private List<Integer> traverseRightChild(List<Integer> list, Node node) {
        if (node.getRightNode() != null) {
            list.add(node.getRightNode().getNumericValue());
            traverseLeftChild(list, node.getRightNode());
            traverseRightChild(list, node.getRightNode());
        }
        return list;
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] ascendedSort = getSortedTreeAsc();
        int[] result = new int[ascendedSort.length];
        for (int i = 0; i < ascendedSort.length; i++) {
            result[i] = ascendedSort[ascendedSort.length - i - 1];
        }
        return result;
    }
}