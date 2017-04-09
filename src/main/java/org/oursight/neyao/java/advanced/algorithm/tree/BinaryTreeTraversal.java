package org.oursight.neyao.java.advanced.algorithm.tree;

import org.oursight.neyao.java.advanced.algorithm.sort.SortingAlgorithms;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by DellPC on 2017/4/9.
 */
public class BinaryTreeTraversal {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        Integer[] arrays = SortingAlgorithms._createArray(5);


        for (Integer a : arrays) {
            System.out.println(a + " add");
            tree.add(a);
            System.out.println();

        }

        TreePrinter.print(tree.root);
        System.out.println();

        System.out.println(Arrays.toString(arrays));
        System.out.println();

        System.out.println("======= preorder start ========");
        preorder(tree.root);
        System.out.println();

        System.out.println("======= preorder_stack_1 start ========");
        preorder_stack_1(tree.root);
        System.out.println();

//        System.out.println("======= inorder start ========");
//        inorder(tree.root);
//        System.out.println();

//        System.out.println("======= postorder start ========");
//        postorder(tree.root);
//        System.out.println();
    }

    /**
     * http://www.gocalf.com/blog/traversing-binary-tree.html
     * http://robinsoncrusoe.iteye.com/blog/808526
     * <p>
     * 递归实现前序遍历
     *
     * @param node
     */
    public static void preorder(Node node) {
        if (node != null) {
            System.out.println(node.getText());
            preorder((Node) node.getLeft());
            preorder((Node) node.getRight());
        }
    }

    /**
     * 递归实现中序遍历
     */
    public static void inorder(Node p) {
        if (p != null) {
            inorder((Node) p.getLeft());
            System.out.println(p.getText());
            inorder((Node) p.getRight());
        }
    }

    /**
     * 递归实现后序遍历
     */
    public static void postorder(Node p) {
        if (p != null) {
            inorder((Node) p.getLeft());
            inorder((Node) p.getRight());
            System.out.println(p.getText());
        }
    }

    /**
     *
     * @param node 树节点
     * 利用栈实现循环先序遍历二叉树
     * 这种实现类似于图的深度优先遍历（DFS）
     * 维护一个栈，将根节点入栈，然后只要栈不为空，出栈并访问，接着依次将访问节点的右节点、左节点入栈。
     * 这种方式应该是对先序遍历的一种特殊实现（看上去简单明了），但是不具备很好的扩展性，在中序和后序方式中不适用
     */
    public static void preorder_stack_1(Node node) {
        Stack<Node> stack = new Stack<>();
        if (node != null) {
            stack.push(node);
            while (!stack.empty()) {
                 Node temp = stack.pop();
                System.out.println(temp.getText());

                // 后进先出，先放右边的
                if(temp.getRight() != null) {
                    stack.push(temp.right);
                }
                if(temp.getLeft() != null) {
                    stack.push(temp.left);
                }

            }
        }
    }

}
