package runnableVScallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableWithExceptionExample {
    public static void main(String[] args) {
        // 使用 Lambda 表达式创建一个可能抛出检查异常的 Callable
        Callable<Integer> task = () -> {
            if (true) {
                throw new Exception("An exception occurred");
            }
            return 123;
        };

        // 使用 ExecutorService 提交 Callable 任务
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        try {
            Integer result = future.get();  // 阻塞，等待结果
            System.out.println("Result from Callable: " + result);
        } catch (Exception e) {
            System.err.println("Caught exception: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}
