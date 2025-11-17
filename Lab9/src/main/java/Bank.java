import java.util.concurrent.locks.Lock;

public class Bank {
    public void transfer(Account from, Account to, int amount) {
        if (from.equals(to)) {
            throw new IllegalArgumentException("Sender can not be equal to receiver");
        }

        Lock fromLock = from.getLock();
        Lock toLock = to.getLock();

        Lock first, second;
        if (from.hashCode() > to.hashCode()) {
            first = fromLock;
            second = toLock;
        } else {
            first = toLock;
            second = fromLock;
        }

        first.lock();
        second.lock();
        try {
            from.withdraw(amount);
            to.deposit(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            first.unlock();
            second.unlock();
        }
    }
}
