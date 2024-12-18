package runnable_callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExample {
    public static void main(String[] args) {
        // 使用匿名内部类实现 Runnable
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable task is running");
            }
        };

        // 使用 ExecutorService 提交 Runnable 任务
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(task);
        executor.shutdown();
    }
}
