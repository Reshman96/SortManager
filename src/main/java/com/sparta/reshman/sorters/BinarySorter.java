package com.sparta.reshman.sorters;

import com.sparta.reshman.sorters.binaryTree.BinaryTreeImpl;

import java.util.List;

public class BinarySorter implements Sorter {
    private static long time;

    @Override
    public List<Integer> sort(int[] generatedArray) {
        BinaryTreeImpl tree = new BinaryTreeImpl(new BinaryTreeImpl.Node(generatedArray[0]));
        for (int i = 1; i < generatedArray.length; i++) {
            tree.addElement(generatedArray[i]);
        }
        time = 0;
        long start = System.nanoTime();
        List<Integer> list = tree.traverseAndSort();
        long end = System.nanoTime();
        time = (end - start) / 1000;
        return list;
    }

    @Override
    public long timeTaken() {
        return time;
    }
}
