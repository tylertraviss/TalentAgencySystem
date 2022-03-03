package com.company;

public class Employee extends Person{

    private static int employedID = 1000;

    // Constructor
    public Employee(String name, int age, String gender, String nationality, String jobTitle, double wage, Date contractStartDate, Date contractEndDate, Employee superior) {
        super(name, age, gender, nationality);
        this.jobTitle = jobTitle;
        this.wage = wage;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.superior = superior;
        this.id = employedID++;
    }

    private int id;
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

    public int getId(){ return this.id; }

    // Prototype Design Pattern

    public Employee clone(){
        // not sure if this is the most efficient way to go along with things lol
        return new Employee(this.name, this.age, this.gender, this.nationality, this.jobTitle, this.wage, this.contractStartDate, this.contractEndDate, this.superior);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
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
