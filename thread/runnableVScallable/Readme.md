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


这是一种 **匿名内部类（Anonymous Inner Class）** 的写法，它允许你 **不显式定义一个类，而是在 `new` 语句中直接实现接口或继承类**。

---

## **📌 1. 这段代码的解析**
```java
Runnable task = new Runnable() { // 创建匿名内部类
    @Override
    public void run() {
        System.out.println("Runnable task is running");
    }
};
```
- `Runnable` 是 **一个接口**，不能直接实例化，但可以使用 **匿名内部类** 来实现它。
- `new Runnable()` **不是创建 `Runnable` 的实例，而是创建 `Runnable` 的匿名子类，并实现 `run()` 方法**。
- 这个写法相当于创建了一个 **继承 `Runnable` 接口的匿名类**，并**立刻实例化它**。

---

## **📌 2. 等价于下面的普通类写法**
如果不使用匿名内部类，等价于：
```java
// 定义一个类实现 Runnable 接口
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable task is running");
    }
}

public class Main {
    public static void main(String[] args) {
        Runnable task = new MyRunnable(); // 创建 MyRunnable 实例
        task.run(); // 执行任务
    }
}
```
📌 **区别**
1. **匿名内部类方式**
    - 代码更简洁，不需要额外定义一个 `MyRunnable` 类。
    - 适用于**只用一次**的场景（如多线程）。

2. **普通类方式**
    - **可复用**，如果 `Runnable` 逻辑较复杂，推荐定义为独立类。

---

## **📌 3. `new Runnable()` 为什么能写？**
**正常情况下，接口不能直接实例化**，但**匿名内部类可以**：
```java
Runnable task = new Runnable() {  // 创建了一个实现 Runnable 的匿名内部类
    @Override
    public void run() {
        System.out.println("Running");
    }
};
```
等价于：
```java
class AnonymousRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Running");
    }
}
Runnable task = new AnonymousRunnable();
```
这里 `new Runnable() {}` **实际上创建了一个 `Runnable` 的匿名子类实例**。

---

## **📌 4. 在 Java 8 及以上，推荐用 Lambda**
Java 8 之后，`Runnable` 是一个 **函数式接口（只有一个抽象方法）**，所以可以用 **Lambda 表达式** 简化：
```java
Runnable task = () -> System.out.println("Runnable task is running");
```
📌 **Lambda 表达式的好处**
- 代码更简洁，不需要 `new Runnable()` 和 `@Override`
- 语法更现代化，适合函数式编程

---

## **📌 5. 什么时候用匿名内部类？**
✅ 适用于 **只需要使用一次的类**
✅ 适用于 **回调函数、事件监听、多线程**
❌ 如果 **代码太长，建议用独立类，提高可读性**

---

## **📌 6. 总结**
| **方式** | **特点** | **示例** |
|---------|---------|---------|
| **普通类** | 适合复杂、可复用的逻辑 | `class MyRunnable implements Runnable` |
| **匿名内部类** | 适合**一次性使用**，简化代码 | `new Runnable() { ... }` |
| **Lambda 表达式（Java 8+）** | **最简洁的写法**，推荐使用 | `Runnable task = () -> { ... };` |

---

## **🚀 最佳实践**
✔ **如果 `Runnable` 逻辑很复杂**，用 **独立类**  
✔ **如果 `Runnable` 只用一次**，用 **匿名内部类**  
✔ **如果是 Java 8+**，**优先使用 Lambda 表达式** 🎯