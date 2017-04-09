package org.oursight.neyao.java.advanced.algorithm.tree;

/**
 * Created by DellPC on 2017/4/9.
 */
public class TrieTreeNode<T> extends Node {

    private int frequency;

    private Node[] children;

    public TrieTreeNode(T data) {
        super(data);
        children = new Node[26];
    }

}
