package src.company;

import java.util.ArrayList;

public class MementoRestorer {
    private ArrayList<Memento> mementoList;
    private static MementoRestorer instance = null;

    private MementoRestorer() {
        mementoList = new ArrayList<Memento>();
    }

    public static MementoRestorer getInstance() {
        if(instance == null) {        	
        	instance = new MementoRestorer();
        }

        return instance;
    }

    public void addMementoToList(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMementoFromList(int index) {
        return mementoList.get(index);
    }

    public Memento getLastMemento() {
        if(mementoList.size() == 0) {        	
        	return null;
        }
        
        return mementoList.get(mementoList.size() - 1);
    }

    public void removeLastMemento() {
        if(mementoList.size() != 0) {        	
        	mementoList.remove(mementoList.size() - 1);
        }
    }
}