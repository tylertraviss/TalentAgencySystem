package src.src.com.company;

public class MementoCreator {
    private Company companyState;

    public void setCompanyState(Company companyState) {
        this.companyState = companyState;
    }

    public Company getCompanyState() {
        return this.companyState;
    }

    public Memento createMementoWithSetCompanyState() {
        return new Memento(this.companyState);
    }

    public void getCompanyStateFromMemento(Memento memento) {
        if(memento != null) {
            this.companyState = memento.getCompanyState();
        }
    }
}