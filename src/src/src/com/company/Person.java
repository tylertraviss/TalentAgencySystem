package src.src.com.company;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String gender;
    private String nationality;

    public Person(String name, int age, String gender, String nationality) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getStringToPrintToConsole() {
        String stringToReturn = "";

        stringToReturn += "Age:\t\t" + age + System.lineSeparator();
        stringToReturn += "Gender:\t\t" + gender + System.lineSeparator();
        stringToReturn += "Nationality:\t" + nationality + System.lineSeparator();

        return stringToReturn;
    }

    @Override
    public int compareTo(Person person) {
        return this.name.compareToIgnoreCase(person.name);
    }
}