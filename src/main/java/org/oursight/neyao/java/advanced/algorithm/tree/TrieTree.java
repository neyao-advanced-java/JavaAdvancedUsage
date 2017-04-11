package org.oursight.neyao.java.advanced.algorithm.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * http://www.cnblogs.com/huangxincheng/archive/2012/11/25/2788268.html
 * http://blog.csdn.net/abcd_d_/article/details/40116485
 * <p>
 * Created by DellPC on 2017/4/9.
 */
public class TrieTree {

    public static void main(String[] args) {

        TrieTree trie = new TrieTree();
        trie.insert("I");
        trie.insert("Love");

        // trie.traversal(trie.root);

        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("xiaoliang");
        trie.insert("xiaoliang");
        trie.insert("man");
        trie.insert("handsome");
        trie.insert("love");

        //trie.traversal(trie.root);

        trie.insert("chinaha");
        trie.insert("her");
        trie.insert("know");

        trie.preTraversal(trie.root);
//        trie.levelTraversal(trie.root);
        System.out.println(trie.wordCount());


    }

    private TrieTreeNode<String> root = null;

    public TrieTree() {
        root = new TrieTreeNode<>("");
    }

    public void insert(String t) {
        insertInternal(t, root);
    }

    private void insertInternal(String word, TrieTreeNode node) {
        if (node == null) {
            return;
        }

        word = word.toLowerCase();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            int index = chars[i] - 'a';

            if (node.getChildren()[index] != null) {
                node.getChildren()[index].addPrefixCount();
            } else {
                node.getChildren()[index] = new TrieTreeNode(chars[i], node);
                node.getChildren()[index].addPrefixCount();
            }

            //如果到了字串结尾，则做标记
            if (i == chars.length - 1) {
                node.getChildren()[index].setLeaf(true);
                node.getChildren()[index].addDumpliCount();
            }

            // 继续
            node = node.getChildren()[index];
        }

    }

    public Map<String, Integer> wordCount() {
        Map<String, Integer> result = new HashMap<>();
        preTraversalWordCounts(root, "", result);
        return result;
    }

    private void preTraversalWordCounts(TrieTreeNode node, String prefix, Map<String, Integer> result) {
        if (node == null)
            return;

        System.out.println(node.getText());

//        if (node.isLeaf()) {
//            return;
//        }

        for (int i = 0; i < node.getChildren().length; i++) {
            TrieTreeNode nodeOfChildren = node.getChildren()[i];
            if (nodeOfChildren != null) {
                char c = (char) (i + 'a');
                String nextPrefix = prefix + c;
                if (nodeOfChildren.isLeaf()) {
                    result.put(nextPrefix, nodeOfChildren.getDumpliCount());
                }
                preTraversalWordCounts(nodeOfChildren, nextPrefix, result);
            }

        }
    }

    public void preTraversal(TrieTreeNode node) {
        if (node == null)
            return;

        System.out.println(node.getText());

//        if (node.isLeaf()) {
//            return;
//        }

        for (int i = 0; i < node.getChildren().length; i++) {
            if (node.getChildren()[i] != null) {
//                char c = (char) (i + 'a');
                //String subPrefix = prefix + c;
                preTraversal(node.getChildren()[i]);
            }
        }

    }

    /**
     * FIXME 实现得不对
     */
    public void levelTraversal(TrieTreeNode node) {
        if (node == null) {
            return;
        }

        Queue<TrieTreeNode> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            TrieTreeNode temp = q.poll();
            System.out.println(temp.getText());

            //if (node.isLeaf() != true) {
            for (int i = 0; i < node.getChildren().length; i++) {
                TrieTreeNode n = node.getChildren()[i];
                if (n != null) {
                    q.add(n);
                }

            }
        }

    }

}
