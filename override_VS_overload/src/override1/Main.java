package override1;
public class Main {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Dog();

        a.move();
        b.move();
        // Error b.bark();
    }
}


