package runnableVScallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) {
        // 使用传统的匿名内部类实现 Callable
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Callable task is running");
                return 123;
            }
        };

        // 使用 ExecutorService 提交 Callable 任务
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);
        try {
            Integer result = future.get();  // 阻塞，等待结果
            System.out.println("Result from Callable: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
