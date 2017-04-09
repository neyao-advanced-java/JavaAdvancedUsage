package org.oursight.neyao.java.advanced.algorithm.tree;

import org.oursight.neyao.java.advanced.algorithm.sort.SortingAlgorithms;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by DellPC on 2017/4/8.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    public static void main(String[] args) throws InterruptedException {

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        Integer[] arrays = SortingAlgorithms._createArray(11);


        for (Integer a : arrays) {
            System.out.println(a + " add");
            tree.add(a);
            TreePrinter.print(tree.root);
//            Thread.sleep(1000);

            System.out.println();
            System.out.println();

        }

//        System.out.println(tree.findInRange(arrays[0], arrays[1]));
        System.out.println(tree.findMax());
        System.out.println(Arrays.toString(arrays));
    }

    private Node root = null;

    public boolean contains(T t) {
        return containsRecursively(t, root);
    }

    private boolean containsRecursively(T t, Node node) {
        if (node == null) {
            return false;
        }

        int compareResult = t.compareTo((T) node.data);
        if (compareResult < 0) {
            return containsRecursively(t, node.left);
        } else if (compareResult > 0) {
            return containsRecursively(t, node.right);
        } else {
            return true;
        }

    }

    public boolean delete(T t) {
        throw new NotImplementedException();
    }

    public T findMax() {
        Node node = findMaxRecursively(root);
        if (node == null) {
            return null;
        } else
            return (T) node.data;
    }

    private Node findMaxRecursively(Node node) {
        if (node == null) {
            return null;
        }

        if (node.right == null) {
            return node;
        } else {
            return findMaxRecursively(node.right);
        }
    }

    /**
     * @param min
     * @param max
     * @return
     */
    public Set<T> findInRange(T min, T max) {
        Set<T> result = new HashSet<>();
        if (root == null) {
            return result;
        }

        // 交换一下，防止写错
        if (min.compareTo(max) > 0) {
            T temp = max;
            max = min;
            min = temp;
        }

        findInRangeRecursively(min, max, root, result);
        return result;
    }

    private void findInRangeRecursively(T min, T max, Node node, Set<T> result) {
        if (node == null) {
            return;
        }

        T nodeData = (T) node.data;
        if (nodeData.compareTo(min) >= 0 && nodeData.compareTo(max) <= 0) {
            result.add((T) node.data);

            if (nodeData.compareTo(min) >= 0) {
                findInRangeRecursively(min, max, node.left, result);
            }

            if (nodeData.compareTo(max) <= 0) {
                findInRangeRecursively(min, max, node.right, result);
            }

        } else {
            return;
        }
    }


    public T findMin() {
        Node node = findMinRecursively(root);
        if (node == null) {
            return null;
        } else {
            return (T) node.data;
        }
    }

    private Node findMinRecursively(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left == null) {
            return node;
        } else {
            return findMinRecursively(node.left);
        }
    }

    public void add(T t) {
        root = addInternal(t, root);
    }

    private Node addInternal(T t, Node node) {
        if (node == null) {
            return new Node(t);
        }

        int result = t.compareTo((T) node.data);
        if (result < 0)
            node.left = addInternal(t, node.left);
        else if (result > 0)
            node.right = addInternal(t, node.right);
        else
            ;//doNothing

        return node;
    }


    private static class Node<T> implements TreePrinter.PrintableNode {

        T data;
        Node left;
        Node right;

        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }


        @Override
        public TreePrinter.PrintableNode getLeft() {
            return left;
        }

        @Override
        public TreePrinter.PrintableNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return data == null ? "" : data.toString();
        }
    }


}
