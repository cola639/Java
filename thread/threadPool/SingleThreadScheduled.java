package threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduled {
    public static void main(String[] args) {
        // 创建一个单线程调度线程池
        java.util.concurrent.ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        // 提交周期性任务，每隔 2 秒执行一次
        executorService.scheduleAtFixedRate(() -> {
            System.out.println("Scheduled task executed by " + Thread.currentThread().getName());
        }, 0, 2, TimeUnit.SECONDS);
    }
}
