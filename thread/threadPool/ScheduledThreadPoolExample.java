package threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        // 创建一个具有 3 个线程的调度线程池
        java.util.concurrent.ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        // 提交一个任务，延迟 2 秒后执行
        executorService.schedule(() -> {
            System.out.println("Scheduled task executed by " + Thread.currentThread().getName());
        }, 2, TimeUnit.SECONDS);

        // 提交周期性任务，每隔 3 秒执行一次
        executorService.scheduleAtFixedRate(() -> {
            System.out.println("Periodic task executed by " + Thread.currentThread().getName());
        }, 0, 3, TimeUnit.SECONDS);
    }
}
