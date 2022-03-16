package src.src.com.company;

import java.util.List;

public class Athlete extends Client {

    private double height;
    private double weight;
    private String sportType;

    public Athlete(String name, int age, String gender,
            String nationality, List<Experience> experiences, double commission,
            List<Award> awards, double height, double weight,
            String sportType, double revenueGenerated) {
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
        return "Athlete | " + name;
    }

    @Override
    public String toConsole() {
        String toReturn = "";

        toReturn += "Athelete:\t" + name + System.lineSeparator();
        toReturn += super.toConsole();

        toReturn += "Sport Type:\t" + sportType + System.lineSeparator();
        toReturn += "Height:\t\t" + height + System.lineSeparator();
        toReturn += "Weight:\t\t" + weight + System.lineSeparator();

        if (awards != null)
            toReturn += printAwards();

        if (experiences != null)
            toReturn += printExperiences();

        if (group.size() > 0)
            toReturn += printGroupMembers();

        return toReturn;
    }

}
