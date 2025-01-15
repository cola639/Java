package collection.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // 重复元素，不会添加

        System.out.println(set); // 输出：[Banana, Apple]，无序
    }
}
