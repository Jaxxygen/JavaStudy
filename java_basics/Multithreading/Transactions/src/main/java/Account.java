public class Account {

    private long money;
    private String accNumber;

    public Account(String accNumber) {
        money = 100000;
        this.accNumber = accNumber;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Аккаунт №: ").append(getAccNumber()).append("  |  Баланс: ").append(getMoney()).append('\n');
        return stringBuilder.toString();
    }
}
