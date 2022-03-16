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
		return "Musician | " + name;
	}

	@Override
	public String toConsole() {
		String toReturn = "";

		toReturn += "Musician:\t" + name + System.lineSeparator();

		toReturn += super.toConsole();

		toReturn += "Stage Name:\t" + stageName + System.lineSeparator();
		toReturn += "Genre:\t\t" + genre + System.lineSeparator();
		toReturn += "Instrument:\t" + instrument + System.lineSeparator();

		toReturn += printAwards();

		toReturn += printExperiences();

		toReturn += printGroupMembers();

		return toReturn;
	}
}
