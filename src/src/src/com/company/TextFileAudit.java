package src.src.com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileAudit implements AuditStrategyInterface {
	private Company talentAgencyCompany;
	private ArrayList<String> information;

	public TextFileAudit() {
		talentAgencyCompany = Company.getInstance();
		information = new ArrayList<String>();
	}
	
	public void writeInformationToTextFile() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("GeneratedAudit.txt"));
		execute(); // Must write to information instance variable before creating the text file with it

		for(int i = 0; i < information.size(); i++) {
			writer.write(information.get(i));
		}
		
		writer.close();
	}

	@Override
	public void execute() {
		displayCompanyInformation();
		displayFinancialSituation();
		displayEmployeeInformation();
		displayClientInformation();
	}

	private void displayClientInformation() {
		information.add("\n");
		information.add("Client Information: \n");
		
		for(Client tempClient : talentAgencyCompany.getAllClients()) {
			information.add(tempClient.getId() + " | " + tempClient.getName() + " | Value: " + tempClient.getAnnualRevenueGenerated() + "\n");
			information.add("Revenue Generated: " + tempClient.getCalculatedRevenue() + "\n\n");
		}
	}

	private void displayEmployeeInformation() {
		information.add("\n");
		information.add("Employee Information: \n");
		
		for(Employee tempEmployee : talentAgencyCompany.getEmployees()) {
			information.add(tempEmployee.getId() + " | " + tempEmployee.getName() + " | " + tempEmployee.getJobTitle() + "\n");
			information.add("Contract: " + tempEmployee.getContractStartDate().displayDate() + " -> "
					+ tempEmployee.getContractEndDate().displayDate() + "\n");
			information.add("Wage: " + tempEmployee.getWage() + "\n\n");
		}
	}

	private void displayFinancialSituation() {
		information.add("");
		information.add("Fiscal Situation:" + "\n");
		information.add("Net Income: " + talentAgencyCompany.calculateAnnualNetIncome() + "\n");
		information.add("Income: " + talentAgencyCompany.calculateClientTotalRevenue() + "\n");
		information.add("Expenses: " + talentAgencyCompany.sumAllEmployeeWages() + "\n");
		information.add("Average Employee Wage: " + talentAgencyCompany.calculateAverageEmployeeWage() + "\n");
		information.add("Average Client Value: " + talentAgencyCompany.calculateAverageClientAnnualRevenue() + "\n");
		information.add("Average Client Commission: " + talentAgencyCompany.calculateAverageClientCommissionValue() + "\n");
	}

	private void displayCompanyInformation() {
		information.add("Company Information: \n");
		information.add(talentAgencyCompany.getName() + "\n");
		information.add("Location: " + talentAgencyCompany.getHqLoc() + "\n");
		information.add("Employees: " + talentAgencyCompany.getNumberOfEmployees() + "\n");
		information.add("Clients: " + talentAgencyCompany.getNumberOfClients() + "\n \n");
	}
}