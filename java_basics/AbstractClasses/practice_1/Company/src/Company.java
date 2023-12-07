import java.util.*;

public class Company {
    List<Employee> employeeInCompanyList = new ArrayList<>();

    public static double moneyEarnedByCompany = 0;
    public int employeesInTheCompanyCount;

    public static void setMoneyEarnedByCompany(double moneyEarnedByCompany) {
        Company.moneyEarnedByCompany += moneyEarnedByCompany;
    }

    public static double getMoneyEarnedByCompany() {
        return moneyEarnedByCompany;
    }

    //Получение списка сотрудников с наибольшим доходом
    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> topSalaryList = new ArrayList<>();
        employeeInCompanyList.sort(Comparator.comparingDouble(Employee::getMonthSalary).reversed());
        for (int i = 0; i < count; i++) {
            topSalaryList.add(employeeInCompanyList.get(i));
        }
        return topSalaryList;
    }

    public List<Employee> getLowSalaryStaff(int count) {
        List<Employee> lowSalaryList = new ArrayList<>();
        employeeInCompanyList.sort(Comparator.comparingDouble(Employee::getMonthSalary));
        for (int i = 0; i < count; i++) {
            lowSalaryList.add(employeeInCompanyList.get(i));
        }
        return lowSalaryList;
    }

    //Найм сотрудника
    public void hire(Employee employee) {
        employeeInCompanyList.add(employee);
        employeesInTheCompanyCount++;
    }
    //Найм списка сотрудников
    public void hireAll(Collection<Employee> employeeList) {
        employeeInCompanyList.addAll(employeeList);
        employeesInTheCompanyCount += employeeList.size();
    }
    // Увольнение сотрудников
    public void fire(Employee employee) {
        employeeInCompanyList.remove(employee);
        employeesInTheCompanyCount--;
    }
    // Увольнение списка сотрудников
    public void fireAll(Collection<Employee> employeesList) {
        List<Employee> tempList = new ArrayList<>(employeesList);
        for (Employee employee : tempList) {
            employeeInCompanyList.remove(employee);
            employeesInTheCompanyCount--;
        }
    }

    //Возврат прибыли компании
    public double getIncome() {
        return getMoneyEarnedByCompany();
    }




    @Override
    public String toString() {
        return "Company \n" + employeeInCompanyList + "\n Количество сотрудников в компании = " + employeesInTheCompanyCount + '\n';
    }
}


//Конструктор компании
//    public Company(int operatorCount, int managerCount, int topManagerCount) {
//        for (int i = 0; i < operatorCount; i++) {
//            Operator operator = new Operator();
//            employeeInCompanyList.add(operator);
//        }
//        for (int i = 0; i < managerCount; i++) {
//            Manager manager = new Manager();
//            employeeInCompanyList.add(manager);
//        }
//        for (int i = 0; i < topManagerCount; i++) {
//            TopManager topManager = new TopManager();
//            employeeInCompanyList.add(topManager);
//        }
//        employeesInTheCompanyCount += (operatorCount + managerCount + topManagerCount);
//    }

//Найм всех сотрудников (случайный класс, определенное количество)
//public void randomHireAll(int count) {
//    for (int i = 0; i < count; i++) {
//        int randomNumber = (int) Math.round(Math.random() * 3);
//        if (randomNumber == 1) {
//            employeeInCompanyList.add(new Operator() {
//                @Override
//                public double getMonthSalary() {
//                    return super.getMonthSalary();
//                }
//            });
//            employeesInTheCompanyCount++;
//        } else if (randomNumber == 2) {
//            employeeInCompanyList.add(new Manager() {
//
//                @Override
//                public double getMonthSalary() {
//                    return super.getMonthSalary();
//                }
//
//            });
//            employeesInTheCompanyCount++;
//        } else {
//            employeeInCompanyList.add(new TopManager() {
//                @Override
//                public double getMonthSalary() {
//                    return super.getMonthSalary();
//                }
//            });
//            employeesInTheCompanyCount++;
//        }
//    }
//}

//Получение случайного сотрудника компании
//    public Employee randomEmployee() {
//        ArrayList<Employee> tempList = new ArrayList<>(employeeInCompanyList);
//        Collections.shuffle(tempList);
//        return tempList.get(0);
//    }