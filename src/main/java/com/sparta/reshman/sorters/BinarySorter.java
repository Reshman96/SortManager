package com.sparta.reshman.sorters;

import com.sparta.reshman.sorters.binaryTree.BinaryTree;

import java.util.List;

public class BinarySorter implements Sorter {
    private static long time;

    @Override
    public List<Integer> sort(int[] generatedArray) {
        BinaryTree tree = new BinaryTree(new BinaryTree.Node(generatedArray[0]));
        for (int i = 1; i < generatedArray.length; i++) {
            tree.addNode(generatedArray[i]);
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
