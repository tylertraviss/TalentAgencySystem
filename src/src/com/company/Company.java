package com.company;
import java.util.List;

public class Company {

    private String name;
    private String hqLoc;
    private List<Employee> employees;
    private List<Client> clients;
    private Company instance; // Memento Later
    private double totalIncome;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHqLoc() {
        return hqLoc;
    }

    public void setHqLoc(String hqLoc) {
        this.hqLoc = hqLoc;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Company getInstance() {
        return instance;
    }

    public void setInstance(Company instance) {
        this.instance = instance;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    // Add RemoveEmployee

    // Add RemoveClients

    // Calculate Expenses

}
