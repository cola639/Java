package accessModifiers;

public class Protected {
    // 这是一个protected变量，对同一包内的类和所有子类可见
    protected int protectedVar = 40;

    // 这是一个protected方法，对同一包内的类和所有子类可见
    protected void protectedMethod() {
        System.out.println("Protected Method: " + protectedVar);
    }
}

class Subclass extends Protected {
    public void accessProtectedMethod() {
        // 可以访问父类的protected成员
        protectedMethod();
    }

    public static void main(String[] args) {
        Subclass subclass = new Subclass();
        subclass.accessProtectedMethod(); // 访问受保护的方法
    }
}