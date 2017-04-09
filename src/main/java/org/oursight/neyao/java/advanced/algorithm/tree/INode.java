package org.oursight.neyao.java.advanced.algorithm.tree;

/**
 * Created by DellPC on 2017/4/9.
 */
public interface INode {

        /** Get left child */
        INode getLeft();


        /** Get right child */
        INode getRight();


        /** Get text to be printed */
        String getText();
}
