package com.company;

import java.util.List;

public class Actor extends Client{

    private String actorType;

    public Actor(String name, int age, String gender, String nationality, List<Experience> experiences, List<Client> group, double comsission, List<Award> awards, String actorType) {
        super(name, age, gender, nationality, experiences, group, comsission, awards);
        this.actorType = actorType;
    }

    public String getActorType() {
        return actorType;
    }

    public void setActorType(String actorType) {
        this.actorType = actorType;
    }

}
