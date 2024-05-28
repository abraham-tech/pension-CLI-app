package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PensionCLIApp {
    private List<Employee> employees;

    public PensionCLIApp() {
        this.employees = DataLoader.loadData();
    }

    public void printAllEmployees() {
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::lastName)
                        .thenComparing(Comparator.comparing(Employee::yearlySalary).reversed()))
                .collect(Collectors.toList());

        String jsonResult = sortedEmployees.stream()
                .map(this::employeeToJson)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(jsonResult);
    }

    public void printUpcomingEnrollees() {
        LocalDate today = LocalDate.now();
        LocalDate firstOfNextMonth = today.withDayOfMonth(1).plusMonths(1);
        LocalDate lastOfNextMonth = firstOfNextMonth.withDayOfMonth(firstOfNextMonth.lengthOfMonth());

        List<Employee> upcomingEnrollees = employees.stream()
                .filter(emp -> emp.pensionPlan() == null)
                .filter(emp -> ChronoUnit.YEARS.between(emp.employmentDate(), firstOfNextMonth) >= 5)
                .collect(Collectors.toList());

        String jsonResult = upcomingEnrollees.stream()
                .map(this::employeeToJson)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(jsonResult);
    }

    private String employeeToJson(Employee employee) {
        StringBuilder json = new StringBuilder();
        json.append("\n{");
        json.append("\"employeeId\":").append(employee.employeeId()).append(",");
        json.append("\"firstName\":\"").append(employee.firstName()).append("\",");
        json.append("\"lastName\":\"").append(employee.lastName()).append("\",");
        json.append("\"employmentDate\":\"").append(employee.employmentDate()).append("\",");
        json.append("\"yearlySalary\":").append(employee.yearlySalary()).append(",");
        json.append("\"pensionPlan\":").append(employee.pensionPlan() != null ? pensionPlanToJson(employee.pensionPlan()) : "null");
        json.append("}");
        return json.toString() ;
    }

    private String pensionPlanToJson(PensionPlan pensionPlan) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"planReferenceNumber\":\"").append(pensionPlan.getPlanReferenceNumber()).append("\",");
        json.append("\"enrollmentDate\":\"").append(pensionPlan.getEnrollmentDate()).append("\",");
        json.append("\"monthlyContribution\":").append(pensionPlan.getMonthlyContribution());
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {
        PensionCLIApp app = new PensionCLIApp();
        System.out.println("List of all Employees in JSON format: ");
        app.printAllEmployees();
        System.out.println("List of all Employees in JSON format: ");
        app.printUpcomingEnrollees();
    }
}
