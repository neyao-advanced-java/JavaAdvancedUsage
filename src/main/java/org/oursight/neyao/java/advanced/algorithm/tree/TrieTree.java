package org.oursight.neyao.java.advanced.algorithm.tree;

/**
 * http://www.cnblogs.com/huangxincheng/archive/2012/11/25/2788268.html
 * http://blog.csdn.net/abcd_d_/article/details/40116485
 *
 * Created by DellPC on 2017/4/9.
 */
public class TrieTree<T> {

    private TrieTreeNode<String> root = null;

    public TrieTree() {
        root = new TrieTreeNode<>((String)"123");
    }

    public void add(String t) {
        root = addInternal(t, root);
    }

    private TrieTreeNode addInternal(String word, TrieTreeNode node) {
        if (node == null) {
            return new TrieTreeNode(word);
        }

        word = word.toLowerCase();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            int index = chars[i] - 'a';

            if(node.getChildren()[index] != null) {
                node.getChildren()[index].addPrefixCount();
            }else {
                node.getChildren()[index] = new TrieTreeNode(chars[i]);
                node.getChildren()[index].addPrefixCount();
            }

            if(i == chars.length -1) {
                node.getChildren()[index].setLeaf(true);
                node.getChildren()[index].addDumpliCount();
            }

            node = node.node.getChildren()[index];
        }



        return node;
    }
}
