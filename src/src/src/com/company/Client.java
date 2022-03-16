package src.src.com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class Client extends Person {

	private static int clientID = 1000;

	protected List<Experience> experiences;
	protected List<Client> group;
	protected double commission;
	protected List<Award> awards;
	protected int id;
	protected double annualRevenueGenerated;

	public Client(String name, int age, String gender, String nationality, List<Experience> experiences,
			double commission, List<Award> awards, double annualRevenueGenerated) {
		super(name, age, gender, nationality);
		this.experiences = experiences;
		this.group = new ArrayList<>();
		this.commission = commission;
		this.awards = awards;
		this.annualRevenueGenerated = annualRevenueGenerated;
		this.id = clientID++;
	}

	public double getAnnualRevenueGenerated() {
		return annualRevenueGenerated;
	}

	public void setAnnualRevenueGenerated(double annualRevenueGenerated) {
		this.annualRevenueGenerated = annualRevenueGenerated;
	}

	public int getID() {
		return this.id;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<Client> getGroup() {
		return group;
	}

	public void setGroup(List<Client> group) {
		this.group = group;
	}

	public double getComsission() {
		return commission;
	}

	public void setComsission(double comsission) {
		this.commission = comsission;
	}

	public List<Award> getAwards() {
		return awards;
	}

	public void setAwards(List<Award> awards) {
		this.awards = awards;
	}

	// Revenue Generated By Individual
	public double revenueGenerated() {
		return commission * annualRevenueGenerated;
	}

	public abstract String toString();

	public abstract String toConsole();

}