package p1_list;

public class Person {
    private String name;
    private int age;

    // 在Java中，一个构造方法（或构造函数）的名称必须与其所在的类名称完全相同
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
        this.age = age;
    }

    // constructor, getters and setters...
}
