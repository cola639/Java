package accessModifiers;

// 这是一个public类，可以被所有类访问
public class Public {
    public static void main(String[] args) {
        Public example = new Public();
        example.publicMethod(); // 直接访问公共方法
    }

    // 这是一个public变量，可以被所有类访问
    public int publicVar = 30;

    // 这是一个public方法，可以被所有类访问
    public void publicMethod() {
        System.out.println("Public Method: " + publicVar);
    }
}
