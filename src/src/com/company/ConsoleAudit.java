package com.company;

public class ConsoleAudit implements AuditStrategy{

    Company TalentAgencyCompany = Company.getInstance();

    // Concrete Implementation
    @Override
    public void execute() {
        companyInfo();
        financialSituation();
        employeeInformation();
        clientInformation();
    }

    /*
        Displays information about company, location, and size.
    */
    private void companyInfo(){
        System.out.println("Company Information: ");
        System.out.println(TalentAgencyCompany.getName());
        System.out.println("Location: " + TalentAgencyCompany.getHqLoc());
        System.out.println("Employees: " + TalentAgencyCompany.amountofEmployees());
        System.out.println("Clients: " + TalentAgencyCompany.amountofClients());
    }

    /*
        Displays information about fiscal information of company.
    */
    private void financialSituation(){
        System.out.println("");
        System.out.println("Fiscal Situation:");
        System.out.println("Net Income: " + TalentAgencyCompany.annualNetIncome());
        System.out.println("Income: " + TalentAgencyCompany.revenueGenerated());
        System.out.println("Expenses: " + TalentAgencyCompany.sumEmployeesWages());
        System.out.println("Average Employee Wage: " + TalentAgencyCompany.averageEmployeeWage());
        System.out.println("Average Client Value: " + TalentAgencyCompany.averageClientValue());
        System.out.println("Average Client Commission: " + TalentAgencyCompany.averageClientCommission());
    }

    /*
        Displays information about employees.
    */
    private void employeeInformation(){
        System.out.println("");
        System.out.println("Employee Information: ");
        // Iterating through Employees
        for (Employee E: TalentAgencyCompany.getEmployees()){
            System.out.println(""+ E.getId() + " | " + E.getName() + " | " + E.getJobTitle());
            System.out.println("Contract: " + E.getContractStartDate().displayDate() + " -> " + E.getContractEndDate().displayDate());
            System.out.println("Wage: " + E.getWage());
            System.out.println();
        }
    }

    /*
        Displays information about clients.
    */
    private void clientInformation(){
        System.out.println("Client Information: ");
        for (Client C: TalentAgencyCompany.getClients()){
            System.out.println(C.getID() + " | "+C.getName() + " | Value: " + C.getAnnualRevenueGenerated());
            System.out.println("Revenue Generated: "+ C.revenueGenerated());
            System.out.println();
        }
    }

}
