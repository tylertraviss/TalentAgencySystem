package src.src.com.company;

import java.util.ArrayList;
import java.util.List;

class SponsorshipMediator implements SponsorshipMediatorBase {

	private List<Sponsorship> sponsorships;

	private static SponsorshipMediator instance = null;

	private SponsorshipMediator() {
		sponsorships = new ArrayList<>();
	}

	public static SponsorshipMediator getInstance() {
		if (instance == null)
			instance = new SponsorshipMediator();

		return instance;
	}

	public void registerSponsorship(Sponsorship sponsorship) {
		sponsorships.add(sponsorship);
	}

	public void discontinueSponsorship(Sponsorship sponsorship) {
		sponsorships.remove(sponsorship);
	}

	public void reportSponsorships() {
		System.out.println("Records of Current Sponsorships: \n\n");
		// System.out.println(sponsorships);

		for (int i = 0; i < sponsorships.size(); i++) {
			System.out.println(sponsorships.get(i).getSponsor().getSponsorName() + " is sponsoring "
					+ sponsorships.get(i).getSponsoredClient().getName() + " at $" + sponsorships.get(i).getValue()
					+ " a year.");
		}
	}

}