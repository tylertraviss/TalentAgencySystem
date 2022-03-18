package src.src.com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

	private String name;
	private String hqLoc;
	private List<Employee> employees;
	private List<Client> clients;
	private static Company instance = null;
	private double totalIncome = 0;

	// Singleton private constructor
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHqLoc() {
		return hqLoc;
	}

	public void setHqLoc(String hqLoc) {
		this.hqLoc = hqLoc;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}

	public void addEmployee(Employee p) {
		employees.add(p);
	}

	public void addClient(Client p) {
		clients.add(p);
	}

	public void removeEmployee(Employee emp) {
		employees.remove(emp);
	}

	public void removeClient(Client client) {
		clients.remove(client);
	}

	// Calculating Wages of All Employees
	public double sumEmployeesWages() {
		double totalWages = 0;
		for (Employee E : employees) {
			totalWages += E.getWage();
		}
		return totalWages;
	}

	// Total Revenue Generated
	public double revenueGenerated() {
		double totalExpenses = 0;
		for (Client C : clients) {
			totalExpenses += C.getComsission() * C.getAnnualRevenueGenerated();
		}
		return totalExpenses;
	}

	// Average Client Commission
	public double averageClientCommission() {
		double sum = 0;
		for (Client C : clients) {
			sum += C.getComsission();
		}
		return sum / amountofClients();
	}

	// Average Value of Client
	public double averageClientValue() {
		double sum = 0;
		for (Client C : clients) {
			sum += C.getAnnualRevenueGenerated();
		}
		return sum / amountofClients();
	}

	public int amountofEmployees() {
		return employees.size();
	}

	public int amountofClients() {
		return clients.size();
	}

	public double averageEmployeeWage() {
		return sumEmployeesWages() / employees.size();
	}

	public double annualNetIncome() {
		return revenueGenerated() - sumEmployeesWages();
	}

	public void sortPeople() {
		Collections.sort(clients);
		Collections.sort(employees);
	}

}
