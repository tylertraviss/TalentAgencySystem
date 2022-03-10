package com.company;

import java.util.ArrayList;
import java.util.List;

public class Employee extends Person{

    // Constructor
    public Employee(String name, int age, String gender, String nationality, String jobTitle, double wage, Date contractStartDate, Date contractEndDate) {
        super(name, age, gender, nationality);
        this.jobTitle = jobTitle;
        this.wage = wage;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.id = employedID++;
        subordinates = new ArrayList<Employee>();
    }
    
    private static int employedID = 1000;
    private int id;
    private String jobTitle;
    private double wage;
    private Date contractStartDate;
    private Date contractEndDate;
    private List<Employee> subordinates;

    public void addSubordinate(Employee e) {
        subordinates.add(e);
    }

    public void removeSubordinate(Employee e){
        subordinates.remove(e);
    }

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

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public int getId(){ return this.id; }

    // Prototype Design Pattern

    public Employee clone(){
        // not sure if this is the most efficient way to go along with things lol
        return new Employee(this.name, this.age, this.gender, this.nationality, this.jobTitle, this.wage, this.contractStartDate, this.contractEndDate, this.superior);
    }

    @Override
    public String toString() {
        // print an employee's subordinates.
        String subs = "";
        for(int i=0; i<subordinates.size(); i++){
            subs = subs + ", " + subordinates.get(i).getName();
        }

        return "Employee{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", wage=" + wage +
                ", contractStartDate=" + contractStartDate +
                ", contractEndDate=" + contractEndDate +
                ", subordinates=" + subs +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
