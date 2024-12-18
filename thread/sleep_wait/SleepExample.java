package sleep_wait;

public class SleepExample {
    public static void main(String[] args) {
        System.out.println("Thread starts");

        try {
            // 当前线程休眠 2 秒
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread ends after sleep");
    }
}
