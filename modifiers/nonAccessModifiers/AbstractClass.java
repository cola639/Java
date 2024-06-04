package nonAccessModifiers;

// abstract 修饰符
// `abstract` 修饰符用于创建抽象类和抽象方法。抽象类不能被实例化，必须由子类实现抽象方法。
// 抽象类
public abstract class AbstractClass {
    // 抽象方法
    public abstract void abstractMethod();

    // 非抽象方法
    public void concreteMethod() {
        System.out.println("Concrete method in abstract class.");
    }
}

