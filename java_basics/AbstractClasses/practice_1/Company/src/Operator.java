public class Operator implements Employee {

    protected String name;
    protected double salary;

    protected Operator() {
        NameGenerator nameGenerate = new NameGenerator();
        this.name = nameGenerate.toString();
        this.salary = FIXED_SALARY;
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Оператор " + name + " " + salary + " руб.\n";
    }
}