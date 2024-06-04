package accessModifiers;

// 这是一个默认访问级别的类，只能在同一包内访问
public class Default {
    // 这是一个默认访问级别的变量
    int defaultVar = 10;

    // 这是一个默认访问级别的方法
    void defaultMethod() {
        System.out.println("Default Method: " + defaultVar);
    }
}
