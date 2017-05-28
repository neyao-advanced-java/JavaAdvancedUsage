package org.oursight.neyao.java.advanced.network;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by neyao on 2017/5/27.
 */
public class UriAndUrl {

    public static void main(String[] args) throws MalformedURLException {
        validUrls();
    }

    public static void validUrls() throws MalformedURLException {
        String urlString = "http://www.taobao.com";
        URL url = new URL(urlString);
        System.out.println("URL for " + urlString +": " + url);
        System.out.println();

        urlString = "http://www.taobao.com/";
        url = new URL(urlString);
        System.out.println("URL for " + urlString +": " + url);
        System.out.println();

        urlString = "http://www.taobao.com//";
        url = new URL(urlString);
        System.out.println("URL for " + urlString +": " + url);
        System.out.println();

        urlString = "http://www.taobao.com/index.jsp";
        url = new URL(urlString);
        System.out.println("URL for " + urlString +": " + url);
        System.out.println();

        urlString = "http://www.taobao.com/../index.jsp";
        url = new URL(urlString);
        System.out.println("URL for " + urlString +": " + url);
        System.out.println();

    }
}
