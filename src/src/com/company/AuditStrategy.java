package com.company;

public interface AuditStrategy {

    /*
    Defining an interface for creating Audit Reports.
    Audit Should include company name, employees, responsibility,
    all clients, their responsibilities, (or costs if they are an
    employee)
     */

    // Strategy Pattern
    void execute();

}
