package org.oursight.neyao.java.advanced.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neyao on 2017/3/16.
 */
public class StringConstPool {

    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        // s3.intern();  如果打开这个注释，把上边的s3.intern();注释掉，下边就会返回false
        System.out.println(s3 == s4);
    }

    /**
     * 疯狂的创建字符串并放到常量池中，在JDK7以前的版本中会导致 Perm内存移除，JDK7之后的不会，因为JDK7之后没有PermGeneration了，而是MeteSpace。
     * see: https://mritd.me/2016/03/22/Java-%E5%86%85%E5%AD%98%E4%B9%8B%E6%96%B9%E6%B3%95%E5%8C%BA%E5%92%8C%E8%BF%90%E8%A1%8C%E6%97%B6%E5%B8%B8%E9%87%8F%E6%B1%A0/
     */
    private static void createStringContinually() {
        List<String> list  = new ArrayList<String>();

        // 无限循环 使用 list 对其引用保证 不被GC  intern 方法保证其加入到常量池中
        int i = 0;
        while (true) {
            // 此处永久执行，最多就是将整个 int 范围转化成字符串并放入常量池
            list.add(String.valueOf(i++).intern());
            System.out.println(i + " string created");
        }
    }
}
