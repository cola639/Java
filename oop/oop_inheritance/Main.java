package oop_inheritance;

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

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound(); // 输出: Animal makes a sound

        Dog dog = new Dog();
        dog.makeSound(); // 输出: Dog barks
    }
}
