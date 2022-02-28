package com.company;

public class Main {

    public static void main(String[] args) {

        // Generate Company
        Company TalentAgencyCompany = Company.getInstance();
        TalentAgencyCompany.setName("Fredericton Talent Agency");
        TalentAgencyCompany.setHqLoc("Fredericton, NB");

        // Generating Dates For Employees
        Date startTime = new Date(11, 15, 2021);
        Date finishTime = new Date(11, 15, 2022);

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
            18,
            "Male",
            "Canada",
            "Computer Programming Intern",
            35000,
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



        // Adding Employees to System
        TalentAgencyCompany.addEmployee(Barrera);
        TalentAgencyCompany.addEmployee(Elliot);
        TalentAgencyCompany.addEmployee(Kisenge);
        TalentAgencyCompany.addEmployee(Tyler);
        TalentAgencyCompany.addEmployee(Carter);

        // Add Clients to System
        TalentAgencyCompany.addClient(JohnLennon);
        TalentAgencyCompany.addClient(LeoMessi);

        // Printing Generated Revenue
        System.out.println(TalentAgencyCompany.annualNetIncome());

    }
}
