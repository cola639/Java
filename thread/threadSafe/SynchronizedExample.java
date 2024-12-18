package threadSafe;

public class SynchronizedExample {
    private static int counter = 0;

    public synchronized static void increment() {  // 使用 synchronized 确保原子性
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                increment();  // 每次调用 increment 都是原子操作
            }
        };

        // 启动多个线程
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final counter value: " + counter);  // 输出 2000
    }
}
