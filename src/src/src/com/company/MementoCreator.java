package src.src.com.company;

public class MementoCreator {
    private Employee emp;
    private Client client;
    private Sponsorship sponsorship;
    private static MementoCreator instance = null;

    private MementoCreator() {}

    public static MementoCreator getInstance() {
        if(instance == null) {        	
        	instance = new MementoCreator();
        }

        return instance;
    }

    public void setState(Employee emp, Client client, Sponsorship sponsorship) {
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

    public Sponsorship getSponsorship() {
        return sponsorship;
    }

    public Memento createMementoWithSetState() {
        return new Memento(emp, client, sponsorship);
    }

    public void getEmployeeStateFromMemento(Memento memento) {
        if(memento != null) {
            this.emp = memento.getEmployee();
        }
    }

    public void getClientStateFromMemento(Memento memento) {
        if(memento != null) {
            this.client = memento.getClient();
        }
    }

    public void getSponsorStateFromMemento(Memento memento) {
        if(memento != null) {
            this.sponsorship = memento.getSponsor();
        }
    }
}