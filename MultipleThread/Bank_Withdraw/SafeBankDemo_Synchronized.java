package Bank_Withdraw;

public class SafeBankDemo_Synchronized {

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

        public BankAccount(String accountNo, int balance) {
            this.accountNo = accountNo;
            this.balance = balance;
        }

        public synchronized void withdraw(int amount) {
            if (balance >= amount) {
                try {
                    Thread.sleep(100);
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
