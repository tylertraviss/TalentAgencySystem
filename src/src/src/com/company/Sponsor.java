package src.src.com.company;

public class Sponsor {
    private SponsorshipMediator sponsorshipMediator;
    private String sponsorName;

    public Sponsor(String sponsorName, SponsorshipMediator sponsorMediator) {
        this.sponsorshipMediator = sponsorMediator;
        this.sponsorName = sponsorName;

    }

    public String getSponsorName() {
        return sponsorName;
    }

    public String toString() {
        return "\t" + sponsorName;
    }

}