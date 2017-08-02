package org.oursight.neyao.java.advanced.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yaonengjun on 2017/7/14 下午2:46.
 */
public class LambdaUsage {

  public static void main(String[] args) {
    basic();
  }

  public static void basic() {
    List<Integer> list = Arrays.asList(1, 2, 5, 4, 6, 3, 4, 5, 6);
    // 使用lambda原生进行请求
    System.out.println("--- iter with lambda ---");
    list.forEach((n) -> System.out.println(n));
    System.out.println();

    // 或者用::  这是java 8里引入lambda后的一种用法，表示引用，比如静态方法的引用String::valueOf;
    System.out.println("--- iter with :: ---");
    list.forEach(System.out::println);
    System.out.println();
  }
}
