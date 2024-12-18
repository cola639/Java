package threadSafe;

public class SynchronizedVisibilityExample2 {
    private static boolean flag = false;  // 非 volatile

    public synchronized static void setFlagTrue() {  // 确保线程间的可见性
        flag = true;
    }

    public synchronized static boolean getFlag() {
        return flag;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                setFlagTrue();  // 设置 flag 为 true
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread readerThread = new Thread(() -> {
            while (!getFlag()) {  // 检查 flag 的值
                // 等待 flag 变为 true
            }
            System.out.println("Flag is true, exiting...");
        });

        writerThread.start();
        readerThread.start();

        writerThread.join();
        readerThread.join();
    }
}
