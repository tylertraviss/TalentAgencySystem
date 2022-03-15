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

        toReturn += "Client ID: " + id + System.lineSeparator();
        toReturn += "Athelete: " + name + System.lineSeparator();
        toReturn += "Age: " + age + System.lineSeparator();
        toReturn += "Gender: " + gender + System.lineSeparator();
        toReturn += "Commission: " + commission + System.lineSeparator();
        toReturn += "Revenue: " + annualRevenueGenerated + System.lineSeparator();
        toReturn += "Nationality: " + nationality + System.lineSeparator();
        toReturn += "Height: " + height + System.lineSeparator();
        toReturn += "Weight: " + weight + System.lineSeparator();
        toReturn += "Sport Type: " + sportType + System.lineSeparator();

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
                toReturn += "    " + client.name;

        return toReturn;
    }

}
