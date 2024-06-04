package nonAccessModifiers;

public class AbstractExample1 {
    public static void main(String[] args) {
        AbstractExample2 concreteClass = new AbstractExample2();
        concreteClass.abstractMethod();
        concreteClass.concreteMethod();
    }
}
