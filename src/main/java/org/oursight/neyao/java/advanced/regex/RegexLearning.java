package org.oursight.neyao.java.advanced.regex;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * 正则表达式学习
 * Created by neyao on 2017/5/27.
 */
public class RegexLearning {

  public static void main(String[] args) {
//        basic();
//        complicate();
//        replace();
//        findAndReplaceBaseInHtml();

    matchSearchQuery();


  }

  public static void matchSearchQuery() {
    //https://www.baidu.com/s?wd=%E9%B2%9C%E8%8A%B1&rsv_spt=1&rsv_iqid=0xdcd4093d00000d48&issp=1&f=8&rsv_bp=0
    // &rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=15&rsv_sug1=1&rsv_sug7=001&rsv_sug2=0&inputT=2957&rsv_sug4=3097&rsv_sug=9

    String target = "https://www.baidu.com/s?wd=%E9%B2%9C%E8%8A%B1&rsv_spt=1&rsv_iqid=0xdcd4093d00000d48&issp=1&f" +
            "=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=15&rsv_sug1=1&rsv_sug7=001&rsv_sug2=0&inputT=2957&rsv_sug4=3097&rsv_sug=9";
    String pattern = "https://www.baidu.com/s(\\?wd=([\\S]*)|[\\S]*\\&wd=)";
    boolean isMatch = Pattern.matches(pattern, target);
    System.out.println(isMatch + ": " + pattern);
    System.out.println();

    target = "https://www.baidu.com/s?rsv_iqid=0xdcd4093d00000d48&issp=1&wd=%E9%B2%9C%E8%8A%B1&rsv_spt=1&f" +
            "=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=15&rsv_sug1=1&rsv_sug7=001&rsv_sug2=0&inputT=2957&rsv_sug4=3097&rsv_sug=9";
    pattern = "https://www.baidu.com/s\\?wd=\\S*|https://www.baidu.com/s\\S*\\&wd=\\S*";
    isMatch = Pattern.matches(pattern, target);
    System.out.println(isMatch + ": " + pattern);
    System.out.println();

    target = "https://www.baidu.com/s?rsv_iqid=0xdcd4093d00000d48&issp=1&wd=";
    pattern = "https://www.baidu.com/s\\?wd=\\S*|https://www.baidu.com/s\\S*\\&wd=\\S*";
    isMatch = Pattern.matches(pattern, target);
    System.out.println(isMatch + ": " + pattern);
    System.out.println();

    target = "https://www.baidu.com/s?wd=";
    pattern = "https://www.baidu.com/s\\?wd=\\S*|https://www.baidu.com/s\\S*\\&wd=\\S*";
    isMatch = Pattern.matches(pattern, target);
    System.out.println(isMatch + ": " + pattern);
    System.out.println();

    target = "https://www.baidu.com/s";
    pattern = "https://www.baidu.com/s\\?wd=\\S*|https://www.baidu.com/s\\S*\\&wd=\\S*";
    isMatch = Pattern.matches(pattern, target);
    System.out.println(isMatch + ": " + pattern);
    System.out.println("SHOULD BE FALSE");
    System.out.println();

    // ===

    target = "https://www.sogou.com/web?query=11234&_asf=www.sogou.com&_ast=&w=01019900&p=40040100&ie=utf8&from=index-nologin&s_from=index&sut=1238&sst0=1499945515112&lkt=5%2C1499945513874%2C1499945514686&sugsuv=1495525014235762&sugtime=1499945515112";
    pattern = "http(s*)://www.sogou.com/web\\?query=\\S*|http(s*)://www.sogou.com/web\\S*\\&query=\\S*";
    isMatch = Pattern.matches(pattern, target);
    System.out.println(isMatch + ": " + pattern);
    System.out.println(target);
    System.out.println();

    target = "http://www.sogou.com/web?query=11234&_asf=www.sogou.com&_ast=&w=01019900&p=40040100&ie=utf8&from=index-nologin&s_from=index&sut=1238&sst0=1499945515112&lkt=5%2C1499945513874%2C1499945514686&sugsuv=1495525014235762&sugtime=1499945515112";
    pattern = "http(s*)://www.sogou.com/web\\?query=\\S*|http(s*)://www.sogou.com/web\\S*\\&query=\\S*";
    isMatch = Pattern.matches(pattern, target);
    System.out.println(isMatch + ": " + pattern);
    System.out.println(target);
    System.out.println();

    // ===

    target = "https://www.so.com/s?src=home_hot&q=3%E5%90%8D%E4%B8%AD%E5%9B%BD%E4%BA%BA%E5%9C%A8%E8%8F%B2%E9%81%AD%E7%BB%91%E6%9E%B6";
    pattern = "https://www.so.com/s\\?q=\\S*|https://www.so.com/s\\S*\\&q=\\S*";
    isMatch = Pattern.matches(pattern, target);
    System.out.println(isMatch + ": " + pattern);
    System.out.println(target);
    System.out.println();

    target = "https://www.so.com/s?q=3%E5%90%8D%E4%B8%AD%E5%9B%BD%E4%BA%BA%E5%9C%A8%E8%8F%B2%E9%81%AD%E7%BB%91%E6%9E%B6";
    pattern = "https://www.so.com/s\\?q=\\S*|https://www.so.com/s\\S*\\&q=\\S*";
    isMatch = Pattern.matches(pattern, target);
    System.out.println(isMatch + ": " + pattern);
    System.out.println(target);
    System.out.println();


    target = "https://www.so.com/s?src=home_hot&q=3%E5%90%8D%E4%B8%AD%E5%9B%BD%E4%BA%BA%E5%9C%A8%E8%8F%B2%E9%81%AD%E7" +
            "%BB%91%E6%9E%B6&&&";
    pattern = "https://www.so.com/s\\?q=\\S*|https://www.so.com/s\\S*\\&q=\\S*";
    isMatch = Pattern.matches(pattern, target);
    System.out.println(isMatch + ": " + pattern);
    System.out.println(target);
    System.out.println();

    target = "https://www.so.com/s?q=3%E5%90%8D%E4%B8%AD%E5%9B%BD%E4%BA%BA%E5%9C%A8%E8%8F%B2%E9%81%AD%E7%BB%91%E6%9E%B6";
    pattern = "https://www.so.com/s\\?q=\\S*|https://www.so.com/s\\S*\\&q=\\S*";
    isMatch = Pattern.matches(pattern, target);
    System.out.println(isMatch + ": " + pattern);
    System.out.println(target);
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

//        str1 = "<src=\"./img/aaa\">";
    str1 = "<src=\"http://11.com\">";
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

  public static void findAndReplaceBaseInHtml() {
    String regex;
    String html11 = "<html><head> <title>aaa</title> </head><body> <a> </a> </body></html>";
    String html12 = "<html><head> <title>aaa</TITLE> </head><body> <a> </a> </body></html>";
    String html2 = "<html><head> <base href=\"xxx\" /> <title>aaa</title> </head><body> <a> </a> </body></html>";
    String html3 = "<html><head> <BASE href=\"xxx\" /> <title>aaa</title> </head><body> <a> </a> </body></html>";

//    String regex1 = "(?i)<head>"
    String regex2 = "(?i)<base";
    System.out.println("regex2 match:" + Pattern.matches(regex2, html2));
    System.out.println("regex2 match html2: " + Pattern.compile(regex2, Pattern.DOTALL).matcher(html2).find());
    System.out.println("regex2 match html3: " + Pattern.compile(regex2, Pattern.DOTALL).matcher(html3).find());
    System.out.println();

    String regex3 = "(?i)<base\\s{1,}(?i)href";
    regex = regex3;
    System.out.println("regex3 match:" + Pattern.matches(regex, html2));
    System.out.println("regex3 match html2: " + Pattern.compile(regex, Pattern.DOTALL).matcher(html2).find());
    System.out.println("regex3 match html3: " + Pattern.compile(regex, Pattern.DOTALL).matcher(html3).find());
    System.out.println();


    String regex11 = "(?i)<head>";
    regex = regex11;
    System.out.println(html2);
    System.out.println("regex3: " + regex3);
    System.out.println(StringUtils.replacePattern(html2, regex, "<head><base href=\"http://11.com\" />"));
    System.out.println();

//        String regex4 = "(?i)<base";
//        System.out.println(html2);
//        System.out.println(regex4);
//        System.out.println(StringUtils.replacePattern(html2, regex3, "<base href=\"http://11.com\">"));
//        System.out.println();

    String str1 = "<basE  href=\"hTtp://www.baidu.com///img/aaa\" />";
    regex = "(?i)<base\\s{1,}href=\"http([\\w\\W]*)\"";
    System.out.println(str1);
    System.out.println("found: " + Pattern.compile(regex, Pattern.DOTALL).matcher(str1).find());
    System.out.println(StringUtils.replacePattern(str1, regex, "<base href=\"1111111\""));

//        str1 = "<src=\"./img/aaa\">";
//        regex = "src=[\"^(\\w+)(/{2})]";
//        System.out.println("str1 match:" + Pattern.matches(regex, str1));
//        System.out.println(str1);
//        System.out.println(StringUtils.replacePattern(str1, regex, "src=\"http://www.baidu.com/"));
//        System.out.println();
  }
}
