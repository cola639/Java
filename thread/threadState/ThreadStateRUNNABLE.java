package threadState;

public class ThreadStateRUNNABLE {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Thread is running");
        });

        System.out.println("Thread state before start: " + thread.getState());  // 输出 NEW

        thread.start();
        System.out.println("Thread state after start: " + thread.getState());  // 输出 RUNNABLE

        thread.join();  // 等待线程执行完毕
    }
}