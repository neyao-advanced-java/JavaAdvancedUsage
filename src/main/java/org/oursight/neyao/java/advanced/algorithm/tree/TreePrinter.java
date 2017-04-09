package org.oursight.neyao.java.advanced.algorithm.tree;

/**
 * Created by DellPC on 2017/4/8.
 */
public class TreePrinter
{


    public static void print(INode root) {
        printTree(root);
    }

    private static void printTree(INode node) {
        if (node.getRight() != null) {
            printTree(node.getRight(), true, "");
        }
        printNodeValue(node);
        if (node.getLeft() != null) {
            printTree(node.getLeft(), false, "");
        }
    }
    private static void printNodeValue(INode node) {
        if (node.getText() == null) {
            System.out.print("<null>");
        } else {
            System.out.print(node.getText());
        }
        System.out.print('\n');
    }
    // use string and not stringbuffer on purpose as we need to change the indent at each recursion
    private static void printTree(INode node, boolean isRight, String indent) {
        if (node.getRight() != null) {
            printTree(node.getRight(), true, indent + (isRight ? "        " : " |      "));
        }
        System.out.print(indent);
        if (isRight) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("----- ");
        printNodeValue(node);
        if (node.getLeft() != null) {
            printTree(node.getLeft(), false, indent + (isRight ? " |      " : "        "));
        }
    }
}
