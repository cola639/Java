package nonAccessModifiers;

// final 类不能被继承
// `final` 修饰符用于修饰类、方法和变量。`final` 修饰的类不能被继承，修饰的方法不能被子类重写，修饰的变量是常量且不可修改。
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

