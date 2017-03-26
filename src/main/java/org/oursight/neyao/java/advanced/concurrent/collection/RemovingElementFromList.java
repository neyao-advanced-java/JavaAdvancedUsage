package org.oursight.neyao.java.advanced.concurrent.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neyao on 2017/3/21.
 */
public class RemovingElementFromList {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        // 会扔出来一个：java.util.ConcurrentModificationException
        for (Integer integer : list) {
            if(3 == integer) {
                list.remove(3);
            }
        }
    }
}
