package oop_encapsulation;

class Person {
    private String name; // 私有属性，不允许外部直接访问
    private int age;     // 私有属性

    // 公共的 getter 和 setter 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) { // 控制年龄不为负数
            this.age = age;
        } else {
            System.out.println("Age cannot be negative.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("John");
        person.setAge(25);
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}
