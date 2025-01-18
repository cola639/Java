package threadCreate;

public class P2_RunnableTest {
    public static void main(String args[]) {
        P2_ByRunnableDemo R1 = new P2_ByRunnableDemo( "Thread-1");
        R1.start();

        P2_ByRunnableDemo R2 = new P2_ByRunnableDemo( "Thread-2");
        R2.start();
    }
}
