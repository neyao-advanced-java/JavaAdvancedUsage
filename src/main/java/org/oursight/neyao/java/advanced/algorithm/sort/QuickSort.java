package org.oursight.neyao.java.advanced.algorithm.sort;

import java.util.Arrays;

/**
 * http://blog.csdn.net/morewindows/article/details/6684558   白话快排, 解释得非常详尽和清楚【但是里边的例子似乎运行不了】
 * https://zh.wikipedia.org/wiki/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F    快速排序的维基百科，有各种算法【本类中的例子】
 * <p>
 * Created by DellPC on 2017/4/16.
 */
public class QuickSort {

    public static void main(String[] args) {
        Integer[] array = SortingAlgorithms._createArray(7);
        System.out.println(Arrays.toString(array));

        QuickSort quickSort = new QuickSort(array);
        quickSort.sort();

        System.out.println(Arrays.toString(quickSort.arr));

    }

    Integer[] arr;

    public QuickSort(Integer[] array) {
        this.arr = array;
    }

    private void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public void sort() {
        quick_sort_recursive(0, arr.length - 1);
    }

    private void quick_sort_recursive(int start, int end) {
        if (start >= end)
            return;

//        int x = arr[end];
        int x = arr[start];

        int left = start, right = end - 1;
        while (left < right) {
            while (arr[left] <= x && left < right)
                left++;

            while (arr[right] >= x && left < right)
                right--;

            swap(left, right);
        }

        if (arr[left] >= arr[end])
            swap(left, end);
        else
            left++;

        quick_sort_recursive(start, left - 1);
        quick_sort_recursive(left + 1, end);
    }


}
