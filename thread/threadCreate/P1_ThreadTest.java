package threadCreate;

public class P1_ThreadTest {

    public static void main(String args[]) {
        P1_ByThread T1 = new P1_ByThread("Thread-1");
        T1.start();

        P1_ByThread T2 = new P1_ByThread("Thread-2");
        T2.start();
    }
}
