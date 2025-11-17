import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private int balance = 0;
    Lock lock = new ReentrantLock();

    public void deposit(int amount) {
        lock.lock();
        balance += amount;
        lock.unlock();
    }

    public void withdraw(int amount) {
        lock.lock();
        if (balance < amount) {
            lock.unlock();
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
        lock.unlock();
    }

    public int getBalance() {
        return balance;
    }

    public Lock getLock() {
        return lock;
    }
}
