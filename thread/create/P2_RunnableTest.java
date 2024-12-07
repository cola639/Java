package create;

public class P2_RunnableTest {
    public static void main(String args[]) {
        P2_RunnableDemo R1 = new P2_RunnableDemo( "Thread-1");
        R1.start();

        P2_RunnableDemo R2 = new P2_RunnableDemo( "Thread-2");
        R2.start();
    }
}
