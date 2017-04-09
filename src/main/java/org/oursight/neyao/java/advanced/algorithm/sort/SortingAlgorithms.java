package org.oursight.neyao.java.advanced.algorithm.sort;

import org.oursight.neyao.java.advanced.util.LogUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by DellPC on 2017/3/19.
 */
public class SortingAlgorithms {

    public static void main(String[] args) {

        int arrayLength = 5;
        int counter = 0;
        Integer[] tempArray;
        boolean print = true;

        long t1 = LogUtil.log("Start creating array");
        Integer[] array = _createArray(arrayLength);
        long t2 = LogUtil.log("Creating array done", t1);
        System.out.println(Arrays.toString(array));

        System.out.println();
        System.out.println("-----");
        System.out.println();

        counter = 0;
        tempArray = Arrays.copyOf(array, arrayLength);
        counter = selectionSorting(tempArray, print);
        System.out.println();
        System.out.println(Arrays.toString(tempArray));
        LogUtil.log("sorting done, execute times: " + counter + ", arrayLength: " + arrayLength, t2);

        System.out.println();
        System.out.println("-----");
        System.out.println();

        counter = 0;
        tempArray = Arrays.copyOf(array, arrayLength);
        counter = bubbleSorting(tempArray, print);
        System.out.println();
        System.out.println(Arrays.toString(tempArray));
        LogUtil.log("sorting done, execute times: " + counter + ", arrayLength: " + arrayLength, t2);


    }

    public static Integer[] _createArray(int length) {
        return _createArray(length, 1000);
    }

    public static Integer[] _createArray(int length, int max) {

        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(max);
        }

        return array;
    }

    /**
     * 选择排序
     */
    public static int selectionSorting(Integer[] array, boolean print) {
        System.out.println("selectionSorting start");

        int _counter = 0;
        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length; j++) {
                _counter++;
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    if (print) {
                        System.out.println(Arrays.toString(array));
                    }
                }
            }

        }

        System.out.println("selectionSorting done");
        return _counter;
    }

    public static int bubbleSorting(Integer[] array, boolean print) {
        System.out.println("bubbleSorting start");

        int _counter = 0;
        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length - i - 1; j++) {
                _counter++;
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    if(print) {
                        System.out.println(Arrays.toString(array));
                    }
                }
            }
        }

        System.out.println("bubbleSorting done");
        return _counter;
    }

    public static int insertionSorting(Integer[] array, boolean print) {
        System.out.println("insertionSorting start");

        int _counter = 0;
        for (int i = 0; i < array.length; i++) {

            for (int j = 1; j < array.length; j++) {

            }
        }

        System.out.println("insertionSorting done");
        return _counter;
    }
}
