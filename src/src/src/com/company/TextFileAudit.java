package src.src.com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileAudit implements AuditStrategy {

	private Company TalentAgencyCompany = Company.getInstance();
	private ArrayList<String> information = new ArrayList<String>();

	// Responsible for taking each Arraylist element, writing

	public TextFileAudit() throws IOException {
		execute();
		BufferedWriter writer = new BufferedWriter(new FileWriter("GeneratedAudit.txt"));

		for (int i = 0; i < information.size(); i++) {
			writer.write(information.get(i));
		}
		writer.close();
	}

	/*
	 * Concrete Implementation of Strategy For Text File ArrayList of strings,
	 * eventually interpreted into file
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
		for (Client C : TalentAgencyCompany.getClients()) {
			information.add(C.getID() + " | " + C.getName() + " | Value: " + C.getAnnualRevenueGenerated() + "\n");
			information.add("Revenue Generated: " + C.revenueGenerated() + "\n\n");
		}
	}

	private void employeeInformation() {
		information.add("" + "\n");
		information.add("Employee Information: " + "\n");
		// Iterating through Employees
		for (Employee E : TalentAgencyCompany.getEmployees()) {
			information.add("" + E.getId() + " | " + E.getName() + " | " + E.getJobTitle() + "\n");
			information.add("Contract: " + E.getContractStartDate().displayDate() + " -> "
					+ E.getContractEndDate().displayDate() + "\n");
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
