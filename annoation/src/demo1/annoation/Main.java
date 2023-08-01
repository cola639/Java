package demo1.annoation;

public class Main {
    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        Injector injector = new Injector();
        injector.injectDependencies(someClass); // 传递someClass
        someClass.callDependency();
    }
}

