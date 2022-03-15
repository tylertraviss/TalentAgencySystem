package src.src.com.company;

public class Sponsorship{
    private SponsorshipMediator sponsorshipMediator;
    private Sponsor sponsor;
    private  SponsoredClient sponsoredClient;
    private double value;

    public Sponsorship(Sponsor sponsor, SponsoredClient sponsoredClient, double value, SponsorshipMediator sponsorshipMediator ){
        this.sponsor=sponsor;
        this.sponsoredClient=sponsoredClient;
        this.sponsorshipMediator=sponsorshipMediator;
        this.value= value;

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

}