package collection.list;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        // Create a LinkedList
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Creating LinkedList:");
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("Initial List: " + list); // Output: [Apple, Banana, Cherry]

        // Insert Operations
        System.out.println("\nInsert Operations:");

        // 1. Insert at the beginning
        list.add(0, "Grapes"); // At index 0
        System.out.println("After inserting at the beginning: " + list); // Output: [Grapes, Apple, Banana, Cherry]

        // 2. Insert in the middle
        list.add(2, "Orange"); // Insert "Orange" at index 2
        System.out.println("After inserting in the middle: " + list); // Output: [Grapes, Apple, Orange, Banana, Cherry]

        // 3. Insert at the end
        list.add(list.size(), "Mango"); // Index equal to the size adds at the end
        System.out.println("After inserting at the end: " + list); // Output: [Grapes, Apple, Orange, Banana, Cherry, Mango]

        // 4. Insert only if the element doesn't exist
        if (!list.contains("Pineapple")) {
            list.add(3, "Pineapple"); // Insert at index 3
        }
        System.out.println("After inserting conditionally: " + list); // Output: [Grapes, Apple, Orange, Pineapple, Banana, Cherry, Mango]

        // Get Index Operations
        System.out.println("\nGet Index Operations:");

        // 1. Get the index of an element
        int firstIndex = list.indexOf("Banana");
        System.out.println("First index of 'Banana': " + firstIndex); // Output: 4

        // 2. Get the last index of an element (for duplicate elements)
        list.add("Banana"); // Add duplicate element
        int lastIndex = list.lastIndexOf("Banana");
        System.out.println("Last index of 'Banana': " + lastIndex); // Output: 7

        // 3. Get the index of a non-existing element
        int missingIndex = list.indexOf("Orange Juice");
        System.out.println("Index of 'Orange Juice': " + missingIndex); // Output: -1

        // Delete Operations
        System.out.println("\nDelete Operations:");

        // 1. Delete by index
        list.remove(3); // Removes the element at index 3 (Pineapple)
        System.out.println("After deleting element at index 3: " + list); // Output: [Grapes, Apple, Orange, Banana, Cherry, Mango, Banana]

        // 2. Delete by element
        list.remove("Banana"); // Removes the first occurrence of "Banana"
        System.out.println("After deleting 'Banana': " + list); // Output: [Grapes, Apple, Orange, Cherry, Mango, Banana]

        // 3. Delete the first element
        list.removeFirst();
        System.out.println("After deleting the first element: " + list); // Output: [Apple, Orange, Cherry, Mango, Banana]

        // 4. Delete the last element
        list.removeLast();
        System.out.println("After deleting the last element: " + list); // Output: [Apple, Orange, Cherry, Mango]
    }
}
