package demo1.annoation;

public class SomeClass {
    @SuppressWarnings("unused") // 省略警告
    @MyAutowired
    private SomeDependency someDependency;

    public void callDependency() {
        someDependency.sayHello();
    }
}

