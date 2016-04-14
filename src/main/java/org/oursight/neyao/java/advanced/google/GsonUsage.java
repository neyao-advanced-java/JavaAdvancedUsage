package org.oursight.neyao.java.advanced.google;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by neyao@github.com on 2016/4/14.
 */
public class GsonUsage {

    public static void main(String[] args) {
        Gson gson = new Gson();
        String[] str = new String[] {"111", "222"};
        System.out.println(gson.toJson(str));
        System.out.println();

        Map<String, Object> toJsonMap = new HashMap<>();
        toJsonMap.put("aaa", 123);
        toJsonMap.put("bbb", "a string");
        System.out.println("toJsonMap = " + toJsonMap);
        System.out.println(gson.toJson(toJsonMap));
        System.out.println();

        Map fromJsonMap = gson.fromJson("{\"aaa\":123,\"bbb\":\"a string\"}",  new TypeToken<HashMap>() {}.getType());
        System.out.println("fromJsonMap = " + fromJsonMap);
        System.out.println();

    }


}
