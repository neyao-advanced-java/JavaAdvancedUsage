package org.oursight.neyao.java.advanced.algorithm.sort;

import org.oursight.neyao.java.advanced.util.LogUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by DellPC on 2017/3/19.
 */
public class SortingAlgorithms {

    public static void main(String[] args) {

        long t1 = LogUtil.log("Start creating array");
        int[] array = createArray(10000);
        LogUtil.log("Creating array done", t1);
       // System.out.println(Arrays.toString(array));

    }

    public static int[] createArray(int length) {
        return createArray(length, 1000);
    }

    public static int[] createArray(int length, int max) {

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(max);
        }

        return array;
    }

    public static void bubbleSorting(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int a = array[i];
        }
    }

}
