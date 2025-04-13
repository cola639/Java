package UnsafeExample;

class Counter {
    public int count = 0;
    void increase() {
        count++;
    }
}

public class ErrorExample {
    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });
        t1.start();
        t2.start();
        t1.join(); // 主线程等待 t1 完成
        t2.join(); // 主线程等待 t2 完成
        System.out.println(counter.count);
    }
}