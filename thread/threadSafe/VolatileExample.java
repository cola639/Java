package threadSafe;

public class VolatileExample {
    private static volatile boolean flag = false;  // 使用 volatile 确保可见性

    public static void main(String[] args) throws InterruptedException {
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);  // 模拟一些工作
                flag = true;  // 设置 flag 为 true
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread readerThread = new Thread(() -> {
            while (!flag) {  // 线程一直等待，直到 flag 为 true
                // 等待 flag 的值变为 true
            }
            System.out.println("Flag is true, exiting...");
        });

        writerThread.start();
        readerThread.start();

        writerThread.join();
        readerThread.join();
    }
}
