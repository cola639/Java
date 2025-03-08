package threadCreate;

// extends Thread
public class P1_ByThread extends Thread {
    private Thread t;
    private String threadName;

    P1_ByThread(String name) {
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
        P1_ByThread T1 = new P1_ByThread("Thread-1");
        T1.start();

        P1_ByThread T2 = new P1_ByThread("Thread-2");
        T2.start();
    }
}

