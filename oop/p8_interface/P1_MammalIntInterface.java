package p8_interface;

/** 文件名 : MammalInt.java */
public class P1_MammalIntInterface implements P1_AnimalInterface {

    public void eat() {
        System.out.println("Mammal eats");
    }

    public void travel() {
        System.out.println("Mammal travels");
    }

    public int noOfLegs() {
        return 0;
    }

    public static void main(String args[]) {
        P1_MammalIntInterface m = new P1_MammalIntInterface();
        m.eat();
        m.travel();
    }
}
