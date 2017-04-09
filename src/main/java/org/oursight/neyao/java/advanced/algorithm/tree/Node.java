package org.oursight.neyao.java.advanced.algorithm.tree;

/**
 * Created by DellPC on 2017/4/9.
 */
public class Node<T> implements INode {

    protected T data;
    protected Node left;
    protected Node right;
    protected int depth;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.depth = 0;
    }

//    Node(T data, Node left, Node right) {
//        this.data = data;
//        this.left = left;
//        this.right = right;
//    }


    @Override
    public INode getLeft() {
        return left;
    }

    @Override
    public INode getRight() {
        return right;
    }

    @Override
    public String getText() {
        return data == null ? "" : "[" + data.toString() + ", " + depth + "]";
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
        this.left.depth = this.depth + 1;
    }

    public void setRight(Node right) {
        this.right = right;
        this.right.depth = this.depth + 1;
    }


}

