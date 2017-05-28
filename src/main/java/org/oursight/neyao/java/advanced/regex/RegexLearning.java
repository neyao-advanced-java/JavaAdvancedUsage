package org.oursight.neyao.java.advanced.regex;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * Created by neyao on 2017/5/27.
 */
public class RegexLearning {

    public static void main(String[] args) {
//        basic();
//        complicate();
//        replace();


        String str1 = "<href=\"http://www.taobao.com/http://www.taobao.com/http://www.taobao.com/d1/a.jpg>";
        String regex = "href=\"(http://www.taobao.com/){2,}";
        System.out.println("str1 match:" + Pattern.matches(regex, str1));
        System.out.println(str1);
        System.out.println(StringUtils.replacePattern(str1, regex, "src=\"http://www.baidu.com/"));
        System.out.println();
        System.out.println();
    }

    public static void basic() {
        String content = "this is text1";
        String pattern = "this\\s+is\\s+text1";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println(isMatch);

        content = "athis is text1";
        pattern = "\\S+this\\s+is\\s+text1";
        isMatch = Pattern.matches(pattern, content);
        System.out.println(isMatch);

        content = "b a athis is text1";
        pattern = "[\\s\\S]*this\\s+is\\s+text1";
        isMatch = Pattern.matches(pattern, content);
        System.out.println(isMatch);
    }

    public static void replace() {
        String str1 = "<src=\"./img/aaa\">";
//        String regex = "[\\s\\S]*src=\"\\.{1}/{1}\\w[\\s\\S]*";
        String regex = "src=\"\\.{1}/{1}";

        System.out.println("str1 match:" + Pattern.matches(regex, str1));
        System.out.println(str1);
        System.out.println(StringUtils.replacePattern(str1, regex, "src=\"http://www.baidu.com/"));
        System.out.println();
        System.out.println();

        str1 = "<src=\"../img/aaa\">";
        regex = "src=\"\\.{2}/{1}";
        System.out.println("str1 match:" + Pattern.matches(regex, str1));
        System.out.println(str1);
        System.out.println(StringUtils.replacePattern(str1, regex, "src=\"http://www.baidu.com/../"));
        System.out.println();
        System.out.println();
//
        String str3 = "<src=\"img/aaa\">";
        regex = "src=\"{1}\\w+/{1}";
        System.out.println("str3 match:" + Pattern.matches(regex, str3));
        System.out.println(str3);
        System.out.println(StringUtils.replacePattern(str3, regex, "src=\"http://www.baidu.com/"));
        System.out.println();
        System.out.println();

        str1 = "<src=\"./img/aaa\">";
        regex = "src=[\"^(\\w+)(/{2})]";
        System.out.println("str1 match:" + Pattern.matches(regex, str1));
        System.out.println(str1);
        System.out.println(StringUtils.replacePattern(str1, regex, "src=\"http://www.baidu.com/"));
        System.out.println();
        System.out.println();


        str1 = "<src=\"img/aaa\">";
        regex = "src=[\"^(\\w+)]";
        System.out.println("str1 match:" + Pattern.matches(regex, str1));
        System.out.println(str1);
        System.out.println(StringUtils.replacePattern(str1, regex, "src=\"http://www.baidu.com/"));
        System.out.println();
        System.out.println();

        str1 = "<src=\"http://www.baidu.com///img/aaa\">";
        regex = "src=\"http://www.baidu.com/{3}";
        System.out.println(str1);
        System.out.println(StringUtils.replacePattern(str1, regex, "src=\"//"));

        str1 = "<src=\"http://www.baidu.com///img/aaa\">";
        regex = "src=\"http://www.baidu.com/{3}";
        System.out.println(str1);
        System.out.println(StringUtils.replacePattern(str1, regex, "src=\"//"));
//        str1 = "<src=\"img/aaa\">";
//        regex = "src=\"img";
//        System.out.println("str1 match:" + Pattern.matches(regex, str1));
//        System.out.println(str1);
//        System.out.println(StringUtils.replacePattern(str1, regex, "src=\"http://www.baidu.com/"));
//        System.out.println();
//        System.out.println();

//        str1 = "<src=\"http://www.163.com/aaa\">";
//        regex = "src=[\"^(http)](\\w+)";
//        System.out.println("str1 match:" + Pattern.matches(regex, str1));
//        System.out.println(str1);
//        System.out.println(StringUtils.replacePattern(str1, regex, "src=\"http://www.baidu.com/"));
//        System.out.println();
//        System.out.println();

    }

    public static void complicate() {

        String str1 = "<src=\"./img/aaa\">";
        String str11 = "<src=\".//img/aaa\">";
        String str2 = "<src=\"im2/aaa\">";
        String str3 = "<src=\"//im3/aaa\">";
        String str4 = "<src=\"./3m3/aaa\">";
        String str5 = "<src=\"./IMG/aaa\">";
        String str6 = "<src=\"./IMG3/aaa\">";
        String str7 = "<src=\"./ImG3/aaa\">";
        String str8 = "<src=\"./3mG3/aaa\">";

//        String regex = "^src=.*./.*[^0-9a-zA-Z]";
        String regex = ".*./.*";
//        Pattern pattern = Pattern.compile(regex);
//        pattern.matcher()
        System.out.println("str1 match:" + Pattern.matches(regex, str1));

        regex = "[\\s\\S]*src=\"\\.{1}/{1}\\w[\\s\\S]*";
        System.out.println("str1 match:" + Pattern.matches(regex, str1));
        System.out.println("str11 match:" + Pattern.matches(regex, str11));

        regex = "[\\s\\S]*src=\"\\w[\\s\\S]*";
        System.out.println("str2 match:" + Pattern.matches(regex, str2));

        regex = "[\\s\\S]*src=\"/{2}\\w[\\s\\S]*";
        System.out.println("str3 match:" + Pattern.matches(regex, str3));
    }
}
