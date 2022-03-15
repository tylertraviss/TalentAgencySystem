package src.src.com.company;

import java.util.List;

public class Athlete extends Client{

    private int height;
    private double weight;
    private String sportType;

    public Athlete(String name, int age, String gender,
                   String nationality, List<Experience> experiences,
                   List<Client> group, double commission,
                   List<Award> awards, int height, int weight,
                   String sportType, double revenueGenerated)
    {
        super(name, age, gender, nationality, experiences, commission, awards, revenueGenerated);
        this.height = height;
        this.weight = weight;
        this.sportType = sportType;
    }

    public int getHeight() {
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
}
