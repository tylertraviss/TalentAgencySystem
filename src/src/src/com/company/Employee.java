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

	public Employee(String name, int age, String gender, String nationality, String jobTitle,
			double wage, Date contractStartDate, Date contractEndDate, Employee superior) {
		super(name, age, gender, nationality);
		
		this.jobTitle = jobTitle;
		this.wage = wage;
		this.contractStartDate = contractStartDate;
		this.contractEndDate = contractEndDate;
		this.id = employedID++;
		this.subordinates = new ArrayList<>();
		this.superior = superior;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}
	
	public double getWage() {
		return wage;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}
	
	public Date getContractStartDate() {
		return contractStartDate;
	}

	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public Date getContractEndDate() {
		return contractEndDate;
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}
	
	public void setSubordinates(List<Employee> subordinates) {
		this.subordinates = subordinates;
	}
	
	public void addSubordinate(Employee e) {
		subordinates.add(e);
	}

	public void removeSubordinate(Employee e) {
		subordinates.remove(e);
	}

	public int getId() {
		return this.id;
	}

	// Used for implementing the prototype design pattern
	public Employee clone() {
		return new Employee(this.getName(), this.getAge(), this.getGender(), this.getNationality(), this.jobTitle, this.wage,
				this.contractStartDate, this.contractEndDate, this.superior);
	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public String getStringToPrintToConsole() {
		String stringToReturn = "";

		stringToReturn += "" + "Employee:\t" + getName() + System.lineSeparator();
		stringToReturn += super.getStringToPrintToConsole();
		stringToReturn += "" + "Job Title:\t" + jobTitle + System.lineSeparator();
		stringToReturn += "" + "Wage:\t\t" + wage + System.lineSeparator();
		stringToReturn += "" + "Start Date:\t" + contractStartDate.toString() + System.lineSeparator();
		stringToReturn += "" + "End Date:\t" + contractEndDate.toString() + System.lineSeparator();

		if(superior != null) {			
			stringToReturn += "Superior:\t" + superior.getName() + System.lineSeparator() + System.lineSeparator();
		}
		else {
			stringToReturn += "Superior: Null " + System.lineSeparator() + System.lineSeparator();			
		}

		return stringToReturn;
	}
}