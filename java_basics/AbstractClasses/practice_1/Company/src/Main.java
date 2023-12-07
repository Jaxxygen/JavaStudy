import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        Collection<Employee> list = new ArrayList<>();
        for (int i = 0; i < 180; i++) {
            list.add(new Operator());
        }
        for (int i = 0; i < 80; i++) {
            list.add(new Manager());
        }
        for (int i = 0; i < 10; i++) {
            list.add(new TopManager());
        }

        company.hireAll(list);
        System.out.println(company);

        System.out.println(company.getTopSalaryStaff(15));
        System.out.println(company.getLowSalaryStaff(15));

        company.hire(new Manager());

        System.out.println(company);
        System.out.println(company.getIncome());

        company.fireAll(list);
        System.out.println(company);

        company.fire(new Manager());
        System.out.println(company);
    }
}