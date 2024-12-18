package threadState;

public class ThreadStateLock {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1 starts and is holding the lock");
                    Thread.sleep(2000);  // 模拟线程持有锁一段时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2 starts and is waiting for the lock");
            }
        });

        thread1.start();
        Thread.sleep(500);  // 确保 thread1 先获取锁
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
