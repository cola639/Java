package Bank_Withdraw;

// 模拟 2 个线程同时对同一个银行账户进行转账（存款 + 取款），展示并发情况下的数据安全问题，并提供解决方案。
// 不应该都成功
public class UnsafeBankDemo {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456", 1000);

        // 启动两个线程同时转账
        Thread t1 = new Thread(() -> account.withdraw(800), "👨 Thread-1");
        Thread t2 = new Thread(() -> account.withdraw(800), "👩 Thread-2");

        t1.start();
        t2.start();
    }

    static class BankAccount {
        private String accountNo;
        private int balance; // 非线程安全字段

        public BankAccount(String accountNo, int balance) {
            this.accountNo = accountNo;
            this.balance = balance;
        }

        public void withdraw(int amount) {
            if (balance >= amount) {
                try {
                    Thread.sleep(100); // 模拟网络延迟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " 提现成功，剩余余额：" + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " 提现失败，余额不足！");
            }
        }
    }
}
