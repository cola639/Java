package threadState;

public class ThreadWait {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1 is waiting");
                    lock.wait();  // 进入等待状态
                    System.out.println("Thread 1 resumed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2 is notifying thread 1");
                lock.notify();  // 唤醒 thread1
            }
        });

        thread1.start();
        Thread.sleep(500);  // 确保 thread1 先进入等待状态
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
