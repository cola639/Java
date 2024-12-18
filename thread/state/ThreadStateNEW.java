package state;

public class ThreadStateNEW {
    public static void main(String[] args) {
        // 创建线程但未启动
        Thread thread = new Thread(() -> System.out.println("Thread is running"));

        System.out.println("Thread state before start: " + thread.getState());  // 输出 NEW

        // 启动线程
        thread.start();
    }
}