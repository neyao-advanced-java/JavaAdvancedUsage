package org.oursight.neyao.java.advanced.algorithm.tree;

/**
 * Created by DellPC on 2017/4/8.
 */
public class MySequentialMap<K, V> {

    public static void main(String[] args) {
        MySequentialMap map = new MySequentialMap();

        map.put("1", "aaa");
        map.put("2", "bbb");
        map.put("3", "ccc");

        System.out.println(map.get("3"));
        System.out.println(map.get("2"));
    }

    private Node first;

//    public SequentialMap() {
//        first = new Node();
//    }

    private class Node {
        Node next;
        K key;
        V value;

        public Node(K k, V v, Node next) {
            this.key = k;
            this.value = v;
            this.next = next;
        }


    }

    public V get(K key) {
        for (Node node = first; node != null; node = node.next) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        for (Node node = first; node != null; node = node.next) {
            if (key.equals(node.key)) {
                node.value = value;
            }
        }

        first = new Node(key, value, first);
    }
}
