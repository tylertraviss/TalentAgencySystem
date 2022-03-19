package src.src.com.company;

import java.util.List;

public class Musician extends Client {
	private String stageName;
	private String genre;
	private Instrument instrument;

	public Musician(String name, int age, String gender, String nationality,
			List<Experience> experiences, double commission, List<Award> awards, double revenueGenerated,
			String stageName, String genre, Instrument instrument) {
		super(name, age, gender, nationality, experiences, commission, awards, revenueGenerated);
		
		this.stageName = stageName;
		this.genre = genre;
		this.instrument = instrument;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public String toString() {
		return "Musician | " + getName();
	}

	@Override
	public String getStringToPrintToConsole() {
		String stringToReturn = "";

		stringToReturn += "Musician:\t" + getName() + System.lineSeparator();
		stringToReturn += super.getStringToPrintToConsole();
		stringToReturn += "Stage Name:\t" + stageName + System.lineSeparator();
		stringToReturn += "Genre:\t\t" + genre + System.lineSeparator();
		stringToReturn += "Instrument:\t" + instrument + System.lineSeparator();
		stringToReturn += printAwards();
		stringToReturn += printExperiences();
		stringToReturn += printGroupMembers();

		if(getGroup().size() > 0) {
			stringToReturn += "============ END OF GROUP MEMEBERS ============";
		}

		return stringToReturn;
	}
}