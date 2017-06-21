package org.oursight.neyao.java.advanced.generic;

/**
 * Created by yaonengjun on 2017/6/21 上午9:27.
 */
interface Info<T> {  // 在接口上定义泛型
  public T getVar(); // 定义抽象方法，抽象方法的返回值就是泛型类型
}

class InfoImpl implements Info<String> { // 定义泛型接口的子类
  private String var;    // 定义属性

  public InfoImpl(String var) {  // 通过构造方法设置属性内容
    this.setVar(var);
  }

  public void setVar(String var) {
    this.var = var;
  }

  public String getVar() {
    return this.var;
  }
};

public class GenericInInterfaceAndImpl2 {
  public static void main(String arsg[]) {
    Info i = null;  // 声明接口对象
    i = new InfoImpl("汤姆"); // 通过子类实例化对象
    System.out.println("内容：" + i.getVar());
  }
};