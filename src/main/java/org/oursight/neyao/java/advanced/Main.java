package org.oursight.neyao.java.advanced;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by yaonengjun on 2017/4/9.
 */
public class Main {

    public static void main(String[] args) {
        String s1  ="<a href=\"http://dig.chouti.com/mobile/link/12348211\" class=\"nm auth jump\">";
        String s2 = StringUtils.replaceIgnoreCase(s1, "\"http://dig.chouti.com/", "\"");
        System.out.println(s1);
        System.out.println(s2);
    }
}
