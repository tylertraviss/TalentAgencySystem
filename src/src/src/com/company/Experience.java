package src.src.com.company;

public class Experience {
    private String jobTitle;

    public Experience(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String newTitle) {
        this.jobTitle = newTitle;
    }

    public String toString() {
        return jobTitle;
    }
}