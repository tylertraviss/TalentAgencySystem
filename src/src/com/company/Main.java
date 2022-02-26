package com.company;

public class Main {

    public static void main(String[] args) {

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

        System.out.println(Elliot);

    }
}
