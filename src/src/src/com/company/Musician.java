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

		toReturn += "Client ID: " + id + System.lineSeparator();
		toReturn += "Athelete: " + name + System.lineSeparator();
		toReturn += "Age: " + age + System.lineSeparator();
		toReturn += "Gender: " + gender + System.lineSeparator();
		toReturn += "Commission: " + commission + System.lineSeparator();
		toReturn += "Revenue: " + annualRevenueGenerated + System.lineSeparator();
		toReturn += "Nationality: " + nationality + System.lineSeparator();
		toReturn += "Stage Name: " + stageName + System.lineSeparator();
		toReturn += "Genre: " + genre + System.lineSeparator();
		toReturn += "Instrument: " + instrument + System.lineSeparator();

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

		return toReturn;
	}
}
