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
		return "Actor | " + getName();
	}

	@Override
	public String getStringToPrintToConsole() {
		String toReturn = "";

		toReturn += "Actor:\t\t" + getName() + System.lineSeparator();

		toReturn += super.getStringToPrintToConsole();

		toReturn += "Actor Type:\t" + actorType + System.lineSeparator();

		toReturn += printAwards();

		toReturn += printExperiences();

		toReturn += printGroupMembers();

		if (getGroup().size() > 0)
			toReturn += "============ END OF GROUP MEMEBERS ============";

		return toReturn;
	}
}
