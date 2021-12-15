package com.sparta.reshman.sorters.binaryTree;

import com.sparta.reshman.exceptions.ChildNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BinaryTreeImplTest {
    private BinaryTreeImpl tree;

    @BeforeEach
    public void setup() {
        tree = new BinaryTreeImpl(new BinaryTreeImpl.Node(50));
        tree.addElement(30);
        tree.addElement(70);
        tree.addElements(new int[]{15, 35, 87, 62, 7, 31, 22});
    }

    @Test
    public void getRootElementTest() {
        Assertions.assertEquals(50, tree.getRootElement());
    }

    @Test
    public void getNumberOfElementsTest() {
        Assertions.assertEquals(10, tree.getNumberOfElements());
    }

    @Test
    public void findRealElementTest() {
        Assertions.assertTrue(tree.findElement(70));
    }

    @Test
    void dontFindFakeElementTest() {
        Assertions.assertFalse(tree.findElement(42));
    }

    @Test
    public void getLeftChildTest() throws ChildNotFoundException {
        Assertions.assertEquals(15, tree.getLeftChild(30));
    }

    @Test
    public void getNonExistingLeftChildTest() {
        Assertions.assertThrows(ChildNotFoundException.class, () -> tree.getLeftChild(7));
    }

    @Test
    public void getRightChildTest() throws ChildNotFoundException {
        Assertions.assertEquals(35, tree.getRightChild(30));
    }

    @Test
    public void getNonExistingRightChildTest() {
        Assertions.assertThrows(ChildNotFoundException.class, () -> tree.getRightChild(87));
    }

    @Test
    void getSortedTreeAscTest() {
        Assertions.assertArrayEquals(new int[]{7, 15, 22, 30, 31, 35, 50, 62, 70, 87}, tree.getSortedTreeAsc());
    }


    @Test
    void main() {
        System.out.println(Arrays.toString(tree.getSortedTreeAsc()));
        System.out.println(tree.traverseLowestNumber(tree.getRootNode()).getNumericValue());
        System.out.println("*******************");
        System.out.println(tree.traverseAndSort());
    }

}
