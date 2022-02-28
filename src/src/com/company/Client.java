package com.company;

import java.util.List;

public class Client extends Person{

    private static int clientID = 1000;

    private List<Experience> experiences;
    private List<Client> group;
    private double comsission;
    private List<Award> awards;
    private int id;
    private double annualRevenueGenerated;

    public static int getClientID() {
        return clientID;
    }

    public static void setClientID(int clientID) {
        Client.clientID = clientID;
    }

    public double getAnnualRevenueGenerated() {
        return annualRevenueGenerated;
    }

    public void setAnnualRevenueGenerated(double annualRevenueGenerated) {
        this.annualRevenueGenerated = annualRevenueGenerated;
    }

    public Client(String name, int age, String gender, String nationality, List<Experience> experiences, List<Client> group, double commission, List<Award> awards, double annualRevenueGenerated) {
        super(name, age, gender, nationality);
        this.experiences = experiences;
        this.group = group;
        this.comsission = commission;
        this.awards = awards;
        this.annualRevenueGenerated = annualRevenueGenerated;
        this.id = clientID++;
    }

    public int getID(){ return this.id; }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Client> getGroup() {
        return group;
    }

    public void setGroup(List<Client> group) {
        this.group = group;
    }

    public double getComsission() {
        return comsission;
    }

    public void setComsission(double comsission) {
        this.comsission = comsission;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    // Add to Group Method

}
