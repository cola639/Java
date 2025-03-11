public class Sleep {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 1: Holding lock...");
                try {
                    System.out.println("Thread 1: Sleeping for 3 seconds...");
                    Thread.sleep(3000);  // Sleep does NOT release the lock
                    System.out.println("Thread 1: Woke up, still holding lock.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Releasing lock.");
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2: Acquired lock.");
            }
        });

        thread1.start();
        try { Thread.sleep(500); } catch (InterruptedException e) { } // Ensure thread1 starts first
        thread2.start();
    }
}
