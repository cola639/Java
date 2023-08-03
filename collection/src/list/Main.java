package list;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        strList();
        numList();
        personList();
    }

    // 字符串list
    public static void strList() {
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        System.out.println("list" + list);
    }

    // 数字list
    public static void numList() {
        List<Integer> list  = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("list" + list);
    }

    // 对象List
    public static void personList() {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("John", 20));
        list.add(new Person("Jane", 30));
        System.out.println("list" + list);
    }
}

