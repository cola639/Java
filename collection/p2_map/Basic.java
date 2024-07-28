package p2_map;

import java.util.HashMap;
import java.util.Map;

public class Basic {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        // 插入键值对
        map.put("key1", "value1");
        map.put("key2", "value2");
        // 重复的值
        map.put("key3", "value1");

        System.out.println("Map内容: " + map);

        // 尝试插入重复的键
        map.put("key1", "value3");  // 这将覆盖键 "key1" 的原值

        System.out.println("插入重复键后的Map内容: " + map);
    }
}

