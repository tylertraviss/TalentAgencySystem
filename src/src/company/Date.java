package src.company;

public class Date {
	private int year;
	private int month;
	private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String displayDate(){
        return this.month + "/" + this.day + "/" + this.year;
    }

    public String toString() {
        return day + "/" + month + "/" + year;
    }
}