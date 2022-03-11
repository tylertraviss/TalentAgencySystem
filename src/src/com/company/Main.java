package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // Generate Company
        Company TalentAgencyCompany = Company.getInstance();
        TalentAgencyCompany.setName("Fredericton Talent Agency");
        TalentAgencyCompany.setHqLoc("Fredericton, NB");

        // Generating Dates For Employees
        Date startTime = new Date(2021, 1, 21);
        Date finishTime = new Date(2023, 1, 20);

        // Generating Employees
        Employee Barrera = new Employee(
            "Julian Barerra",
            35,
            "Male",
            "Canada",
            "Chief Executive Officer",
            100000,
            startTime,
            finishTime,
            null
        );

        Employee Elliot = new Employee(
            "Elliot Chin",
            20,
            "Male",
            "Canada",
            "Chief Software Developer",
            90000,
            startTime,
            finishTime,
            Barrera
        );

        Employee Kisenge = new Employee(
            "Kisenge Mbaga",
            20,
            "Male",
            "Canada",
            "Chief Operations Officer",
            90000,
            startTime,
            finishTime,
            Barrera
        );

        Employee Tyler = new Employee(
            "Tyler Travis",
            20,
            "Male",
            "Canada",
            "Chief Machine Learning Officer",
            90000,
            startTime,
            finishTime,
            Barrera
        );

        Employee Carter = new Employee(
            "Carter Moore",
            19,
            "Male",
            "Canada",
            "Computer Programming Intern",
            35000,
            startTime,
            finishTime,
            Barrera
        );

        Employee EthanGarnier = new Employee(
            "Ethan Garnier",
            21,
            "Male",
            "Canada",
            "Chief Cloud Tech Officer",
            90000,
            startTime,
            finishTime,
            Barrera
        );

        // Adding Musician

        Musician JohnLennon = new Musician(
            "John Lennon",
            82,
            "Male",
            "United Kingdom",
            null,
            null,
            .20,
             null,
             "John Lennon",
            "Rock",
            null,
            500000
        );

        // Adding Athlete

        Athlete LeoMessi = new Athlete(
            "Leo Messi",
            32,
            "Male",
            "Argentina",
            null,
            null,
            .30,
            null,
            156,
            60,
            "Soccer",
            5000000
        );

        // Adding Actor

        Actor TomHolland = new Actor(
            "Tom Holland",
            25,
            "Male",
            "United Kingdom",
            null,
            null,
            0.4,
            null,
            "Movie Actor",
            2500000
        );



        // Adding Employees to System
        TalentAgencyCompany.addEmployee(Barrera);
        TalentAgencyCompany.addEmployee(Elliot);
        TalentAgencyCompany.addEmployee(Kisenge);
        TalentAgencyCompany.addEmployee(Tyler);
        TalentAgencyCompany.addEmployee(Carter);
        TalentAgencyCompany.addEmployee(EthanGarnier);

        // Add Clients to System
        TalentAgencyCompany.addClient(JohnLennon);
        TalentAgencyCompany.addClient(LeoMessi);
        TalentAgencyCompany.addClient(TomHolland);

        ConsoleAudit ca = new ConsoleAudit();
        TextFileAudit tfa = new TextFileAudit();
        tfa.execute();




        //Sponsorship Stuff
        SponsorshipMediator sponsorshipMediator= new SponsorshipMediator();
        Sponsor PizzaHut= new Sponsor("PizzaHut",sponsorshipMediator);
        Sponsor Walmart= new Sponsor("Walmart",sponsorshipMediator);
        Sponsor CanadianTire= new Sponsor("Canadian Tire", sponsorshipMediator);



        SponsoredClient client1= new SponsoredClient(LeoMessi,sponsorshipMediator);
        SponsoredClient client2= new SponsoredClient(JohnLennon,sponsorshipMediator);


        Sponsorship sponsorship1= new Sponsorship(PizzaHut,client1,5000,sponsorshipMediator);
        Sponsorship sponsorship2= new Sponsorship(Walmart,client2,10,sponsorshipMediator);
        Sponsorship sponsorship3= new Sponsorship(CanadianTire,client2,1000000,sponsorshipMediator);


        sponsorshipMediator.registerSponsorship(sponsorship1);
        sponsorshipMediator.registerSponsorship(sponsorship2);
        sponsorshipMediator.registerSponsorship(sponsorship3);

        sponsorshipMediator.discontinueSponsorship(sponsorship2);

        sponsorshipMediator.reportSponsorships();


    }
}
