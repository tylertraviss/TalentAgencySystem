package com.company;

import java.util.List;

public class Actor extends Client{

    private String actorType;

    public Actor(String name, int age, String gender, String nationality, List<Experience> experiences, List<Client> group, double commission, List<Award> awards, String actorType, double revenueGenerated) {
        super(name, age, gender, nationality, experiences, group, commission, awards, revenueGenerated);
        this.actorType = actorType;
    }

    public String getActorType() {
        return actorType;
    }

    public void setActorType(String actorType) {
        this.actorType = actorType;
    }

}
