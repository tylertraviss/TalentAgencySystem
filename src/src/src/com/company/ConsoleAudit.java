package src.src.com.company;

public class ConsoleAudit implements AuditStrategy {
    private Company talentAgencyCompany = Company.getInstance();

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
        System.out.println(talentAgencyCompany.getName());
        System.out.println("Location: " + talentAgencyCompany.getHqLoc());
        System.out.println("Employees: " + talentAgencyCompany.getNumberOfEmployees());
        System.out.println("Clients: " + talentAgencyCompany.getNumberOfClients());
    }

    /*
        Displays information about fiscal information of company.
    */
    private void financialSituation(){
        System.out.println("");
        System.out.println("Fiscal Situation:");
        System.out.println("Net Income: " + talentAgencyCompany.calculateAnnualNetIncome());
        System.out.println("Income: " + talentAgencyCompany.calculateClientTotalRevenue());
        System.out.println("Expenses: " + talentAgencyCompany.sumAllEmployeeWages());
        System.out.println("Average Employee Wage: " + talentAgencyCompany.calculateAverageEmployeeWage());
        System.out.println("Average Client Value: " + talentAgencyCompany.calculateAverageClientAnnualRevenue());
        System.out.println("Average Client Commission: " + talentAgencyCompany.calculateAverageClientCommissionValue());
    }

    /*
        Displays information about employees.
    */
    private void employeeInformation(){
        System.out.println("");
        System.out.println("Employee Information: ");
        // Iterating through Employees
        for (Employee E: talentAgencyCompany.getEmployees()){
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
        for (Client C: talentAgencyCompany.getAllClients()){
            System.out.println(C.getId() + " | "+C.getName() + " | Value: " + C.getAnnualRevenueGenerated());
            System.out.println("Revenue Generated: "+ C.getCalculatedRevenue());
            System.out.println();
        }
    }
}