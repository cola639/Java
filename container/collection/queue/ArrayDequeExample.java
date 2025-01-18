package collection.queue;

import java.util.ArrayDeque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        // Create an ArrayDeque
        ArrayDeque<String> deque = new ArrayDeque<>();
        System.out.println("Creating ArrayDeque:");

        // Add elements to the ArrayDeque
        deque.add("Apple");
        deque.add("Banana");
        deque.add("Cherry");
        System.out.println("Initial Deque: " + deque); // Output: [Apple, Banana, Cherry]

        // Insert Operations
        System.out.println("\nInsert Operations:");

        // Add to the front
        deque.addFirst("Grapes");
        System.out.println("After adding Grapes to the front: " + deque); // Output: [Grapes, Apple, Banana, Cherry]

        // Add to the back
        deque.addLast("Mango");
        System.out.println("After adding Mango to the back: " + deque); // Output: [Grapes, Apple, Banana, Cherry, Mango]

        // Get Operations
        System.out.println("\nGet Operations:");

        // Get the first element
        String first = deque.getFirst();
        System.out.println("First element: " + first); // Output: Grapes

        // Get the last element
        String last = deque.getLast();
        System.out.println("Last element: " + last); // Output: Mango

        // Delete Operations
        System.out.println("\nDelete Operations:");

        // Remove the first element
        deque.removeFirst();
        System.out.println("After removing the first element: " + deque); // Output: [Apple, Banana, Cherry, Mango]

        // Remove the last element
        deque.removeLast();
        System.out.println("After removing the last element: " + deque); // Output: [Apple, Banana, Cherry]

        // Remove a specific element
        deque.remove("Banana");
        System.out.println("After removing Banana: " + deque); // Output: [Apple, Cherry]
    }
}
