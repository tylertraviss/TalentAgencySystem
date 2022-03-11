package com.company;

public class SponsoredClient{
    private SponsorshipMediator sponsorshipMediator;
    private Musician musician;
    private Actor actor;
    private Athlete athlete;
    private String name;



    public SponsoredClient(Musician musician, SponsorshipMediator sponsorshipMediator){
        this.sponsorshipMediator= sponsorshipMediator;
        this.musician= musician;
        Person person= (Person) musician;
        this.name= person.getName();

    }


    public SponsoredClient(Actor actor, SponsorshipMediator sponsorshipMediator){
        this.sponsorshipMediator= sponsorshipMediator;
        Person person= (Person) actor;
        this.name= person.getName();
    }


    public SponsoredClient(Athlete athlete, SponsorshipMediator sponsorshipMediator){
        this.sponsorshipMediator= sponsorshipMediator;
        Person person= (Person) athlete;
        this.name= person.getName();

    }

    public String getName(){
            return name;
    }






}