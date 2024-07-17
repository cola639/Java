package nonAccessModifiers;

//  final 类不能被继承
//  1 `final` 修饰符用于修饰类、方法和变量。`final` 修饰的类不能被继承，修饰的方法不能被子类重写，修饰的变量是常量且不可修改。
//  2 不可变性：`final`字段一旦被赋值（通常在构造函数中），在对象的生命周期内就不能被修改。
//  3 线程安全：由于`final`字段在赋值后不可变，因此在多线程环境中，可以保证这些字段的安全性，避免了竞态条件。
public final class FinalExample1 {
    // final 变量是常量，不可修改
    public final int finalVar = 10;

    // final 方法不能被子类重写
    public final void finalMethod() {
        System.out.println("Final method called. finalVar = " + finalVar);
    }
}

// 下面的代码会导致编译错误，因为 FinalClass 不能被继承
// class SubClass extends FinalExample1 {}

