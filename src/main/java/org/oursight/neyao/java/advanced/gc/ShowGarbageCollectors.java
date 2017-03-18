package org.oursight.neyao.java.advanced.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DellPC on 2017/3/18.
 */
public class ShowGarbageCollectors {

    public static void main(String[] args) {
        print();
    }

    public static void print() {
        try {
            List<GarbageCollectorMXBean> gcMxBeans = ManagementFactory.getGarbageCollectorMXBeans();

            for (GarbageCollectorMXBean gcMxBean : gcMxBeans) {
                // System.out.println(gcMxBean.getName());
                System.out.println(gcMxBean.getObjectName() + ": " + Arrays.toString(gcMxBean.getMemoryPoolNames()));
            }

        } catch (RuntimeException re) {
            throw re;
        } catch (Exception exp) {
            throw new RuntimeException(exp);
        }
    }

}
