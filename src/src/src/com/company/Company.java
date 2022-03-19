package src.src.com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import UI.textarea.ConsoleTA;

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
		List<Employee> toReturn = new ArrayList<>();
		if (employees.size() > 0) {
			for (var emp : employees)
				toReturn.addAll(getEmployees(emp));
		}
		return toReturn;
	}

	public List<Employee> getEmployees(Employee emp) {
		if (emp == null)
			return null;

		List<Employee> subList = new ArrayList<>();

		subList.add(emp);

		for (var sub : emp.getSubordinates()) {
			var newSubList = getEmployees(sub);
			subList.addAll(newSubList);
		}

		return subList;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Client> getClients() {
		List<Client> toReturn = new ArrayList<>();
		toReturn.addAll(clients);
		for (var c : clients)
			if (c.getGroup().size() > 0)
				toReturn.addAll(c.getGroup());

		return toReturn;
	}

	public List<Client> getClientsForAdding() {
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
		if (employees.contains(emp))
			employees.remove(emp);
		else
			removeSubordinate(employees.get(0), emp);
	}

	public void removeClient(Client client) {
		if (clients.contains(client))
			clients.remove(client);
		else {
			for (var c : clients) {
				if (c.getGroup().contains(client)) {
					c.removeFromGroup(client);
					break;
				}

			}
		}

		removeSponsorship(client);
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
			totalExpenses += C.getCommission() * C.getAnnualRevenueGenerated();
		}
		return totalExpenses;
	}

	// Average Client Commission
	public double averageClientCommission() {
		double sum = 0;
		for (Client C : clients) {
			sum += C.getCommission();
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
		return getEmployees().size();
	}

	public int amountofClients() {
		return getClients().size();
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

	private boolean removeSubordinate(Employee emp, Employee toRemove) {
		if (emp.getSubordinates().contains(toRemove)) {
			emp.removeSubordinate(toRemove);
			return true;
		}

		for (var sub : emp.getSubordinates()) {
			var removed = removeSubordinate(sub, toRemove);

			if (removed) {
				return true;
			}
		}

		return false;

	}

	private void removeSponsorship(Client c) {
		var sponsorshipMediator = SponsorshipMediator.getInstance();
		var console = ConsoleTA.getInstance();
		var sponsorship = sponsorshipMediator.getSponsorshipByClient(c);

		if (sponsorship != null) {
			sponsorshipMediator.discontinueSponsorship(sponsorship);
			console.log("The sponsor for Client [" + c.getName() + "] has been discontinued");
		}

		if (c.getGroup().size() > 0) {
			for (var subClient : c.getGroup()) {
				var subSponsorship = sponsorshipMediator.getSponsorshipByClient(subClient);

				if (subSponsorship != null) {
					sponsorshipMediator.discontinueSponsorship(subSponsorship);
					console.log("The sponsor for Client [" + subClient.getName() + "] has been discontinued");
				}
			}

		}
	}

}
