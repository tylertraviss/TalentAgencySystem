package src.src.com.company;

public class Memento {
    private Employee emp;
    private Client client;
    private Sponsorship sponsorship;

    public Memento(Employee emp, Client client, Sponsorship sponsorship) {
        this.emp = emp;
        this.client = client;
        this.sponsorship = sponsorship;
    }

    public Employee getEmployee() {
        return emp;
    }

    public Client getClient() {
        return client;
    }

    public Sponsorship getSponsor() {
        return sponsorship;
    }
}