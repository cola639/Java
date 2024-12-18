package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class newCachedThreadPool {
    public static void main(String[] args) {
        // 创建一个缓存线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

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

