//package org.oursight.neyao.java.advanced.algorithm.tree;
//
//import org.oursight.neyao.java.advanced.algorithm.sort.SortingAlgorithms;
//
//import java.util.Stack;
//
///**
// * Created by DellPC on 2017/4/8.
// */
//public class AVLBinarySearchTree<T extends Comparable<T>> {
//
//    public static void main(String[] args) throws InterruptedException {
//
//        AVLBinarySearchTree<Integer> tree = new AVLBinarySearchTree<>();
//
//        Integer[] arrays = SortingAlgorithms._createArray(11);
//
//
//        for (Integer a : arrays) {
//            System.out.println(a + " add");
//            tree.add(a);
//            TreePrinter.print(tree.root);
////            Thread.sleep(1000);
//
//            System.out.println();
//            System.out.println();
//
//        }
//
//    }
//
//    private Node root = null;
//
//    public boolean contains(T t) {
//        return containsRecursively(t, root);
//    }
//
//    private boolean containsRecursively(T t, Node node) {
//        if (node == null) {
//            return false;
//        }
//
//        int compareResult = t.compareTo((T) node.data);
//        if (compareResult < 0) {
//            return containsRecursively(t, node.left);
//        } else if (compareResult > 0) {
//            return containsRecursively(t, node.right);
//        } else {
//            return true;
//        }
//
//    }
//
//
//    public void add(T t) {
//        root = addInternal(t, root);
//    }
//
//    private Node addInternal(T t, Node node) {
//        if (node == null) {
//            return new Node<T>(t);
//        }
//
//        int result = t.compareTo((T) node.data);
//        if (result < 0)
//            node.left = addInternal(t, node.left);
//        else if (result > 0)
//            node.right = addInternal(t, node.right);
//        else
//            ;//doNothing
//
//        return node;
//    }
//
//
////    private static class Node<T> implements TreePrinter.PrintableNode {
////
////        T data;
////        Node parent;
////        Node left;
////        Node right;
////        int height;
////
////        Node(T data) {
////            this.data = data;
////            this.left = null;
////            this.right = null;
////        }
////
////        Node(T data, Node left, Node right) {
////            this.data = data;
////            this.left = left;
////            this.right = right;
////        }
////
////
////        @Override
////        public TreePrinter.PrintableNode getLeft() {
////            return left;
////        }
////
////        @Override
////        public TreePrinter.PrintableNode getRight() {
////            return right;
////        }
////
////        @Override
////        public String getText() {
////            return data == null ? "" : data.toString();
////        }
////    }
////
////    public static <T> int computeHeight(Node<T> rootNode, boolean recursionFlag) {
////        if (recursionFlag) {
////            if (null == rootNode) {
////                return -1;
////            }
////            int leftHeight = rootNode.left.height + 1;
////            int rightHeight = rootNode.right.height + 1;
////            return leftHeight > rightHeight ? leftHeight : rightHeight;
////        } else {
////            //由于跟深度相反，故最大深度即为高度，利用求深度的方法即可
////            if (null == rootNode) {
////                return -1;
////            }
////            int currentDepth = -1;
////            int maxDepth = -1;
////            Node<T> currentNode;
////            Stack<Node<T>> nodeStack = new Stack<>();
////            Stack<Integer> depthStack = new Stack<>();
////            nodeStack.push(rootNode);
////            depthStack.push(0);
////            while (!nodeStack.isEmpty()) {
////                currentNode = nodeStack.pop();
////                currentDepth = depthStack.pop();
////                if (currentDepth > maxDepth) {
////                    maxDepth = currentDepth;
////                }
////                if (currentNode.left != null) {
////                    nodeStack.push(currentNode.left);
////                    depthStack.push(currentDepth + 1);
////                }
////                if (currentNode.right != null) {
////                    nodeStack.push(currentNode.right);
////                    depthStack.push(currentDepth + 1);
////                }
////            }
////            return maxDepth;
////        }
////
////    }
//
//
//}
