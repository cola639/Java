package collection.list;

import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Apple");
        vector.add("Banana");

        System.out.println(vector); // Output：[Apple, Banana]
        // Vector: Uses dynamic array, thread-safe but slower due to synchronization.
    }
}
