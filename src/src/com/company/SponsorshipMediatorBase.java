package com.company;
public interface SponsorshipMediatorBase {

    public void registerSponsorship(Sponsorship sponsorship);
    public void discontinueSponsorship(int id);
    public void reportSponsorships();

}