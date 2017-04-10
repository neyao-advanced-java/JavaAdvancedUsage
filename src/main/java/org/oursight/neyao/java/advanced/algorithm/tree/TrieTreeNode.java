package org.oursight.neyao.java.advanced.algorithm.tree;

/**
 * Created by DellPC on 2017/4/9.
 */
public class TrieTreeNode<T> extends Node {

    private int dumpliCount = 0;
    private int prefixCount = 0;
    private boolean leaf = false;

    private TrieTreeNode[] children;

    public TrieTreeNode(T data) {
        super(data);
        children = new TrieTreeNode[26];
    }

    public void addDumpliCount() {
        dumpliCount++;
    }

    public void addPrefixCount() {
        prefixCount++;
    }

    public TrieTreeNode[] getChildren() {
        return children;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
        children = null;
    }
}
