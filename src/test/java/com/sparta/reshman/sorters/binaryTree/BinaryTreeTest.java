package com.sparta.reshman.sorters.binaryTree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BinaryTreeTest {
    private BinaryTree tree;

    @BeforeEach
    public void setup() {
        tree = new BinaryTree(new BinaryTree.Node(50));
        tree.addNode(30);
        tree.addNode(70);
        tree.addNodes(new int[]{15, 35, 87, 62, 7, 31, 22});
    }

    @Test
    void binaryTreeTest() {
        Assertions.assertEquals(Arrays.asList(7, 15, 22, 30, 31, 35, 50, 62, 70, 87), tree.traverseAndSort());
    }
}
