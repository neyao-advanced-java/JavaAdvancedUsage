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

        int compareResult = t.compareTo((T) node.getData());
        if (compareResult < 0) {
            return containsRecursively(t, (Node) node.getLeft());
        } else if (compareResult > 0) {
            return containsRecursively(t, (Node) node.getRight());
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
            return (T) node.getData();
    }

    private Node findMaxRecursively(Node node) {
        if (node == null) {
            return null;
        }

        if (node.getRight() == null) {
            return node;
        } else {
            return findMaxRecursively((Node) node.getRight());
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

        T nodeData = (T) node.getData();
        if (nodeData.compareTo(min) >= 0 && nodeData.compareTo(max) <= 0) {
            result.add((T) node.getData());

            if (nodeData.compareTo(min) >= 0) {
                findInRangeRecursively(min, max, (Node) node.getLeft(), result);
            }

            if (nodeData.compareTo(max) <= 0) {
                findInRangeRecursively(min, max, (Node) node.getRight(), result);
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
            return (T) node.getData();
        }
    }

    private Node findMinRecursively(Node node) {
        if (node == null) {
            return null;
        }

        if (node.getLeft() == null) {
            return node;
        } else {
            return findMinRecursively((Node) node.getLeft());
        }
    }

    public void add(T t) {
        root = addInternal(t, root);
    }

    private Node addInternal(T t, Node node) {
        if (node == null) {
            return new Node(t);
        }

        int result = t.compareTo((T) node.getData());
        if (result < 0)
            node.setLeft(addInternal(t, (Node) node.getLeft()));
        else if (result > 0)
            node.setRight(addInternal(t, (Node) node.getRight()));
        else
            ;//doNothing

        return node;
    }


}
