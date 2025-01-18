下面是 **`Runnable`** 和 **`Callable`** 的两个对应例子：一个是使用传统的匿名内部类实现的，另一个是使用 **Lambda 表达式** 实现的。每个例子都展示了如何提交任务到 **`ExecutorService`** 并获取结果。

### 1. **Runnable 示例 1：使用匿名内部类实现**

```java
package runnableVScallable;

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
```

### 2. **Runnable 示例 2：使用 Lambda 表达式实现**

```java
package runnableVScallable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExample {
    public static void main(String[] args) {
        // 使用 Lambda 表达式实现 Runnable
        Runnable task = () -> System.out.println("Runnable task is running");

        // 使用 ExecutorService 提交 Runnable 任务
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(task);
        executor.shutdown();
    }
}
```

### 3. **Callable 示例 1：使用匿名内部类实现**

```java
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
```

### 4. **Callable 示例 2：使用 Lambda 表达式实现**

```java
package runnableVScallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) {
        // 使用 Lambda 表达式实现 Callable
        Callable<Integer> task = () -> {
            System.out.println("Callable task is running");
            return 123;
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
```

### 5. **Callable 带异常的示例：使用 Lambda 表达式实现**

```java
package runnableVScallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableWithExceptionExample {
    public static void main(String[] args) {
        // 使用 Lambda 表达式创建一个可能抛出检查异常的 Callable
        Callable<Integer> task = () -> {
            // 这里直接抛出异常
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
```

### **对比总结**：
- **Runnable** 适用于不需要返回值的任务。它使用 `run()` 方法执行任务，并且不能抛出检查异常。
- **Callable** 适用于需要返回值或可能抛出检查异常的任务。它使用 `call()` 方法执行任务，并且可以抛出检查异常。
- 在 **JDK 8** 中，`Runnable` 和 `Callable` 都可以通过 **Lambda 表达式** 来简化代码，避免传统的匿名内部类写法。

### 核心区别：
| 特性                   | **Runnable**                             | **Callable**                                  |
|------------------------|------------------------------------------|-----------------------------------------------|
| **返回值**             | 无返回值（`void run()`）                 | 有返回值（`T call()`）                        |
| **异常**               | 不能抛出检查异常（`throws Exception`）   | 可以抛出检查异常（`throws Exception`）       |
| **函数式接口**         | 是（可以使用 Lambda）                   | 是（可以使用 Lambda）                        |
| **常见用途**           | 无需返回值的任务（例如后台任务）         | 需要返回值或者可能抛出异常的任务（例如计算任务）|

这两个例子展示了如何在 **JDK 8** 中使用 **Lambda 表达式** 和 **匿名内部类** 来实现 `Runnable` 和 `Callable`，并通过 `ExecutorService` 提交任务。