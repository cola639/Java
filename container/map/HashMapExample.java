package map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(null, "Cherry");

        System.out.println(map); // Output：{null=Cherry, 1=Apple, 2=Banana}，无序
    }
}
