package parentDelegation;

public class Test {
    public static void main(String[] args) {
        // Bootstrap ClassLoader 加载的核心类
        String str = "Hello, JVM!";
        // Parent delegation ClassLoader 加载的类
        System.out.println("String from java.lang.String: " + str);

        // 自定义类加载器加载的类
        MyString myString = new MyString();
        myString.print();
    }
}
