package com.company;

public class Employee extends Person{

    // Constructor
    public Employee(String name, int age, String gender, String nationality, String jobTitle, double wage, Date contractStartDate, Date contractEndDate, Employee superior) {

        // Setting Information from Extended Code
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
        this.setNationality(nationality);

        // New Features
        this.jobTitle = jobTitle;
        this.wage = wage;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.superior = superior;
    }

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

    @Override
    public String toString() {
        return "Employee{" +
                "jobTitle='" + jobTitle + '\'' +
                ", wage=" + wage +
                ", contractStartDate=" + contractStartDate +
                ", contractEndDate=" + contractEndDate +
                ", superior=" + superior +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
