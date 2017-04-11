package org.oursight.neyao.java.advanced.algorithm.tree;

/**
 * Created by DellPC on 2017/4/9.
 */
public class TrieTreeNode<T> extends Node {

    private int dumpliCount = 0;
    private int prefixCount = 0;
    private int depth = 0;
    private boolean leaf = false;

    private TrieTreeNode parent;
    private TrieTreeNode[] children;

    public TrieTreeNode(T data) {
        super(data);
        children = new TrieTreeNode[26];
    }

    public TrieTreeNode(T data, TrieTreeNode node) {
        super(data);
        children = new TrieTreeNode[26];
        parent = node;
        depth = parent.depth + 1;
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
        //children = null;
    }

    public int getPrefixCount() {
        return prefixCount;
    }

    public int getDumpliCount() {
        return dumpliCount;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public String getText() {
        return "[" + data + ", " + dumpliCount + ", " + prefixCount + ", " + leaf + ", " + depth + "]";
    }
}
