package org.oursight.neyao.java.advanced.math;

import java.util.List;

/**
 * Created by neyao on 2017/5/21.
 */
public class StandardDeviation {

    public static double computeAverage(double[] array) {
        double sum = 0.0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum / array.length;
    }

    /**
     * see http://zh.wikihow.com/%E8%AE%A1%E7%AE%97%E5%9D%87%E5%80%BC%E3%80%81%E6%A0%87%E5%87%86%E5%B7%AE%E5%92%8C%E6%A0%87%E5%87%86%E8%AF%AF%E5%B7%AE
     * @param array
     * @return
     */
    public static double computeStandardDeviation(double[] array) {
        double average = computeAverage(array);

        double sum = 0.0;
        for (int i = 0; i < array.length; i++) {

            sum += Math.pow((array[i] - average), 2);
//            for (int j = 0; j < array.length; j++) {
//                sum += Math.pow((array[j] - array[i]), 2);
//            }
        }

        double standardDeviation = Math.sqrt(sum / array.length);
        return standardDeviation;


    }

    public static void main(String[] args) {

        double[] array = new double[]{12, 55, 74, 79, 90};
        double standardDeviation = computeStandardDeviation(array);
        System.out.println(standardDeviation);
    }
}
