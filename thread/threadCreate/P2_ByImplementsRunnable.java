package threadCreate;

public class P2_ByImplementsRunnable implements Runnable {
    private String threadName;

    P2_ByImplementsRunnable(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public static void main(String[] args) {
        Thread T1 = new Thread(new P2_ByImplementsRunnable("Thread-1"));
        Thread T2 = new Thread(new P2_ByImplementsRunnable("Thread-2"));

        T1.start(); // ✅ 直接用 Thread 启动 Runnable
        T2.start();
    }
}
