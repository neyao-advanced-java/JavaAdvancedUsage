package org.oursight.neyao.java.advanced.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Created by neyao on 2017/5/26.
 */
public class TestHttpURLConnection {

    protected static final String IPHONE6_UA = "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1";

    /**
     * 本方法展示了从http跳转到http说的处理方式。
     * 访问路径：http://weibo.com 302到 http://m.weibo.cn/?&jumpfrom=weibocom，随后又跳到 https://m.weibo.cn/?&jumpfrom=weibocom
     *
     * @throws Exception
     */
    public static void handleHttpToHttpsRedircts() throws Exception {
        URL url = new URL("http://weibo.com");
        System.out.println("url.toString(): " + url.toString());
        HttpURLConnection.setFollowRedirects(true);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setInstanceFollowRedirects(true);
//        int code = conn.getResponseCode();
//        while (code == 302) {
//            url = conn.getURL();
//            conn.disconnect();
//            conn = (HttpURLConnection) url.openConnection();
//            conn.setInstanceFollowRedirects(true);
//        }

        conn
                .setRequestProperty(
                        "User-Agent",
                        IPHONE6_UA);

        System.out.println(conn.getRequestProperties());
        System.out.println();

        System.out.println(conn.getResponseCode());
        System.out.println();

        int code = conn.getResponseCode();
        System.out.println("Redirected URL 11: " + conn.getURL());
        System.out.println("===== handling multilple 302 start ========");
        int counter = 0;
        while (code == 302) {
            counter++;
            URL nexUrl = new URL(conn.getHeaderField("Location"));
            conn.disconnect();
            conn = (HttpURLConnection) nexUrl.openConnection();
            conn.setInstanceFollowRedirects(true);
            code = conn.getResponseCode();
        }
        System.out.println("===== handling multilple 302 done: "+counter+" times ========");

        System.out.println(conn.getInstanceFollowRedirects());
        System.out.println();

        System.out.println(conn.getHeaderFields());
        System.out.println();

//        InputStream inputStream = null;

        InputStream inputStream = conn.getInputStream();

        System.out.println("Redirected URL 22: " + conn.getURL());

        System.out.println();
        System.out.println();
        System.out.println("=======1st=========");
        read(inputStream);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("=======2st=========");
        // 不能同时读两次流，以下代码会报异常
        //read(inputStream);


    }

    public static void basic() throws Exception {

//        URL url = new URL("http://uc.ww88.net.cn");
//        URL url = new URL("http://uc.10000et.com/?MzQ=");
//        URL url = new URL("http://www.baidu.com");
        URL url = new URL("http://chouti.com");
        System.out.println("url.toString(): " + url.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setInstanceFollowRedirects(true);
        conn
                .setRequestProperty(
                        "User-Agent",
                        IPHONE6_UA);

        System.out.println(conn.getRequestProperties());
        System.out.println();
        System.out.println(conn.getRequestProperties());
        System.out.println();

        System.out.println(conn.getResponseCode());
        System.out.println();

        System.out.println(conn.getInstanceFollowRedirects());
        System.out.println();

        System.out.println(conn.getHeaderFields());
        System.out.println();

//        InputStream inputStream = null;
        InputStream inputStream = conn.getInputStream();

        System.out.println("Redirected URL: " + conn.getURL());

        System.out.println();
        System.out.println();
        System.out.println("=======1st=========");
        read(inputStream);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("=======2st=========");
        // 不能同时读两次流，以下代码会报异常
        //read(inputStream);


        conn.disconnect();
    }

    private static void read(InputStream inputStream) {
        read(inputStream, null);
    }

    private static void read(InputStream inputStream, Charset charset) {
        if (inputStream == null)
            return;

        if (charset == null)
            charset = StandardCharsets.UTF_8;

        BufferedReader reader = null;
        try {
            //            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));//和接受的页面的页面编码一致即可解决中文乱码问题
//            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));//和接受的页面的页面编码一致即可解决中文乱码问题
            reader = new BufferedReader(new InputStreamReader(inputStream, charset));//和接受的页面的页面编码一致即可解决中文乱码问题
            String line = null;
            while ((line = reader.readLine()) != null) {
//                System.out.println(new String(line.getBytes("ISO8859-1"), "GB2312"));
                System.out.println(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
