package collection.list;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayListExample {
    public static void main(String[] args) {
        // 1 ArrayList: Uses dynamic array, fast for random access, not thread-safe.
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println(list); // Output：[Apple, Banana, Cherry]
        list.remove("Banana");
        list.remove(0);
        System.out.println(list); // Output：[Cherry]
        list.set(0, "updatedCherry");
        System.out.println(list); // Output：[updatedCherry]

        // 2 Remove duplicates from ArrayList
        List<String> listWithDuplicates = new ArrayList<>();
        listWithDuplicates.add("Apple");
        listWithDuplicates.add("Banana");
        listWithDuplicates.add("Apple");
        listWithDuplicates.add("Cherry");

        // clone
        List<String> listWithDuplicates2 = new ArrayList<>();
        listWithDuplicates2.add("Apple");
        listWithDuplicates2.add("Banana");
        listWithDuplicates2.add("Apple");
        listWithDuplicates2.add("Cherry");

        // clone
        List<String> listWithDuplicates3 = new ArrayList<>();
        listWithDuplicates3.add("Apple");
        listWithDuplicates3.add("Banana");
        listWithDuplicates3.add("Apple");
        listWithDuplicates3.add("Cherry");

        // 1 stream API
        List<String> listWithoutDuplicates = listWithDuplicates.stream().distinct().collect(Collectors.toList());
        System.out.println(listWithoutDuplicates); // Output：[Apple, Banana, Cherry]
        // 2 for loop
        List<String> listWithoutDuplicates2 = new ArrayList<>();
        for (String fruit : listWithDuplicates2) {
            if (!listWithoutDuplicates2.contains(fruit)) {
                listWithoutDuplicates2.add(fruit);
            }
        }
        // 3 linkedHashSet
        Set<String> set = new LinkedHashSet<>(listWithDuplicates3);
        listWithDuplicates.clear();
        listWithDuplicates.addAll(set);


        // 增强型 for 循环(也叫forEach循环)
        //        for (String item : list) {
        //            System.out.println(item);
        //        }

        // Iterator
        //        Iterator<String> iterator = list.iterator();
        //        while (iterator.hasNext()) {
        //            String item = iterator.next();
        //            System.out.println(item);
        //        }

        //        // Stream API：
        //       list.forEach(item -> System.out.println(item));
    }
}
