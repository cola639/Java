package oop_polymorphism;

// 父类 Animal
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// 子类 Dog 继承 Animal
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

// 子类 Cat 继承 Animal
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        // 多态：父类引用指向子类对象
        Animal animal = new Dog();
        animal.makeSound(); // 输出: Dog barks

        animal = new Cat();
        animal.makeSound(); // 输出: Cat meows
    }
}
