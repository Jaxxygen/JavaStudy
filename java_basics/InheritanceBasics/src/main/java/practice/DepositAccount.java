package practice;

import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;

    @Override
    public void put(double amountToPut) {
        lastIncome = LocalDate.now();
        super.put(amountToPut);
    }

    @Override
    public void take(double amountToTake) {
        LocalDate time = LocalDate.now();
        if (time.minusDays(30).isBefore(lastIncome)) {
            System.out.println("Снятие невозможно, прошло менее 30-ти дней");
        } else {
            super.take(amountToTake);
        }
    }
}
