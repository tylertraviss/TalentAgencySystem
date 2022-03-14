package com.company;

public class Memento {
    private Company companyState;

    public Memento(Company companyState) {
        this.companyState = companyState;
    }

    public Company getCompanyState() {
        return this.companyState;
    }
}