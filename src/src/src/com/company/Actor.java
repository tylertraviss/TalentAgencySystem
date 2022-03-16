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

		toReturn += "Actor:\t\t" + name + System.lineSeparator();

		toReturn += super.toConsole();

		toReturn += "Actor Type:\t" + actorType + System.lineSeparator();

		if (awards != null)
			toReturn += printAwards();

		if (experiences != null)
			toReturn += printExperiences();

		if (group.size() > 0)
			toReturn += printGroupMembers();

		return toReturn;
	}
}
