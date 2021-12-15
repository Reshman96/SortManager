package com.sparta.reshman.sorters.binaryTree;

import com.sparta.reshman.exceptions.ChildNotFoundException;

import java.util.Set;
import java.util.TreeSet;

public class BinaryTreeImpl implements BinaryTree {
    private final Node root;
    private Node currentElement;
    private Set<Integer> set = new TreeSet<>();

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
        this.set.add(root.getNumericValue());
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
        set.add(element);
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
        int[] result = new int[getNumberOfElements()];
        int i = 0;
        for (int num : set) {
            result[i] = num;
            i++;
        }
        return result;
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] result = new int[getNumberOfElements()];
        int i = getNumberOfElements() - 1;
        for (int num : set) {
            result[i] = num;
            i--;
        }
        return result;
    }
}