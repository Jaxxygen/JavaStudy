public class TopManager implements Employee {
    protected String name;
    protected double salary;

    protected TopManager() {
        NameGenerator nameGenerate = new NameGenerator();
        this.name = nameGenerate.toString();
        this.salary = monthSalary();
    }

    protected double monthSalary() {

        if (Company.getMoneyEarnedByCompany() > 10_000_000) {
            return FIXED_SALARY + (FIXED_SALARY * 1.5);
        }
        return FIXED_SALARY;
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Топменеджер " + name + " " + salary + " руб.\n";
    }
}
