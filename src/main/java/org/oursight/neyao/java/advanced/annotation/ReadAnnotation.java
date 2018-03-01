package org.oursight.neyao.java.advanced.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaonengjun on 2018/3/1 下午1:50.
 */
public class ReadAnnotation {

  public static void main(String[] args) throws Exception {
//    readInMethod(MyAnnotation.class, "test", UseAnnotation.class.getName());

    UseAnnotation useAnnotation = new UseAnnotation();
    useAnnotation.setTest("test_value");

    readInField(MyAnnotation.class, UseAnnotation.class.getName(), useAnnotation);
  }

  /**
   * 读取注解值
   *
   * @param annotationClasss 处理Annotation类名称
   * @param annotationField  处理Annotation类属性名称
   * @param className        处理Annotation的使用类名称
   * @return
   * @throws Exception
   */
  @SuppressWarnings("all")
  public static Map<String, String> readInMethod(Class annotationClasss, String annotationField, String className) throws Exception {

    System.out.println("处理Annotation类名称  === " + annotationClasss.getName());
    System.out.println("处理Annotation类属性名称  === " + annotationField);
    System.out.println("处理Annotation的调用类名称  === " + className);


    Map<String, String> map = new HashMap<String, String>();

    Method[] methods = Class.forName(className).getDeclaredMethods();
    for (Method method : methods) {
      if (method.isAnnotationPresent(annotationClasss)) {
        Annotation p = method.getAnnotation(annotationClasss);
        Method m = p.getClass().getDeclaredMethod(annotationField, null);
        String[] values = (String[]) m.invoke(p, null);
        for (String key : values) {
          System.out.println("方法上的注解值 === " + key);
//          map.put(key, key);
        }
      }
    }

//    System.out.println("map数量  === " + map.size());
    return map;
  }

  @SuppressWarnings("all")
  public static Map<String, String> readInField(Class annotationClasss, String className, Object object) throws Exception {

    System.out.println("Annotation定义  === " + annotationClasss.getName());
    System.out.println("Annotation的调用类名称  === " + className);
    System.out.println();
    System.out.println();

    Map<String, String> map = new HashMap<String, String>();

//    Field[] fields = Class.forName(className).getFields();
    Field[] fields = Class.forName(className).getDeclaredFields();
    System.out.println("fields of class " + className + " : " + Arrays.toString(fields));

    for (Field field : fields) {
      field.setAccessible(true);
      if (field.isAnnotationPresent(annotationClasss)) {
        System.out.println("field: " + field);
        System.out.println("value: " + field.get(object));
        Annotation p = field.getAnnotation(annotationClasss);
        System.out.println("Annotation: " + p);


//        Type type = field.getGenericType();
//        System.out.println("field.getGenericType: " + type);
//
//        System.out.println("field.getGenericType int: " + type.equals(int.class));
//        System.out.println("field.getGenericType string: " + type.equals(String.class));

      }
    }

//    System.out.println("map数量  === " + map.size());
    return map;
  }
}
