package nonAccessModifiers;

public class StaticExample {
    /**
     * 静态方法是属于类本身的，应该通过类名调用，而不是通过实例调用。
     * 子类可以继承父类的静态方法，且可以通过子类的类名调用继承的静态方法。
     * 尽管通过实例调用静态方法在语法上是允许的，但这是不推荐的用法，因为这违反了静态方法的设计初衷，并且可能导致代码的可读性和维护性下降。
     */
    // `static` 修饰符用于修饰类方法和类变量。静态方法和变量属于类本身，而不是某个具体的对象。
    //  而不会为每个实例单独创建副本
    //  常用于定义共享的配置类、常量或工具类
    // static关键字的使用取决于具体的需求和上下文
    // 静态变量
    public static int staticVar = 42;

    // 静态方法
    public static void staticMethod() {
        System.out.println("Static method called. staticVar = " + staticVar);
    }

    public static void main(String[] args) {
        // 通过类名访问静态变量和方法
        StaticExample.staticVar = 100;
        StaticExample.staticMethod();
    }
}
