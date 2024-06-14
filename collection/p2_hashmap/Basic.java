package p2_hashmap;

import java.util.HashMap;

public class Basic {
    /**
     * 存储键值对：HashMap是基于哈希表实现的，用于存储键值对。它允许一个键为null，但不允许有重复键。
     * 无序：HashMap不保证元素的顺序，这意味着它不会记录插入的顺序。
     * 非线程安全：HashMap不是线程安全的，在多线程环境中需要使用同步机制，如Collections.synchronizedMap或ConcurrentHashMap。
     * 效率：HashMap的操作时间复杂度为O(1)，即插入、删除和查找操作在大多数情况下都能在常数时间内完成。
     */
    public static void main(String[] args) {
        // 创建 HashMap 对象
        HashMap<Integer, String> sites = new HashMap<>();

        // 添加键值对
        sites.put(1, "Google");
        sites.put(2, "Runoob");
        sites.put(3, "Taobao");
        sites.put(4, "Zhihu");

        // 输出 HashMap
        System.out.println("HashMap: " + sites);  // 输出: {1=Google, 2=Runoob, 3=Taobao, 4=Zhihu}

        // 访问元素
        String site = sites.get(3);
        System.out.println("Key 3 对应的值: " + site);  // 输出: Taobao

        // 判断是否包含某个键
        boolean containsKey = sites.containsKey(2);
        System.out.println("是否包含键 2: " + containsKey);  // 输出: true

        // 判断是否包含某个值
        boolean containsValue = sites.containsValue("Zhihu");
        System.out.println("是否包含值 Zhihu: " + containsValue);  // 输出: true

        // 删除元素
        sites.remove(4);
        System.out.println("删除键 4 后的 HashMap: " + sites);  // 输出: {1=Google, 2=Runoob, 3=Taobao}

        // 清空 HashMap
        sites.clear();
        System.out.println("清空后的 HashMap: " + sites);  // 输出: {}

        // 添加一些元素用于演示
        sites.put(1, "Google");
        sites.put(2, "Runoob");
        sites.put(3, "Taobao");
        sites.put(4, "Zhihu");

        // 计算大小
        int size = sites.size();
        System.out.println("HashMap 大小: " + size);  // 输出: 4

        // 迭代 HashMap
        System.out.println("迭代 HashMap 中的元素:");
        for (Integer key : sites.keySet()) {
            System.out.println("key: " + key + " value: " + sites.get(key));
        }

        // 输出所有值
        System.out.println("HashMap 中的所有值:");
        for (String value : sites.values()) {
            System.out.println(value);
        }
    }
}