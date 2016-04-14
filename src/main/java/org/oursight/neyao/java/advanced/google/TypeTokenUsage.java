package org.oursight.neyao.java.advanced.google;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Created by neyao@github.com on 2016/4/14.
 */
public class TypeTokenUsage {

    public static void main(String[] args) {
        Type mapType = new TypeToken<HashMap<String, String>>() {
        }.getType();

        System.out.println("mapType = " + mapType);

    }
}
