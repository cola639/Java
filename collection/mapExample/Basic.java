package mapExample;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class Basic {
    public static void main(String[] args) {
        // HashMap Demo
        Map<String, String> hashMap = new HashMap<>();

        hashMap.put("1", "One");
        hashMap.put("2", "Two");
        hashMap.put(null, "NullKey"); // 允许 null 键
        hashMap.put("3", null);      // 允许 null 值

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println(hashMap);
        System.out.println("Key '1': " + hashMap.get("1"));
        //        null -> NullKey
        //        1 -> One
        //        2 -> Two
        //        3 -> null
        //        Key '1': One

        // Hashtable Demo
        Hashtable<String, String> hashtable = new Hashtable<>();

        // 添加元素
        hashtable.put("1", "One");
        hashtable.put("2", "Two");
        // hashtable.put(null, "NullKey"); // 抛出 NullPointerException
        // hashtable.put("3", null);      // 抛出 NullPointerException

        // 遍历
        for (Map.Entry<String, String> entry : hashtable.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 获取元素
        System.out.println("Key '1': " + hashtable.get("1"));
        //        1 -> One
        //        2 -> Two
        //        Key '1': One

        // TreeMap Demo
        TreeMap<String, String> treeMap = new TreeMap<>();

        // 添加元素
        treeMap.put("2", "Two");
        treeMap.put("1", "One");
        treeMap.put("3", "Three");
        // treeMap.put(null, "NullKey"); // 抛出 NullPointerException

        // 遍历
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 获取元素
        System.out.println("Key '1': " + treeMap.get("1"));
        //        1 -> One
        //        2 -> Two
        //        3 -> Three
        //        Key '1': One

    }
}

