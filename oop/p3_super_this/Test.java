package p3_super_this;

public class Test {
    public static void main(String[] args) {
        P1ParentAnimal a = new P1ParentAnimal();
        a.eat();

        P1ChildDog d = new P1ChildDog();
        d.eatTest();
    }
}
