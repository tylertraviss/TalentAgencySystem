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

	// Singleton: private constructor
	private Company() {
		employees = new ArrayList<Employee>();
		clients = new ArrayList<Client>();
	}

	// Singleton: function to retrieve the existing instance
	public static Company getInstance() {
		if(instance == null) {			
			instance = new Company();
		}
		
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
		List<Employee> employeeList = new ArrayList<Employee>();
		
		for(Employee emp : employees) {
			employeeList.addAll(getAllEmployees(emp));
		}
		
		return employeeList;
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

	public void removeEmployee(Employee emp) {
		if (employees.contains(emp))
			employees.remove(emp);
		else
			removeSubordinate(employees.get(0), emp);
	}
	
	public void addClient(Client p) {
		clients.add(p);
	}

	public void removeClient(Client client) {
		if(clients.contains(client)) {
			clients.remove(client);
			
		} else {
			for(Client c : clients) {
				if(c.getGroup().contains(client)) {
					c.removeFromGroup(client);
					break;
				}
			}
		}

		removeSponsorship(client);
	}

	public double sumAllEmployeeWages() {
		double totalWages = 0;
		
		for(Employee E : employees) {
			totalWages += E.getWage();
		}
		
		return totalWages;
	}

	public double calculateClientTotalRevenue() {
		double totalExpenses = 0;
		
		for(Client tempClient : clients) {
			totalExpenses += tempClient.getCommission() * tempClient.getAnnualRevenueGenerated();
		}
		
		return totalExpenses;
	}

	public double calculateAverageClientCommissionValue() {
		double sum = 0;
		
		for(Client tempClient : clients) {
			sum += tempClient.getCommission();
		}
		
		return sum / getNumberOfClients();
	}

	public double calculateAverageClientAnnualRevenue() {
		double sum = 0;
		
		for(Client tempClient : clients) {
			sum += tempClient.getAnnualRevenueGenerated();
		}
		
		return sum / getNumberOfClients();
	}

	public int getNumberOfEmployees() {
		return getEmployees().size();
	}

	public int getNumberOfClients() {
		return getAllClients().size();
	}

	public double calculateAverageEmployeeWage() {
		return sumAllEmployeeWages() / employees.size();
	}

	public double calculateAnnualNetIncome() {
		return calculateClientTotalRevenue() - sumAllEmployeeWages();
	}

	public void sortPeople() {
		Collections.sort(clients);
		Collections.sort(employees);
	}
	
	public List<Client> getAllClients() {
		List<Client> listOfClients = new ArrayList<Client>();
		listOfClients.addAll(clients);
		
		for(Client c : clients) {
			if(c.getGroup().size() > 0) {
				listOfClients.addAll(c.getGroup());
			}
		}

		return listOfClients;
	}
	
	private void removeSponsorship(Client client) {
		SponsorshipMediator sponsorshipMediator = SponsorshipMediator.getInstance();
		ConsoleTA console = ConsoleTA.getInstance();
		Sponsorship sponsorship = sponsorshipMediator.getSponsorshipByClient(client);

		if(sponsorship != null) {
			sponsorshipMediator.discontinueSponsorship(sponsorship);
			console.log("The sponsor for Client [" + client.getName() + "] has been discontinued.");
		}

		if (client.getGroup().size() > 0) {
			for (Client subClient : client.getGroup()) {
				Sponsorship subSponsorship = sponsorshipMediator.getSponsorshipByClient(subClient);

				if(subSponsorship != null) {
					sponsorshipMediator.discontinueSponsorship(subSponsorship);
					console.log("The sponsor for Client [" + subClient.getName() + "] has been discontinued.");
				}
			}
		}
	}
	
	/*
	 * This is a recursive method
	 */
	private boolean removeSubordinate(Employee tempEmployee, Employee employeeToRemove) {
		if(tempEmployee.getSubordinates().contains(employeeToRemove)) {
			tempEmployee.removeSubordinate(employeeToRemove);
			return true;
		}

		for(Employee sub : tempEmployee.getSubordinates()) {
			boolean removed = removeSubordinate(sub, employeeToRemove);

			if(removed) {
				return true;
			}
		}

		return false;

	}
	
	/*
	 * This is a recursive method to get all subordinates of a subordinate.
	 * Ultimately, this function will return a list where index 0 is the passed employee
	 * and its subordinates are listed out from index 1.
	 */
	private List<Employee> getAllEmployees(Employee emp) {
		if(emp == null) {	
			return null;
		}

		List<Employee> subList = new ArrayList<Employee>();

		subList.add(emp);

		for(Employee sub : emp.getSubordinates()) {
			List<Employee> newSubList = getAllEmployees(sub);
			subList.addAll(newSubList);
		}

		return subList;
	}
}