package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    public static List<Employee> loadData() {
        List<Employee> employees = new ArrayList<>();

        PensionPlan pensionPlan1 = new PensionPlan("EX1089", LocalDate.parse("2023-01-17"), 100.00);
        Employee emp1 = new Employee(1, "Daniel", "Agar", LocalDate.parse("2018-01-17"), 105945.50, pensionPlan1);
        employees.add(emp1);

        Employee emp2 = new Employee(2, "Benard", "Shaw", LocalDate.parse("2019-05-03"), 197750.00, null);
        employees.add(emp2);

        PensionPlan pensionPlan2 = new PensionPlan("SM2307", LocalDate.parse("2023-01-17"), 100.00);
        Employee emp3 = new Employee(3, "Carly", "Agar", LocalDate.parse("2014-05-16"), 1555.50, pensionPlan2);
        employees.add(emp3);

        Employee emp4 = new Employee(4, "Wesley", "Schneider", LocalDate.parse("2019-05-02"), null, null);
        employees.add(emp4);

        return employees;
    }
}


