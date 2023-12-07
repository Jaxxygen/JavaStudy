public class Manager implements Employee {

    protected String name;
    protected double salary;
    protected double moneyEarned;

    protected Manager() {
        NameGenerator nameGenerate = new NameGenerator();
        name = nameGenerate.toString();
        moneyEarned = moneyEarnedToCompany();
        salary = FIXED_SALARY + (moneyEarned * 0.05);
        Company.setMoneyEarnedByCompany(moneyEarned);
    }

    protected double moneyEarnedToCompany() {
        return (double) Math.round(115_000 + (Math.random() * (140_000 - 115_000)));
    }


    @Override
    public double getMonthSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Менеджер " + name + " " + salary + " руб.\n";
    }
}