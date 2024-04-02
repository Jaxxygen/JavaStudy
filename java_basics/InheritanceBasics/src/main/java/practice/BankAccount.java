package practice;

public class BankAccount {
  private double balance = 0.0;

  public double getAmount() {
    //TODO: реализуйте метод и удалите todo
    // верните значение количества денег не счету
    return balance;
  }

  public void put(double amountToPut) {
    //TODO: реализуйте метод и удалите todo
    // метод зачисляет деньги на счет
    if (amountToPut >= 0) {
      balance = balance + amountToPut;
    }
  }

  public void take(double amountToTake) {
    //TODO: реализуйте метод и удалите todo
    // метод списывает деньги со счета
    if (amountToTake <= balance) {
      balance = balance - amountToTake;
    }
  }
}
