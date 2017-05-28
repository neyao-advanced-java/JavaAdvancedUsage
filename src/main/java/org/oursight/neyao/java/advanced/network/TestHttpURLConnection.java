package org.oursight.neyao.java.advanced.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by neyao on 2017/5/26.
 */
public class TestHttpURLConnection {

    public static void main(String[] args) throws Exception {

//        URL url = new URL("http://uc.ww88.net.cn");
        URL url = new URL("http://uc.10000et.com/?MzQ=");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        InputStream inputStream = conn.getInputStream();

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
        read(inputStream);


        conn.disconnect();
    }

    private static void read(InputStream inputStream) {
        BufferedReader reader = null;
        try {
        //            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));//和接受的页面的页面编码一致即可解决中文乱码问题
//            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));//和接受的页面的页面编码一致即可解决中文乱码问题
            reader = new BufferedReader(new InputStreamReader(inputStream,"ISO8859-1"));//和接受的页面的页面编码一致即可解决中文乱码问题
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(new String(line.getBytes("ISO8859-1"), "GB2312"));
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
