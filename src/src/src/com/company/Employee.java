package src.src.com.company;

import java.util.ArrayList;
import java.util.List;

public class Employee extends Person {

	private static int employedID = 1000;
	private int id;
	private String jobTitle;
	private double wage;
	private Date contractStartDate;
	private Date contractEndDate;
	private List<Employee> subordinates;
	private Employee superior;

	// Constructor
	public Employee(String name, int age, String gender, String nationality, String jobTitle, double wage,
			Date contractStartDate, Date contractEndDate, Employee superior) {
		super(name, age, gender, nationality);
		this.jobTitle = jobTitle;
		this.wage = wage;
		this.contractStartDate = contractStartDate;
		this.contractEndDate = contractEndDate;
		this.id = employedID++;
		subordinates = new ArrayList<>();
		this.superior = superior;
	}

	public void addSubordinate(Employee e) {
		subordinates.add(e);
	}

	public void removeSubordinate(Employee e) {
		subordinates.remove(e);
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public double getWage() {
		return wage;
	}

	public Date getContractStartDate() {
		return contractStartDate;
	}

	public Date getContractEndDate() {
		return contractEndDate;
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public int getId() {
		return this.id;
	}

	// Prototype Design Pattern

	public Employee clone() {
		return new Employee(this.name, this.age, this.gender, this.nationality, this.jobTitle, this.wage,
				this.contractStartDate, this.contractEndDate, this.superior);
	}

	@Override
	public String toString() {
		return name;
	}

	private String printSubordinates() {
		String toReturn = "";

		for (var sub : subordinates)
			toReturn += sub.toConsole() + System.lineSeparator();

		return toReturn;
	}

	@Override
	public String toConsole() {
		String toReturn = "";

		toReturn += "" + "Employee:\t" + name + System.lineSeparator();
		toReturn += super.toConsole();
		toReturn += "" + "Job Title:\t" + jobTitle + System.lineSeparator();
		toReturn += "" + "Wage:\t\t" + wage + System.lineSeparator();
		toReturn += "" + "Start Date:\t" + contractStartDate.toString() + System.lineSeparator();
		toReturn += "" + "End Date:\t" + contractEndDate.toString() + System.lineSeparator();

		if (superior != null)
			toReturn += "Superior:\t" + superior.name + System.lineSeparator() + System.lineSeparator();
		else
			toReturn += "Superior: Null " + System.lineSeparator() + System.lineSeparator();

		toReturn += printSubordinates();

		if (subordinates.size() > 0)
			toReturn += System.lineSeparator() + "======== END SUBORDINATES =========" + System.lineSeparator();

		return toReturn;
	}
}
