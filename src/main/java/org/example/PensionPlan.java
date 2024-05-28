package org.example;

import java.time.LocalDate;

public class PensionPlan {

    String planReferenceNumber;


    LocalDate enrollmentDate;



    Double monthlyContribution;

    public PensionPlan(String planReferenceNumber, LocalDate enrollmentDate, Double monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }

    public Double getMonthlyContribution() {
        return monthlyContribution;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public String getPlanReferenceNumber() {
        return planReferenceNumber;
    }
}