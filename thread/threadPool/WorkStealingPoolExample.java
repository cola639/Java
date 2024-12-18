package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkStealingPoolExample {
    public static void main(String[] args) {
        // 创建一个具有 4 个线程的工作窃取线程池
        ExecutorService executorService = Executors.newWorkStealingPool(4);

        // 提交任务
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println("Task executed by " + Thread.currentThread().getName());
            });
        }

        // 关闭线程池
        executorService.shutdown();
    }
}
