package map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();
        map.put(5, "Apple");
        map.put(2, "Banana");
        map.put(10, "Cherry");

        System.out.println(map); // 输出：{2=Banana, 5=Apple, 10=Cherry}，按键排序
    }
}

