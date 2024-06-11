package overload;

// overload 方法重载 一个类中
// 重载(overloading) !!!是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同。

// 每个重载的方法（或者构造函数）都必须有一个独一无二的参数类型列表。

// 最常用的地方就是构造器的重载。
public class Main {
    public static void demoMethod(int a) {
        System.out.println("a" + a);
        // some code here
    }

    public static void demoMethod(String b) {
        System.out.println("b" + b);
        // some code here
    }

    public void demoNoStatic(int c) {
        System.out.println("c" + c);
        // some code here
    }

    public static void main(String[] args) {
        demoMethod("Hello"); // 直接调用静态方法
        // Error: demoNoStatic(1L);  // 非静态方法需要先实例化对象
        //  Main demo = new Main();
        //  demo.demoNoStatic(1);

    }
}
