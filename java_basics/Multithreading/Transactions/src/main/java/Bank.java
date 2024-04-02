import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {

    private final Map<String, Account> accounts = new LinkedHashMap<>();
    private final List<Account> blockedAccounts = new ArrayList<>();
    private final Random random = new Random();
    private final int accNumberCounter;
    public volatile boolean wait = true;

    public Bank(int numberOfAccounts) {
        accNumberCounter = numberOfAccounts;
        for (int i = 1; i <= numberOfAccounts; i++) {
            Account newAcc = new Account(String.valueOf(i));
            accounts.put(newAcc.getAccNumber(), newAcc);
        }
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        wait = false;
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws Exception {
            Account from = accounts.get(fromAccountNum);
            Account to = accounts.get(toAccountNum);
            if (!isMoneyEnough(from, amount)) {
                throw new IndexOutOfBoundsException("Недостаточно средств для преревода пользователю "
                        + to
                        + " "
                        +amount
                        + " руб.");
            }
            if (blockedAccounts.contains(from) || blockedAccounts.contains(to)) {
                throw new SecurityException("Аккаунт отправителя/получателя заблокирован. Операция отменена.");
            }
            if (amount > 50_000 && isFraud(fromAccountNum, toAccountNum, amount)) {
                synchronized (from.getMoney() - to.getMoney() > 0 ? to : from) {
                    from.setMoney(from.getMoney() - amount);
                    to.setMoney(to.getMoney() + amount);
                }
            } else if (amount < 50_000) {
                synchronized (from.getMoney() - to.getMoney() > 0 ? to : from) {
                    from.setMoney(from.getMoney() - amount);
                    to.setMoney(to.getMoney() + amount);
                }
            } else {
                synchronized (from.getMoney() - to.getMoney() > 0 ? to : from) {
                    accounts.remove(fromAccountNum);
                    accounts.remove(toAccountNum);
                    blockedAccounts.add(from);
                    blockedAccounts.add(to);
                }
            }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }
    public String getRandomAccNum() {
        String randomAccNum = String.valueOf(Math.round(Math.random() * accNumberCounter));
        while (accounts.get(randomAccNum) == null) {
            randomAccNum = String.valueOf(Math.round(Math.random() * accNumberCounter));
        }
        return randomAccNum;
    }

    public long getSumAllAccounts() {
        AtomicLong accSum = new AtomicLong();
        Iterator<Account> iterator = accounts.values().iterator();
        iterator.forEachRemaining(account -> {
            accSum.addAndGet(account.getMoney());
        });
        if (blockedAccounts.size() > 0) {
            blockedAccounts.forEach(a -> accSum.addAndGet(a.getMoney()));
        }
        return accSum.longValue();
    }

    public String getAllAccNumbers() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry : accounts.entrySet()) {
            stringBuilder.append(entry.getKey().toString()).append('\n');
        }
        return stringBuilder.toString();
    }
    public boolean isMoneyEnough(Account from, long amount) {
        return from.getMoney() - amount >= 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        accounts.values().forEach(a -> stringBuilder.append(a.toString()));
        if (blockedAccounts.size() != 0) {
            stringBuilder.append("\n ----Заблокированные аккаунты---- \n");
            blockedAccounts.forEach(a -> stringBuilder.append(a.toString()));
        }
        return stringBuilder.toString();
    }
}
