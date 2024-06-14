package p1_arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class Basic {
    /**
     * ArrayList 中的元素实际上是对象，在以上实例中，数组列表元素都是字符串 String 类型。
     * 如果我们要存储其他类型，而 <E> 只能为引用数据类型，这时我们就需要使用到基本类型的包装类
     */

    public static void main(String[] args) {
        // Create an instance of the Basic class
        Basic obj = new Basic();

        // Call the addExample method
        obj.addExample();
        obj.getExample();
        obj.setExample();
        obj.removeExample();
        obj.clearExample();
        obj.sortExample();
    }

    /**
     * elements sizes
     */
    public void sizeExample() {
        // Create a new ArrayList of Integer type
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add elements to the ArrayList
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // Print the size of the ArrayList
        System.out.println(numbers.size()); // Output: 3
    }

    /**
     * add elements
     */
    public void addExample() {
        // Create a new ArrayList of Integer type
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add elements to the ArrayList
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // Print the ArrayList
        System.out.println(numbers); // Output: [1, 2, 3]
    }

    /**
     * get elements
     */
    public void getExample() {
        // Create a new ArrayList of Integer type
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add elements to the ArrayList
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // Get the element at index 2
        int element = numbers.get(2);

        // Print the element
        System.out.println(element); // Output: 3
    }

    /**
     * set elements
     */
    public void setExample() {
        // Create a new ArrayList of Integer type
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add elements to the ArrayList
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // Set the element at index 1 to 4
        numbers.set(1, 4);

        // Print the ArrayList
        System.out.println(numbers); // Output: [1, 4, 3]
    }

    /**
     * remove elements
     */
    public void removeExample() {
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Ru noob");
        sites.add("Baobab");
        sites.add("Weibo");
        sites.remove(3); // 删除第四个元素
        System.out.println(sites);
    }

    /**
     * clear elements
     */
    public void clearExample() {
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Ru noob");
        sites.add("Baobab");
        sites.add("Weibo");
        sites.clear();
        System.out.println(sites);
    }

    /**
     * sort arraylist
     */
    public void sortExample() {
        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(33);
        myNumbers.add(15);
        myNumbers.add(20);
        myNumbers.add(34);
        myNumbers.add(8);
        myNumbers.add(12);

        Collections.sort(myNumbers);  // 数字排序

        for (int i : myNumbers) {
            System.out.println(i);
        }

        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Baobab");
        sites.add("Wiki");
        sites.add("Ru noob");
        sites.add("Weibo");
        sites.add("Google");
        Collections.sort(sites);  // 字母排序
        for (String i : sites) {
            System.out.println(i);
        }
    }
}
