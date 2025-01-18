package map;

import java.util.Hashtable;
import java.util.Map;

public class HashtableExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new Hashtable<>();
        map.put(1, "Apple");
        map.put(2, "Banana");

        System.out.println(map); // Output：{1=Apple, 2=Banana}
    }
}
