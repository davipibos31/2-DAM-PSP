import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }
    public static Lock myLock = new ReentrantLock();
    public void addMoney(int money) {
        myLock.lock();
        balance += money;
        System.out.println("Money added. Current Balance: " + balance);
        myLock.unlock();
    }

    public void takeOutMoney(int money) {
        myLock.lock();
        balance -= money;
        System.out.println("Money taken out. Current Balance: " + balance);
        myLock.unlock();
    }

    @SuppressWarnings("unused")
    public int getBalance() {
        return balance;
    }
}
