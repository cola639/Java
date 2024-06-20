package create;

public class P1_TestThread {

    public static void main(String args[]) {
        P1_ThreadDemo T1 = new P1_ThreadDemo("Thread-1");
        T1.start();

        P1_ThreadDemo T2 = new P1_ThreadDemo("Thread-2");
        T2.start();
    }
}
