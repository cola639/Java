package Bank_Transfer;

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

