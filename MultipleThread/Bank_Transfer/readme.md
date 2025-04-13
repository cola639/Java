### ✅ `SafeTransferDemo.java`（**线程安全版本**）
### ❌ `UnSafeTransferDemo.java`（**线程不安全版本**）

---

## ✅ SafeTransferDemo.java（线程安全版本）

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeTransferDemo {

    public static void main(String[] args) {
        Account a = new Account("A", 1000);
        Account b = new Account("B", 1000);

        TransferTask task1 = new TransferTask(a, b, 100);
        TransferTask task2 = new TransferTask(b, a, 200);

        for (int i = 0; i < 5; i++) {
            new Thread(task1, "💸T-A->B-" + i).start();
            new Thread(task2, "💸T-B->A-" + i).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n✅ 最终余额：");
        System.out.println("账户 A：" + a.getBalance());
        System.out.println("账户 B：" + b.getBalance());
    }

    static class Account {
        private final String name;
        private int balance;
        private final Lock lock = new ReentrantLock(); // ✅ 加锁机制

        public Account(String name, int balance) {
            this.name = name;
            this.balance = balance;
        }

        public boolean withdraw(int amount) {
            if (balance >= amount) {
                balance -= amount;
                return true;
            } else {
                return false;
            }
        }

        public void deposit(int amount) {
            balance += amount;
        }

        public Lock getLock() {
            return lock;
        }

        public String getName() {
            return name;
        }

        public int getBalance() {
            return balance;
        }
    }

    static class TransferTask implements Runnable {
        private final Account from;
        private final Account to;
        private final int amount;

        public TransferTask(Account from, Account to, int amount) {
            this.from = from;
            this.to = to;
            this.amount = amount;
        }

        @Override
        public void run() {
            while (true) {
                if (transfer(from, to, amount)) break;
                try {
                    Thread.sleep(10); // 重试等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private boolean transfer(Account from, Account to, int amount) {
            // ✅ 固定加锁顺序，避免死锁
            Account first = from.getName().compareTo(to.getName()) < 0 ? from : to;
            Account second = from.getName().compareTo(to.getName()) < 0 ? to : from;

            boolean gotFirst = false, gotSecond = false;

            try {
                gotFirst = first.getLock().tryLock();
                gotSecond = second.getLock().tryLock();

                if (gotFirst && gotSecond) {
                    if (from.withdraw(amount)) {
                        to.deposit(amount);
                        System.out.printf("[%s] ✅ %s → %s 成功 %d 元，A: %d, B: %d\n",
                                Thread.currentThread().getName(), from.getName(), to.getName(),
                                amount, from.getBalance(), to.getBalance());
                        return true;
                    } else {
                        System.out.printf("[%s] ❌ %s 余额不足，转账失败\n",
                                Thread.currentThread().getName(), from.getName());
                        return true;
                    }
                }
            } finally {
                if (gotFirst) first.getLock().unlock();
                if (gotSecond) second.getLock().unlock();
            }

            return false;
        }
    }
}
```

---

## ❌ UnSafeTransferDemo.java（线程不安全版本）

```java
public class UnSafeTransferDemo {

    public static void main(String[] args) {
        Account a = new Account("A", 1000);
        Account b = new Account("B", 1000);

        TransferTask task1 = new TransferTask(a, b, 100);
        TransferTask task2 = new TransferTask(b, a, 200);

        for (int i = 0; i < 5; i++) {
            new Thread(task1, "💸T-A->B-" + i).start();
            new Thread(task2, "💸T-B->A-" + i).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n❌ 最终余额（不安全，可能错乱）：");
        System.out.println("账户 A：" + a.getBalance());
        System.out.println("账户 B：" + b.getBalance());
    }

    static class Account {
        private final String name;
        private int balance; // ❌ 没加锁，线程不安全

        public Account(String name, int balance) {
            this.name = name;
            this.balance = balance;
        }

        public boolean withdraw(int amount) {
            if (balance >= amount) {
                try {
                    Thread.sleep(50); // ❗ 模拟网络延迟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance -= amount;
                return true;
            }
            return false;
        }

        public void deposit(int amount) {
            balance += amount;
        }

        public String getName() {
            return name;
        }

        public int getBalance() {
            return balance;
        }
    }

    static class TransferTask implements Runnable {
        private final Account from;
        private final Account to;
        private final int amount;

        public TransferTask(Account from, Account to, int amount) {
            this.from = from;
            this.to = to;
            this.amount = amount;
        }

        @Override
        public void run() {
            if (from.withdraw(amount)) {
                to.deposit(amount);
                System.out.printf("[%s] ✅ %s → %s 转账成功 %d 元\n",
                        Thread.currentThread().getName(), from.getName(), to.getName(), amount);
            } else {
                System.out.printf("[%s] ❌ %s 余额不足，转账失败\n",
                        Thread.currentThread().getName(), from.getName());
            }
        }
    }
}
```

---

## 🧠 关键区别说明汇总

| 项目             | `SafeTransferDemo`（✅） | `UnSafeTransferDemo`（❌）         |
|------------------|--------------------------|------------------------------------|
| 是否加锁         | 使用 `ReentrantLock`     | 没有加锁，完全暴露数据             |
| 加锁顺序控制     | 固定字典序，防止死锁     | 无序访问，存在并发和死锁风险       |
| 支持重试         | 有重试机制，失败可继续   | 无重试机制                         |
| 多线程安全       | 是                        | 否（会出现数据错乱/余额异常）      |
| 可预测输出       | 是                        | 否（可能输出负数余额或重复转账）   |

---
