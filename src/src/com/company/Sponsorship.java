package com.company;

public class Sponsorship{
    private SponsorshipMediator sponsorshipMediator;
    private Sponsor sponsor;
    private  SponsoredClient sponsoredClient;
    private double value;
    private static int clientID = 3000;
    private int id;

    public Sponsorship(Sponsor sponsor, SponsoredClient sponsoredClient, double value, SponsorshipMediator sponsorshipMediator ){
        this.sponsor=sponsor;
        this.sponsoredClient=sponsoredClient;
        this.sponsorshipMediator=sponsorshipMediator;
        this.value= value;
        this.id= clientID++;

    }

    public Sponsor getSponsor(){
        return sponsor;
    }

    public SponsoredClient getSponsoredClient() {
        return sponsoredClient;
    }

    public double getValue(){
        return value;
    }

    public int getId(){ return id;}

}