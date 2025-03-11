public class Wait {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 1: Holding lock...");
                try {
                    System.out.println("Thread 1: Calling wait()...");
                    lock.wait();  // Wait releases the lock
                    System.out.println("Thread 1: Resumed after wait.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Exiting.");
            }
        });

        Thread thread2 = new Thread(() -> {
            try { Thread.sleep(500); } catch (InterruptedException e) { }
            synchronized (lock) {
                System.out.println("Thread 2: Acquired lock, notifying thread1...");
                lock.notify();  // Notify thread1 to resume
            }
        });

        thread1.start();
        thread2.start();
    }
}
