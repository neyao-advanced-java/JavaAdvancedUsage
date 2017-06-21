package org.oursight.neyao.java.advanced.generic;

/**
 * Created by yaonengjun on 2017/6/21 上午9:24.
 */


interface Info2<T> {  // 在接口上定义泛型
  public T getVar(); // 定义抽象方法，抽象方法的返回值就是泛型类型
}

class InfoImpl2<T> implements Info2<T> { // 定义泛型接口的子类
  private T var;    // 定义属性

  public InfoImpl2(T var) {  // 通过构造方法设置属性内容
    this.setVar(var);
  }

  public void setVar(T var) {
    this.var = var;
  }

  public T getVar() {
    return this.var;
  }
};

public class GenericInInterfaceAndImpl {
  public static void main(String arsg[]) {
    Info2<String> i = null;  // 声明接口对象
    i = new InfoImpl2<String>("汤姆"); // 通过子类实例化对象
    System.out.println("内容：" + i.getVar());
  }
};