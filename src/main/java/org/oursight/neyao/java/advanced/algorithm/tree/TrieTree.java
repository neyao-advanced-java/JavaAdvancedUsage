package org.oursight.neyao.java.advanced.algorithm.tree;

/**
 * Created by DellPC on 2017/4/9.
 */
public class TrieTree<String> {

    private TrieTreeNode<String> root = null;

    public TrieTree() {
        root = new TrieTreeNode<>((String)"123");
    }

    public void add(String t) {
        root = addInternal(t, root);
    }

    private TrieTreeNode addInternal(String t, TrieTreeNode node) {
        if (node == null) {
            return new TrieTreeNode(t);
        }



//        int result = t.compareTo((String) node.getData());
//        if (result < 0)
//            node.setLeft(addInternal(t, (TrieTreeNode) node.getLeft()));
//        else if (result > 0)
//            node.setRight(addInternal(t, (TrieTreeNode) node.getRight()));
//        else
//            ;//doNothing

        return node;
    }
}
