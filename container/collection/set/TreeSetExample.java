package collection.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(2);
        set.add(10);

        System.out.println(set); // 输出：[2, 5, 10]，自然顺序
    }
}
