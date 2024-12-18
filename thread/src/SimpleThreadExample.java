package src;

public class SimpleThreadExample {
    public static void main(String[] args) {
        // 创建第一个线程，用于打印偶数
        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10; i += 2) {
                    System.out.println("偶数：" + i);
                    try {
                        Thread.sleep(500); // 线程休眠500毫秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 创建第二个线程，用于打印奇数
        Thread oddThread = new Thread(new Runnable() {
             @Override
            public void run() {
                for (int i = 1; i <= 9; i += 2) {
                    System.out.println("奇数：" + i);
                    try {
                        Thread.sleep(500); // 线程休眠500毫秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 启动两个线程
        evenThread.start();
        oddThread.start();
    }
}
