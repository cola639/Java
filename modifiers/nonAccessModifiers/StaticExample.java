package nonAccessModifiers;

public class StaticExample {
    // `static` 修饰符用于修饰类方法和类变量。静态方法和变量属于类本身，而不是某个具体的对象。
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
