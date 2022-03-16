package src.src.com.company;

public class Person {

    protected String name;
    protected int age;
    protected String gender;
    protected String nationality;

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

    public String toConsole() {
        String toReturn = "";

        toReturn += "Age:\t\t" + age + System.lineSeparator();
        toReturn += "Gender:\t\t" + gender + System.lineSeparator();
        toReturn += "Nationality:\t" + nationality + System.lineSeparator();

        return toReturn;
    }
}
