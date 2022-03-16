package src.src.com.company;

public class SponsoredClient {
    private SponsorshipMediator sponsorshipMediator;
    private Client client;
    private String name;

    public SponsoredClient(Client client, SponsorshipMediator sponsorshipMediator) {
        this.sponsorshipMediator = sponsorshipMediator;
        this.client = client;
        this.name = client.getName();

    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

}