package oop_abstraction;

// 抽象类 Animal
abstract class Animal {
    // 抽象方法：子类必须实现这个方法
    public abstract void makeSound();

    // 普通方法：可以被子类继承
    public void eat() {
        System.out.println("Animal eats food");
    }
}

// 子类 Dog 继承 Animal 并实现 makeSound 方法
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        // Animal animal = new Animal(); // 错误，不能实例化抽象类
        Dog dog = new Dog();
        dog.makeSound(); // 输出: Dog barks
        dog.eat(); // 输出: Animal eats food
    }
}
