`Thread.sleep()` 和 `Object.wait()` 都是用来使线程暂停执行的，但它们的作用、实现方式和使用场景有所不同。下面是这两个方法的详细解释：

### **1. `Thread.sleep()`**

- **类**：`Thread`
- **作用**：使当前正在执行的线程暂停指定的时间（以毫秒为单位），然后继续执行。
- **使用场景**：用于控制线程的延迟，暂停当前线程的执行，但不会释放锁。常用于模拟延迟、定时任务等场景。

#### **用法**：
```java
Thread.sleep(1000);  // 使当前线程暂停 1000 毫秒（即 1 秒）
```

- **注意**：
    - `sleep()` 是 `Thread` 类的静态方法，因此可以直接调用 `Thread.sleep()`，并且它只能使当前线程暂停，不会影响其他线程。
    - `sleep()` 会抛出 `InterruptedException`，如果当前线程在休眠期间被中断，则会抛出该异常。

#### **关键特点**：
- 由 `Thread` 类提供。
- **不会释放锁**：如果当前线程持有某个对象的锁，调用 `sleep()` 不会释放锁，其他线程依然无法访问该锁。
- **不依赖同步机制**：`sleep()` 方法不需要线程同步，也不需要 `synchronized` 块或方法。

### **2. `Object.wait()`**

- **类**：`Object`
- **作用**：使当前线程进入等待状态，直到其他线程调用相同对象的 `notify()` 或 `notifyAll()` 方法唤醒它。
- **使用场景**：常用于线程间的通信，尤其是在生产者-消费者问题中，一个线程可能需要等待另一个线程完成某些任务（如数据准备好之后再继续处理）。

#### **用法**：
```java
synchronized (object) {
    while (condition) {
        object.wait();  // 当前线程进入等待状态
    }
}
```

- **注意**：
    - `wait()` 方法必须在 **同步块或同步方法** 内部调用。因为 `wait()` 方法会释放对象的锁，这样其他线程就可以访问该对象。
    - `wait()` 方法会使线程进入等待队列，直到调用 `notify()` 或 `notifyAll()` 方法，才会从等待状态中恢复。
    - `wait()` 也会抛出 `InterruptedException`，如果线程在等待期间被中断，则会抛出该异常。

#### **关键特点**：
- 由 `Object` 类提供，因此所有 Java 对象都可以调用 `wait()` 方法。
- **会释放锁**：当线程调用 `wait()` 后，它会释放持有的锁，允许其他线程访问这个锁。
- **需要同步机制**：`wait()` 方法只能在同步块（`synchronized`）中使用，确保在等待时不会发生线程安全问题。
- **线程间通信**：通常用于线程间的协调工作，例如生产者-消费者模型。

### **主要区别**：
| 特性                 | **`Thread.sleep()`**                                      | **`Object.wait()`**                                         |
|----------------------|-----------------------------------------------------------|------------------------------------------------------------|
| **所属类**           | `Thread` 类                                               | `Object` 类                                                 |
| **作用**             | 使当前线程暂停指定时间                                    | 使当前线程进入等待状态，直到其他线程调用 `notify()` 唤醒 |
| **释放锁**           | 不释放锁（当前线程持有的锁在休眠期间仍然保持）              | 释放锁，允许其他线程访问锁                                 |
| **使用场景**         | 用于暂停当前线程的执行                                   | 用于线程间通信，通常与 `notify()` 配合使用                 |
| **调用位置**         | 可以在任何地方直接调用                                    | 必须在同步块或同步方法中调用（`synchronized`）             |
| **异常**             | 可能抛出 `InterruptedException`                           | 可能抛出 `InterruptedException`                             |

### 示例：`Thread.sleep()` vs `Object.wait()` 的区别

#### **1. `Thread.sleep()` 示例**：
```java
public class SleepExample {
    public static void main(String[] args) {
        System.out.println("Thread starts");

        try {
            // 当前线程休眠 2 秒
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread ends after sleep");
    }
}
```
**输出**：
```
Thread starts
Thread ends after sleep
```
`Thread.sleep(2000)` 会使当前线程暂停 2 秒钟，然后继续执行后续代码。

#### **2. `Object.wait()` 示例**：
```java
class WaitNotifyExample {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1 starts and is waiting");
                    lock.wait();  // 线程 1 进入等待状态
                    System.out.println("Thread 1 resumed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2 starts and notifying thread 1");
                lock.notify();  // 唤醒线程 1
            }
        });

        thread1.start();
        thread2.start();
    }
}
```
**输出**：
```
Thread 1 starts and is waiting
Thread 2 starts and notifying thread 1
Thread 1 resumed
```

在上面的代码中：
- `Thread 1` 通过 `lock.wait()` 进入等待状态，直到 `Thread 2` 调用 `lock.notify()` 唤醒它。
- `Thread 1` 在等待期间释放了锁，允许 `Thread 2` 执行 `notify()`。

### 总结：
- **`Thread.sleep()`** 是用于让当前线程暂停执行一段时间，它不会释放锁，也不涉及线程间的通信。
- **`Object.wait()`** 是线程间通信的一部分，它可以让线程在持有锁的情况下进入等待状态，并且会释放锁，直到其他线程通知它继续执行。