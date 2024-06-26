import java.util.*;

/**
 * Java集合框架主要由接口、具体类和算法组成：
 * 接口：如 Collection、List、Set、Map 等，定义了数据结构的行为。
 * 具体类：如 ArrayList、LinkedList、HashSet、HashMap 等，实现了接口并提供了具体的功能。
 * 算法：如 Collections 类中的静态方法，提供了对集合进行排序、搜索和修改的算法。
 *
 * 接口与数据结构的关系
 * Collection：根接口，所有集合类的超类。提供了基本的集合操作方法。
 * List：线性列表，元素有序且可重复。
 * ArrayList：基于动态数组实现，适合频繁访问元素的场景。
 * LinkedList：基于双向链表实现，适合频繁插入和删除元素的场景。
 * Set：无序集合，元素不重复。
 * HashSet：基于哈希表实现，不保证顺序。
 * TreeSet：基于红黑树实现，元素按自然顺序或指定比较器排序。
 * Queue：队列，通常用于按FIFO顺序存储元素。
 * LinkedList：也实现了Queue接口，提供队列操作。
 * PriorityQueue：基于堆实现，元素按优先级顺序处理。
 * Map：键值对集合，不属于Collection接口，但与集合框架密切相关。
 * HashMap：基于哈希表实现，键值对无序。
 * TreeMap：基于红黑树实现，键值对按键的自然顺序或指定比较器排序。
 */
//        - Set：无序，不允许重复元素。
//        - List：有序，允许重复元素。
//        - Map：键值对，键唯一，允许值重复。
//        - Queue：先进先出，用于按顺序处理元素。

public class Collection {
    public static void main(String[] args) {
        // 实例化并调用每个示例类的方法
        SetExample setExample = new SetExample();
        setExample.demo();

        ListExample listExample = new ListExample();
        listExample.demo();

        MapExample mapExample = new MapExample();
        mapExample.demo();

        QueueExample queueExample = new QueueExample();
        queueExample.demo();
    }

    // Set 是一种不允许有重复元素的集合。它主要用于需要保证元素唯一性的场景。
    public static class SetExample {
        public void demo() {
            // HashSet 不保证元素的顺序
            Set<String> hashSet = new HashSet<>();
            hashSet.add("Apple");
            hashSet.add("Banana");
            hashSet.add("Orange");
            hashSet.add("Apple"); // 重复元素不会被添加

            System.out.println("HashSet: " + hashSet);

            // LinkedHashSet 保证元素的插入顺序
            Set<String> linkedHashSet = new LinkedHashSet<>();
            linkedHashSet.add("Apple");
            linkedHashSet.add("Banana");
            linkedHashSet.add("Orange");
            linkedHashSet.add("Apple");

            System.out.println("LinkedHashSet: " + linkedHashSet);

            // TreeSet 按照自然顺序排序
            // TreeSet: [Apple, Banana, Orange]
            Set<String> treeSet = new TreeSet<>();
            treeSet.add("Apple");
            treeSet.add("Orange");
            treeSet.add("Banana");
            treeSet.add("Apple");

            System.out.println("TreeSet: " + treeSet);
            System.out.println("-------------------------------------------------------");
        }
    }

    // List 是一种有序的集合，允许包含重复元素。它主要用于需要按特定顺序访问元素的场景。
    public static class ListExample {
        public void demo() {
            // ArrayList 基于动态数组实现
            List<String> arrayList = new ArrayList<>();
            arrayList.add("Apple");
            arrayList.add("Banana");
            arrayList.add("Orange");
            arrayList.add("Apple"); // 允许重复元素

            System.out.println("ArrayList: " + arrayList);

            // LinkedList 基于双向链表实现
            List<String> linkedList = new LinkedList<>();
            linkedList.add("Apple");
            linkedList.add("Banana");
            linkedList.add("Orange");
            linkedList.add("Apple");

            System.out.println("LinkedList: " + linkedList);
            System.out.println("-------------------------------------------------------");
        }
    }

    // Map 是一种键值对的集合，每个键唯一对应一个值。它主要用于需要根据键快速查找值的场景。
    public static class MapExample {
        public void demo() {
            // HashMap 不保证顺序
            Map<String, Integer> hashMap = new HashMap<>();
            hashMap.put("Apple", 1);
            hashMap.put("Banana", 2);
            hashMap.put("Orange", 3);
            hashMap.put("Apple", 4); // 覆盖之前的值

            System.out.println("HashMap: " + hashMap);

            // LinkedHashMap 保证插入顺序
            Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("Apple", 1);
            linkedHashMap.put("Banana", 2);
            linkedHashMap.put("Orange", 3);
            linkedHashMap.put("Apple", 4);

            System.out.println("LinkedHashMap: " + linkedHashMap);

            // TreeMap 按照自然顺序排序
            Map<String, Integer> treeMap = new TreeMap<>();
            treeMap.put("Apple", 1);
            treeMap.put("Banana", 2);
            treeMap.put("Orange", 3);
            treeMap.put("Apple", 4);

            System.out.println("TreeMap: " + treeMap);
            System.out.println("-------------------------------------------------------");
        }
    }

    // Queue 是一种先进先出的集合，用于需要按顺序处理元素的场景。
    public static class QueueExample {
        public void demo() {
            // LinkedList 实现 Queue 接口
            Queue<String> linkedListQueue = new LinkedList<>();
            linkedListQueue.offer("Apple");
            linkedListQueue.offer("Banana");
            linkedListQueue.offer("Orange");

            System.out.println("LinkedList Queue: " + linkedListQueue);
            System.out.println("Poll: " + linkedListQueue.poll()); // 先进先出

            // PriorityQueue 基于优先级堆排序
            Queue<String> priorityQueue = new PriorityQueue<>();
            priorityQueue.offer("Apple");
            priorityQueue.offer("Banana");
            priorityQueue.offer("Orange");

            System.out.println("PriorityQueue: " + priorityQueue);
            System.out.println("Poll: " + priorityQueue.poll()); // 最小元素优先出队
        }
    }
}