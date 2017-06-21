package org.oursight.neyao.java.advanced.generic;

/**
 * Created by yaonengjun on 2017/6/21 上午9:19.
 */
public class GenericInClass<T> {

  private T t;

  public void add(T t) {
    this.t = t;
  }

  public T get() {
    return t;
  }

  public static void main(String[] args) {
    GenericInClass<Integer> integerBox = new GenericInClass<Integer>();
    GenericInClass<String> stringBox = new GenericInClass<String>();

    integerBox.add(new Integer(10));
    stringBox.add(new String("菜鸟教程"));

    System.out.printf("整型值为 :%d\n\n", integerBox.get());
    System.out.printf("字符串为 :%s\n", stringBox.get());
  }
}