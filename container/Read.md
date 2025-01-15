下面是 Java 中不同集合类型的概述及它们对应的类（包括 `List`、`Set`、`Map` 和 `Queue`），以及它们的特点：

### **1. List**
`List` 接口用于存储有序的元素集合，并允许重复元素。`List` 按照插入顺序来存储元素，可以通过索引访问。

- **ArrayList**：
    - 基于动态数组实现。
    - 允许快速的随机访问（通过索引）。
    - 插入和删除操作性能较差，尤其是在中间部分。

  **示例代码**：
  ```java
  List<String> arrayList = new ArrayList<>();
  arrayList.add("apple");
  arrayList.add("banana");
  arrayList.add("cherry");
  System.out.println(arrayList); // 输出: [apple, banana, cherry]
  ```

- **LinkedList**：
    - 基于双向链表实现。
    - 允许快速的插入和删除操作（特别是在列表的头尾）。
    - 相比 `ArrayList`，随机访问元素的性能较差。

  **示例代码**：
  ```java
  List<String> linkedList = new LinkedList<>();
  linkedList.add("apple");
  linkedList.add("banana");
  linkedList.add("cherry");
  System.out.println(linkedList); // 输出: [apple, banana, cherry]
  ```

- **Vector**：
    - 基于动态数组实现。
    - 线程安全，但性能较差，因为每个操作都需要同步。
    - 可以自动扩容，且每次扩容是原大小的两倍。

  **示例代码**：
  ```java
  List<String> vector = new Vector<>();
  vector.add("apple");
  vector.add("banana");
  vector.add("cherry");
  System.out.println(vector); // 输出: [apple, banana, cherry]
  ```

### **2. Set**
`Set` 接口用于存储不包含重复元素的集合。它不保证元素的顺序，除非使用特定实现类（如 `LinkedHashSet`）。

- **HashSet**：
    - 基于哈希表实现。
    - 不保证元素的顺序，性能较高（大多数操作的时间复杂度为 O(1)）。

  **示例代码**：
  ```java
  Set<String> hashSet = new HashSet<>();
  hashSet.add("apple");
  hashSet.add("banana");
  hashSet.add("cherry");
  System.out.println(hashSet); // 输出: [banana, apple, cherry]（顺序不确定）
  ```

- **LinkedHashSet**：
    - 基于哈希表和链表实现，保证元素的插入顺序。
    - 性能稍低于 `HashSet`，但能够维护插入顺序。

  **示例代码**：
  ```java
  Set<String> linkedHashSet = new LinkedHashSet<>();
  linkedHashSet.add("apple");
  linkedHashSet.add("banana");
  linkedHashSet.add("cherry");
  System.out.println(linkedHashSet); // 输出: [apple, banana, cherry]
  ```

- **TreeSet**：
    - 基于红黑树实现。
    - 保证元素的自然顺序或根据提供的比较器排序。
    - 性能较低于 `HashSet` 和 `LinkedHashSet`，插入、删除和查找的时间复杂度为 O(log n)。

  **示例代码**：
  ```java
  Set<String> treeSet = new TreeSet<>();
  treeSet.add("apple");
  treeSet.add("banana");
  treeSet.add("cherry");
  System.out.println(treeSet); // 输出: [apple, banana, cherry]（按字母排序）
  ```

### **3. Map**
`Map` 接口用于存储键值对映射，每个键唯一。值可以重复，但每个键只能映射到一个值。

- **HashMap**：
    - 基于哈希表实现。
    - 不保证元素的顺序，性能较高（大多数操作的时间复杂度为 O(1)）。

  **示例代码**：
  ```java
  Map<String, String> hashMap = new HashMap<>();
  hashMap.put("a", "apple");
  hashMap.put("b", "banana");
  hashMap.put("c", "cherry");
  System.out.println(hashMap); // 输出: {a=apple, b=banana, c=cherry}
  ```

- **TreeMap**：
    - 基于红黑树实现。
    - 键按自然顺序或指定的比较器排序。
    - 插入、删除和查找的时间复杂度为 O(log n)。

  **示例代码**：
  ```java
  Map<String, String> treeMap = new TreeMap<>();
  treeMap.put("a", "apple");
  treeMap.put("b", "banana");
  treeMap.put("c", "cherry");
  System.out.println(treeMap); // 输出: {a=apple, b=banana, c=cherry}（按键排序）
  ```

- **LinkedHashMap**：
    - 基于哈希表和双向链表实现。
    - 保证插入顺序，或者根据访问顺序（通过构造方法指定）。

  **示例代码**：
  ```java
  Map<String, String> linkedHashMap = new LinkedHashMap<>();
  linkedHashMap.put("a", "apple");
  linkedHashMap.put("b", "banana");
  linkedHashMap.put("c", "cherry");
  System.out.println(linkedHashMap); // 输出: {a=apple, b=banana, c=cherry}
  ```

- **Hashtable**：
    - 基于哈希表实现。
    - 线程安全，但性能较差，因为每个操作都需要同步。

  **示例代码**：
  ```java
  Map<String, String> hashtable = new Hashtable<>();
  hashtable.put("a", "apple");
  hashtable.put("b", "banana");
  hashtable.put("c", "cherry");
  System.out.println(hashtable); // 输出: {a=apple, b=banana, c=cherry}
  ```

### **4. Queue**
`Queue` 接口表示队列，按照 FIFO（先进先出）原则处理元素。

- **PriorityQueue**：
    - 基于堆（Heap）实现的优先队列。
    - 元素按优先级排序，而不是按插入顺序。

  **示例代码**：
  ```java
  Queue<Integer> priorityQueue = new PriorityQueue<>();
  priorityQueue.add(3);
  priorityQueue.add(1);
  priorityQueue.add(2);
  System.out.println(priorityQueue); // 输出: [1, 3, 2]（自动按自然顺序排序）
  ```

- **ArrayDeque**：
    - 基于数组实现的双端队列（Deque）。
    - 可以作为栈或队列使用，提供高效的插入和删除操作。

  **示例代码**：
  ```java
  Queue<String> arrayDeque = new ArrayDeque<>();
  arrayDeque.add("apple");
  arrayDeque.add("banana");
  arrayDeque.add("cherry");
  System.out.println(arrayDeque); // 输出: [apple, banana, cherry]
  ```

### 总结：
- **List**：`ArrayList`（基于数组）、`LinkedList`（基于链表）、`Vector`（线程安全）。
- **Set**：`HashSet`（无序）、`LinkedHashSet`（按插入顺序）、`TreeSet`（排序）。
- **Map**：`HashMap`（无序）、`TreeMap`（按键排序）、`LinkedHashMap`（按插入顺序）、`Hashtable`（线程安全）。
- **Queue**：`PriorityQueue`（优先队列）、`ArrayDeque`（双端队列）。

这些集合类型各有不同的用途，选择合适的集合类可以优化应用的性能和可读性。