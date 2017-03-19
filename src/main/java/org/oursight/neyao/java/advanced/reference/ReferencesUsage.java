package org.oursight.neyao.java.advanced.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by DellPC on 2017/3/19.
 */
public class ReferencesUsage {

    public static void main(String[] args) {
        ReferencesUsage r = new ReferencesUsage();

        r.strongReference();
        r.softReference();
        r.weakReference();
        r.phantomReferenceAlwaysNull();
    }


    public void strongReference() {
        System.out.println();
        System.out.println();
        System.out.println("===== strongReference() =====");

        Object referent = new Object();

        /**
         * 通过赋值创建 StrongReference
         */
        Object strongReference = referent;

        System.out.println(referent == strongReference);  // 应该返回true

        referent = null;
        System.gc();

        /**
         * StrongReference 在 GC 后不会被回收
         */
        System.out.println(strongReference == null);  //false
    }

    /**
     * 只有在JVM内存不足的时候才会进行回收，即在OutOfMemory之前。
     * 适合与用来做缓存。
     */
    public void softReference() {
        System.out.println();
        System.out.println();
        System.out.println("===== softReference() =====");

        Object referent = new Object();
        SoftReference<Object> softRerference = new SoftReference<Object>(referent);

        System.out.println("softRerference == null: " + softRerference.get() == null);  // false

        referent = null;
        System.gc();

        /**
         *  soft references 只有在 jvm OutOfMemory 之前才会被回收, 所以它非常适合缓存应用
         */
        System.out.println("softRerference == null: " + softRerference.get() == null);  // false
    }

    /**
     * 在垃圾回收时会被清除。
     * 一个好处是用来做WeakHashMap
     */
    public void weakReference() {
        System.out.println();
        System.out.println();
        System.out.println("===== weakReference() =====");

        Object referent = new Object();
        WeakReference<Object> weakReference = new WeakReference<Object>(referent);

        System.out.println(referent == weakReference.get());  // true

        referent = null;
        System.gc();

        /**
         * 一旦没有指向 referent 的强引用, weak reference 在 GC 后会被自动回收
         */
        System.out.println(weakReference.get() == null); // true
    }

    public void phantomReferenceAlwaysNull() {
        System.out.println();
        System.out.println();
        System.out.println("===== phantomReferenceAlwaysNull() =====");

        Object referent = new Object();
        PhantomReference<Object> phantomReference = new PhantomReference<Object>(referent, new ReferenceQueue<Object>());

        /**
         * phantom reference 的 get 方法永远返回 null
         */
        System.out.println("phantomReference.get() will always return null = " + phantomReference.get());
    }

}
