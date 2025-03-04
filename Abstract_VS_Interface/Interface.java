public interface Interface {
    // 普通接口方法，必须由实现类实现,否则编辑器提示错误
    void method1();

    // 静态方法 只能通过接口来调用
    static void staticMethod() {
        System.out.println("Static method in the interface");
    }
}

