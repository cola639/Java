package example;

public class BankThreadTest {
    public static final int DELAY = 10;
    public static final int STEPS = 100;
    public static final int MAX_AMOUNT = 1000;

    public static void main(String[] args){
        Bank bank = new Bank(4, 100000);
        Runnable task1 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = Math.random() * MAX_AMOUNT;
                    bank.transfer(0, 1, amount);
                    Thread.sleep((int) (Math.random() * DELAY));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable task2 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = Math.random() * MAX_AMOUNT;
                    bank.transfer(2, 3, amount);
                    Thread.sleep((int) (Math.random() * DELAY));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }
}
