package org.oursight.neyao.java.advanced.algorithm.tree;

/**
 * Created by DellPC on 2017/4/8.
 */
public class TreePrinter
{
    /** Node that can be printed */
    public interface PrintableNode
    {
        /** Get left child */
        PrintableNode getLeft();


        /** Get right child */
        PrintableNode getRight();


        /** Get text to be printed */
        String getText();
    }

    public static void print(PrintableNode root) {
        printTree(root);
    }

    private static void printTree(PrintableNode node) {
        if (node.getRight() != null) {
            printTree(node.getRight(), true, "");
        }
        printNodeValue(node);
        if (node.getLeft() != null) {
            printTree(node.getLeft(), false, "");
        }
    }
    private static void printNodeValue(PrintableNode node) {
        if (node.getText() == null) {
            System.out.print("<null>");
        } else {
            System.out.print(node.getText());
        }
        System.out.print('\n');
    }
    // use string and not stringbuffer on purpose as we need to change the indent at each recursion
    private static void printTree(PrintableNode node, boolean isRight, String indent) {
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
