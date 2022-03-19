package src.src.com.company;

import java.util.List;

public class Athlete extends Client {
    private double height;
    private double weight;
    private String sportType;

    public Athlete(String name, int age, String gender, String nationality,
    		List<Experience> experiences, double commission, List<Award> awards, double revenueGenerated,
    		double height, double weight, String sportType) {
        super(name, age, gender, nationality, experiences, commission, awards, revenueGenerated);
        
        this.height = height;
        this.weight = weight;
        this.sportType = sportType;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String toString() {
        return "Athlete | " + getName();
    }

    @Override
    public String getStringToPrintToConsole() {
        String stringToReturn = "";

        stringToReturn += "Athelete:\t" + getName() + System.lineSeparator();
        stringToReturn += super.getStringToPrintToConsole();
        stringToReturn += "Sport Type:\t" + sportType + System.lineSeparator();
        stringToReturn += "Height:\t\t" + height + System.lineSeparator();
        stringToReturn += "Weight:\t\t" + weight + System.lineSeparator();
        stringToReturn += printAwards();
        stringToReturn += printExperiences();
        stringToReturn += printGroupMembers();

        if(getGroup().size() > 0) {        	
        	stringToReturn += "============ END OF GROUP MEMEBERS ============";
        }

        return stringToReturn;
    }
}