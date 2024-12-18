我理解了，你希望我提供的代码能够实际运行并解释线程的不同状态。让我们通过逐步的代码示例来观察线程的不同状态，并确保它们能正确运行。

我将结合实际代码和注释来帮助你理解每个状态的转换。

### 1. **NEW 状态：线程创建但未启动**

当线程被创建但没有调用 `start()` 方法时，它处于 **NEW** 状态。

#### **代码示例：NEW 状态**

```java
public class ThreadStateExample {
    public static void main(String[] args) {
        // 创建线程但未启动
        Thread thread = new Thread(() -> System.out.println("Thread is running"));
        
        System.out.println("Thread threadState before start: " + thread.getState());  // 输出 NEW
        
        // 启动线程
        thread.start();
    }
}
```

**输出**：
```
Thread threadState before start: NEW
Thread is running
```

在这段代码中，线程创建后未启动时，它处于 `NEW` 状态。

### 2. **RUNNABLE 状态：线程准备就绪且可以运行**

线程被 `start()` 方法启动后，它进入 **RUNNABLE** 状态。值得注意的是，线程并不一定立即开始执行，因为它依赖于操作系统的调度，可能还在等待 CPU 时间片。

#### **代码示例：RUNNABLE 状态**

```java
public class ThreadStateExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Thread is running");
        });

        System.out.println("Thread threadState before start: " + thread.getState());  // 输出 NEW
        
        thread.start();
        System.out.println("Thread threadState after start: " + thread.getState());  // 输出 RUNNABLE
        
        thread.join();  // 等待线程执行完毕
    }
}
```

**输出**：
```
Thread threadState before start: NEW
Thread is running
Thread threadState after start: RUNNABLE
```

在这个示例中，线程调用了 `start()` 方法后，它变为 **RUNNABLE** 状态，等待操作系统为它分配 CPU 时间片。

### 3. **BLOCKED 状态：等待获取锁**

当线程试图获取一个已经被其他线程占用的锁时，它会进入 **BLOCKED** 状态。

#### **代码示例：BLOCKED 状态**

```java
public class ThreadStateExample {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1 starts and is holding the lock");
                    Thread.sleep(2000);  // 模拟线程持有锁一段时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2 starts and is waiting for the lock");
            }
        });

        thread1.start();
        Thread.sleep(500);  // 确保 thread1 先获取锁
        thread2.start();
        
        thread1.join();
        thread2.join();
    }
}
```

**输出**：
```
Thread 1 starts and is holding the lock
Thread 2 starts and is waiting for the lock
```

在这个例子中，`thread2` 会进入 **BLOCKED** 状态，因为它正在等待 `thread1` 释放 `lock` 锁。

### 4. **WAITING 状态：等待其他线程的通知**

线程可以通过 `Object.wait()`、`Thread.join()` 或 `Lock.await()` 进入 **WAITING** 状态，直到其他线程通过 `notify()`、`notifyAll()` 或 `interrupt()` 唤醒它。

#### **代码示例：WAITING 状态**

```java
public class ThreadStateExample {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1 is waiting");
                    lock.wait();  // 进入等待状态
                    System.out.println("Thread 1 resumed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2 is notifying thread 1");
                lock.notify();  // 唤醒 thread1
            }
        });

        thread1.start();
        Thread.sleep(500);  // 确保 thread1 先进入等待状态
        thread2.start();
        
        thread1.join();
        thread2.join();
    }
}
```

**输出**：
```
Thread 1 is waiting
Thread 2 is notifying thread 1
Thread 1 resumed
```

在这个例子中，`thread1` 进入 **WAITING** 状态，等待 `thread2` 调用 `lock.notify()` 来唤醒它。

### 5. **TERMINATED 状态：线程执行完毕**

当线程执行完成后，它进入 **TERMINATED** 状态。线程进入 **TERMINATED** 状态后，不能再次启动。

#### **代码示例：TERMINATED 状态**

```java
public class ThreadStateExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Thread is running");
        });

        thread.start();
        thread.join();  // 等待线程完成

        System.out.println("Thread threadState after completion: " + thread.getState());  // 输出 TERMINATED
    }
}
```

**输出**：
```
Thread is running
Thread threadState after completion: TERMINATED
```

在这个例子中，线程 `thread` 在完成执行后进入 **TERMINATED** 状态。

### **总结**

Java 中的线程有五种主要状态，每种状态表示线程生命周期中的不同阶段：

| 状态         | 描述                                             | 示例                                 |
|--------------|--------------------------------------------------|--------------------------------------|
| **NEW**      | 线程已创建，但尚未调用 `start()` 方法。            | `Thread thread = new Thread();`      |
| **RUNNABLE** | 线程已经启动，正在等待操作系统分配 CPU 时间片。   | `thread.start();`                    |
| **BLOCKED**  | 线程试图获取一个已经被其他线程占用的锁。          | `synchronized(lock)`                 |
| **WAITING**  | 线程在等待其他线程的通知或中断。                  | `lock.wait()`                        |
| **TERMINATED**| 线程执行完毕，无法再次启动。                      | `thread.join()`                      |

通过这些状态和方法，我们可以更好地理解线程的生命周期，并且在多线程编程中更加高效地调试和管理线程。