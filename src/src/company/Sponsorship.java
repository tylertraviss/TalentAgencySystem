package src.company;

public class Sponsorship implements Comparable<Sponsorship> {
    private SponsorshipMediator sponsorshipMediator;
    private Sponsor sponsor;
    private SponsoredClient sponsoredClient;
    private double value;

    public Sponsorship(Sponsor sponsor, SponsoredClient sponsoredClient, double value,
            SponsorshipMediator sponsorshipMediator) {
        this.sponsor = sponsor;
        this.sponsoredClient = sponsoredClient;
        this.sponsorshipMediator = sponsorshipMediator;
        this.value = value;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public SponsoredClient getSponsoredClient() {
        return sponsoredClient;
    }

    public double getValue() {
        return value;
    }

    public String getStringToPrintToConsole() {
        String stringToReturn = "";

        stringToReturn += "Sponsor: " + sponsor + System.lineSeparator();
        stringToReturn += "Sponsored Client: " + sponsoredClient.toString() + System.lineSeparator();
        stringToReturn += "Amount Sponsored: " + value + System.lineSeparator();

        return stringToReturn;
    }

    public String toString() {
        return "Sponsor | " + sponsor;
    }

    @Override
    public int compareTo(Sponsorship sponsorship) {
        return this.sponsor.getSponsorName().compareToIgnoreCase(sponsorship.getSponsor().getSponsorName());
    }
}