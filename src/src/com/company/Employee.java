package com.company;

public class Employee extends Person{

    private String jobTitle;
    private double wage;
    private Date contractStartDate;
    private Date contractEndDate;
    private Employee superior;

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public void setSuperior(Employee superior) {
        this.superior = superior;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getWage() {
        return wage;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public Employee getSuperior() {
        return superior;
    }
}
