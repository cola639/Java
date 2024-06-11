package override1;

//  override 方法重写   子类重写父类

//        (1)方法重载是一个类中定义了多个方法名相同,而他们的参数的数量不同或数量相同而类型和次序不同,则称为方法的重载(Overload)。
//        (2)方法重写是在子类存在方法与父类的方法的名字相同,而且参数的个数与类型一样,返回值也一样的方法,就称为重写(Override)。
//        (3)方法重载是一个类的多态性表现,而方法重写是子类与父类的一种多态性表现。

public class Main {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Dog();

        a.move();
        b.move();
        // Error b.bark();
    }
}


