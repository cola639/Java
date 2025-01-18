package collection.queue;

import java.util.ArrayDeque;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Create a PriorityQueue
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        System.out.println("Creating PriorityQueue:");

        // Add elements to the PriorityQueue
        queue.add(30);
        queue.add(10);
        queue.add(20);
        queue.add(40);
        System.out.println("Initial Queue: " + queue); // Output: [10, 30, 20, 40] (Heap order)

        // Insert Operations
        System.out.println("\nInsert Operations:");
        queue.add(15); // Add an element
        System.out.println("After inserting 15: " + queue); // Output: [10, 15, 20, 40, 30]

        // Peek (Retrieve the head element without removing it)
        int head = queue.peek();
        System.out.println("Head element (peek): " + head); // Output: 10

        // Delete Operations
        System.out.println("\nDelete Operations:");

        // Poll (Retrieve and remove the head element)
        int removed = queue.poll();
        System.out.println("After polling (removed head): " + removed); // Output: 10
        System.out.println("Queue after polling: " + queue); // Output: [15, 30, 20, 40]

        // Remove a specific element
        queue.remove(20);
        System.out.println("After removing 20: " + queue); // Output: [15, 30, 40]
    }
}
