package Bank_Withdraw;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeBankDemo_ReentrantLock {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456", 1000);

        Thread t1 = new Thread(() -> account.withdraw(800), "👨 Thread-1");
        Thread t2 = new Thread(() -> account.withdraw(800), "👩 Thread-2");

        t1.start();
        t2.start();
    }

    static class BankAccount {
        private String accountNo;
        private int balance;
        private final Lock lock = new ReentrantLock();

        public BankAccount(String accountNo, int balance) {
            this.accountNo = accountNo;
            this.balance = balance;
        }

        public void withdraw(int amount) {
            lock.lock(); // 获取锁
            try {
                if (balance >= amount) {
                    Thread.sleep(100);
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " 提现成功，剩余余额：" + balance);
                } else {
                    System.out.println(Thread.currentThread().getName() + " 提现失败，余额不足！");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(); // 释放锁
            }
        }
    }
}
