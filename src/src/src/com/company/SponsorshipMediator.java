package src.src.com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SponsorshipMediator implements SponsorshipMediatorBase {
	private List<Sponsorship> sponsorships;
	private static SponsorshipMediator instance = null;

	private SponsorshipMediator() {
		sponsorships = new ArrayList<Sponsorship>();
	}

	public static SponsorshipMediator getInstance() {
		if(instance == null) {			
			instance = new SponsorshipMediator();
		}

		return instance;
	}

	public List<Sponsorship> getSponsorships() {
		return sponsorships;
	}

	public void registerSponsorship(Sponsorship sponsorship) {
		sponsorships.add(sponsorship);
	}

	public void discontinueSponsorship(Sponsorship sponsorship) {
		sponsorships.remove(sponsorship);
	}

	public Sponsorship getSponsorshipByClient(Client client) {
		for(Sponsorship tempSponsorship : sponsorships) {
			if(tempSponsorship.getSponsoredClient().getName().equals(client.getName())) {
				System.out.println(client.getName());
				return tempSponsorship;
			}
		}
		
		return null;
	}

	public void sortSponsors() {
		Collections.sort(sponsorships);
	}

	public void reportSponsorships() {
		System.out.println("Records of Current Sponsorships: \n\n");
		
		for(int i = 0; i < sponsorships.size(); i++) {
			System.out.println(sponsorships.get(i).getSponsor().getSponsorName() + " is sponsoring "
					+ sponsorships.get(i).getSponsoredClient().getName() + " at $" + sponsorships.get(i).getValue()
					+ " a year.");
		}
	}
}