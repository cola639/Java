package accessModifiers;

// private  修饰符在同一类内可见。
public class Private {
    public static void main(String[] args) {
        Private example = new Private();
        example.accessPrivateMethod(); // 通过公共方法访问私有方法
    }

    // 这是一个private变量，只能在此类内访问
    private int privateVar = 20;

    // 这是一个private方法，只能在此类内访问
    private void privateMethod() {
        System.out.println("Private Method: " + privateVar);
    }

    // 公共方法，间接访问private成员
    public void accessPrivateMethod() {
        privateMethod();
    }
}
