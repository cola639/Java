package p4_constructor;

class SuperClass {
    private int n;

    // 默认构造函数 编译器自动生成
    // public SuperClass() {
    // }
    // 没有返回类型 甚至void 不然视为方法
    SuperClass() {
        System.out.println("SuperClass()");
    }

    SuperClass(int n) {
        System.out.println("SuperClass(int n)");
        this.n = n;
    }
}
