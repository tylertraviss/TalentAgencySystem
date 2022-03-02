package com.company;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileAudit implements AuditStrategy{

    Company TalentAgencyCompany = Company.getInstance();



    @Override
    public void execute() {

        companyInfo();
        financialSituation();
        employeeInformation();
        clientInformation();
    }

    private void clientInformation() {
        //System.out.println("");
        //System.out.println("Client Information: ");
        //for (Client C: TalentAgencyCompany.getClients()){
        //    System.out.println(C.getID() + " | "+C.getName() + " | Value: " + C.getAnnualRevenueGenerated());
        //    System.out.println("Revenue Generated: "+ C.revenueGenerated());
        //    System.out.println();
        //}
    }

    private void employeeInformation() {
        //System.out.println("");
        //System.out.println("Employee Information: ");
        // Iterating through Employees
        //for (Employee E : TalentAgencyCompany.getEmployees()) {
            //System.out.println("" + E.getId() + " | " + E.getName() + " | " + E.getJobTitle());
            //System.out.println("Contract: " + E.getContractStartDate().displayDate() + " -> " + E.getContractEndDate().displayDate());
            //System.out.println("Wage: " + E.getWage());
            //System.out.println();
    //    }
    }

    private void financialSituation() {
        //System.out.println("");
        //System.out.println("Fiscal Situation:");
        //System.out.println("Net Income: " + TalentAgencyCompany.annualNetIncome());
        //System.out.println("Income: " + TalentAgencyCompany.revenueGenerated());
        //System.out.println("Expenses: " + TalentAgencyCompany.sumEmployeesWages());
        //System.out.println("Average Employee Wage: " + TalentAgencyCompany.averageEmployeeWage());
        //System.out.println("Average Client Value: " + TalentAgencyCompany.averageClientValue());
        //System.out.println("Average Client Commission: " + TalentAgencyCompany.averageClientCommission());
    }

    private void companyInfo() {
    //    System.out.println("Company Information: ");
    //    System.out.println(TalentAgencyCompany.getName());
    //    System.out.println("Location: " + TalentAgencyCompany.getHqLoc());
    //    System.out.println("Employees: " + TalentAgencyCompany.amountofEmployees());
    //    System.out.println("Clients: " + TalentAgencyCompany.amountofClients());
    }
}
