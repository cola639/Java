package threadCreate;

// 继承 Thread
public class P1_ByExtendThread extends Thread {
    private String threadName;

    // 构造方法
    public P1_ByExtendThread(String name) {
        super(name); // 传递线程名
        this.threadName = name;
        System.out.println("Creating " + threadName);
    }

    // 重写 run() 方法
    @Override
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

    // 主方法
    public static void main(String[] args) {
        // 创建线程实例
        P1_ByExtendThread T1 = new P1_ByExtendThread("Thread-1");
        P1_ByExtendThread T2 = new P1_ByExtendThread("Thread-2");

        // 启动线程
        T1.start();
        T2.start();
    }
}
