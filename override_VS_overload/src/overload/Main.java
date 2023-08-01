package overload;

public class Main {
    public static void demoMethod(int a) {
        System.out.println("a" + a);
        // some code here
    }

    public static void demoMethod(String b) {
        System.out.println("b" + b);
        // some code here
    }

    public  void demoNoStatic(int c) {
        System.out.println("c" + c);
        // some code here
    }

    public static void main(String[] args) {
        demoMethod("Hello"); // 直接调用静态方法
        // Error: demoNoStatic(1L);
    }
}
