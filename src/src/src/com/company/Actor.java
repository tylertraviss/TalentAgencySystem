package src.src.com.company;

import java.util.List;

public class Actor extends Client {

	private String actorType;

	public Actor(String name, int age, String gender, String nationality, List<Experience> experiences,
			double commission, List<Award> awards, double revenueGenerated, String actorType) {
		super(name, age, gender, nationality, experiences, commission, awards, revenueGenerated);

		this.actorType = actorType;
	}

	public String getActorType() {
		return actorType;
	}

	public void setActorType(String actorType) {
		this.actorType = actorType;
	}

	public String toString() {
		return "Actor | " + name;
	}

	@Override
	public String toConsole() {
		String toReturn = "";

		toReturn += "Client ID: " + id + System.lineSeparator();
		toReturn += "Actor: " + name + System.lineSeparator();
		toReturn += "Age: " + age + System.lineSeparator();
		toReturn += "Gender: " + gender + System.lineSeparator();
		toReturn += "Commission: " + commission + System.lineSeparator();
		toReturn += "Revenue: " + annualRevenueGenerated + System.lineSeparator();
		toReturn += "Nationality: " + nationality + System.lineSeparator();
		toReturn += "Actor Type: " + actorType + System.lineSeparator();

		toReturn += "Awards: ";
		if (awards != null)
			for (var award : awards)
				toReturn += award.toString() + " | ";

		toReturn += "\nExperiences: ";
		if (experiences != null)
			for (var exp : experiences)
				toReturn += exp.toString() + " | ";

		toReturn += "\nClients in group: ";
		if (group != null)
			for (var client : group)
				toReturn += "     " + client.toString();
		toReturn += System.lineSeparator();
		return toReturn;
	}
}
