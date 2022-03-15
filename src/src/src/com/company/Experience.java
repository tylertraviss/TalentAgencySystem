package src.src.com.company;

public class Experience {

    private String jobTitle;

    // # Add Constructor

    public Experience(String jobTititle) {
        this.jobTitle = jobTititle;
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
