package threadSafe;

public class HappensBeforeExample {
    private static int a = 0;
    private static int b = 0;

    public synchronized static void write() {
        a = 1;  // 写入 a
        b = 2;  // 写入 b
    }

    public synchronized static void read() {
        if (b == 2) {
            System.out.println("b is 2");
            if (a == 1) {
                System.out.println("a is 1");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread writerThread = new Thread(() -> {
            write();  // 写入操作
        });

        Thread readerThread = new Thread(() -> {
            read();  // 读取操作
        });

        writerThread.start();
        readerThread.start();

        writerThread.join();
        readerThread.join();
    }
}
