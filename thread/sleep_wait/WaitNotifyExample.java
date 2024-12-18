package sleep_wait;

class WaitNotifyExample {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1 starts and is waiting");
                    lock.wait();  // 线程 1 进入等待状态
                    System.out.println("Thread 1 resumed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2 starts and notifying thread 1");
                lock.notify();  // 唤醒线程 1
            }
        });

        thread1.start();
        thread2.start();
    }
}
