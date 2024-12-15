import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private final ReentrantLock lock = new ReentrantLock();
    private int sharedVariable = 0;

    public void accessVariable() {
        try {
            if (lock.tryLock()) { // Try acquiring the lock
                System.out.println(Thread.currentThread().getName() + " has locked the variable.");
                sharedVariable++;
                System.out.println("Shared variable updated: " + sharedVariable);

                // Simulate lock holding for 10 seconds
                Thread.sleep(10000);
            } else {
                System.out.println(Thread.currentThread().getName() + " cannot access the variable, locked by another thread.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " has released the lock.");
            }
        }
    }

    public static void main(String[] args) {
        LockExample example = new LockExample();

        Runnable task = () -> example.accessVariable();

        // Launch multiple threads
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
