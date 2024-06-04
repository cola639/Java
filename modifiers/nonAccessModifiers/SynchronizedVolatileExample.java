package nonAccessModifiers;

public class SynchronizedVolatileExample {
    // volatile 变量
    private volatile boolean flag = true;

    // synchronized 方法
    public synchronized void synchronizedMethod() {
        System.out.println("Synchronized method called.");
        // 修改 volatile 变量
        flag = false;
    }

    public static void main(String[] args) {
        SynchronizedVolatileExample example = new SynchronizedVolatileExample();
        Thread thread1 = new Thread(() -> {
            while (example.flag) {
                // 循环等待 flag 变为 false
            }
            System.out.println("Flag changed to false.");
        });

        Thread thread2 = new Thread(() -> {
            example.synchronizedMethod();
        });

        thread1.start();
        thread2.start();
    }
}