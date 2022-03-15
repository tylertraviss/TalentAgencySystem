package src.src.com.company;

public class Instrument {

	String instrumentName;

	public Instrument(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public String getName() {
		return instrumentName;
	}

	public void setName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public String toString() {
		return instrumentName;
	}
}
