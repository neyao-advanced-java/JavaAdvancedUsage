package org.oursight.neyao.java.advanced.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by neyao on 2017/3/15.
 */
public class TestSerial {

    public static void main(String[] args) throws Exception {

        testSerial();
        testDeSerial();
    }

    private static void testSerial() throws Exception{
        File file = new File("person.out");
        // 序列化
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        Person person = new Person("John", 21, "广州");
        oout.writeObject(person);
        oout.close();
        // 反序列化
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject();
        oin.close();
        System.out.println(newPerson);
    }

    /**
     * 如果此时将 Person类中的serialVersionUID = 1L 改为 serialVersionUID = 2L，则会抛出异常：java.io.InvalidClassException: org.oursight.neyao.java.advanced.serial.Person; local class incompatible: stream classdesc serialVersionUID = 1, local class serialVersionUID = 2
     * @throws Exception
     */
    public static void testDeSerial() throws Exception {
        File file = new File("person.out");
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject();
        oin.close();
        System.out.println(newPerson);
    }


}
