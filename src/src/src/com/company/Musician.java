package src.src.com.company;

import java.util.List;

public class Musician extends Client {
	private String stageName;
	private String genre;
	private Instrument instrument;

	public Musician(String name, int age, String gender, String nationality, List<Experience> experiences,
			double commission, List<Award> awards, String stageName, String genre,
			Instrument instrument, double revenueGenerated) {
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
		String toReturn = "";

		toReturn += "Musician:\t" + getName() + System.lineSeparator();

		toReturn += super.getStringToPrintToConsole();

		toReturn += "Stage Name:\t" + stageName + System.lineSeparator();
		toReturn += "Genre:\t\t" + genre + System.lineSeparator();
		toReturn += "Instrument:\t" + instrument + System.lineSeparator();

		toReturn += printAwards();

		toReturn += printExperiences();

		toReturn += printGroupMembers();

		if (getGroup().size() > 0)
			toReturn += "============ END OF GROUP MEMEBERS ============";

		return toReturn;
	}
}
