package org.oursight.neyao.java.advanced.concurrent.basic;

/**
 * Created by DellPC on 2017/3/19.
 */
public class DoubleCheckingFactory {

    private static Object instance;
//    private static volatile Object instance;

    public static Object getInstance() {

        if (instance == null) {
            instance = new String("aaa");
        }

        return instance;
    }


    public static Object getInstance1() {

        if (instance == null) {
            synchronized (DoubleCheckingFactory.class) {
                if (instance == null) {
                    instance = new String("aaa");
                }
            }
        }

        return instance;
    }
}
