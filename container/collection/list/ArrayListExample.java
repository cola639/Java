package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println(list); // Output：[Apple, Banana, Cherry]
        // ArrayList: Uses dynamic array, fast for random access, not thread-safe.
    }
}
