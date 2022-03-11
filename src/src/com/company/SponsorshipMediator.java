package com.company;
import java.util.*;

class SponsorshipMediator implements SponsorshipMediatorBase{

    private ArrayList<Sponsorship> sponsorships= new ArrayList<>();




    public void registerSponsorship(Sponsorship sponsorship){
        sponsorships.add(sponsorship);
    }


    public void discontinueSponsorship(Sponsorship sponsorship){
        sponsorships.remove(sponsorship);
    }



    public void reportSponsorships(){
        System.out.println("Records of Current Sponsorships: \n\n");
        //System.out.println(sponsorships);

        for (int i = 0; i < sponsorships.size(); i++) {
            System.out.println(sponsorships.get(i).getSponsor().getSponsorName()+ " is sponsoring " + sponsorships.get(i).getSponsoredClient().getName() +" at $" +sponsorships.get(i).getValue()+ " a year.");
        }
    }


}