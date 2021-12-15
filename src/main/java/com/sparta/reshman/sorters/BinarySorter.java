package com.sparta.reshman.sorters;

import com.sparta.reshman.sorters.binaryTree.BinaryTreeImpl;

import java.util.ArrayList;
import java.util.List;

public class BinarySorter implements Sorter {

    @Override
    public List<Integer> sort(int[] generatedArray) {
        BinaryTreeImpl binaryTree = new BinaryTreeImpl(new BinaryTreeImpl.Node(generatedArray[0]));
        for (int i = 1; i < generatedArray.length; i++) {
            binaryTree.addElement(generatedArray[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : binaryTree.getSortedTreeAsc()) {
            list.add(i);
        }
        return list;
    }

    @Override
    public long timeTaken() {
        return 0;
    }

}
