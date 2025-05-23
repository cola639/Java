package nonAccessModifiers;

public class StaticExample {
    /**
     * 1 static修饰的变量并不一定是常量 static关键字在Java中表示该变量属于类级别 而不是实例级别
     *   这意味着无论创建了多少个类的实例 静态变量在内存中只有一个副本 所有实例共享这个变量
     * 2 静态方法是属于类本身的，应该通过类名调用，而不是通过实例调用。
     *   子类可以继承父类的静态方法，且可以通过子类的类名调用继承的静态方法。
     * 3 尽管通过实例调用静态方法在语法上是允许的，但这是不推荐的用法，因为这违反了静态方法的设计初衷，并且可能导致代码的可读性和维护性下降。
     */
    // `static` 修饰符用于修饰类方法和类变量。静态方法和变量属于类本身，而不是某个实例的对象。
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
