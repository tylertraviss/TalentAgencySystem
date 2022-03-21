# Design Patterns

### Memento
This was used to create undo functionality. A Memento class was created to grab a company state and set a company state.
```java
public class Memento {
    private Company companyState;

    public Memento(Company companyState) {
        this.companyState = companyState;
    }

    public Company getCompanyState() {
        return this.companyState;
    }
}
```
In the folder MementoCreater.java,
```java
public class MementoCreator {
    private Company companyState;

    public void setCompanyState(Company companyState) {
        this.companyState = companyState;
    }

    public Company getCompanyState() {
        return this.companyState;
    }

    public Memento createMementoWithSetCompanyState() {
        return new Memento(this.companyState);
    }

    public void getCompanyStateFromMemento(Memento memento) {
        if(memento != null) {
            this.companyState = memento.getCompanyState();
        }
    }
}
```
In MementoRestorer.java,
```java
import java.util.ArrayList;

public class MementoRestorer {
    private ArrayList<Memento> mementoList = new ArrayList<Memento>();

    public void addMementoToList(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMementoFromList(int index) {
        return mementoList.get(index);
    }
}
```
### Mediator
The mediator pattern was designed to simplify the sponsorship classes into a simplified class that mediates all the complexity.
```java
package com.company;
import java.util.*;

class SponsorshipMediator implements SponsorshipMediatorBase{

    private ArrayList<Sponsorship> sponsorships= new ArrayList<>();
    
    public void registerSponsorship(Sponsorship sponsorship){
        sponsorships.add(sponsorship);
    }
    
    public void discontinueSponsorship(Sponsorship sponsorship){
        sponsorships.remove(sponsorship);
    }
    
    public void reportSponsorships(){
        System.out.println("Records of Current Sponsorships: \n\n");
        //System.out.println(sponsorships);

        for (int i = 0; i < sponsorships.size(); i++) {
            System.out.println(sponsorships.get(i).getSponsor().getSponsorName()+ " is sponsoring " + sponsorships.get(i).getSponsoredClient().getName() +" at $" +sponsorships.get(i).getValue()+ " a year.");
        }
    }


}
```
### Composite
Composition was used to structure the hierarchy of employees of who is in charge of each specific person.
### Singleton
Validating there is only a single instance of the company.
```java
    private Company() {
        employees = new ArrayList<>();
        clients = new ArrayList<>();
    }

    // getting the instance
    public static Company getInstance() {
        if (instance == null)
            instance = new Company();
        return instance;
    }
```

### Prototype
Although not implemented into UI version of software, one may build an employee and copy and paste it using the prototype pattern.
```java
    public Employee clone(){
        return new Employee(this.name, this.age, this.gender, this.nationality, this.jobTitle, this.wage, this.contractStartDate, this.contractEndDate, this.superior);
    }
```
### Template
This was used for auditing functionality. It was done in both a console and a text document. 
```java
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

```
Firstly, the console audit.
```java
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
```
Then text file audits. 
```java
public class TextFileAudit implements AuditStrategy{

    Company TalentAgencyCompany = Company.getInstance();
    ArrayList<String> information = new ArrayList<String>();

    // Responsible for taking each Arraylist element, writing

    public TextFileAudit() throws IOException {
        execute();
        FileWriter writer = new FileWriter("GeneratedAudit.txt");

        for (int i = 0; i < information.size(); i++){
            writer.write(information.get(i));
        }
        writer.close();
    }

    /*
    Concrete Implementation of Strategy For Text File
    ArrayList of strings, eventually interpreted into file
     */

    @Override
    public void execute() {
        companyInfo();
        financialSituation();
        employeeInformation();
        clientInformation();
    }

    private void clientInformation() {
        information.add("\n");
        information.add("Client Information: \n");
        for (Client C: TalentAgencyCompany.getClients()){
            information.add(C.getID() + " | "+C.getName() + " | Value: " + C.getAnnualRevenueGenerated() + "\n");
            information.add("Revenue Generated: "+ C.revenueGenerated() + "\n\n");
        }
    }

    private void employeeInformation() {
        information.add(""+ "\n");
        information.add("Employee Information: "+ "\n");
        // Iterating through Employees
        for (Employee E : TalentAgencyCompany.getEmployees()) {
            information.add("" + E.getId() + " | " + E.getName() + " | " + E.getJobTitle()+ "\n");
            information.add("Contract: " + E.getContractStartDate().displayDate() + " -> " + E.getContractEndDate().displayDate() + "\n");
            information.add("Wage: " + E.getWage() + "\n\n");
        }
    }

    private void financialSituation() {
        information.add("");
        information.add("Fiscal Situation:" + "\n");
        information.add("Net Income: " + TalentAgencyCompany.annualNetIncome() + "\n");
        information.add("Income: " + TalentAgencyCompany.revenueGenerated() + "\n");
        information.add("Expenses: " + TalentAgencyCompany.sumEmployeesWages() + "\n");
        information.add("Average Employee Wage: " + TalentAgencyCompany.averageEmployeeWage() + "\n");
        information.add("Average Client Value: " + TalentAgencyCompany.averageClientValue() + "\n");
        information.add("Average Client Commission: " + TalentAgencyCompany.averageClientCommission() + "\n");
    }

    private void companyInfo() {
        information.add("Company Information: \n");
        information.add(TalentAgencyCompany.getName() + "\n");
        information.add("Location: " + TalentAgencyCompany.getHqLoc() + "\n");
        information.add("Employees: " + TalentAgencyCompany.amountofEmployees() + "\n");
        information.add("Clients: " + TalentAgencyCompany.amountofClients() + "\n \n");
    }
}

```
