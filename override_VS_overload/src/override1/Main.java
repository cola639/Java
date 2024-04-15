package override1;

//  override 方法重写 父类子类之间
public class Main {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Dog();

        a.move();
        b.move();
        // Error b.bark();
    }
}


