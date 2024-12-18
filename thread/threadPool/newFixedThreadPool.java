package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class newFixedThreadPool {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 提交任务
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                System.out.println("Task executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);  // 模拟任务执行
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // 关闭线程池
        executorService.shutdown();
    }
}
