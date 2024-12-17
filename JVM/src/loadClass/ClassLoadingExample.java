package loadClass;

public class ClassLoadingExample {
    // 1. 静态变量
    static String staticVar = "Static Variable";

    // 2. 静态代码块
    static {
        System.out.println("Static Block: Initializing staticVar...");
        staticVar = "Static Variable Initialized";
    }

    // 3. 构造函数
    public ClassLoadingExample() {
        System.out.println("Constructor: Creating an instance of ClassLoadingExample");
    }

    public static void main(String[] args) {
        System.out.println("Main Method: Program starts");

        // 类加载到此处才会发生
        System.out.println("Accessing staticVar: " + ClassLoadingExample.staticVar);

        // 创建类的实例
        new ClassLoadingExample();
    }
}
