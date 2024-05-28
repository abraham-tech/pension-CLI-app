package org.example;
import java.time.LocalDate;

public record Employee(
        long employeeId,
        String firstName,
        String lastName,
        LocalDate employmentDate,
        Double yearlySalary,
        PensionPlan pensionPlan
) {
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employmentDate=" + employmentDate +
                ", yearlySalary=" + yearlySalary +
                ", pensionPlan=" + (pensionPlan != null ? pensionPlan : "None") +
                '}';
    }
}

