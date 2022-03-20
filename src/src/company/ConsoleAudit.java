package src.company;

public class ConsoleAudit implements AuditStrategyInterface {
    private Company talentAgencyCompany = Company.getInstance();

    @Override
    public void execute() {
        displayCompanyInformation();
        displayFiscalSituation();
        displayEmployeeInformation();
        displayClientInformation();
    }

    /*
     * Displays information about company, location, and size.
     */
    private void displayCompanyInformation() {
        System.out.println("Company Information: ");
        System.out.println(talentAgencyCompany.getName());
        System.out.println("Location: " + talentAgencyCompany.getHqLoc());
        System.out.println("Employees: " + talentAgencyCompany.getNumberOfEmployees());
        System.out.println("Clients: " + talentAgencyCompany.getNumberOfClients());
    }

    /*
     * Displays information about fiscal situation of company.
     */
    private void displayFiscalSituation() {
        System.out.println();
        System.out.println("Fiscal Situation:");
        System.out.println("Net Income: " + talentAgencyCompany.calculateAnnualNetIncome());
        System.out.println("Income: " + talentAgencyCompany.calculateClientTotalRevenue());
        System.out.println("Expenses: " + talentAgencyCompany.sumAllEmployeeWages());
        System.out.println("Average Employee Wage: " + talentAgencyCompany.calculateAverageEmployeeWage());
        System.out.println("Average Client Value: " + talentAgencyCompany.calculateAverageClientAnnualRevenue());
        System.out.println("Average Client Commission: " + talentAgencyCompany.calculateAverageClientCommissionValue());
    }

    /*
     * Displays information about employees.
     */
    private void displayEmployeeInformation() {
        System.out.println();
        System.out.println("Employee Information: ");
        
        for(Employee tempEmployee : talentAgencyCompany.getEmployees()){
            System.out.println(""+ tempEmployee.getId() + " | " + tempEmployee.getName() + " | " + tempEmployee.getJobTitle());
            System.out.println("Contract: " + tempEmployee.getContractStartDate().displayDate() + " -> " + tempEmployee.getContractEndDate().displayDate());
            System.out.println("Wage: " + tempEmployee.getWage());
            System.out.println();
        }
    }

    /*
     * Displays information about clients.
     */
    private void displayClientInformation() {
        System.out.println("Client Information: ");
        
        for (Client tempClient : talentAgencyCompany.getAllClients()){
            System.out.println(tempClient.getId() + " | "+tempClient.getName() + " | Value: " + tempClient.getAnnualRevenueGenerated());
            System.out.println("Revenue Generated: "+ tempClient.getCalculatedRevenue());
            System.out.println();
        }
    }
}