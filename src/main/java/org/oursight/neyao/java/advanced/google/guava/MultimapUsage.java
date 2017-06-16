package org.oursight.neyao.java.advanced.google.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.oursight.neyao.java.advanced.algorithm.lof.Node;

import java.util.List;

/**
 * Created by yaonengjun on 170506.
 */
public class MultimapUsage {

    public static void main(String[] args) {
        Multimap<String, Node> map = ArrayListMultimap.create();
        Node node1 = new Node("1", null);
        Node node2 = new Node("2", null);
        Node node3 = new Node("3", null);
        map.put("1", node1);
        map.put("1", node2);
        map.put("2", node2);
        map.put("3", node3);

        System.out.println(map.asMap());
        System.out.println();
        System.out.println();

        System.out.println(map.get("1"));
        System.out.println();
        for (String key : map.keySet()) {
            List list = (List) map.get(key);
            System.out.println(key + ": " + list);
        }


    }
}
