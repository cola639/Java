下面是关于 **封装**（Encapsulation）、**继承**（Inheritance）、**多态**（Polymorphism）和 **抽象**（Abstraction）的具体示例，帮助你理解这些面向对象编程的基本概念。

### 1. **封装 (Encapsulation)**

封装是指将对象的内部状态隐藏起来，只通过公共的方法（getter 和 setter）来访问和修改数据。这种做法提高了安全性，因为它限制了直接访问对象的内部状态，提供了控制和验证的机会。

#### 示例：

```java
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
```

在这个例子中，`Person` 类的 `name` 和 `age` 属性是私有的，不能直接访问。通过 `getName`、`setName`、`getAge` 和 `setAge` 方法进行访问和修改，这就是封装的体现。

---

### 2. **继承 (Inheritance)**

继承是创建新类的一种方式，新类基于已有的类并继承其属性和方法。通过继承，可以重用父类的代码，减少代码重复，并且可以在子类中增加新的功能。

#### 示例：

```java
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
```

在这个例子中，`Dog` 类继承了 `Animal` 类，并重写了 `makeSound` 方法。这使得我们能够在 `Dog` 类中定义特有的行为，同时保留了从 `Animal` 类继承的其他功能。

---

### 3. **多态 (Polymorphism)**

多态是指同一个方法调用在不同对象上表现出不同的行为。多态通常通过方法重载和方法重写来实现，使得代码更加灵活和可扩展。

#### 示例：

```java
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
```

在这个例子中，我们用父类 `Animal` 的引用来指向 `Dog` 或 `Cat` 对象。这就是多态，通过同一个父类引用，不同的子类实现了不同的行为（`makeSound` 的实现）。

---

### 4. **抽象 (Abstraction)**

抽象是指通过定义抽象类和抽象方法来提取对象的共性特征和行为，而不关心具体实现。抽象类不能被实例化，必须由子类来实现其抽象方法。

#### 示例：

```java
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
```

在这个例子中，`Animal` 是一个抽象类，定义了一个抽象方法 `makeSound`。子类 `Dog` 必须实现这个方法。抽象类的目的是提供一个公共的接口，并让具体的子类来实现具体的行为。

---

### 总结：

- **封装**：隐藏对象的内部实现，通过方法提供访问。
- **继承**：从一个现有的类创建新类，重用现有的代码。
- **多态**：同一个方法在不同对象中表现出不同的行为。
- **抽象**：通过定义抽象类和抽象方法来提取共性，只提供接口，让子类来实现具体的行为。

这些概念是面向对象编程（OOP）的四大基本特征，帮助我们编写更结构化、易维护、可扩展的代码。