package threadCreate;

// implements Runnable
public class P2_ByRunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    P2_ByRunnableDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }


    public static void main(String args[]) {
        P2_ByRunnableDemo R1 = new P2_ByRunnableDemo( "Thread-1");
        R1.start();

        P2_ByRunnableDemo R2 = new P2_ByRunnableDemo( "Thread-2");
        R2.start();
    }
}
