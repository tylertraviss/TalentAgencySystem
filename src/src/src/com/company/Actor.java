package src.src.com.company;

import java.util.List;

public class Actor extends Client {
	private String actorType;

	public Actor(String name, int age, String gender, String nationality,
			List<Experience> experiences, double commission, List<Award> awards, double revenueGenerated, String actorType) {
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
		String stringToReturn = "";

		stringToReturn += "Actor:\t\t" + getName() + System.lineSeparator();
		stringToReturn += super.getStringToPrintToConsole();
		stringToReturn += "Actor Type:\t" + actorType + System.lineSeparator();
		stringToReturn += printAwards();
		stringToReturn += printExperiences();
		stringToReturn += printGroupMembers();

		if(getGroup().size() > 0) {
			stringToReturn += "============ END OF GROUP MEMEBERS ============";		
		}

		return stringToReturn;
	}
}